//処理内容はIndexRead.javaと同様
//知っておきたい救命手当　目次
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

public class Read18index3 extends Activity{

	private Button read_button_1;
	private Button read_button_2;
	
	//画面移動ボタンを定義
	private Button read_button_18_index_back;
	private Button read_button_18_index_menu;
	private Button read_button_18_index_next;
	
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_18_index);

        read_button_1 = (Button) findViewById(R.id.button1);
        read_button_1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
            	Read_button_1_onClick();
            }
        });

        read_button_2 = (Button) findViewById(R.id.button2);
        read_button_2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
            	Read_button_2_onClick();
            }
        });
        read_button_18_index_back = (Button) findViewById(R.id.read_button_18_index_back);
        read_button_18_index_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_18_index_back_onClick();
            }
        });
        
        read_button_18_index_menu = (Button) findViewById(R.id.read_button_18_index_mneu);
        read_button_18_index_menu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_18_index_mneu_onClick();
            }
        });
        
        read_button_18_index_next = (Button) findViewById(R.id.read_button_18_index_next);
        read_button_18_index_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            Read_button_18_index_next_onClick();
            }
        });

    }

    private void Read_button_1_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Read18_1.class);
        startActivity(intent_read_1);
    }

    private void Read_button_2_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),Read18_2.class);
        startActivity(intent_read_2);
    }
    
    private void Read_button_18_index_back_onClick() {
        Intent intent_read_18_index_back = new Intent(getApplicationContext(),Read12no3.class);
        startActivity(intent_read_18_index_back);
    }
    
    private void Read_button_18_index_mneu_onClick() {
        Intent intent_read_18_index_mneu = new Intent(getApplicationContext(),Read10_0.class);
        startActivity(intent_read_18_index_mneu);
    }
    
    private void Read_button_18_index_next_onClick() {
        Intent intent_read_18_index_next = new Intent(getApplicationContext(),Read10.class);
        startActivity(intent_read_18_index_next);
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
