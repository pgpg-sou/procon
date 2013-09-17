package com.example.dneshiboshiken;


import java.io.File;
import java.util.Calendar;

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
import com.example.dneshiboshiken.R;

public class Write2 extends Activity {
	EditText et[];
	String tableData[];
	CheckBox cb[];
	Spinner spin[];
	String labels[][];
	String fileName;
	
	//目次の項目だけボタンを定義
	private Button ButtonLock_write_2;
	private Button ButtonUnlock_write_2;
	private Button ButtonCancel_write_2;


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_2);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        ButtonLock_write_2 = (Button) findViewById(R.id.ButtonLock_write_2);
        ButtonLock_write_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            ButtonLock_write_2_onClick();
            }
        });

        ButtonUnlock_write_2 = (Button) findViewById(R.id.ButtonUnlock_write_2);
        ButtonUnlock_write_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonUnlock_write_2_onClick();
            }
        });

        ButtonCancel_write_2 = (Button) findViewById(R.id.ButtonCancel_write_2);
        ButtonCancel_write_2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonCancel_write_2_onClick();
            }
        });
        
      //この画面で利用するファイル名の定義
      		fileName="write_2.txt";
        
      //表示するEditTextを宣言
      		et=new EditText[20];
      		et[0]=(EditText)findViewById(R.id.EditText_write_2_01);
      		et[1]=(EditText)findViewById(R.id.EditText_write_2_02);
      		et[2]=(EditText)findViewById(R.id.EditText_write_2_03);
      		et[3]=(EditText)findViewById(R.id.EditText_write_2_04);
      		et[4]=(EditText)findViewById(R.id.EditText_write_2_05);
      		et[5]=(EditText)findViewById(R.id.EditText_write_2_06);
      		et[6]=(EditText)findViewById(R.id.EditText_write_2_07);
      		et[7]=(EditText)findViewById(R.id.EditText_write_2_08);
      		et[8]=(EditText)findViewById(R.id.EditText_write_2_09);
      		et[9]=(EditText)findViewById(R.id.EditText_write_2_10);
      		et[10]=(EditText)findViewById(R.id.EditText_write_2_11);
      		et[11]=(EditText)findViewById(R.id.EditText_write_2_12);
      		et[12]=(EditText)findViewById(R.id.EditText_write_2_13);
      		et[13]=(EditText)findViewById(R.id.EditText_write_2_14);
      		et[14]=(EditText)findViewById(R.id.EditText_write_2_15);
      		et[15]=(EditText)findViewById(R.id.EditText_write_2_16);
      		et[16]=(EditText)findViewById(R.id.EditText_write_2_17);
      		et[17]=(EditText)findViewById(R.id.EditText_write_2_18);
      		et[18]=(EditText)findViewById(R.id.EditText_write_2_19);
      		et[19]=(EditText)findViewById(R.id.EditText_write_2_20);
        
      		
      	//空欄にする
    		for(int i=0;i<et.length;i++){
    			et[i].setText("");
    		}

    		//年月日の記入欄に現在の日時を表示
    		//表示させた後に読み込むため，データが存在する場合には表示されない
    		Calendar cld=Calendar.getInstance();
    		et[15].setText(String.valueOf(cld.get(Calendar.YEAR)));
    		et[16].setText(String.valueOf(cld.get(Calendar.MONTH)+1));
    		et[17].setText(String.valueOf(cld.get(Calendar.DAY_OF_MONTH)));
    		
    		//Spinnerを表示されている分だけ宣言
    		spin=new Spinner[10];
    		spin[0]=(Spinner)findViewById(R.id.spinner04);
    		spin[1]=(Spinner)findViewById(R.id.spinner05);
    		spin[2]=(Spinner)findViewById(R.id.spinner06);
    		spin[3]=(Spinner)findViewById(R.id.spinner07);
    		spin[4]=(Spinner)findViewById(R.id.spinner08);
    		spin[5]=(Spinner)findViewById(R.id.spinner09);
    		spin[6]=(Spinner)findViewById(R.id.spinner10);
    		spin[7]=(Spinner)findViewById(R.id.spinner11);
    		spin[8]=(Spinner)findViewById(R.id.spinner12);
    		spin[9]=(Spinner)findViewById(R.id.spinner13);
    		//スピナーで利用する文字列の配列も宣言(すべてres/values/strings.xml内を参照)
    		labels=new String[spin.length][];
            labels[0] = getResources().getStringArray(R.array.yes_no);
            labels[1] = getResources().getStringArray(R.array.yes_no);
            labels[2] = getResources().getStringArray(R.array.yes_no);
            labels[3] = getResources().getStringArray(R.array.nashi_ari);
            labels[4] = getResources().getStringArray(R.array.yes_no);
            labels[5] = getResources().getStringArray(R.array.yes_no);
            labels[6] = getResources().getStringArray(R.array.health);
            labels[7] = getResources().getStringArray(R.array.isnormal);
            labels[8] = getResources().getStringArray(R.array.sex);
            labels[9] = getResources().getStringArray(R.array.health);
          //それぞれのSpinnerにlabelsをセットする
            ArrayAdapter<String> adapter;
            for(int i=0;i<spin.length;i++){
                adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels[i]);
    	        spin[i].setAdapter(adapter);
    	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            }
            
            
          //CheckBoxを画面に表示した分だけ宣言
            cb=new CheckBox[9];
    		cb[0]=(CheckBox)findViewById(R.id.CheckBox01);
    		cb[1]=(CheckBox)findViewById(R.id.CheckBox02);
    		cb[2]=(CheckBox)findViewById(R.id.CheckBox03);
    		cb[3]=(CheckBox)findViewById(R.id.CheckBox04);
    		cb[4]=(CheckBox)findViewById(R.id.CheckBox05);
    		cb[5]=(CheckBox)findViewById(R.id.CheckBox06);
    		cb[6]=(CheckBox)findViewById(R.id.CheckBox07);
    		cb[7]=(CheckBox)findViewById(R.id.CheckBox08);
    		cb[8]=(CheckBox)findViewById(R.id.CheckBox09);
            
    		
    		
    		
        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void ButtonLock_write_2_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_31.class);
        startActivity(intent_read_1);
    }

    private void ButtonUnlock_write_2_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_0.class);
        startActivity(intent_read_2);
    }

    private void ButtonCancel_write_2_onClick() {
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
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Write_0_21.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}


}