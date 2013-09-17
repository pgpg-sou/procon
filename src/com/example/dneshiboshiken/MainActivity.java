//起動画面の表示
//本アプリケーションは完成しきっていないので参考にしないでください．
//2コ，3コ上の先輩のアプリケーションを参考にして独自で作り上げた方が自分の勉強にもなると思います．
//driveとcalendarへのアクセスも独自で開発をしてください．

package com.example.dneshiboshiken;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;






public class MainActivity extends Activity {
    private ImageButton btn_dayindex;	//今日の情報への遷移用ボタン
    private Button btn_daywrite;	//日々の健康記録への遷移用ボタン
    private Button btn_watch;	//見守るへの遷移用ボタン
    private Button btn_write;	//記録するへの遷移用ボタン
    private Button btn_search; //調べるへの遷移用ボタン
    private Button btn_synchro; //同期への遷移用ボタン
    /** Called when the activity is first created. */
    //まず呼び出される関数


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //レイアウトの呼び出し
        setContentView(R.layout.activity_main);
/*
        btn_dayindex = (ImageButton) findViewById(R.id.Button_dayindex_main);
        btn_dayindex.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Button_dayindex_onClick();		//日々の健康記録呼び出し
            }
        });*/

        btn_daywrite = (Button) findViewById(R.id.Button_daywrite_main);
        btn_daywrite.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Button_daywrite_onClick();		//日々の健康記録呼び出し
            }
        });

        btn_watch = (Button) findViewById(R.id.Button_watch_main);
        btn_watch.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Button_watch_onClick();		//見守る呼び出し
            }
        });

        btn_write = (Button) findViewById(R.id.Button_write_main);
        btn_write.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Button_write_onClick();		//記録するページを表示
            }
        });


        btn_search = (Button) findViewById(R.id.Button_search_main);
        btn_search.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                Button_search_onClick();		//妊婦の記録機能の呼び出し
            }
        });


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
        Intent intent_search = new Intent(getApplicationContext(),SearchActivity.class);
        startActivity(intent_search);
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

    // アラートダイアログ
    @Override
    public Dialog onCreateDialog(int id) {
        switch (id) {

        case 0:
            //ダイアログの作成(AlertDialog.Builder)
            return new AlertDialog.Builder(MainActivity.this)
            .setMessage("「縁」を終了しますか?")
            .setCancelable(false)
            // 「終了する」が押された時の処理
            .setPositiveButton("終了する", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // アクティビティ消去
                    MainActivity.this.finish();
                }
            })
            // 「終了しない」が押された時の処理
            .setNegativeButton("終了しない", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            })
            .create();
        }
        return null;
    }

}