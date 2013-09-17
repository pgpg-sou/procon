//処理内容はRead1.javaと同様
//乳幼児期の栄養
package com.example.dneshiboshiken;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.drawable;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

public class Read7 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_7_back;
	private Button read_button_7_menu;
	private Button read_button_7_next;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_7);
        
        ImageView img001 = (ImageView) findViewById(R.id.imageView1);
        img001.setImageResource(R.drawable.rinyu);
        
        read_button_7_back = (Button) findViewById(R.id.read_button_7_back);
        read_button_7_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_7_back_onClick();
            }
        });
        
        read_button_7_menu = (Button) findViewById(R.id.read_button_7_mneu);
        read_button_7_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_7_mneu_onClick();
            }
        });
        
        read_button_7_next = (Button) findViewById(R.id.read_button_7_next);
        read_button_7_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_7_next_onClick();
            }
        });
        
        
        
        

    }
    
    private void Read_button_7_back_onClick() {
        Intent intent_read_7_back = new Intent(getApplicationContext(),Read6.class);
        startActivity(intent_read_7_back);
    }
    
    private void Read_button_7_mneu_onClick() {
        Intent intent_read_7_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_7_mneu);
    }
    
    private void Read_button_7_next_onClick() {
        Intent intent_read_7_next = new Intent(getApplicationContext(),Read8.class);
        startActivity(intent_read_7_next);
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
