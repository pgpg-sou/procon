//処理内容はRead1.javaと同様
//子育てのスタート
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;

public class Read4 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_4_back;
	private Button read_button_4_menu;
	private Button read_button_4_next;

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_4);
        
        read_button_4_back = (Button) findViewById(R.id.read_button_4_back);
        read_button_4_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_4_back_onClick();
            }
        });
        
        read_button_4_menu = (Button) findViewById(R.id.read_button_4_mneu);
        read_button_4_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_4_mneu_onClick();
            }
        });
        
        read_button_4_next = (Button) findViewById(R.id.read_button_4_next);
        read_button_4_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_4_next_onClick();
            }
        });
        
        
        
        
        
        
    }
    private void Read_button_4_back_onClick() {
        Intent intent_read_4_back = new Intent(getApplicationContext(),Read3.class);
        startActivity(intent_read_4_back);
    }
    
    private void Read_button_4_mneu_onClick() {
        Intent intent_read_4_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_4_mneu);
    }
    
    private void Read_button_4_next_onClick() {
        Intent intent_read_4_next = new Intent(getApplicationContext(),Read5.class);
        startActivity(intent_read_4_next);
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
