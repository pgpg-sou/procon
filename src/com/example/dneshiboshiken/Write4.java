package com.example.dneshiboshiken;


import java.io.File;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Write4 extends Activity {

	//目次の項目だけボタンを定義
	private Button ButtonLock_write_4;
	private Button ButtonUnlock_write_4;
	private Button ButtonCancel_write_4;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_4);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        ButtonLock_write_4 = (Button) findViewById(R.id.ButtonLock_write_4);
        ButtonLock_write_4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            ButtonLock_write_4_onClick();
            }
        });

        ButtonUnlock_write_4 = (Button) findViewById(R.id.ButtonUnlock_write_4);
        ButtonUnlock_write_4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonUnlock_write_4_onClick();
            }
        });

        ButtonCancel_write_4 = (Button) findViewById(R.id.ButtonCancel_write_4);
        ButtonCancel_write_4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonCancel_write_4_onClick();
            }
        });







    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void ButtonLock_write_4_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_31.class);
        startActivity(intent_read_1);
    }

    private void ButtonUnlock_write_4_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_0.class);
        startActivity(intent_read_2);
    }

    private void ButtonCancel_write_4_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_0_21.class);
        startActivity(intent_read_3);
    }
    
   



  //onCreateOptionsMenuメソッド(オプションメニュー生成)
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);

    //メニューアイテムの追加
    	MenuItem item1=menu.add(0,0,0,"編集");
    	item1.setIcon(android.R.drawable.ic_menu_edit);

    	MenuItem item2=menu.add(0,1,0,"タイトル");
    	item2.setIcon(R.drawable.ic_menu_home);

    	return true;
    }
    


  //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Write_0_41.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}


}