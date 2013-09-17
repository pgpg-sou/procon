//処理内容はRead1.javaと同様
//育児のしおり2歳
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;

public class Read5no5 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_5_5_back;
	private Button read_button_5_5_menu;
	private Button read_button_5_5_next;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_5no5);
        
        
        read_button_5_5_back = (Button) findViewById(R.id.read_button_5_5_back);
        read_button_5_5_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_5_back_onClick();
            }
        });
        
        read_button_5_5_menu = (Button) findViewById(R.id.read_button_5_5_mneu);
        read_button_5_5_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_5_mneu_onClick();
            }
        });
        
        read_button_5_5_next = (Button) findViewById(R.id.read_button_5_5_next);
        read_button_5_5_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_5_5_next_onClick();
            }
        });
        
        
        
        
    }
    
    private void Read_button_5_5_back_onClick() {
        Intent intent_read_5_5_back = new Intent(getApplicationContext(),Read5no4.class);
        startActivity(intent_read_5_5_back);
    }
    
    private void Read_button_5_5_mneu_onClick() {
        Intent intent_read_5_5_mneu = new Intent(getApplicationContext(),Read5.class);
        startActivity(intent_read_5_5_mneu);
    }
    
    private void Read_button_5_5_next_onClick() {
        Intent intent_read_5_5_next = new Intent(getApplicationContext(),Read5no6.class);
        startActivity(intent_read_5_5_next);
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
