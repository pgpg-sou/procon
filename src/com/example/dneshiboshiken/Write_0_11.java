//教育機能の目次
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
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;
import android.content.Context;
import android.util.Log;


public class Write_0_11 extends Activity {

	
	//それぞれのView(Spinner,EditText)を画面に表示する分定義する
    Spinner[] spin;
	EditText et[];
	String fileName;
	//目次の項目だけボタンを定義
	private Button button_Write_0_11_back;
	private Button button_Write_0_11_home;
	private Button button_Write_0_11_next;

	public static final String WRITE1 = "WRITE";
	public Context otherContext;
	//public SharedPreferences pref =getSharedPreferences("WRITE1",MODE_WORLD_READABLE);
	
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_0_11);	//画面レイアウトを指定(res/layout/index_read.xml)


        //それぞれのボタンにクリック時の処理を表示
        button_Write_0_11_back = (Button) findViewById(R.id.Button_Write_0_11_back);
        button_Write_0_11_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_0_11_back_onClick();
            }
        });

        button_Write_0_11_home = (Button) findViewById(R.id.Button_Write_0_11_home);
        button_Write_0_11_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_0_11_home_onClick();
            }
        });

        button_Write_0_11_next = (Button) findViewById(R.id.Button_Write_0_11_next);
        button_Write_0_11_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_0_11_next_onClick();
            }
        });
        
        //addPreferencesFromResource(R.xml.WRITE1);
        
        /*
        SharedPreferences pref =getSharedPreferences( "WRITE", Context.MODE_WORLD_READABLE );
        
        TextView[] tv=new TextView[3];
        tv[0]=(TextView)findViewById(R.id.write_0_11_01);
        tv[1]=(TextView)findViewById(R.id.write_0_11_02);
        tv[2]=(TextView)findViewById(R.id.write_0_11_03);
        
        
        tv[0].setText(pref.getString("EditText_write_1_01", ""));
        tv[2].setText(pref.getString("EditText_write_1_02", ""));
        tv[3].setText(pref.getString("EditText_write_1_03", ""));
        */
        
        /*String write1 =pref.getString("EditText_write_1_01", "");
        
        TextView write11 = new TextView(this);
        write11.setText(write1);*/
        


        /*SharedPreferences pref= getSharedPreferences(WRITE1, MODE_WORLD_READABLE);
        pref = getPreferences(MODE_WORLD_READABLE);
        
        
        EditText write_0_11_01 = (EditText)findViewById(R.id.EditText_write_1_01);
        EditText write_0_11_02 = (EditText)findViewById(R.id.EditText_write_1_02);
        EditText write_0_11_03 = (EditText)findViewById(R.id.EditText_write_1_03);
        EditText write_0_11_04 = (EditText)findViewById(R.id.EditText_write_1_04);
        EditText write_0_11_05 = (EditText)findViewById(R.id.EditText_write_1_05);
        EditText write_0_11_06 = (EditText)findViewById(R.id.EditText_write_1_06);
        EditText write_0_11_07 = (EditText)findViewById(R.id.EditText_write_1_07);
        EditText write_0_11_08 = (EditText)findViewById(R.id.EditText_write_1_08);
        EditText write_0_11_09 = (EditText)findViewById(R.id.EditText_write_1_09);
        EditText write_0_11_10 = (EditText)findViewById(R.id.EditText_write_1_10);
        EditText write_0_11_11 = (EditText)findViewById(R.id.EditText_write_1_11);
        EditText write_0_11_12 = (EditText)findViewById(R.id.EditText_write_1_12);
        EditText write_0_11_13 = (EditText)findViewById(R.id.EditText_write_1_13);
        EditText write_0_11_14 = (EditText)findViewById(R.id.EditText_write_1_14);
        EditText write_0_11_15 = (EditText)findViewById(R.id.EditText_write_1_15);
        EditText write_0_11_16 = (EditText)findViewById(R.id.EditText_write_1_16);
        EditText write_0_11_17 = (EditText)findViewById(R.id.EditText_write_1_17);
        EditText write_0_11_18 = (EditText)findViewById(R.id.EditText_write_1_18);
        EditText write_0_11_19 = (EditText)findViewById(R.id.EditText_write_1_19);
        EditText write_0_11_20 = (EditText)findViewById(R.id.EditText_write_1_20);
        EditText write_0_11_21 = (EditText)findViewById(R.id.EditText_write_1_21);
        EditText write_0_11_22 = (EditText)findViewById(R.id.EditText_write_1_22);
        EditText write_0_11_23 = (EditText)findViewById(R.id.EditText_write_1_22);*/
        //EditText write_0_11_24 = (EditText)findViewById(R.id.EditText_write_1_24);
        //EditText write_0_11_25 = (EditText)findViewById(R.id.EditText_write_1_25);
        //EditText write_0_11_26 = (EditText)findViewById(R.id.EditText_write_1_26);
        
        //spinner01
        
        /*
        write_0_11_01.setText(pref.getString("EditText_write_1_01", "----"));
        write_0_11_02.setText(pref.getString("EditText_write_1_02", "----"));
        write_0_11_03.setText(pref.getString("EditText_write_1_03", "----"));
        write_0_11_04.setText(pref.getString("EditText_write_1_04", "----"));
        write_0_11_05.setText(pref.getString("EditText_write_1_05", "----"));
        write_0_11_06.setText(pref.getString("EditText_write_1_06", "----"));
        write_0_11_07.setText(pref.getString("EditText_write_1_07", "----"));
        write_0_11_08.setText(pref.getString("EditText_write_1_08", "----"));
        write_0_11_09.setText(pref.getString("EditText_write_1_09", "----"));
        write_0_11_10.setText(pref.getString("EditText_write_1_10", "----"));
        write_0_11_11.setText(pref.getString("EditText_write_1_11", "----"));
        write_0_11_12.setText(pref.getString("EditText_write_1_12", "----"));
        write_0_11_13.setText(pref.getString("EditText_write_1_13", "----"));
        write_0_11_14.setText(pref.getString("EditText_write_1_14", "----"));
        write_0_11_15.setText(pref.getString("EditText_write_1_15", "----"));
        write_0_11_16.setText(pref.getString("EditText_write_1_16", "----"));
        write_0_11_17.setText(pref.getString("EditText_write_1_17", "----"));
        write_0_11_18.setText(pref.getString("EditText_write_1_18", "----"));
        write_0_11_19.setText(pref.getString("EditText_write_1_19", "----"));
        write_0_11_20.setText(pref.getString("EditText_write_1_20", "----"));
        write_0_11_21.setText(pref.getString("EditText_write_1_21", "----"));
        write_0_11_22.setText(pref.getString("EditText_write_1_22", "----"));
        write_0_11_23.setText(pref.getString("EditText_write_1_23", "----"));*/
        //write_0_11_24.setText(pref.getString("EditText_write_1_24", "----"));
        //write_0_11_25.setText(pref.getString("EditText_write_1_25", "----"));
        //write_0_11_26.setText(pref.getString("EditText_write_1_26", "----"));
        
        

    }
    /*
        public String ( Context context );{
            // プリファレンスの準備 //
            SharedPreferences pref = 
                    context.getSharedPreferences( "name_and_age", Context.MODE_PRIVATE );
     
            // "user_name" というキーで保存されている値を読み出す
            return pref.getString( "user_name", "" );
        }*/
        
        
        
    //}
    
   
   
    
    /*
    public String loadName(Context context){
    	
    	
    
    	
        // プリファレンスの準備 //
        SharedPreferences pref =context.getSharedPreferences( "WRITE1", Context.MODE_WORLD_READABLE );
 
      // EditText write_0_11_01 = (EditText)findViewById(R.id.write_0_11_01);
        
        
        final TextView write_0_11_01 = (TextView) findViewById(R.id.write_0_11_01);
        
        final String write0_11_01 = pref.getString("EditText_write_1_01","---");
        
        
        
        write_0_11_01.setText(pref.getString("EditText_write_1_01", "----"));
        
        // "user_name" というキーで保存されている値を読み出す
       return pref.getString( "user_name", "" );
       
       
    }*/
    
    
 
    
    

    
    
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_0_11_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_0_31.class);
        startActivity(intent_read_1);
    }

    private void button_Write_0_11_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),Write1.class);
        startActivity(intent_read_2);
    }

    private void button_Write_0_11_next_onClick() {
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
    
  //onOPtionsItemSelectedメソッド(メニューアイテム選択処理)
    @Override
     public boolean onOptionsItemSelected(MenuItem item){
    	 switch (item.getItemId()){
    	 case 0:
    		 Intent intent1 = new Intent();
    		 intent1.setClass(Write_0_11.this, Write1.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_0_11.this, MainActivity.class);
    		 startActivity(intent2);
    		 return true;
    	 }
    	 return true;
    }

  //バックキーのアクション
    public boolean onKeyDown(int keyCode, KeyEvent event) {
   if(keyCode==KeyEvent.KEYCODE_BACK){
   	
   
   Intent intent_back = new Intent(getApplicationContext(),IndexWrite_0.class);
   startActivity(intent_back);
   setResult(RESULT_OK, intent_back);
   finish();
   }
   return false;
}


}
