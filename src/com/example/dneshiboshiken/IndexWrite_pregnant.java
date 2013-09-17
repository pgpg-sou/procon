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

public class IndexWrite_pregnant extends Activity {

	private Button write_button_pregnant_1;
	private Button write_button_pregnant_2;
	private Button write_button_pregnant_3;
	private Button write_button_pregnant_4;
	private Button write_button_pregnant_5;
	
	//ホーム画面に戻るボタンを定義
	private Button index_read_home;

	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_write_pregnant);
        
        /*final String sdcard = Environment.getExternalStorageDirectory().getPath();
        XmlMyFunc xmf=new XmlMyFunc();
        String fileName=sdcard+"/data.xml";
		if(xmf.searchTag("root/child/name")){
			setTitle(xmf.getData( "root/child/name")+"ちゃんの電子母子健康手帳");
		}**/

        write_button_pregnant_1 = (Button) findViewById(R.id.write_button_pregnant_1);
        write_button_pregnant_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent_write = new Intent(getApplicationContext(),Write_pregnant_41.class);
                startActivity(intent_write);
            }
        });

        write_button_pregnant_2 = (Button) findViewById(R.id.write_button_pregnant_2);
        write_button_pregnant_2.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_pregnant_51.class);
                startActivity(intent_write);
        	}
        });

        write_button_pregnant_3 = (Button) findViewById(R.id.write_button_pregnant_3);
        write_button_pregnant_3.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_pregnant_61.class);
                startActivity(intent_write);
        	}
        });
        
        write_button_pregnant_4 = (Button) findViewById(R.id.write_button_pregnant_4);
        write_button_pregnant_4.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_pregnant_71.class);
                startActivity(intent_write);
        	}
        });
        
        write_button_pregnant_5 = (Button) findViewById(R.id.write_button_pregnant_5);
        write_button_pregnant_5.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_pregnant_81.class);
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