//処理内容はRead1.javaと同様
//共働きの子育て
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;

public class Read11 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_11_back;
	private Button read_button_11_menu;
	private Button read_button_11_next;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_11);
        
        read_button_11_back = (Button) findViewById(R.id.read_button_11_back);
        read_button_11_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_11_back_onClick();
            }
        });
        
        read_button_11_menu = (Button) findViewById(R.id.read_button_11_mneu);
        read_button_11_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_11_mneu_onClick();
            }
        });
        
        read_button_11_next = (Button) findViewById(R.id.read_button_11_next);
        read_button_11_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_11_next_onClick();
            }
        });
        
        
        
    }
    
    
    private void Read_button_11_back_onClick() {
        Intent intent_read_11_back = new Intent(getApplicationContext(),Read10.class);
        startActivity(intent_read_11_back);
    }
    
    private void Read_button_11_mneu_onClick() {
        Intent intent_read_11_mneu = new Intent(getApplicationContext(),Read10_0.class);
        startActivity(intent_read_11_mneu);
    }
    
    private void Read_button_11_next_onClick() {
        Intent intent_read_11_next = new Intent(getApplicationContext(),Read12no1.class);
        startActivity(intent_read_11_next);
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
