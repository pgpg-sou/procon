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

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Context;




public class Write1 extends Activity {

	//それぞれのView(Spinner,EditText)を画面に表示する分定義する
    Spinner[] spin;
	EditText et[];
	String fileName;
	//目次の項目だけボタンを定義
	private Button ButtonLock_write_1;
	private Button ButtonUnlock_write_1;
	private Button ButtonCancel_write_1;
	
	private EditText editText;
    private Button button;
    private SharedPreferences pref;


	public static final String WRITE1 = "WRITE";
	
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_0_12);	//画面レイアウトを指定(res/layout/index_read.xml)


        
        //それぞれのボタンにクリック時の処理を表示
        ButtonLock_write_1 = (Button) findViewById(R.id.ButtonSave_write_1);
        ButtonLock_write_1.setTag("save");
        ButtonLock_write_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            ButtonLock_write_1_onClick();
            
            }
        });


        ButtonCancel_write_1 = (Button) findViewById(R.id.ButtonCancel_write_1);
        ButtonCancel_write_1.setTag("cancel");
        ButtonCancel_write_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	ButtonCancel_write_1_onClick();
            }
        });

      //Spinnerを画面に表示する分定義する
        spin=new Spinner[3];
        spin[0] = (Spinner)findViewById(R.id.spinner01);
        spin[1] = (Spinner)findViewById(R.id.spinner02);
        spin[2] = (Spinner)findViewById(R.id.spinner03);
        String[] labels = getResources().getStringArray(R.array.blood_type);	//Spinnerに表示させる回答を配列として宣言(res/values/string.xml内に定義)
        //spinにlabelsの内容をセットする
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, labels);
        spin[0].setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin[1].setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin[2].setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        


        
      //この画面で利用するファイル名の定義
  		fileName="write_1.txt";
        
      //表示するEditTextを宣言
		et=new EditText[23];
		et[0]=(EditText)findViewById(R.id.EditText_write_1_01);
		et[1]=(EditText)findViewById(R.id.EditText_write_1_02);
		et[2]=(EditText)findViewById(R.id.EditText_write_1_03);
		et[3]=(EditText)findViewById(R.id.EditText_write_1_04);
		et[4]=(EditText)findViewById(R.id.EditText_write_1_05);
		et[5]=(EditText)findViewById(R.id.EditText_write_1_06);
		et[6]=(EditText)findViewById(R.id.EditText_write_1_07);
		et[7]=(EditText)findViewById(R.id.EditText_write_1_08);
		et[8]=(EditText)findViewById(R.id.EditText_write_1_09);
		et[9]=(EditText)findViewById(R.id.EditText_write_1_10);
		et[10]=(EditText)findViewById(R.id.EditText_write_1_11);
		et[11]=(EditText)findViewById(R.id.EditText_write_1_12);
		et[12]=(EditText)findViewById(R.id.EditText_write_1_13);
		et[13]=(EditText)findViewById(R.id.EditText_write_1_14);
		et[14]=(EditText)findViewById(R.id.EditText_write_1_15);
		et[15]=(EditText)findViewById(R.id.EditText_write_1_16);
		et[16]=(EditText)findViewById(R.id.EditText_write_1_17);
		et[17]=(EditText)findViewById(R.id.EditText_write_1_18);
		et[18]=(EditText)findViewById(R.id.EditText_write_1_19);
		et[19]=(EditText)findViewById(R.id.EditText_write_1_20);
		et[20]=(EditText)findViewById(R.id.EditText_write_1_21);
		et[21]=(EditText)findViewById(R.id.EditText_write_1_22);
		et[22]=(EditText)findViewById(R.id.EditText_write_1_23);
        
		//空欄にする
		for(int i=0;i<et.length;i++){
			et[i].setText("");
		}
		
		pref = getPreferences(MODE_WORLD_READABLE);
		
		final EditText EditText_write_1_01 = (EditText) findViewById(R.id.EditText_write_1_01);
		EditText EditText_write_1_02 = (EditText) findViewById(R.id.EditText_write_1_02);
		EditText EditText_write_1_03 = (EditText) findViewById(R.id.EditText_write_1_03);
		EditText EditText_write_1_04 = (EditText) findViewById(R.id.EditText_write_1_04);
		EditText EditText_write_1_05 = (EditText) findViewById(R.id.EditText_write_1_05);
		EditText EditText_write_1_06 = (EditText) findViewById(R.id.EditText_write_1_06);
		EditText EditText_write_1_07 = (EditText) findViewById(R.id.EditText_write_1_07);
		EditText EditText_write_1_08 = (EditText) findViewById(R.id.EditText_write_1_08);
		EditText EditText_write_1_09 = (EditText) findViewById(R.id.EditText_write_1_09);
		EditText EditText_write_1_10 = (EditText) findViewById(R.id.EditText_write_1_10);
		EditText EditText_write_1_11 = (EditText) findViewById(R.id.EditText_write_1_11);
		EditText EditText_write_1_12 = (EditText) findViewById(R.id.EditText_write_1_12);
		EditText EditText_write_1_13 = (EditText) findViewById(R.id.EditText_write_1_13);
		EditText EditText_write_1_14 = (EditText) findViewById(R.id.EditText_write_1_14);
		EditText EditText_write_1_15 = (EditText) findViewById(R.id.EditText_write_1_15);
		EditText EditText_write_1_16 = (EditText) findViewById(R.id.EditText_write_1_16);
		EditText EditText_write_1_17 = (EditText) findViewById(R.id.EditText_write_1_17);
		EditText EditText_write_1_18 = (EditText) findViewById(R.id.EditText_write_1_18);
		EditText EditText_write_1_19 = (EditText) findViewById(R.id.EditText_write_1_19);
		EditText EditText_write_1_20 = (EditText) findViewById(R.id.EditText_write_1_20);
		EditText EditText_write_1_21 = (EditText) findViewById(R.id.EditText_write_1_21);
		EditText EditText_write_1_22 = (EditText) findViewById(R.id.EditText_write_1_22);
		EditText EditText_write_1_23 = (EditText) findViewById(R.id.EditText_write_1_23);

		
		
		
		EditText_write_1_01.setText(pref.getString("EditText_write_1_01", ""));
		EditText_write_1_02.setText(pref.getString("EditText_write_1_02", ""));
		EditText_write_1_03.setText(pref.getString("EditText_write_1_03", ""));
		EditText_write_1_04.setText(pref.getString("EditText_write_1_04", ""));
		EditText_write_1_05.setText(pref.getString("EditText_write_1_05", ""));
		EditText_write_1_06.setText(pref.getString("EditText_write_1_06", ""));
		EditText_write_1_07.setText(pref.getString("EditText_write_1_07", ""));
		EditText_write_1_08.setText(pref.getString("EditText_write_1_08", ""));
		EditText_write_1_09.setText(pref.getString("EditText_write_1_09", ""));
		EditText_write_1_10.setText(pref.getString("EditText_write_1_10", ""));
		EditText_write_1_11.setText(pref.getString("EditText_write_1_11", ""));
		EditText_write_1_12.setText(pref.getString("EditText_write_1_12", ""));
		EditText_write_1_13.setText(pref.getString("EditText_write_1_13", ""));
		EditText_write_1_14.setText(pref.getString("EditText_write_1_14", ""));
		EditText_write_1_15.setText(pref.getString("EditText_write_1_15", ""));
		EditText_write_1_16.setText(pref.getString("EditText_write_1_16", ""));
		EditText_write_1_17.setText(pref.getString("EditText_write_1_17", ""));
		EditText_write_1_18.setText(pref.getString("EditText_write_1_18", ""));
		EditText_write_1_19.setText(pref.getString("EditText_write_1_19", ""));
		EditText_write_1_20.setText(pref.getString("EditText_write_1_20", ""));
		EditText_write_1_21.setText(pref.getString("EditText_write_1_21", ""));
		EditText_write_1_22.setText(pref.getString("EditText_write_1_22", ""));
		EditText_write_1_23.setText(pref.getString("EditText_write_1_23", ""));

		
		
		
        
    }
    
    
    
    
  
    
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void ButtonLock_write_1_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_11.class);
        startActivity(intent_read_1);
        

    	EditText EditText_write_1_01 = (EditText)findViewById(R.id.EditText_write_1_01);
    	EditText EditText_write_1_02 = (EditText)findViewById(R.id.EditText_write_1_02);
    	EditText EditText_write_1_03 = (EditText)findViewById(R.id.EditText_write_1_03);
    	EditText EditText_write_1_04 = (EditText)findViewById(R.id.EditText_write_1_04);
    	EditText EditText_write_1_05 = (EditText)findViewById(R.id.EditText_write_1_05);
    	EditText EditText_write_1_06 = (EditText)findViewById(R.id.EditText_write_1_06);
    	EditText EditText_write_1_07 = (EditText)findViewById(R.id.EditText_write_1_07);
    	EditText EditText_write_1_08 = (EditText)findViewById(R.id.EditText_write_1_08);
    	EditText EditText_write_1_09 = (EditText)findViewById(R.id.EditText_write_1_09);
    	EditText EditText_write_1_10 = (EditText)findViewById(R.id.EditText_write_1_10);
    	EditText EditText_write_1_11 = (EditText)findViewById(R.id.EditText_write_1_11);
    	EditText EditText_write_1_12 = (EditText)findViewById(R.id.EditText_write_1_12);
    	EditText EditText_write_1_13 = (EditText)findViewById(R.id.EditText_write_1_13);
    	EditText EditText_write_1_14 = (EditText)findViewById(R.id.EditText_write_1_14);
    	EditText EditText_write_1_15 = (EditText)findViewById(R.id.EditText_write_1_15);
    	EditText EditText_write_1_16 = (EditText)findViewById(R.id.EditText_write_1_16);
    	EditText EditText_write_1_17 = (EditText)findViewById(R.id.EditText_write_1_17);
    	EditText EditText_write_1_18 = (EditText)findViewById(R.id.EditText_write_1_18);
    	EditText EditText_write_1_19 = (EditText)findViewById(R.id.EditText_write_1_19);
    	EditText EditText_write_1_20 = (EditText)findViewById(R.id.EditText_write_1_20);
    	EditText EditText_write_1_21 = (EditText)findViewById(R.id.EditText_write_1_21);
    	EditText EditText_write_1_22 = (EditText)findViewById(R.id.EditText_write_1_22);
    	EditText EditText_write_1_23 = (EditText)findViewById(R.id.EditText_write_1_23);
    	
    	
    	
    	//spinner取得
		Spinner spinner01 = (Spinner)findViewById(R.id.spinner01);
		Spinner spinner02 = (Spinner)findViewById(R.id.spinner02);
		Spinner spinner03 = (Spinner)findViewById(R.id.spinner03);
		
		String spinner_write1_01 = (String)spinner01.getSelectedItem();
		String spinner_write1_02 = (String)spinner02.getSelectedItem();
		String spinner_write1_03 = (String)spinner03.getSelectedItem();

    	
    	//プリファレンスオブジェクト取得
    	SharedPreferences pref=getSharedPreferences(WRITE1,MODE_WORLD_READABLE);
    	
 
    	
    		//プリファレンスの編集用オブジェクト取得
    		SharedPreferences.Editor editor =pref.edit();
            Toast.makeText(getApplicationContext(), "保存", Toast.LENGTH_SHORT).show();
    		
    		
    		
    		//プリファレンスファイルに保存
    	    editor.putString("EditText_write_1_01",EditText_write_1_01.getText().toString());
    	    editor.putString("EditText_write_1_02",EditText_write_1_02.getText().toString());
    	    editor.putString("EditText_write_1_03",EditText_write_1_03.getText().toString());
    	    editor.putString("EditText_write_1_04",EditText_write_1_04.getText().toString());
    	    editor.putString("EditText_write_1_05",EditText_write_1_05.getText().toString());
    	    editor.putString("EditText_write_1_06",EditText_write_1_06.getText().toString());
    	    editor.putString("EditText_write_1_07",EditText_write_1_07.getText().toString());
    	    editor.putString("EditText_write_1_08",EditText_write_1_08.getText().toString());
    	    editor.putString("EditText_write_1_09",EditText_write_1_09.getText().toString());
    	    editor.putString("EditText_write_1_10",EditText_write_1_10.getText().toString());
    	    editor.putString("EditText_write_1_11",EditText_write_1_11.getText().toString());
    	    editor.putString("EditText_write_1_12",EditText_write_1_12.getText().toString());
    	    editor.putString("EditText_write_1_13",EditText_write_1_13.getText().toString());
    	    editor.putString("EditText_write_1_14",EditText_write_1_14.getText().toString());
    	    editor.putString("EditText_write_1_15",EditText_write_1_15.getText().toString());
    	    editor.putString("EditText_write_1_16",EditText_write_1_16.getText().toString());
    	    editor.putString("EditText_write_1_17",EditText_write_1_17.getText().toString());
    	    editor.putString("EditText_write_1_18",EditText_write_1_18.getText().toString());
    	    editor.putString("EditText_write_1_19",EditText_write_1_19.getText().toString());
    	    editor.putString("EditText_write_1_20",EditText_write_1_20.getText().toString());
    	    editor.putString("EditText_write_1_21",EditText_write_1_21.getText().toString());
    	    editor.putString("EditText_write_1_22",EditText_write_1_22.getText().toString());
    	    editor.putString("EditText_write_1_23",EditText_write_1_23.getText().toString());
    	    editor.putString("spinner_write1_01",spinner_write1_01);
    	    editor.putString("spinner_write1_02",spinner_write1_02);
    	    editor.putString("spinner_write1_03",spinner_write1_03);
    	    
    		
    	 // 書き込み内容を確定する
            editor.commit();

    	

    }




    public  void ButtonCancel_write_1_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_0_11.class);
        startActivity(intent_read_3);
        
    	SharedPreferences pref=getSharedPreferences(WRITE1,MODE_WORLD_READABLE);
    	
    	EditText EditText_write_1_01 = (EditText)findViewById(R.id.EditText_write_1_01);
    	EditText EditText_write_1_02 = (EditText)findViewById(R.id.EditText_write_1_02);
    	EditText EditText_write_1_03 = (EditText)findViewById(R.id.EditText_write_1_03);
    	EditText EditText_write_1_04 = (EditText)findViewById(R.id.EditText_write_1_04);
    	EditText EditText_write_1_05 = (EditText)findViewById(R.id.EditText_write_1_05);
    	EditText EditText_write_1_06 = (EditText)findViewById(R.id.EditText_write_1_06);
    	EditText EditText_write_1_07 = (EditText)findViewById(R.id.EditText_write_1_07);
    	EditText EditText_write_1_08 = (EditText)findViewById(R.id.EditText_write_1_08);
    	EditText EditText_write_1_09 = (EditText)findViewById(R.id.EditText_write_1_09);
    	EditText EditText_write_1_10 = (EditText)findViewById(R.id.EditText_write_1_10);
    	EditText EditText_write_1_11 = (EditText)findViewById(R.id.EditText_write_1_11);
    	EditText EditText_write_1_12 = (EditText)findViewById(R.id.EditText_write_1_12);
    	EditText EditText_write_1_13 = (EditText)findViewById(R.id.EditText_write_1_13);
    	EditText EditText_write_1_14 = (EditText)findViewById(R.id.EditText_write_1_14);
    	EditText EditText_write_1_15 = (EditText)findViewById(R.id.EditText_write_1_15);
    	EditText EditText_write_1_16 = (EditText)findViewById(R.id.EditText_write_1_16);
    	EditText EditText_write_1_17 = (EditText)findViewById(R.id.EditText_write_1_17);
    	EditText EditText_write_1_18 = (EditText)findViewById(R.id.EditText_write_1_18);
    	EditText EditText_write_1_19 = (EditText)findViewById(R.id.EditText_write_1_19);
    	EditText EditText_write_1_20 = (EditText)findViewById(R.id.EditText_write_1_20);
    	EditText EditText_write_1_21 = (EditText)findViewById(R.id.EditText_write_1_21);
    	EditText EditText_write_1_22 = (EditText)findViewById(R.id.EditText_write_1_22);
    	EditText EditText_write_1_23 = (EditText)findViewById(R.id.EditText_write_1_23);
    	
    	//spinner取得
    	Spinner spinner01 = (Spinner)findViewById(R.id.spinner01);
    	Spinner spinner02 = (Spinner)findViewById(R.id.spinner02);
    	Spinner spinner03 = (Spinner)findViewById(R.id.spinner03);
    	
    	String spinner_write1_01 = (String)spinner01.getSelectedItem();
		String spinner_write1_02 = (String)spinner02.getSelectedItem();
		String spinner_write1_03 = (String)spinner03.getSelectedItem();
    	
    	
    	
    	
    	EditText_write_1_01.setText(pref.getString("EditText_write_1_01", "---"));
    	EditText_write_1_02.setText(pref.getString("EditText_write_1_02", "---"));
    	EditText_write_1_03.setText(pref.getString("EditText_write_1_03", "---"));
    	EditText_write_1_04.setText(pref.getString("EditText_write_1_04", "---"));
    	EditText_write_1_05.setText(pref.getString("EditText_write_1_05", "---"));
    	EditText_write_1_06.setText(pref.getString("EditText_write_1_06", "---"));
    	EditText_write_1_07.setText(pref.getString("EditText_write_1_07", "---"));
    	EditText_write_1_08.setText(pref.getString("EditText_write_1_08", "---"));
    	EditText_write_1_09.setText(pref.getString("EditText_write_1_09", "---"));
    	EditText_write_1_10.setText(pref.getString("EditText_write_1_10", "---"));
    	EditText_write_1_11.setText(pref.getString("EditText_write_1_11", "---"));
    	EditText_write_1_12.setText(pref.getString("EditText_write_1_12", "---"));
    	EditText_write_1_13.setText(pref.getString("EditText_write_1_13", "---"));
    	EditText_write_1_14.setText(pref.getString("EditText_write_1_14", "---"));
    	EditText_write_1_15.setText(pref.getString("EditText_write_1_15", "---"));
    	EditText_write_1_16.setText(pref.getString("EditText_write_1_16", "---"));
    	EditText_write_1_17.setText(pref.getString("EditText_write_1_17", "---"));
    	EditText_write_1_18.setText(pref.getString("EditText_write_1_18", "---"));
    	EditText_write_1_19.setText(pref.getString("EditText_write_1_19", "---"));
    	EditText_write_1_20.setText(pref.getString("EditText_write_1_20", "---"));
    	EditText_write_1_21.setText(pref.getString("EditText_write_1_21", "---"));
    	EditText_write_1_22.setText(pref.getString("EditText_write_1_22", "---"));
    	EditText_write_1_23.setText(pref.getString("EditText_write_1_23", "---"));
    	

        
    	
    	
        
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
   	
   
   Intent intent_back = new Intent(getApplicationContext(),Write_0_11.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}


}