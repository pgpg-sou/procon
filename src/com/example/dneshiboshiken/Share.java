//教育機能の目次
package com.example.dneshiboshiken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

public class Share extends Activity {

	//目次の項目だけボタンを定義
	private Button button_share_read;
	private Button button_share_write;
	
	EditText et[];
	String fileName;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_share_write = (Button) findViewById(R.id.Button_Share_Write);
        button_share_write.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_share_read_onClick();
            }
        });
        
      //それぞれのボタンにクリック時の処理を表示
        button_share_read = (Button) findViewById(R.id.Button_Share_Read);
        button_share_read.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_share_read_onClick();
            }
        });


        
       
		
		
		
        
        
        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    public void button_share_read_onClick() {
       // Intent intent_read_1 = new Intent(getApplicationContext(),Calendar.class);
    	Intent intent_read_1 = new Intent(getApplicationContext(),Calendar.class);
       startActivity(intent_read_1);
    }
    
    public void button_share_write_onClick() {
        // Intent intent_read_1 = new Intent(getApplicationContext(),Calendar.class);
     	Intent intent_read_1 = new Intent(getApplicationContext(),Read1.class);
        startActivity(intent_read_1);
     }



  
    
   



  //onCreateOptionsMenuメソッド(オプションメニュー生成)
   /* @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);

    //メニューアイテムの追加
    	MenuItem item1=menu.add(0,0,0,"編集");
    	item1.setIcon(android.R.drawable.ic_menu_edit);

    	MenuItem item2=menu.add(0,1,0,"タイトル");
    	item2.setIcon(R.drawable.ic_menu_home);

    	return true;
    }*/
    
  //onOPtionsItemSelectedメソッド(メニューアイテム選択処理)
   /* @Override
     public boolean onOptionsItemSelected(MenuItem item){
    	 switch (item.getItemId()){
    	 case 0:
    		 Intent intent1 = new Intent();
    		 intent1.setClass(Schedule.this, MainActivity.class);
    		 startActivity(intent1);
    		 return true;
    	 }
    	 return true;
    }*/

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


