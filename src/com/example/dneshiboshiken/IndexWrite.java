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

public class IndexWrite extends Activity {

	private Button write_button_0_1;
	private Button write_button_0_2;
	private Button write_button_0_3;


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
                Intent intent_write = new Intent(getApplicationContext(),Read1.class);
                startActivity(intent_write);
            }
        });

        write_button_0_2 = (Button) findViewById(R.id.write_button_0_2);
        write_button_0_2.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Read2.class);
                startActivity(intent_write);
        	}
        });

        write_button_0_3 = (Button) findViewById(R.id.write_button_0_3);
        write_button_0_3.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Read3.class);
                startActivity(intent_write);
        	}
        });



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