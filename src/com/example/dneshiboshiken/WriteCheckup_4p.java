//教育機能の目次
package com.example.dneshiboshiken;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;



public class WriteCheckup_4p extends Activity{

	private SharedPreferences pref;// Drive関係
	private Activity activity;// Drive関係

	//目次の項目だけボタンを定義
	private EditText editText_day1;
	private DatePickerDialog.OnDateSetListener varDateSetListener_day1;
	private EditText editText_day2;
	private DatePickerDialog.OnDateSetListener varDateSetListener_day2;
	private EditText editText_day3;
	private DatePickerDialog.OnDateSetListener varDateSetListener_day3;

	private Button button_Write_cancel;
	private Button button_Write_save;
	private Button button_Write_gallery;
	private Button button_Write_camera;
  //ここはクラス内で実行
	static int REQUEST_ACTION_PICK = 1;
	static final int REQUEST_CAPTURE_IMAGE = 100;
	private static final String APPLICATION_NAME = "PATOM";
	private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/Yukari/Photo/" + APPLICATION_NAME;
	private static int REQUEST_CAMERA = 1;
	private static Uri mImageUri; // インスタンス変数
	private String spinner_text1;
	private String spinner_text2;
	private String spinner_text3;
	private String spinner_text4;
	private String spinner_text5;

	private String[] item_checkup_4tag = {"EditText__write_checkup_4p_examination",
			"EditText_write_checkup_4p_weight",
			"EditText_write_checkup_4p_height",
			"EditText_write_checkup_4p_chest",
			"EditText_write_checkup_4p_head",
			"Spinner_write_checkup_4p_diet",
			"Spinner_write_checkup_4p_feeding",
			"EditText_write_checkup_4p_hip",
			"EditText_write_checkup_4p_other",
			"EditText_write_checkup_4p_name"};
	private String[] item_checkup_EditText_4tag = {"EditText__write_checkup_4p_examination",
			"EditText_write_checkup_4p_weight",
			"EditText_write_checkup_4p_height",
			"EditText_write_checkup_4p_chest",
			"EditText_write_checkup_4p_head",
			"EditText_write_checkup_4p_other",
			"EditText_write_checkup_4p_name",};
	private String[] item_checkup_Spinner_4tag = {"Spinner_write_checkup_4p_diet",
			"Spinner_write_checkup_4p_feeding",
			"Spinner_write_checkup_4p_hip"};
	public static int[] item_checkup_EditText_4 = {R.id.EditText__write_checkup_4p_examination,
		R.id.EditText_write_checkup_4p_weight,
		R.id.EditText_write_checkup_4p_height,
		R.id.EditText_write_checkup_4p_chest,
		R.id.EditText_write_checkup_4p_head,
		R.id.EditText_write_checkup_4p_other,
		R.id.EditText_write_checkup_4p_name,};
	public static int[] item_checkup_Spinner_4 = {R.id.Spinner_write_checkup_4p_diet,
		R.id.Spinner_write_checkup_4p_feeding,
		R.id.Spinner_write_checkup_4p_hip,};


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_checkup_4p);	//画面レイアウトを指定(res/layout/index_read.xml)
        activity=this;



        EditText[] tvParam_EditText = new EditText[item_checkup_EditText_4.length];
        Spinner[] tvParam_Spinner = new Spinner[item_checkup_Spinner_4.length];

        //初期値読み込み
        File dir = new File(Environment.getExternalStorageDirectory().getPath());
        if(dir.exists()){

            File file = new File(dir.getAbsolutePath()+"/Yukari/Write/Checkup/WriteCheckup_4file.xml");
            if (file.exists()) {
            	try {
            		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            		factory.setNamespaceAware(true);
            		XmlPullParser parser = factory.newPullParser();
            		FileInputStream fis = new FileInputStream(file);
            		parser.setInput(new InputStreamReader(fis));

            		// EditTextインスタンスの取得
            		for (int i1 = 0; i1 < item_checkup_EditText_4.length; i1++) {
            			tvParam_EditText[i1] = (EditText)findViewById(item_checkup_EditText_4[i1]);
                    }
            		// Spinnerインスタンスの取得
            		for (int i1 = 0; i1 < item_checkup_Spinner_4.length; i1++) {
            			tvParam_Spinner[i1] = (Spinner)findViewById(item_checkup_Spinner_4[i1]);
                    }


                    // タグ名
                    String tag = "";
                    // 値
                    String value = "";
                    // XMLの解析
                    for (int type = parser.getEventType(); type != XmlPullParser.END_DOCUMENT;
                            type = parser.next()) {
                        switch(type) {
                        case XmlPullParser.START_TAG: // 開始タグ
                            tag = parser.getName();
                            break;
                        case XmlPullParser.TEXT: // タグの内容
                            value = parser.getText();
                            if(value.trim().length() != 0) {
                            // 空白で取得したものは全て処理対象外とする
                          	  if(tag.equals(item_checkup_4tag[0])) {tvParam_EditText[0].setText(value);}
                          	else if(tag.equals(item_checkup_4tag[1])) {tvParam_EditText[1].setText(value);}
                          	else if(tag.equals(item_checkup_4tag[2])) {tvParam_EditText[2].setText(value);}
                          	else if(tag.equals(item_checkup_4tag[3])) {tvParam_EditText[3].setText(value);}
                          	else if(tag.equals(item_checkup_4tag[4])) {tvParam_EditText[4].setText(value);}
                          	else if(tag.equals(item_checkup_4tag[5])) {spinner_text1 = parser.getText();}
                          	else if(tag.equals(item_checkup_4tag[6])) {spinner_text2 = parser.getText();}
                          	else if(tag.equals(item_checkup_4tag[7])) {spinner_text3 = parser.getText();}
                          	else if(tag.equals(item_checkup_4tag[8])) {tvParam_EditText[5].setText(value);}
                          	else if(tag.equals(item_checkup_4tag[9])) {tvParam_EditText[6].setText(value);}
                            }
                            break;
                        case XmlPullParser.END_TAG: // 終了タグ
                            break;
                        }

                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "エラー発生", Toast.LENGTH_SHORT);
                }
            }
        }
        //画像読み込み
        if(dir.exists()){
            File view = new File(dir.getAbsolutePath()+"/Yukari/Photo/imageView_write_checkup_4p.png");
            if (view.exists()) {
            	BitmapFactory.Options options = new BitmapFactory.Options();
            	options.inJustDecodeBounds = true;
            	Bitmap bmp1 = BitmapFactory.decodeFile(view.getPath(), options );

            	int reqWidth = 0;
            	int reqHeight = 0;
            	options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
            	int scale = Math.max(1, 1);
            	options.inJustDecodeBounds = false;
            	options.inSampleSize = scale;
            	Bitmap image = BitmapFactory.decodeFile(view.getPath(), options);

            	((ImageView)findViewById(R.id.imageview_write_checkup_4p)).setImageBitmap(image);
            }else{
                //存在しない
            }
        }



        //日付出力
        editText_day1 = (EditText) findViewById(R.id.EditText__write_checkup_4p_examination);
        varDateSetListener_day1
			= new DatePickerDialog.OnDateSetListener() {
			public void onDateSet(
				DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
				editText_day1.setText(year + "年"
					+ (monthOfYear + 1) + "月"
					+ dayOfMonth + "日");
				}
		};


        //それぞれのボタンにクリック時の処理を表示
       button_Write_camera = (Button) findViewById(R.id.Button_write_checkup_4p_camera);
            button_Write_camera.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                button_Write_camera();
                }
            });

        button_Write_gallery = (Button) findViewById(R.id.Button_write_checkup_4p_gallery);
        button_Write_gallery.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_gallery();
            }
        });


        button_Write_cancel = (Button) findViewById(R.id.Button_checkup_cancel);
        button_Write_cancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_cancel();
            }
        });

        button_Write_save = (Button) findViewById(R.id.Button_checkup_save);
        button_Write_save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_save();
            }
        });
        //スピナーへの入力
        execSpinners();

    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

	    // 画像の元サイズ
	    final int height = options.outHeight;
	    final int width = options.outWidth;
	    int inSampleSize = 1;

	    if (height > reqHeight || width > reqWidth) {
	        if (width > height) {
	            inSampleSize = Math.round((float)height / (float)reqHeight);
	        } else {
	            inSampleSize = Math.round((float)width / (float)reqWidth);
	        }
	    }
	    return inSampleSize;
	}
    //スピナー入出力関数

	private void execSpinners() {
		Spinner Spinner1,Spinner2,Spinner3;
		Spinner1= (Spinner) findViewById(R.id.Spinner_write_checkup_4p_diet);
		Spinner2 = (Spinner) findViewById(R.id.Spinner_write_checkup_4p_feeding);
		Spinner3 = (Spinner) findViewById(R.id.Spinner_write_checkup_4p_hip);

		String[] labels1 = getResources().getStringArray(R.array.diet_label);
		String[] labels2 = getResources().getStringArray(R.array.feeding_label);
		String[] labels3 = getResources().getStringArray(R.array.none_label);

		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, labels1);
		adapter1.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);

		Spinner1.setAdapter(adapter1);
		for(int i1 = 0; i1 < labels1.length; i1++) {//初期値設定
			if (labels1[i1].equals(spinner_text1))  Spinner1.setSelection(i1);
		}

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, labels2);
		adapter2.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		Spinner2.setAdapter(adapter2);
		for(int i1 = 0; i1 < labels2.length; i1++) {//初期値設定
			if (labels2[i1].equals(spinner_text2))  Spinner2.setSelection(i1);
		}

		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, labels3);
		adapter3.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
		Spinner3.setAdapter(adapter3);
		for(int i1 = 0; i1 < labels3.length; i1++) {//初期値設定
			if (labels3[i1].equals(spinner_text3))  Spinner3.setSelection(i1);
		}

	}

	//日付出力関数
	public void datePickerShow1(View v) {
		Calendar calendar = Calendar.getInstance();
		DatePickerDialog dateDialog	= new DatePickerDialog(
			this,
			varDateSetListener_day1,
			calendar.get(Calendar.YEAR),
			calendar.get(Calendar.MONTH),
			calendar.get(Calendar.DAY_OF_MONTH));
		dateDialog.show();
	}


    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_gallery() {

    	//実行フロー
    	Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    	//これだとギャラリー専門が開きます。
    	//Intent intent = new Intent(Intent.ACTION_PICK);
    	intent.setType("image/*");
    	//createChooserを使うと選択ダイアログのタイトルを変更する事ができます。
    	startActivityForResult(Intent.createChooser(intent,"select"), REQUEST_ACTION_PICK);
    	//デフォルトで「アプリ選択」と出ます。
    	//startActivityForResult(intent, REQUEST_ACTION_PICK);

    }
    private void button_Write_camera() {
    	Intent intent = new Intent();
    	ContentValues values = new ContentValues();
        values.put(Images.Media.TITLE,"aaaaa");//任意のタイトル（拡張子は付けない）
        values.put(Images.Media.MIME_TYPE, "image/jpeg");
        //URIの取得
        mImageUri = getContentResolver().insert(Images.Media.EXTERNAL_CONTENT_URI, values);
       // mImageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory().getPath()  + System.currentTimeMillis() +"."));
        intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
    	startActivityForResult(intent, REQUEST_CAMERA);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

      	 if(resultCode == RESULT_OK){
      		 Bitmap imageBitmap = null;
   	        if(requestCode == REQUEST_ACTION_PICK){
   	        	Uri uri;
   	        	try {
   	        		if(data == null){//カメラの時
   	        			uri = mImageUri;
                      }else uri = data.getData();//ギャラリーの時

   	    			ContentResolver contentResolver = getContentResolver();
   	    		    InputStream inputStream;
   	    		    BitmapFactory.Options imageOptions;

   	    		    // メモリ上に画像を読み込まず、画像サイズ情報のみを取得する
   	    		    inputStream = contentResolver.openInputStream(uri);
   	    		    imageOptions = new BitmapFactory.Options();

   	    		    imageOptions.inJustDecodeBounds = true;
   	    		    BitmapFactory.decodeStream(inputStream, null, imageOptions);
   	    		    inputStream.close();
   	    		    // もし読み込む画像が大きかったら縮小して読み込む
   	    		    inputStream = contentResolver.openInputStream(uri);
   	    		    if (imageOptions.outWidth > 512 && imageOptions.outHeight > 512) {
   	    		        imageOptions = new BitmapFactory.Options();
   	    		        imageOptions.inSampleSize = 4;
   	    		        imageBitmap = BitmapFactory.decodeStream(inputStream, null, imageOptions);
   	    		        //Toast.makeText(this, "圧縮しました。", Toast.LENGTH_LONG).show();

   	    		    } else {
   	    		        imageBitmap = BitmapFactory.decodeStream(inputStream, null, null);

   	    		    }
   	    		    inputStream.close();
   	    			//Bitmapで普通に利用ができます。
   	    		    ((ImageView)findViewById(R.id.imageview_write_checkup_4p)).setImageBitmap(imageBitmap);
   	    		} catch (FileNotFoundException e) {
   	    			e.printStackTrace();
   	    		} catch (IOException e) {
   	    			e.printStackTrace();
   	    		}

   	    		String filename = "imageView_write_checkup_4p.png";
   	    		String path = Environment.getExternalStorageDirectory().getPath() + "/Yukari/Photo/" + filename;
   	    		File file = new File(path);

   	    		// 上の階層(アプリ名のディレクトリ)が存在しなかったら作成
   	    		if(!file.getParentFile().exists()){
   	    			file.getParentFile().mkdir();
   	    		}

   	    		try {
   	    			OutputStream os = new FileOutputStream(file);
   	    			imageBitmap.compress(CompressFormat.PNG, 50, os); // 拡張子、品質、出力先
   	    			os.close();
   	    		} catch (FileNotFoundException e) {
   	    			e.printStackTrace();
   	    		} catch (IOException e) {
   	    			e.printStackTrace();
   	    		}

                     }
      	 }
       }
    private void button_Write_cancel() {
    	Intent intent_cancel = new Intent(getApplicationContext(),WriteCheckup_4.class);
        startActivity(intent_cancel);
        ImageView iv = (ImageView)findViewById(R.id.imageview_write_checkup_4p);
        iv.setImageDrawable(null);
        finish();
    }

    private void button_Write_save() {
    	Spinner spinner;
		Text text;

    	//ディレクトリの作成
    	String target_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Yukari/Write/Checkup";
    	File dir = new File(target_path);
    	if(!dir.exists()){
    	    dir.mkdirs();
    	}
    	DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
    	try {
    		 DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
    	     Document document = dbuilder.newDocument();
    	     Element root = document.createElement("members");

    	     //edittextの中身を保存
    	     for (int i1 = 0; i1 < item_checkup_EditText_4.length; i1++) {
    	    	 Element element1 = document.createElement(item_checkup_EditText_4tag[i1]);
    	    	 String string1 = ((EditText) findViewById(item_checkup_EditText_4[i1])).getText().toString();
    	    	 text = document.createTextNode(string1);
    	    	 element1.appendChild(text);
    	    	 root.appendChild(element1);
    	     }

    	     //spinnerの中身を保存
    	     for (int i1 = 0; i1 < item_checkup_Spinner_4.length; i1++) {
    	   		 spinner = (Spinner) findViewById(item_checkup_Spinner_4[i1]);
    	    	 Element element1 = document.createElement(item_checkup_Spinner_4tag[i1]);
    	    	 String string1 = spinner.getSelectedItem().toString();
    	    	 text = document.createTextNode(string1);
    	    	 element1.appendChild(text);
    	    	 root.appendChild(element1);
    	     }

    	     document.appendChild(root);

    	     TransformerFactory tffactory = TransformerFactory.newInstance();
    	     Transformer transformer = tffactory.newTransformer();

    	//保存ファイルの作成
    	String filePath = Environment.getExternalStorageDirectory() + "/Yukari/Write/Checkup/WriteCheckup_4file.xml";
        File file = new File(filePath);
        file.getParentFile().mkdir();
        transformer.transform(new DOMSource(document), new StreamResult(file));


    	} catch (ParserConfigurationException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	 }catch (TransformerConfigurationException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	 } catch (TransformerException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	 }

    	/**
		 * ここからGoogleDriveへのアップロード 個々によって変更するところ
		 * */
		try {
			DriveModule.OAuth(GoogleDriveBuild.credential, activity);
			pref = getSharedPreferences("prefs", Activity.MODE_PRIVATE);
			final String str = pref.getString("RootFolder",
					"PERF NOT FOUND!!");
			Log.i("PREF", str);

			AsyncTask<Void, ProgressDialog, Void> task = new AsyncTask<Void, ProgressDialog, Void>() {
				protected void onPostExecute() {
					// UIスレッド
					//Toast.makeText(WriteCheckup_12p.this, "UPLOAD OK",
						//	Toast.LENGTH_LONG);
				}

				protected Void doInBackground(Void... params) {
					// TODO 自動生成されたメソッド・スタブ
					boolean a = false;
					try {
						com.google.api.services.drive.model.File file1 = GoogleDriveBuild.service
								.files()
								.get(pref.getString("RootFolder", null))
								.execute();
						if (file1 != null) {
							String filePath = Environment.getExternalStorageDirectory()+ "/Yukari/Write/Checkup/WriteCheckup_4file.xml";
							String path = Environment.getExternalStorageDirectory().getPath() + "/Yukari/Photo/imageView_write_checkup_4p.png" ;
							File view = new File(path);
							if (DriveModule.checkFile(file1, "Checkup","WriteCheckup_4file.xml",GoogleDriveBuild.service,GoogleDriveBuild.credential, filePath,"application/xml", activity) == true) {
							} else {
							}
							if(view.exists()&&DriveModule.checkFile(file1, "Photo","imageView_write_checkup_4p.png",GoogleDriveBuild.service,GoogleDriveBuild.credential, path,"image/*", activity) == true)
							a = true;
						}
					} catch (IOException e) {
						// TODO 自動生成された catch ブロック
						Log.e("ERROR a", e.toString());
					}
					return null;

				}

			};
			task.execute(); // 実行

		} catch (Exception e) {
			Log.e("DRIVE ERROR", e.toString());
		}

		if(GoogleDriveBuild.netWorkCheck(this)==false){
			Toast.makeText(this, "インターネットに接続されていません", Toast.LENGTH_LONG).show();
			Log.i("NETWORK","false")	;
		}


		/**
		 * ここまでがアップロード
		 * */

    	Toast.makeText(this, "保存が完了しました", Toast.LENGTH_LONG).show();
    	Intent intent_cancel = new Intent(getApplicationContext(),WriteCheckup_4.class);
        startActivity(intent_cancel);
        ImageView iv = (ImageView)findViewById(R.id.imageview_write_checkup_4p);
        iv.setImageDrawable(null);
        finish();
    }

  //バックキー
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
      if(keyCode==KeyEvent.KEYCODE_BACK){
    	  Intent intent_cancel = new Intent(getApplicationContext(),WriteCheckup_4.class);
          startActivity(intent_cancel);
          finish();
          return true;
      }
      return false;
    }
}
