//起動画面の表示
//本アプリケーションは完成しきっていないので参考にしないでください．
//2コ，3コ上の先輩のアプリケーションを参考にして独自で作り上げた方が自分の勉強にもなると思います．
//driveとcalendarへのアクセスも独自で開発をしてください．

package com.example.dneshiboshiken;

import java.util.Arrays;
import java.util.List;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;


public class MainActivity extends Activity {
	private ImageButton btn_dayindex;	//今日の情報への遷移用ボタン
	private Button btn_daywrite;	//日々の健康記録への遷移用ボタン
	private Button btn_watch;	//見守るへの遷移用ボタン
	private Button btn_write;	//記録するへの遷移用ボタン
	private Button btn_search; //調べるへの遷移用ボタン
	private Button btn_synchro;
	private Button btn_index;//同期への遷移用ボタン
	private Button btn_calender;

	private float actDownX;
	private float actDownY;
	private float actUpX;
	private float actUpY;


    private SharedPreferences pref;// GoogleDriveアカウント名保存用
    private SharedPreferences.Editor editor;// GoogleDriveアカウント名保存用
    public static String accountName;// アカウント名
    public final int REQUEST_ACCOUNT_PICKER = 1;// intent用の呼び出し定数
    public static final int REQUEST_AUTHORIZATION = 2;
    public static File UPLOAD_FILE;// ファイル取り扱い用変数
    public static List<File> listData;
    public static String ROOT_FOLDER_ID;
    private Activity activity;
    private static ProgressTask mTask;
    public static String id;// id
    public static final int NETOWORK_ERROR=1;
    public static boolean get = false;
    public static boolean folderRun = false;
    public static boolean diff=true;
    private static ProgressFolderCreate foldercreate;
    private static DiffDownloader diffDown;
    public static boolean folderdialog=false;


	/** Called when the activity is first created. */
	//まず呼び出される関数


	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		activity=this;
		//レイアウトの呼び出し
		setContentView(R.layout.activity_main);


		btn_daywrite = (Button) findViewById(R.id.Button_daywrite_main);
		btn_daywrite.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v) {
				Button_daywrite_onClick();
			}
		});

		btn_watch = (Button) findViewById(R.id.Button_watch_main);
		btn_watch.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v) {
				Button_watch_onClick();		//見守る呼び出し
			}
		});

		btn_search = (Button) findViewById(R.id.Button_yahoo);
		btn_search.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v) {
				Button_search_onClick();		//妊婦の記録機能の呼び出し
			}
		});

		btn_index = (Button) findViewById(R.id.Button_search);
		btn_index.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v) {
				Button_index_search_onClick();		//妊婦の記録機能の呼び出し
			}
		});

		btn_write = (Button) findViewById(R.id.Button_write_main);
		btn_write.setOnClickListener(new View.OnClickListener(){

			public void onClick(View v) {
				Button_write_onClick();		//記録するページを表示
			}
		});


		btn_calender = (Button) findViewById(R.id.Button_calendar);
		btn_calender.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this, DisplayCalender.class);
				startActivity(intent);
			}
		});
		/* GoogleDriveの初期設定 */
        driveSettings();
        Toast.makeText(MainActivity.this, "OKOK", Toast.LENGTH_LONG);


	}


	
    /* GoogleDriveの初期設定 */
    @SuppressWarnings("deprecation")
    private void driveSettings() {
        // TODO 自動生成されたメソッド・スタブ
        // GoogleDriveBuild.driveAccountCredential(getApplicationContext());
        GoogleDriveBuild.credential = GoogleAccountCredential.usingOAuth2(this,
                Arrays.asList(DriveScopes.DRIVE_FILE));
        // Log.d("CREDENTIAL",GoogleDriveBuild.credential.toString());
        pref = getSharedPreferences("prefs", Activity.MODE_PRIVATE);

        if (pref.getString("accountName", accountName) == null) {
            startActivityForResult(
                    GoogleDriveBuild.credential.newChooseAccountIntent(),
                    REQUEST_ACCOUNT_PICKER);
        } else {
            accountName = pref.getString("accountName", null);
            GoogleDriveBuild.credential = GoogleAccountCredential.usingOAuth2(
                    this, Arrays.asList(DriveScopes.DRIVE_FILE));
            // Log.d("CREDENTIAL",GoogleDriveBuild.credential.toString());
            GoogleDriveBuild.driveService(accountName);
            DriveModule.OAuth(GoogleDriveBuild.credential, activity);
            // Log.d("OAUTH", "O ok");
            try {
                if(GoogleDriveBuild.netWorkCheck(this.getApplicationContext())){
                    //ネットワークにつながっている時の処理
                    mTask = new ProgressTask(activity);
                    mTask.execute(activity);
                   if(pref.getString("First start", null)==null){
//                        Log.e("task","task execute");
//                        foldercreate=new ProgressFolderCreate(activity);
//                        foldercreate.execute(activity);
//                    }
//					if(pref.getString("First start", null)!=null&&pref.getString("RootFolder", null)!=null){
//						Log.i("SSD in","SSD in");
//						diffcheck();
					}else{
                    diffDown=new DiffDownloader(activity);
                    diffDown.execute(activity);
					}
                }else if(pref.getString("RootFolder", null)==null&&GoogleDriveBuild.netWorkCheck(this.getApplicationContext())==false){
                    //つながってない時の処理
                    showDialog(NETOWORK_ERROR);
                }

            } catch (Exception e) {
                Log.e("ERROR drivesetting", e.toString());
            }
            // getList();
        }

    }

    /* アカウントがなかった場合のアカウント名を選択後の処理 */
    protected void onActivityResult(final int requestCode,
                                    final int resultCode, final Intent data) {
        switch (requestCode) {
            case REQUEST_ACCOUNT_PICKER:
                if (resultCode == RESULT_OK && data != null
                        && data.getExtras() != null) {
                    accountName = data
                            .getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                    if (accountName != null) {
                        try {
                            GoogleDriveBuild
                                    .getDriveService(GoogleDriveBuild.credential);
                            GoogleDriveBuild.driveService(accountName);
                            //アカウント名保存
                            onSaveData("accountName", accountName);
                            DriveModule
                                    .OAuth(GoogleDriveBuild.credential, activity);
                            Log.e("activity result", "drivemodule oauth");
                            if(GoogleDriveBuild.netWorkCheck(this.getApplicationContext())){
                            	Log.d("net work","net work coneccted");
                                //ネットワークにつながっている時の処理
                                mTask = new ProgressTask(activity);
                                Log.d("new pregresstask","new progresstask");
                                mTask.execute(activity);
                                Log.d("execute","execute");
                                if(pref.getString("First start", null)==null){
//                                    Log.e("task","task execute");
//                                    foldercreate=new ProgressFolderCreate(activity);
//                                    foldercreate.execute(activity);
                                }else{
                                
                                diffDown=new DiffDownloader(activity);
                                diffDown.execute(activity);
                                }
                            }else if(pref.getString("RootFolder", null)==null&&GoogleDriveBuild.netWorkCheck(this.getApplicationContext())==false){
                                //ネットワークに繋がっていない時の処理
                                showDialog(NETOWORK_ERROR);
                            }
                        } catch (Exception e) {
                            Log.e("ERROR", e.toString());
                        }
                    }
                }
                break;
            case REQUEST_AUTHORIZATION:
                DriveModule.OAuth(GoogleDriveBuild.credential, activity);
                break;
        }
    }

    void onSaveData(String Text, String data) {
        // TODO 自動生成されたメソッド・スタブ
        editor = pref.edit();
        editor.putString(Text, data);
        // Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
        editor.commit();
    }




    //今日の知識呼び出し
	/*private void Button_dayindex_onClick() {
        Intent intent_dayindex = new Intent(getApplicationContext(),Indexdayindex.class);
        startActivity(intent_dayindex);
    }*/
	//日々の健康記録呼び出し
	private void Button_daywrite_onClick() {
		Intent intent_write = new Intent(getApplicationContext(),diary_main.class);
		startActivity(intent_write);

	}
	//見守る機能の呼び出し
	private void Button_watch_onClick() {
		Intent intent_write = new Intent(getApplicationContext(),Album_Main.class);
		startActivity(intent_write);

	}

	//記録機能の呼び出し
	private void Button_write_onClick() {
		Intent intent_write = new Intent(getApplicationContext(),WriteActivity.class);
		startActivity(intent_write);
	}
	//調べる機能
	private void Button_search_onClick() {
		Intent yahoo_search = new Intent(getApplicationContext(),YahooActivity.class);
        startActivity(yahoo_search);
	}

	private void Button_index_search_onClick() {
        Intent intent_read = new Intent(getApplicationContext(),IndexActivity.class);
        startActivity(intent_read);
    }

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK){
			// アラートダイアログ
			showDialog(0);
			return true;
		}
		return false;
	}

//	@Override
//	public boolean onTouchEvent(MotionEvent event){
//		Log.d("TouchEvent", "X:" + event.getX() + ",Y:" + event.getY());
//		//左方向に指をスライドさせた場合に画面遷移
//		//あとで消す
//		switch(event.getAction()){
//		case MotionEvent.ACTION_DOWN:
//			actDownX = event.getX();
//			break;
//		case MotionEvent.ACTION_MOVE:
//			break;
//		case MotionEvent.ACTION_UP:
//			actUpX = event.getX();
//			if(actDownX - actUpX > 100){
//				Intent intent = new Intent(MainActivity.this, WriteActivity.class);
//				startActivity(intent);
//			}
//			break;
//		}
//		return false;
//
//	}

	// アラートダイアログ
    @Override
    public Dialog onCreateDialog(int id) {
        switch (id) {

            case 0:
                // ダイアログの作成(AlertDialog.Builder)
                return new AlertDialog.Builder(MainActivity.this)
                        .setMessage("「縁」を終了しますか?")
                        .setCancelable(false)
                                // 「終了する」が押された時の処理
                        .setPositiveButton("終了する",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        // アクティビティ消去
                                        MainActivity.this.finish();
                                    }
                                })
                                // 「終了しない」が押された時の処理
                        .setNegativeButton("終了しない",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {

                                    }
                                }).create();
            case NETOWORK_ERROR:
                // ダイアログの作成(AlertDialog.Builder)
                return new AlertDialog.Builder(MainActivity.this)
                        .setTitle("インターネットにつながっていません")
                        .setMessage("初期設定にはインターネットにつながっている必要があります。設定を開きますか？")

                        .setCancelable(false)
                                // 「終了する」が押された時の処理
                        .setPositiveButton("はい",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        Intent it;
                                        it = new Intent(Settings.ACTION_SETTINGS);
                                        try {
                                            startActivity(it);
                                        } catch (ActivityNotFoundException e) {
                                            Log.e("TAG",
                                                    "ActivityNotFoundException");
                                        }
                                        finish();
                                    }
                                })
                                // 「終了しない」が押された時の処理
                        .setNegativeButton("いいえ",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        finish();
                                    }
                                }).create();
        }
        return null;
	}

}