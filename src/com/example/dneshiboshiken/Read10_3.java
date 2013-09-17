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

public class Read10_3 extends Activity {

	//目次の項目だけボタンを定義
	private Button read_button_12no1;
	private Button read_button_12no2;
	private Button read_button_12no3;
	
	//画面移動ボタンを定義
	private Button read_button_10_3_back;
	private Button read_button_10_3_menu;
	private Button read_button_10_3_next;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_10_3);	//画面レイアウトを指定(res/layout/index_read.xml)



	    read_button_12no1 = (Button) findViewById(R.id.read_button_12no1);
	    read_button_12no1.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                    Read_button_12no1_onClick();
	            }
	    });

	    read_button_12no2 = (Button) findViewById(R.id.read_button_12no2);
	    read_button_12no2.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                    Read_button_12no2_onClick();
	            }
	    });

	    read_button_12no3 = (Button) findViewById(R.id.read_button_12no3);
	    read_button_12no3.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                    Read_button_12no3_onClick();
	            }
	    });
	    
        read_button_10_3_back = (Button) findViewById(R.id.read_button_10_3_back);
        read_button_10_3_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_10_3_back_onClick();
            }
        });
        
        read_button_10_3_menu = (Button) findViewById(R.id.read_button_10_3_mneu);
        read_button_10_3_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_10_3_mneu_onClick();
            }
        });
        
        read_button_10_3_next = (Button) findViewById(R.id.read_button_10_3_next);
        read_button_10_3_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_10_3_next_onClick();
            }
        });
	    
	    

    }

    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様


    	private void Read_button_12no1_onClick() {
    	Intent intent_read_12no1 = new Intent(getApplicationContext(),Read12no1.class);
    	startActivity(intent_read_12no1);
    }

    	private void Read_button_12no2_onClick() {
    	Intent intent_read_12no2 = new Intent(getApplicationContext(),Read12no2.class);
    	startActivity(intent_read_12no2);
    }

    	private void Read_button_12no3_onClick() {
    	Intent intent_read_12no3 = new Intent(getApplicationContext(),Read12no3.class);
    	startActivity(intent_read_12no3);
    }


    private void Read_button_10_3_back_onClick() {
        Intent intent_read_10_3_back = new Intent(getApplicationContext(),Read9.class);
        startActivity(intent_read_10_3_back);
    }
    
    private void Read_button_10_3_mneu_onClick() {
        Intent intent_read_10_3_mneu = new Intent(getApplicationContext(),Read10_0.class);
        startActivity(intent_read_10_3_mneu);
    }
    
    private void Read_button_10_3_next_onClick() {
        Intent intent_read_10_3_next = new Intent(getApplicationContext(),Read18index3.class);
        startActivity(intent_read_10_3_next);
    }
    
  //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Read10_0.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}
    

}
