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

public class Write_pregnant_52 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_pregnant_52_back;
	private Button button_Write_pregnant_52_home;
	private Button button_Write_pregnant_52_next;

	EditText et[];

	int numOfButton[];
	RadioGroup rg[];
	RadioButton rb[][];
	int rb_id[][];
	String labels[][];
	CheckBox cb[];
    Spinner[] spin;
	String fileName;
	
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_pregnant_52);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_pregnant_52_back = (Button) findViewById(R.id.Button_Write_pregnant_52_back);
        button_Write_pregnant_52_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_pregnant_52_back_onClick();
            }
        });

        button_Write_pregnant_52_home = (Button) findViewById(R.id.Button_Write_pregnant_52_home);
        button_Write_pregnant_52_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_52_home_onClick();
            }
        });

        button_Write_pregnant_52_next = (Button) findViewById(R.id.Button_Write_pregnant_52_next);
        button_Write_pregnant_52_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_52_next_onClick();
            }
        });
        
      //ファイル名の指定
      		fileName="write_5.txt";
      	//初期化の準備
    		int numOfEditText=41;
    		int numOfRadioGroup=0;
    		numOfButton=new int [numOfRadioGroup];
    		int numOfCheckBox=0;
    		int numOfSpinner=14;
            spin=new Spinner[numOfSpinner];
            labels = new String[spin.length][];
        
      //表示するEditTextを宣言
  		et=new EditText[numOfEditText];
  		et[0]=(EditText)findViewById(R.id.EditText_write_pregnant_52_01);
  		et[1]=(EditText)findViewById(R.id.EditText_write_pregnant_52_02);
  		et[2]=(EditText)findViewById(R.id.EditText_write_pregnant_52_03);
  		et[3]=(EditText)findViewById(R.id.EditText_write_pregnant_52_04);
  		et[4]=(EditText)findViewById(R.id.EditText_write_pregnant_52_05);
  		et[5]=(EditText)findViewById(R.id.EditText_write_pregnant_52_06);
  		et[6]=(EditText)findViewById(R.id.EditText_write_pregnant_52_07);
  		et[7]=(EditText)findViewById(R.id.EditText_write_pregnant_52_08);
  		et[8]=(EditText)findViewById(R.id.EditText_write_pregnant_52_09);
  		et[9]=(EditText)findViewById(R.id.EditText_write_pregnant_52_10);
  		et[10]=(EditText)findViewById(R.id.EditText_write_pregnant_52_11);
  		et[11]=(EditText)findViewById(R.id.EditText_write_pregnant_52_12);
  		et[12]=(EditText)findViewById(R.id.EditText_write_pregnant_52_13);
  		et[13]=(EditText)findViewById(R.id.EditText_write_pregnant_52_14);
  		et[14]=(EditText)findViewById(R.id.EditText_write_pregnant_52_15);
  		et[15]=(EditText)findViewById(R.id.EditText_write_pregnant_52_16);
  		et[16]=(EditText)findViewById(R.id.EditText_write_pregnant_52_17);
  		et[17]=(EditText)findViewById(R.id.EditText_write_pregnant_52_18);
  		et[18]=(EditText)findViewById(R.id.EditText_write_pregnant_52_19);
  		et[19]=(EditText)findViewById(R.id.EditText_write_pregnant_52_20);
  		et[20]=(EditText)findViewById(R.id.EditText_write_pregnant_52_21);
  		et[21]=(EditText)findViewById(R.id.EditText_write_pregnant_52_22);
  		et[22]=(EditText)findViewById(R.id.EditText_write_pregnant_52_23);
  		et[23]=(EditText)findViewById(R.id.EditText_write_pregnant_52_24);
  		et[24]=(EditText)findViewById(R.id.EditText_write_pregnant_52_25);
  		et[25]=(EditText)findViewById(R.id.EditText_write_pregnant_52_26);
  		et[26]=(EditText)findViewById(R.id.EditText_write_pregnant_52_27);
  		et[27]=(EditText)findViewById(R.id.EditText_write_pregnant_52_28);
  		et[28]=(EditText)findViewById(R.id.EditText_write_pregnant_52_29);
  		et[29]=(EditText)findViewById(R.id.EditText_write_pregnant_52_30);
  		et[30]=(EditText)findViewById(R.id.EditText_write_pregnant_52_31);
  		et[31]=(EditText)findViewById(R.id.EditText_write_pregnant_52_32);
  		et[32]=(EditText)findViewById(R.id.EditText_write_pregnant_52_33);
  		et[33]=(EditText)findViewById(R.id.EditText_write_pregnant_52_34);
  		et[34]=(EditText)findViewById(R.id.EditText_write_pregnant_52_35);
  		et[35]=(EditText)findViewById(R.id.EditText_write_pregnant_52_36);
  		et[36]=(EditText)findViewById(R.id.EditText_write_pregnant_52_37);
  		et[37]=(EditText)findViewById(R.id.EditText_write_pregnant_52_38);
  		et[38]=(EditText)findViewById(R.id.EditText_write_pregnant_52_39);
  		et[39]=(EditText)findViewById(R.id.EditText_write_pregnant_52_40);
  		et[40]=(EditText)findViewById(R.id.EditText_write_pregnant_52_41);
  		
  		for(int i=0;i<et.length;i++){
			et[i].setText("");
		}

		int maxNum=0;
		for(int i=0;i<numOfButton.length;i++){
			if(numOfButton[i]>maxNum){
				maxNum=numOfButton[i];
			}
		}
  		
        
        
  	//Spinnerと選択肢の宣言
		spin=new Spinner[14];
        spin[0]=(Spinner)findViewById(R.id.Spinner27);	//午前か午後か
        spin[1]=(Spinner)findViewById(R.id.Spinner28);	//子供の向き
        spin[2]=(Spinner)findViewById(R.id.Spinner29);	//出血量
        spin[3]=(Spinner)findViewById(R.id.Spinner30);	//性別
        spin[4]=(Spinner)findViewById(R.id.Spinner31);	//数
        spin[5]=(Spinner)findViewById(R.id.Spinner32);	//仮死
        spin[6]=(Spinner)findViewById(R.id.Spinner33);	//証明書の種類
        spin[7]=(Spinner)findViewById(R.id.Spinner34);
        spin[8]=(Spinner)findViewById(R.id.Spinner35);
        spin[9]=(Spinner)findViewById(R.id.Spinner36);
        spin[10]=(Spinner)findViewById(R.id.Spinner37);
        spin[11]=(Spinner)findViewById(R.id.Spinner38);
        spin[12]=(Spinner)findViewById(R.id.Spinner39);
        spin[13]=(Spinner)findViewById(R.id.Spinner40);
        labels[0] = getResources().getStringArray(R.array.am_pm);
        labels[1] = getResources().getStringArray(R.array.child_direction);
        labels[2] = getResources().getStringArray(R.array.lose_blood);
        labels[3] = getResources().getStringArray(R.array.sex);
        labels[4] = getResources().getStringArray(R.array.number);
        labels[5] = getResources().getStringArray(R.array.death);
        labels[6] = getResources().getStringArray(R.array.proof);
        labels[7] = getResources().getStringArray(R.array.womb);
        labels[8] = getResources().getStringArray(R.array.lochia);
        labels[9] = getResources().getStringArray(R.array.mother_condition);
        labels[10] = getResources().getStringArray(R.array.mother_condition);
        labels[11] = getResources().getStringArray(R.array.no_0_yes);
        labels[12] = getResources().getStringArray(R.array.nashi_ari);
        labels[13] = getResources().getStringArray(R.array.who_tell);
        ArrayAdapter<String> adapter;
        for(int i=0;i<spin.length;i++){
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels[i]);
	        spin[i].setAdapter(adapter);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
        
      //ラジオ・チェックボタンはそれぞれレイアウト(res/layout/write5.xmlを参照)で表示する文字列を定める
		rg=new RadioGroup[numOfButton.length];
		rb=new RadioButton[rg.length][maxNum];
		rb_id=new int[rg.length][maxNum];	//findViewByIdが返す値はINT型
		cb=new CheckBox[numOfCheckBox];
        
        
        
        
        
        
        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_pregnant_52_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_pregnant_41.class);
        startActivity(intent_read_1);
    }

    private void button_Write_pregnant_52_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
        startActivity(intent_read_2);
    }

    private void button_Write_pregnant_52_next_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_pregnant_61.class);
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
    		 intent1.setClass(Write_pregnant_52.this, Write3.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_pregnant_52.this, MainActivity.class);
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
