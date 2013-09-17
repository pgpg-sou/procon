//教育機能の目次
package com.example.dneshiboshiken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class IndexRead extends Activity {

	//目次の項目だけボタンを定義
	private Button read_button_1;
	private Button read_button_2;
	private Button read_button_3;
	private Button read_button_4;
	private Button read_button_5;
	private Button read_button_6;
	private Button read_button_7;
	private Button read_button_8;
	private Button read_button_9;
	private Button read_button_10_0;
	
	//ホーム画面に戻るボタンを定義
	private Button index_read_home;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_read);	//画面レイアウトを指定(res/layout/index_read.xml)

        
        //それぞれのボタンにクリック時の処理を表示
        read_button_1 = (Button) findViewById(R.id.read_button_1);
        read_button_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_1_onClick();
            }
        });

        read_button_2 = (Button) findViewById(R.id.read_button_2);
        read_button_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	Read_button_2_onClick();
            }
        });

        read_button_3 = (Button) findViewById(R.id.read_button_3);
        read_button_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	Read_button_3_onClick();
            }
        });

        read_button_4 = (Button) findViewById(R.id.read_button_4);
	    read_button_4.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	        	Read_button_4_onClick();
	        }
	    });

        read_button_5 = (Button) findViewById(R.id.read_button_5);
	    read_button_5.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	        	Read_button_5_onClick();
	        }
	    });

        read_button_6 = (Button) findViewById(R.id.read_button_6);
	    read_button_6.setOnClickListener(new View.OnClickListener(){

	        public void onClick(View v) {
	        	Read_button_6_onClick();
	        }
	    });

        read_button_7 = (Button) findViewById(R.id.read_button_7);
	    read_button_7.setOnClickListener(new View.OnClickListener(){

	        public void onClick(View v) {
	        Read_button_7_onClick();
	        }
	    });
	    read_button_8 = (Button) findViewById(R.id.read_button_8);
	    read_button_8.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                   Read_button_8_onClick();
	            }
	    });

	    read_button_9 = (Button) findViewById(R.id.read_button_9);
	    read_button_9.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                Read_button_9_onClick();
	            }
	    });

	    read_button_10_0 = (Button) findViewById(R.id.read_button_10_0);
	    read_button_10_0.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	               Read_button_10_0_onClick();
	            }
	    });
	    
	    index_read_home = (Button) findViewById(R.id.index_read_home);
	    index_read_home.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	            	Index_read_home_onClick();
	            }
	    });


    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void Read_button_1_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Read1.class);
        startActivity(intent_read_1);
    }

    private void Read_button_2_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),Read2.class);
        startActivity(intent_read_2);
    }

    private void Read_button_3_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Read3.class);
        startActivity(intent_read_3);
    }

    private void Read_button_4_onClick() {
        Intent intent_read_4 = new Intent(getApplicationContext(),Read4.class);
        startActivity(intent_read_4);
    }

    private void Read_button_5_onClick() {
        Intent intent_read_5 = new Intent(getApplicationContext(),Read5.class);
        startActivity(intent_read_5);
    }

    private void Read_button_6_onClick() {
        Intent intent_read_6 = new Intent(getApplicationContext(),Read6.class);
        startActivity(intent_read_6);
    }

    private void Read_button_7_onClick() {
       Intent intent_read_7 = new Intent(getApplicationContext(),Read7.class);
       startActivity(intent_read_7);
    }


    private void Read_button_8_onClick() {
    	Intent intent_read_8 = new Intent(getApplicationContext(),Read8.class);
    	startActivity(intent_read_8);
    }

   	private void Read_button_9_onClick() {
    	Intent intent_read_9 = new Intent(getApplicationContext(),Read9.class);
    	startActivity(intent_read_9);
    }

    	private void Read_button_10_0_onClick() {
    	Intent intent_read_10_0 = new Intent(getApplicationContext(),Read10_0.class);
    	startActivity(intent_read_10_0);
    }

     private void Index_read_home_onClick() {
            Intent index_read_home = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(index_read_home);
        }
     

     //バックキーのアクション
     public boolean onKeyDown(int keyCode, KeyEvent event) {
    if(keyCode==KeyEvent.KEYCODE_BACK){
    	
    
    Intent intent_back = new Intent(getApplicationContext(),MainActivity.class);
    startActivity(intent_back);
    setResult(RESULT_OK, intent_back);
    finish();
    }
    return false;
}

     
     
    	
}
