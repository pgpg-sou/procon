//処理内容はRead1.javaと同様
//予防接種
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;

public class Read8 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_8_back;
	private Button read_button_8_menu;
	private Button read_button_8_next;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_8);
        
        read_button_8_back = (Button) findViewById(R.id.read_button_8_back);
        read_button_8_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_8_back_onClick();
            }
        });
        
        read_button_8_menu = (Button) findViewById(R.id.read_button_8_mneu);
        read_button_8_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_8_mneu_onClick();
            }
        });
        
        read_button_8_next = (Button) findViewById(R.id.read_button_8_next);
        read_button_8_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_8_next_onClick();
            }
        });
        
        
        
    }
    
    private void Read_button_8_back_onClick() {
        Intent intent_read_8_back = new Intent(getApplicationContext(),Read7.class);
        startActivity(intent_read_8_back);
    }
    
    private void Read_button_8_mneu_onClick() {
        Intent intent_read_8_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_8_mneu);
    }
    
    private void Read_button_8_next_onClick() {
        Intent intent_read_8_next = new Intent(getApplicationContext(),Read9.class);
        startActivity(intent_read_8_next);
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
