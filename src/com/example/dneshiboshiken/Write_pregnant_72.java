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
import java.util.GregorianCalendar;

import android.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.array;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

public class Write_pregnant_72 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_pregnant_72_back;
	private Button button_Write_pregnant_72_home;
	private Button button_Write_pregnant_72_next;

	EditText et[];
	String fileName;
	Spinner spin[];
	CheckBox cb[];

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_pregnant_72);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_pregnant_72_back = (Button) findViewById(R.id.Button_Write_pregnant_72_back);
        button_Write_pregnant_72_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_pregnant_72_back_onClick();
            }
        });

        button_Write_pregnant_72_home = (Button) findViewById(R.id.Button_Write_pregnant_72_home);
        button_Write_pregnant_72_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_72_home_onClick();
            }
        });

        button_Write_pregnant_72_next = (Button) findViewById(R.id.Button_Write_pregnant_72_next);
        button_Write_pregnant_72_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_72_next_onClick();
            }
        });
        
      //表示するEditTextを宣言
  		et=new EditText[16];
  		et[0]=(EditText)findViewById(R.id.EditText_write_pregnant_72_01);
  		et[1]=(EditText)findViewById(R.id.EditText_write_pregnant_72_02);
  		et[2]=(EditText)findViewById(R.id.EditText_write_pregnant_72_03);
  		et[3]=(EditText)findViewById(R.id.EditText_write_pregnant_72_04);
  		et[4]=(EditText)findViewById(R.id.EditText_write_pregnant_72_05);
  		et[5]=(EditText)findViewById(R.id.EditText_write_pregnant_72_06);
  		et[6]=(EditText)findViewById(R.id.EditText_write_pregnant_72_07);
  		et[7]=(EditText)findViewById(R.id.EditText_write_pregnant_72_08);
  		et[8]=(EditText)findViewById(R.id.EditText_write_pregnant_72_09);
  		et[9]=(EditText)findViewById(R.id.EditText_write_pregnant_72_10);
  		et[10]=(EditText)findViewById(R.id.EditText_write_pregnant_72_11);
  		et[11]=(EditText)findViewById(R.id.EditText_write_pregnant_72_12);
  		et[12]=(EditText)findViewById(R.id.EditText_write_pregnant_72_13);
  		et[13]=(EditText)findViewById(R.id.EditText_write_pregnant_72_14);
  		et[14]=(EditText)findViewById(R.id.EditText_write_pregnant_72_15);
  		et[15]=(EditText)findViewById(R.id.EditText_write_pregnant_72_16);
        
  		for(int i=0;i<et.length;i++){
			et[i].setText("");
		}
		Calendar cl=Calendar.getInstance();
		et[0].setText(String.valueOf(cl.get(Calendar.YEAR)));
		et[1].setText(String.valueOf(cl.get(Calendar.MONTH)));
		et[2].setText(String.valueOf(cl.get(Calendar.DAY_OF_MONTH)));
		
		//日数計算
				Calendar birthDay=new GregorianCalendar(2011, 4, 17);
				int differenceDay=(int)((cl.getTimeInMillis()-birthDay.getTimeInMillis())/(1000*3600*24));
				et[3].setText(String.valueOf(differenceDay/365));
				differenceDay=differenceDay%365;
				et[4].setText(String.valueOf(differenceDay/30));
		
				int numOfSpinner=35;
		        spin=new Spinner[numOfSpinner];
				String labels[][]= new String[spin.length][];
		        spin[0]=(Spinner)findViewById(R.id.Spinner01);
		        spin[1]=(Spinner)findViewById(R.id.Spinner02);
		        spin[2]=(Spinner)findViewById(R.id.Spinner03);
		        spin[3]=(Spinner)findViewById(R.id.Spinner04);
		        spin[4]=(Spinner)findViewById(R.id.Spinner05);
		        spin[5]=(Spinner)findViewById(R.id.Spinner06);
		        spin[6]=(Spinner)findViewById(R.id.Spinner07);
		        spin[7]=(Spinner)findViewById(R.id.Spinner08);
		        spin[8]=(Spinner)findViewById(R.id.Spinner09);
		        spin[9]=(Spinner)findViewById(R.id.Spinner10);
		        spin[10]=(Spinner)findViewById(R.id.Spinner11);
		        spin[11]=(Spinner)findViewById(R.id.Spinner12);
		        spin[12]=(Spinner)findViewById(R.id.Spinner13);
		        spin[13]=(Spinner)findViewById(R.id.Spinner14);
		        spin[14]=(Spinner)findViewById(R.id.Spinner15);
		        spin[15]=(Spinner)findViewById(R.id.Spinner16);
		        spin[16]=(Spinner)findViewById(R.id.Spinner17);
		        spin[17]=(Spinner)findViewById(R.id.Spinner18);
		        spin[18]=(Spinner)findViewById(R.id.Spinner19);
		        spin[19]=(Spinner)findViewById(R.id.Spinner20);
		        spin[20]=(Spinner)findViewById(R.id.Spinner21);
		        spin[21]=(Spinner)findViewById(R.id.Spinner22);
		        spin[22]=(Spinner)findViewById(R.id.Spinner23);
		        spin[23]=(Spinner)findViewById(R.id.Spinner24);
		        spin[24]=(Spinner)findViewById(R.id.Spinner25);
		        spin[25]=(Spinner)findViewById(R.id.Spinner26);
		        spin[26]=(Spinner)findViewById(R.id.Spinner27);
		        spin[27]=(Spinner)findViewById(R.id.Spinner28);
		        spin[28]=(Spinner)findViewById(R.id.Spinner29);
		        spin[29]=(Spinner)findViewById(R.id.Spinner30);
		        spin[30]=(Spinner)findViewById(R.id.Spinner31);
		        spin[31]=(Spinner)findViewById(R.id.Spinner32);
		        spin[32]=(Spinner)findViewById(R.id.Spinner33);
		        spin[33]=(Spinner)findViewById(R.id.Spinner34);
		        spin[34]=(Spinner)findViewById(R.id.Spinner35);
		        for(int i=0;i<32;i++){
		            labels[i] = getResources().getStringArray(R.array.tooth_condition);
		        }
		        labels[32] = getResources().getStringArray(R.array.nashi_ari);
		        labels[33] = getResources().getStringArray(R.array.ninshin_sango);
		        labels[34] = getResources().getStringArray(R.array.nashi_ari);
		        ArrayAdapter<String> adapter;
		        for(int i=0;i<spin.length;i++){
		            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels[i]);
			        spin[i].setAdapter(adapter);
			        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		        }
		
        
        
		        cb=new CheckBox[4];
		        cb[0]=(CheckBox)findViewById(R.id.CheckBox01);
		        cb[1]=(CheckBox)findViewById(R.id.CheckBox02);
		        cb[2]=(CheckBox)findViewById(R.id.CheckBox03);
		        cb[3]=(CheckBox)findViewById(R.id.CheckBox04);
		        
		        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_pregnant_72_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_pregnant_61.class);
        startActivity(intent_read_1);
    }

    private void button_Write_pregnant_72_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
        startActivity(intent_read_2);
    }

    private void button_Write_pregnant_72_next_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_pregnant_81.class);
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
    		 intent1.setClass(Write_pregnant_72.this, Write3.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_pregnant_72.this, MainActivity.class);
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
