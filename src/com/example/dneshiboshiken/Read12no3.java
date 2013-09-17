//処理内容はRead1.javaと同様
//主な母子医療の公費負担制度
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;

public class Read12no3 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_12_3_back;
	private Button read_button_12_3_menu;
	private Button read_button_12_3_next;
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_12no3);
        
        read_button_12_3_back = (Button) findViewById(R.id.read_button_12_3_back);
        read_button_12_3_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_12_3_back_onClick();
            }
        });
        
        read_button_12_3_menu = (Button) findViewById(R.id.read_button_12_3_mneu);
        read_button_12_3_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_12_3_mneu_onClick();
            }
        });
        
        read_button_12_3_next = (Button) findViewById(R.id.read_button_12_3_next);
        read_button_12_3_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_12_3_next_onClick();
            }
        });
        
        
    }
    
    private void Read_button_12_3_back_onClick() {
        Intent intent_read_12_3_back = new Intent(getApplicationContext(),Read12no2.class);
        startActivity(intent_read_12_3_back);
    }
    
    private void Read_button_12_3_mneu_onClick() {
        Intent intent_read_12_3_mneu = new Intent(getApplicationContext(),Read10_3.class);
        startActivity(intent_read_12_3_mneu);
    }
    
    private void Read_button_12_3_next_onClick() {
        Intent intent_read_12_3_next = new Intent(getApplicationContext(),Read18index3.class);
        startActivity(intent_read_12_3_next);
    }
    
    
    
  //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Read10_3.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}
    
}
