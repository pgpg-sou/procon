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
import com.example.dneshiboshiken.R.array;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

public class Write_pregnant_42 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_pregnant_42_back;
	private Button button_Write_pregnant_42_home;
	private Button button_Write_pregnant_42_next;

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
        setContentView(R.layout.write_pregnant_42);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_pregnant_42_back = (Button) findViewById(R.id.Button_Write_pregnant_42_back);
        button_Write_pregnant_42_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_pregnant_42_back_onClick();
            }
        });

        button_Write_pregnant_42_home = (Button) findViewById(R.id.Button_Write_pregnant_42_home);
        button_Write_pregnant_42_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_42_home_onClick();
            }
        });

        button_Write_pregnant_42_next = (Button) findViewById(R.id.Button_Write_pregnant_42_next);
        button_Write_pregnant_42_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_42_next_onClick();
            }
        });
        
      //ファイル名を指定
		fileName="write_4.txt";
		
		int numOfEditText=42;
		int numOfCheckBox=0;
		
		//表示するEditTextを宣言
  		et=new EditText[numOfEditText];
  		et[0]=(EditText)findViewById(R.id.EditText_write_pregnant_42_01);
  		et[1]=(EditText)findViewById(R.id.EditText_write_pregnant_42_02);
  		et[2]=(EditText)findViewById(R.id.EditText_write_pregnant_42_03);
  		et[3]=(EditText)findViewById(R.id.EditText_write_pregnant_42_04);
  		et[4]=(EditText)findViewById(R.id.EditText_write_pregnant_42_05);
  		et[5]=(EditText)findViewById(R.id.EditText_write_pregnant_42_06);
  		et[6]=(EditText)findViewById(R.id.EditText_write_pregnant_42_07);
  		et[7]=(EditText)findViewById(R.id.EditText_write_pregnant_42_08);
  		et[8]=(EditText)findViewById(R.id.EditText_write_pregnant_42_09);
  		et[9]=(EditText)findViewById(R.id.EditText_write_pregnant_42_10);
  		et[10]=(EditText)findViewById(R.id.EditText_write_pregnant_42_11);
  		et[11]=(EditText)findViewById(R.id.EditText_write_pregnant_42_12);
  		et[12]=(EditText)findViewById(R.id.EditText_write_pregnant_42_13);
  		et[13]=(EditText)findViewById(R.id.EditText_write_pregnant_42_14);
  		et[14]=(EditText)findViewById(R.id.EditText_write_pregnant_42_15);
  		et[15]=(EditText)findViewById(R.id.EditText_write_pregnant_42_16);
  		et[16]=(EditText)findViewById(R.id.EditText_write_pregnant_42_17);
  		et[17]=(EditText)findViewById(R.id.EditText_write_pregnant_42_18);
  		et[18]=(EditText)findViewById(R.id.EditText_write_pregnant_42_19);
  		et[19]=(EditText)findViewById(R.id.EditText_write_pregnant_42_20);
  		et[20]=(EditText)findViewById(R.id.EditText_write_pregnant_42_21);
  		et[21]=(EditText)findViewById(R.id.EditText_write_pregnant_42_22);
  		et[22]=(EditText)findViewById(R.id.EditText_write_pregnant_42_23);
  		et[23]=(EditText)findViewById(R.id.EditText_write_pregnant_42_24);
  		et[24]=(EditText)findViewById(R.id.EditText_write_pregnant_42_25);
  		et[25]=(EditText)findViewById(R.id.EditText_write_pregnant_42_26);
  		et[26]=(EditText)findViewById(R.id.EditText_write_pregnant_42_27);
  		et[27]=(EditText)findViewById(R.id.EditText_write_pregnant_42_28);
  		et[28]=(EditText)findViewById(R.id.EditText_write_pregnant_42_29);
  		et[29]=(EditText)findViewById(R.id.EditText_write_pregnant_42_30);
  		et[30]=(EditText)findViewById(R.id.EditText_write_pregnant_42_31);
  		et[31]=(EditText)findViewById(R.id.EditText_write_pregnant_42_32);
  		et[32]=(EditText)findViewById(R.id.EditText_write_pregnant_42_33);
  		et[33]=(EditText)findViewById(R.id.EditText_write_pregnant_42_34);
  		et[34]=(EditText)findViewById(R.id.EditText_write_pregnant_42_35);
  		et[35]=(EditText)findViewById(R.id.EditText_write_pregnant_42_36);
  		et[36]=(EditText)findViewById(R.id.EditText_write_pregnant_42_37);
  		et[37]=(EditText)findViewById(R.id.EditText_write_pregnant_42_38);
  		et[38]=(EditText)findViewById(R.id.EditText_write_pregnant_42_39);
  		et[39]=(EditText)findViewById(R.id.EditText_write_pregnant_42_40);
  		et[40]=(EditText)findViewById(R.id.EditText_write_pregnant_42_41);
  		et[41]=(EditText)findViewById(R.id.EditText_write_pregnant_42_42);
  		
  	//空欄にする
		for(int i=0;i<et.length;i++){
			et[i].setText("");
		}

  		
  	//検査の年月日記入欄に現在の日付を表示
		Calendar cld=Calendar.getInstance();
		et[0].setText(String.valueOf(cld.get(Calendar.YEAR)));
		et[1].setText(String.valueOf(cld.get(Calendar.MONTH)+1));
		et[2].setText(String.valueOf(cld.get(Calendar.DAY_OF_MONTH)));
		
		spin=new Spinner[6];
		spin[0]=(Spinner)findViewById(R.id.spinner25);
		spin[1]=(Spinner)findViewById(R.id.spinner24);
		spin[2]=(Spinner)findViewById(R.id.spinner26);
		spin[3]=(Spinner)findViewById(R.id.spinner21);
		spin[4]=(Spinner)findViewById(R.id.spinner22);
		spin[5]=(Spinner)findViewById(R.id.spinner23);
		
		labels=new String[spin.length][];
        labels[0] = getResources().getStringArray(R.array.blood_type_abo);
        labels[1] = getResources().getStringArray(R.array.blood_type_rh);
        labels[2] = getResources().getStringArray(R.array.means_of_Transport_tohospital);
        labels[3] = getResources().getStringArray(R.array.mother_condition);
        labels[4] = getResources().getStringArray(R.array.mother_condition);
        labels[5] = getResources().getStringArray(R.array.mother_condition);
         ArrayAdapter<String> adapter;
        for(int i=0;i<spin.length;i++){
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels[i]);
	        spin[i].setAdapter(adapter);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
		
        
        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_pregnant_42_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_21.class);
        startActivity(intent_read_1);
    }

    private void button_Write_pregnant_42_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
        startActivity(intent_read_2);
    }

    private void button_Write_pregnant_42_next_onClick() {
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
    		 intent1.setClass(Write_pregnant_42.this, Write3.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_pregnant_42.this, MainActivity.class);
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
