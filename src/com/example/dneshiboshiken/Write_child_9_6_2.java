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
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.array;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Write_child_9_6_2 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_child_9_12_2_back;
	private Button button_Write_child_9_12_2_home;
	private Button button_Write_child_9_12_2_next;

	EditText et[];
	int numOfButton[];
	Spinner spin[];
	String labels[][];
	CheckBox cb[];
	String fileName;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_child_9_6_2);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_child_9_12_2_back = (Button) findViewById(R.id.ButtonLock);
        button_Write_child_9_12_2_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_child_9_12_2_back_onClick();
            }
        });

        button_Write_child_9_12_2_home = (Button) findViewById(R.id.ButtonUnlock);
        button_Write_child_9_12_2_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_child_9_12_2_home_onClick();
            }
        });

        button_Write_child_9_12_2_next = (Button) findViewById(R.id.ButtonCancel);
        button_Write_child_9_12_2_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_child_9_12_2_next_onClick();
            }
        });

        fileName="write_9_6.txt";

		int numOfEditText=29;
		int numOfCheckBox=0;

		et=new EditText[numOfEditText];
		et[0]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_01);
		et[1]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_02);
		et[2]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_03);
		et[3]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_04);
		et[4]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_05);
		et[5]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_06);
		et[6]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_07);
		et[7]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_08);
		et[8]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_09);
		et[9]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_10);
		et[10]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_11);
		et[11]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_12);
		et[12]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_13);
		et[13]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_14);
		et[14]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_15);
		et[15]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_16);
		et[16]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_17);
		et[17]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_18);
		et[18]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_19);
		et[19]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_20);
		et[20]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_21);
		et[21]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_22);
		et[22]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_23);
		et[23]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_24);
		et[24]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_25);
		et[25]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_26);
		et[26]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_27);
		et[27]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_28);
		et[28]=(EditText)findViewById(R.id.EditText_write_child_9_6_2_29);
		for(int i=0;i<et.length;i++){
			et[i].setText("");
		}

		cb=new CheckBox[numOfCheckBox];

		spin=new Spinner[6];
		spin[0]=(Spinner)findViewById(R.id.Spinner01);
		spin[1]=(Spinner)findViewById(R.id.Spinner02);
		spin[2]=(Spinner)findViewById(R.id.Spinner03);
		spin[3]=(Spinner)findViewById(R.id.Spinner04);
		spin[4]=(Spinner)findViewById(R.id.Spinner05);
		spin[5]=(Spinner)findViewById(R.id.Spinner06);

		labels=new String[spin.length][];
		for(int i=0;i<labels.length;i++){
	        labels[i] = getResources().getStringArray(R.array.yes_no);
		}
        ArrayAdapter<String> adapter;
        for(int i=0;i<spin.length;i++){
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels[i]);
	        spin[i].setAdapter(adapter);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_child_9_12_2_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_21.class);
        startActivity(intent_read_1);
    }

    private void button_Write_child_9_12_2_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
        startActivity(intent_read_2);
    }

    private void button_Write_child_9_12_2_next_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_pregnant_51.class);
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
    		 intent1.setClass(Write_child_9_6_2.this, Write3.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_child_9_6_2.this, MainActivity.class);
    		 startActivity(intent2);
    		 return true;
    	 }
    	 return true;
    }



}
