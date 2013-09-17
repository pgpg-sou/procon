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
import com.example.dneshiboshiken.R;

public class Write3 extends Activity {

	//目次の項目だけボタンを定義
	private Button ButtonLock_write_3;
	private Button ButtonUnlock_write_3;
	private Button ButtonCancel_write_3;

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
        setContentView(R.layout.write_3);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        ButtonLock_write_3 = (Button) findViewById(R.id.ButtonLock_write_3);
        ButtonLock_write_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            ButtonLock_write_3_onClick();
            }
        });

        ButtonUnlock_write_3 = (Button) findViewById(R.id.ButtonUnlock_write_3);
        ButtonUnlock_write_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonUnlock_write_3_onClick();
            }
        });

        ButtonCancel_write_3 = (Button) findViewById(R.id.ButtonCancel_write_3);
        ButtonCancel_write_3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonCancel_write_3_onClick();
            }
        });
        
      //ファイル名指定
		fileName="write_3.txt";
        
		int numOfEditText=27;
		int numOfCheckBox=7;
		
		//EditTextを宣言
		et=new EditText[numOfEditText];
		et[0]=(EditText)findViewById(R.id.EditText_write_3_01);
  		et[1]=(EditText)findViewById(R.id.EditText_write_3_02);
  		et[2]=(EditText)findViewById(R.id.EditText_write_3_03);
  		et[3]=(EditText)findViewById(R.id.EditText_write_3_04);
  		et[4]=(EditText)findViewById(R.id.EditText_write_3_05);
  		et[5]=(EditText)findViewById(R.id.EditText_write_3_06);
  		et[6]=(EditText)findViewById(R.id.EditText_write_3_07);
  		et[7]=(EditText)findViewById(R.id.EditText_write_3_08);
  		et[8]=(EditText)findViewById(R.id.EditText_write_3_09);
  		et[9]=(EditText)findViewById(R.id.EditText_write_3_10);
  		et[10]=(EditText)findViewById(R.id.EditText_write_3_11);
  		et[11]=(EditText)findViewById(R.id.EditText_write_3_12);
  		et[12]=(EditText)findViewById(R.id.EditText_write_3_13);
  		et[13]=(EditText)findViewById(R.id.EditText_write_3_14);
  		et[14]=(EditText)findViewById(R.id.EditText_write_3_15);
  		et[15]=(EditText)findViewById(R.id.EditText_write_3_16);
  		et[16]=(EditText)findViewById(R.id.EditText_write_3_17);
  		et[17]=(EditText)findViewById(R.id.EditText_write_3_18);
  		et[18]=(EditText)findViewById(R.id.EditText_write_3_19);
  		et[19]=(EditText)findViewById(R.id.EditText_write_3_20);
  		et[20]=(EditText)findViewById(R.id.EditText_write_3_21);
  		et[21]=(EditText)findViewById(R.id.EditText_write_3_22);
  		et[22]=(EditText)findViewById(R.id.EditText_write_3_23);
  		et[23]=(EditText)findViewById(R.id.EditText_write_3_24);
  		et[24]=(EditText)findViewById(R.id.EditText_write_3_25);
  		et[25]=(EditText)findViewById(R.id.EditText_write_3_26);
  		et[26]=(EditText)findViewById(R.id.EditText_write_3_27);
		
  	//空欄にする
		for(int i=0;i<et.length;i++){
			et[i].setText("");
		}
		
		//チェックボックスを宣言
		cb=new CheckBox[numOfCheckBox];
		cb[0]=(CheckBox) findViewById(R.id.CheckBox01);
		cb[1]=(CheckBox) findViewById(R.id.CheckBox02);
		cb[2]=(CheckBox) findViewById(R.id.CheckBox03);
		cb[3]=(CheckBox) findViewById(R.id.CheckBox04);
		cb[4]=(CheckBox) findViewById(R.id.CheckBox05);
		cb[5]=(CheckBox) findViewById(R.id.CheckBox06);
		cb[6]=(CheckBox) findViewById(R.id.CheckBox07);

		//Spinnerを宣言して文字列の代入(Werite2.java参照)
		spin=new Spinner[7];
		spin[0]=(Spinner)findViewById(R.id.spinner14);
		spin[1]=(Spinner)findViewById(R.id.spinner15);
		spin[2]=(Spinner)findViewById(R.id.spinner16);
		spin[3]=(Spinner)findViewById(R.id.spinner17);
		spin[4]=(Spinner)findViewById(R.id.spinner18);
		spin[5]=(Spinner)findViewById(R.id.spinner19);
		spin[6]=(Spinner)findViewById(R.id.spinner20);
		
		labels=new String[spin.length][];
        labels[0] = getResources().getStringArray(R.array.work_type);
        labels[1] = getResources().getStringArray(R.array.nashi_ari);
        labels[2] = getResources().getStringArray(R.array.house_type);
        labels[3] = getResources().getStringArray(R.array.nashi_ari);
        labels[4] = getResources().getStringArray(R.array.noise_type);
        labels[5] = getResources().getStringArray(R.array.lay_type);
        labels[6] = getResources().getStringArray(R.array.child_num);
        ArrayAdapter<String> adapter;
        for(int i=0;i<spin.length;i++){
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels[i]);
	        spin[i].setAdapter(adapter);
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        }
		
		
		
        
    }
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void ButtonLock_write_3_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_31.class);
        startActivity(intent_read_1);
    }

    private void ButtonUnlock_write_3_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_0.class);
        startActivity(intent_read_2);
    }

    private void ButtonCancel_write_3_onClick() {
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
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Write_0_31.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}


}