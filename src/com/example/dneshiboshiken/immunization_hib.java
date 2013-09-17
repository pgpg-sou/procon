package com.example.dneshiboshiken;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class immunization_hib extends Activity {

	private String setpath = "immunization_hib";

	private String[] immunization_mumps_tag = {"EditText_immunization_write_ymd",
			"EditText_immunization_write_lot",
			"EditText_immunization_write_name",
			"EditText_immunization_write_other"};

	public static int[] item_immunization_mumps_tag = {R.id.TextView_immunization_write_hib_ymd1,
		R.id.TextView_immunization_write_hib_ymd2,
		R.id.TextView_immunization_write_hib_ymd3,
		R.id.TextView_immunization_write_hib_ymd4,
		R.id.TextView_immunization_write_hib_lot1,
		R.id.TextView_immunization_write_hib_lot2,
		R.id.TextView_immunization_write_hib_lot3,
		R.id.TextView_immunization_write_hib_lot4,
		R.id.TextView_immunization_write_hib_name1,
		R.id.TextView_immunization_write_hib_name2,
		R.id.TextView_immunization_write_hib_name3,
		R.id.TextView_immunization_write_hib_name4,
		R.id.TextView_immunization_write_hib_other1,
		R.id.TextView_immunization_write_hib_other2,
		R.id.TextView_immunization_write_hib_other3,
		R.id.TextView_immunization_write_hib_other4,};

	private String[] ymd = new String[immunization_mumps_tag.length];
	private String[] lot = new String[immunization_mumps_tag.length];
	private String[] name = new String[immunization_mumps_tag.length];
	private String[] other = new String[immunization_mumps_tag.length];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization_hib);
    }

    public void onStart(){
    	super.onStart();
    	 //xmlファイル読み込み
        TextView[] tvParam = new TextView[item_immunization_mumps_tag.length];
        File dir1 = new File(Environment.getExternalStorageDirectory().getPath());
        if(dir1.exists()){

        	int i1 = 1;
	    	File file = new File(dir1.getAbsolutePath()+ "/Yukari/Write/immunization/"+setpath+"1file.xml" );
	    	while(file!=null) {
	    		file = new File(dir1.getAbsolutePath() + "/Yukari/Write/immunization/"+ setpath +i1+"file.xml");
	    		if (file.exists()) {
            	try {
            		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            		factory.setNamespaceAware(true);
            		XmlPullParser parser = factory.newPullParser();
            		FileInputStream fis = new FileInputStream(file);
            		parser.setInput(new InputStreamReader(fis));
                    // タグ名
                    String tag = "";
                    // 値
                    String value = "";
                    // XMLの解析
                    for (int type = parser.getEventType(); type != XmlPullParser.END_DOCUMENT;
                            type = parser.next()) {
                        switch(type) {
                        case XmlPullParser.START_TAG: // 開始タグ
                            tag = parser.getName();
                            break;
                        case XmlPullParser.TEXT: // タグの内容
                            value = parser.getText();
                            if(value.trim().length() != 0) {
                            // 空白で取得したものは全て処理対象外とする
                          	  if(tag.equals(immunization_mumps_tag[0])) {ymd[i1-1]=value;}
                          	  else if(tag.equals(immunization_mumps_tag[1])) {lot[i1-1]=value;}
                          	  else if(tag.equals(immunization_mumps_tag[2])) {name[i1-1]=value;}
                          	  else if(tag.equals(immunization_mumps_tag[3])) {other[i1-1]=value;}
                            }

                            break;
                        case XmlPullParser.END_TAG: // 終了タグ
                            break;
                        }

                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "エラー発生", Toast.LENGTH_SHORT);
                }
            }else break;
	    		i1++;
	    	}

	    	// TextViewインスタンスの取得
    		for (int i11 = 0; i11 < item_immunization_mumps_tag.length; i11++) {
          	tvParam[i11] = (TextView)findViewById(item_immunization_mumps_tag[i11]);
    		}
    		//初期値入力
    		int n = 0;
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/4; i11++){
	    		tvParam[n].setText(ymd[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/4; i11++){
	    		tvParam[n].setText(lot[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/4; i11++){
	    		tvParam[n].setText(name[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/4; i11++){
	    		tvParam[n].setText(other[i11]);
	    		n++;
	    	}

        }

        //それぞれのボタンにクリック時の処理を表示
        Button button_Write_child_9_12_1_back = (Button) findViewById(R.id.Button_checkup_back);
        button_Write_child_9_12_1_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	//mode="aaaa";
            	Intent intent_read_1 = new Intent(getApplicationContext(),immunization_dt.class);
                startActivity(intent_read_1);
                finish();
            }
        });

        Button button_Write_child_9_12_1_home = (Button) findViewById(R.id.Button_checkup_edit);
        button_Write_child_9_12_1_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	immunization_main.immunization_flag="immunization_hib";
            	Intent intent_read_1 = new Intent(getApplicationContext(),immunization_save.class);
                startActivity(intent_read_1);
            }
        });

        Button button_Write_child_9_12_1_next = (Button) findViewById(R.id.Button_checkup_next);
        button_Write_child_9_12_1_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	Intent intent_read_1 = new Intent(getApplicationContext(),immunization_seven.class);
                startActivity(intent_read_1);
                finish();
            }
        });

    }
}