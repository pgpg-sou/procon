//処理内容はRead1.javaと同様
//育児のしおり5，6歳
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;

public class Read5no7 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_5_7_back;
	private Button read_button_5_7_menu;
	private Button read_button_5_7_next;
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_5no7);
        
        read_button_5_7_back = (Button) findViewById(R.id.read_button_5_7_back);
        read_button_5_7_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_7_back_onClick();
            }
        });
        
        read_button_5_7_menu = (Button) findViewById(R.id.read_button_5_7_mneu);
        read_button_5_7_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_7_mneu_onClick();
            }
        });
        
        read_button_5_7_next = (Button) findViewById(R.id.read_button_5_7_next);
        read_button_5_7_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_7_next_onClick();
            }
        });
        
        
        
    }
    
    private void Read_button_5_7_back_onClick() {
        Intent intent_read_5_7_back = new Intent(getApplicationContext(),Read5no6.class);
        startActivity(intent_read_5_7_back);
    }
    
    private void Read_button_5_7_mneu_onClick() {
        Intent intent_read_5_7_mneu = new Intent(getApplicationContext(),Read5.class);
        startActivity(intent_read_5_7_mneu);
    }
    
    private void Read_button_5_7_next_onClick() {
        Intent intent_read_5_7_next = new Intent(getApplicationContext(),Read5no1.class);
        startActivity(intent_read_5_7_next);
    }
    
    
  //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Read5.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}
    
}
