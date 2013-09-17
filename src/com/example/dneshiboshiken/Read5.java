//教育機能の目次
package com.example.dneshiboshiken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

public class Read5 extends Activity {

	//目次の項目だけボタンを定義
	private Button read_button_5no1;
	private Button read_button_5no2;
	private Button read_button_5no3;
	private Button read_button_5no4;
	private Button read_button_5no5;
	private Button read_button_5no6;
	private Button read_button_5no7;

	//画面移動ボタンを定義
	private Button read_button_5_back;
	private Button read_button_5_menu;
	private Button read_button_5_next;
	
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_5);	//画面レイアウトを指定(res/layout/index_read.xml)

        //それぞれのボタンにクリック時の処理を表示
        read_button_5no1 = (Button) findViewById(R.id.read_button_5no1);
	    read_button_5no1.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	        	Read_button_5no1_onClick();
	        }
	    });

        read_button_5no2 = (Button) findViewById(R.id.read_button_5no2);
	    read_button_5no2.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	        	Read_button_5no2_onClick();
	        }
	    });

        read_button_5no3 = (Button) findViewById(R.id.read_button_5no3);
	    read_button_5no3.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	        	Read_button_5no3_onClick();
	        }
	    });

        read_button_5no4 = (Button) findViewById(R.id.read_button_5no4);
	    read_button_5no4.setOnClickListener(new View.OnClickListener(){
	        public void onClick(View v) {
	        	Read_button_5no4_onClick();
	        }
	    });

        read_button_5no5 = (Button) findViewById(R.id.read_button_5no5);
	    read_button_5no5.setOnClickListener(new View.OnClickListener(){

	        public void onClick(View v) {
	        	Read_button_5no5_onClick();
	        }
	    });

        read_button_5no6 = (Button) findViewById(R.id.read_button_5no6);
	    read_button_5no6.setOnClickListener(new View.OnClickListener(){

	        public void onClick(View v) {
	        	Read_button_5no6_onClick();
	        }
	    });

        read_button_5no7 = (Button) findViewById(R.id.read_button_5no7);
	    read_button_5no7.setOnClickListener(new View.OnClickListener(){

	        public void onClick(View v) {
	        	Read_button_5no7_onClick();
	        }
	    });
	    
        read_button_5_back = (Button) findViewById(R.id.read_button_5_back);
        read_button_5_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_back_onClick();
            }
        });
        
        read_button_5_menu = (Button) findViewById(R.id.read_button_5_mneu);
        read_button_5_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_mneu_onClick();
            }
        });
        
        read_button_5_next = (Button) findViewById(R.id.read_button_5_next);
        read_button_5_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_next_onClick();
            }
        });
        
        
	    
	    
	    
	    

    }

    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様

    private void Read_button_5no1_onClick() {
        Intent intent_read_5no1 = new Intent(getApplicationContext(),Read5no1.class);
        startActivity(intent_read_5no1);
    }

    private void Read_button_5no2_onClick() {
        Intent intent_read_5no2 = new Intent(getApplicationContext(),Read5no2.class);
        startActivity(intent_read_5no2);
    }

    private void Read_button_5no3_onClick() {
        Intent intent_read_5no3 = new Intent(getApplicationContext(),Read5no3.class);
        startActivity(intent_read_5no3);
    }

    private void Read_button_5no4_onClick() {
        Intent intent_read_5no4 = new Intent(getApplicationContext(),Read5no4.class);
        startActivity(intent_read_5no4);
    }

    private void Read_button_5no5_onClick() {
        Intent intent_read_5no5 = new Intent(getApplicationContext(),Read5no5.class);
        startActivity(intent_read_5no5);
    }

    private void Read_button_5no6_onClick() {
        Intent intent_read_5no6 = new Intent(getApplicationContext(),Read5no6.class);
        startActivity(intent_read_5no6);
    }

    private void Read_button_5no7_onClick() {
        Intent intent_read_5no7 = new Intent(getApplicationContext(),Read5no7.class);
        startActivity(intent_read_5no7);
    }
    
    private void Read_button_5_back_onClick() {
        Intent intent_read_5_back = new Intent(getApplicationContext(),Read4.class);
        startActivity(intent_read_5_back);
    }
    
    private void Read_button_5_mneu_onClick() {
        Intent intent_read_5_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_5_mneu);
    }
    
    private void Read_button_5_next_onClick() {
        Intent intent_read_5_next = new Intent(getApplicationContext(),Read6.class);
        startActivity(intent_read_5_next);
    }
    

    //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),IndexRead.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}
    
    
    

}
