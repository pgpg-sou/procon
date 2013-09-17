package com.example.dneshiboshiken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class IndexWrite_0 extends Activity {

	private Button write_button_0_1;
	private Button write_button_0_2;
	private Button write_button_0_3;

	//ホーム画面に戻るボタンを定義
	private Button index_read_home;

	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_write_0);
        
        /*final String sdcard = Environment.getExternalStorageDirectory().getPath();
        XmlMyFunc xmf=new XmlMyFunc();
        String fileName=sdcard+"/data.xml";
		if(xmf.searchTag("root/child/name")){
			setTitle(xmf.getData( "root/child/name")+"ちゃんの電子母子健康手帳");
		}**/

        write_button_0_1 = (Button) findViewById(R.id.write_button_0_1);
        write_button_0_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent_write = new Intent(getApplicationContext(),Write_0_11.class);
                startActivity(intent_write);
            }
        });

        write_button_0_2 = (Button) findViewById(R.id.write_button_0_2);
        write_button_0_2.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_0_21.class);
                startActivity(intent_write);
        	}
        });

        write_button_0_3 = (Button) findViewById(R.id.write_button_0_3);
        write_button_0_3.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_0_31.class);
                startActivity(intent_write);
        	}
        });
        index_read_home = (Button) findViewById(R.id.index_read_home);
	    index_read_home.setOnClickListener(new View.OnClickListener(){

	            public void onClick(View v) {
	            	Index_read_home_onClick();
	            }
	    });




	}
    private void Index_read_home_onClick() {
        Intent index_read_home = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(index_read_home);
    }
    
    
    //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),MainActivity.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}
    
    
    
    
 }