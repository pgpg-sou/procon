//処理内容はRead1.javaと同様
//歯の健康と歯みがき
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


public class Read9 extends Activity {
	
	//画面移動ボタンを定義
	private Button read_button_9_back;
	private Button read_button_9_menu;
	private Button read_button_9_next;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_9_1);

        ImageView img001 = (ImageView) findViewById(R.id.imageView1);
        img001.setImageResource(R.drawable.teeth);
        
        read_button_9_back = (Button) findViewById(R.id.read_button_9_back);
        read_button_9_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_9_back_onClick();
            }
        });
        
        read_button_9_menu = (Button) findViewById(R.id.read_button_9_mneu);
        read_button_9_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_9_mneu_onClick();
            }
        });
        
        read_button_9_next = (Button) findViewById(R.id.read_button_9_next);
        read_button_9_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_9_next_onClick();
            }
        });
        
        

    }
    
    private void Read_button_9_back_onClick() {
        Intent intent_read_9_back = new Intent(getApplicationContext(),Read8.class);
        startActivity(intent_read_9_back);
    }
    
    private void Read_button_9_mneu_onClick() {
        Intent intent_read_9_mneu = new Intent(getApplicationContext(),IndexRead.class);
        startActivity(intent_read_9_mneu);
    }
    
    private void Read_button_9_next_onClick() {
        Intent intent_read_9_next = new Intent(getApplicationContext(),Read10_0.class);
        startActivity(intent_read_9_next);
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
