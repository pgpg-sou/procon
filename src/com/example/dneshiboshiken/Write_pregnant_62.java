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

public class Write_pregnant_62 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_pregnant_62_back;
	private Button button_Write_pregnant_62_home;
	private Button button_Write_pregnant_62_next;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_pregnant_62);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_pregnant_62_back = (Button) findViewById(R.id.Button_Write_pregnant_62_back);
        button_Write_pregnant_62_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_pregnant_62_back_onClick();
            }
        });

        button_Write_pregnant_62_home = (Button) findViewById(R.id.Button_Write_pregnant_62_home);
        button_Write_pregnant_62_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_62_home_onClick();
            }
        });

        button_Write_pregnant_62_next = (Button) findViewById(R.id.Button_Write_pregnant_62_next);
        button_Write_pregnant_62_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_62_next_onClick();
            }
        });







    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_pregnant_62_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_pregnant_51.class);
        startActivity(intent_read_1);
    }

    private void button_Write_pregnant_62_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
        startActivity(intent_read_2);
    }

    private void button_Write_pregnant_62_next_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_pregnant_71.class);
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
    
  //onOPtionsItemSelectedメソッド(メニューアイテム選択処理)
    @Override
     public boolean onOptionsItemSelected(MenuItem item){
    	 switch (item.getItemId()){
    	 case 0:
    		 Intent intent1 = new Intent();
    		 intent1.setClass(Write_pregnant_62.this, Write3.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_pregnant_62.this, MainActivity.class);
    		 startActivity(intent2);
    		 return true;
    	 }
    	 return true;
    }
    //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}


}
