//処理内容はRead1.javaと同様
//子どもを事故から守る
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.layout;
public class Read6 extends Activity {
	
	
	//画面移動ボタンを定義
	private Button read_button_6_back;
	private Button read_button_6_menu;
	private Button read_button_6_next;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_6);
        
        read_button_6_back = (Button) findViewById(R.id.read_button_6_back);
        read_button_6_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_6_back_onClick();
            }
        });
        
        read_button_6_menu = (Button) findViewById(R.id.read_button_6_mneu);
        read_button_6_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_6_mneu_onClick();
            }
        });
        
        read_button_6_next = (Button) findViewById(R.id.read_button_6_next);
        read_button_6_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_6_next_onClick();
            }
        });
        
        
    }
    private void Read_button_6_back_onClick() {
        Intent intent_read_6_back = new Intent(getApplicationContext(),Read5.class);
        startActivity(intent_read_6_back);
    }
    
    private void Read_button_6_mneu_onClick() {
        Intent intent_read_6_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_6_mneu);
    }
    
    private void Read_button_6_next_onClick() {
        Intent intent_read_6_next = new Intent(getApplicationContext(),Read7.class);
        startActivity(intent_read_6_next);
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
