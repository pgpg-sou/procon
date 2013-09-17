//教育機能の目次
package com.example.dneshiboshiken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Write_0_41 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_0_41_back;
	private Button button_Write_0_41_home;
	private Button button_Write_0_41_next;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_0_41);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_0_41_back = (Button) findViewById(R.id.Button_Write_0_41_back);
        button_Write_0_41_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_0_41_back_onClick();
            }
        });

        button_Write_0_41_home = (Button) findViewById(R.id.Button_Write_0_41_home);
        button_Write_0_41_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_0_41_home_onClick();
            }
        });

        button_Write_0_41_next = (Button) findViewById(R.id.Button_Write_0_41_next);
        button_Write_0_41_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_0_41_next_onClick();
            }
        });







    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_0_41_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_21.class);
        startActivity(intent_read_1);
    }

    private void button_Write_0_41_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),Write4.class);
        startActivity(intent_read_2);
    }

    private void button_Write_0_41_next_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_0_11.class);
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
    		 intent1.setClass(Write_0_41.this, Write3.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_0_41.this, MainActivity.class);
    		 startActivity(intent2);
    		 return true;
    	 }
    	 return true;
    }



}
