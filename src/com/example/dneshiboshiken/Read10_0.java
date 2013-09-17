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

public class Read10_0 extends Activity {

	//目次の項目だけボタンを定義
	private Button read_button_10;
	private Button read_button_11;
	private Button read_button_10_3;
	private Button read_button_18;
	
	//画面移動ボタンを定義
	private Button read_button_10_0_back;
	private Button read_button_10_0_menu;
	private Button read_button_10_0_next;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_10_0);	//画面レイアウトを指定(res/layout/index_read.xml)

        //それぞれのボタンにクリック時の処理を表示
	    read_button_18 = (Button) findViewById(R.id.read_button_18);
	    read_button_18.setOnClickListener(new View.OnClickListener(){
	            public void onClick(View v) {
                    Read_button_18_onClick();
	            }
	    });

	    read_button_10 = (Button) findViewById(R.id.read_button_10);
	    read_button_10.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                    Read_button_10_onClick();
	            }
	    });

	    read_button_11 = (Button) findViewById(R.id.read_button_11);
	    read_button_11.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                    Read_button_11_onClick();
	            }
	    });

	    read_button_10_3 = (Button) findViewById(R.id.read_button_10_3);
	    read_button_10_3.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	                    Read_button_10_3_onClick();
	            }
	    });

	    
        read_button_10_0_back = (Button) findViewById(R.id.read_button_10_0_back);
        read_button_10_0_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_10_0_back_onClick();
            }
        });
        
        read_button_10_0_menu = (Button) findViewById(R.id.read_button_10_0_mneu);
        read_button_10_0_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_10_0_mneu_onClick();
            }
        });
        
        read_button_10_0_next = (Button) findViewById(R.id.read_button_10_0_next);
        read_button_10_0_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_10_0_next_onClick();
            }
        });
	    
	    

    }

    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様

    	private void Read_button_10_onClick() {
    	Intent intent_read_10 = new Intent(getApplicationContext(),Read10.class);
    	startActivity(intent_read_10);
    }

    	private void Read_button_11_onClick() {
    	Intent intent_read_11 = new Intent(getApplicationContext(),Read11.class);
    	startActivity(intent_read_11);
    }

    	private void Read_button_10_3_onClick() {
    	Intent intent_read_10_3 = new Intent(getApplicationContext(),Read10_3.class);
    	startActivity(intent_read_10_3);
    }


	private void Read_button_18_onClick() {
		Intent intent_read_18 = new Intent(getApplicationContext(),Read18index3.class);
    	startActivity(intent_read_18);
    }

    private void Read_button_10_0_back_onClick() {
        Intent intent_read_10_0_back = new Intent(getApplicationContext(),Read9.class);
        startActivity(intent_read_10_0_back);
    }
    
    private void Read_button_10_0_mneu_onClick() {
        Intent intent_read_10_0_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_10_0_mneu);
    }
    
    private void Read_button_10_0_next_onClick() {
        Intent intent_read_10_0_next = new Intent(getApplicationContext(),Read1.class);
        startActivity(intent_read_10_0_next);
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
