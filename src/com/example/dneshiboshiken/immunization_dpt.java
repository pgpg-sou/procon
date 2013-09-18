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


public class immunization_dpt extends Activity {

	private String setpath = "immunization_dpt";

	private String[] immunization_mumps_tag = {
			"EditText_immunization_write_vaccine",
			"EditText_immunization_write_ymd",
			"EditText_immunization_write_lot",
			"EditText_immunization_write_name",
			"EditText_immunization_write_other"};

	public static int[] item_immunization_mumps_tag = {R.id.TextView_immunization_write_dpt_vaccine1,
		R.id.TextView_immunization_write_dpt_vaccine2,
		R.id.TextView_immunization_write_dpt_vaccine3,
		R.id.TextView_immunization_write_dpt_vaccine4,
		R.id.TextView_immunization_write_dpt_ymd1,
		R.id.TextView_immunization_write_dpt_ymd2,
		R.id.TextView_immunization_write_dpt_ymd3,
		R.id.TextView_immunization_write_dpt_ymd4,
		R.id.TextView_immunization_write_dpt_lot1,
		R.id.TextView_immunization_write_dpt_lot2,
		R.id.TextView_immunization_write_dpt_lot3,
		R.id.TextView_immunization_write_dpt_lot4,
		R.id.TextView_immunization_write_dpt_name1,
		R.id.TextView_immunization_write_dpt_name2,
		R.id.TextView_immunization_write_dpt_name3,
		R.id.TextView_immunization_write_dpt_name4,
		R.id.TextView_immunization_write_dpt_other1,
		R.id.TextView_immunization_write_dpt_other2,
		R.id.TextView_immunization_write_dpt_other3,
		R.id.TextView_immunization_write_dpt_other4,};

	private String[] vaccine = new String[immunization_mumps_tag.length];
	private String[] ymd = new String[immunization_mumps_tag.length];
	private String[] lot = new String[immunization_mumps_tag.length];
	private String[] name = new String[immunization_mumps_tag.length];
	private String[] other = new String[immunization_mumps_tag.length];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization_main);
    }

    public void onStart(TextView[] tvParam){

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
                            	if (tag.equals(immunization_mumps_tag[0])) {vaccine[i1-1]=value;}
                              else if(tag.equals(immunization_mumps_tag[1])) {ymd[i1-1]=value;}
                          	  else if(tag.equals(immunization_mumps_tag[2])) {lot[i1-1]=value;}
                          	  else if(tag.equals(immunization_mumps_tag[3])) {name[i1-1]=value;}
                          	  else if(tag.equals(immunization_mumps_tag[4])) {other[i1-1]=value;}
                            }

                            break;
                        case XmlPullParser.END_TAG: // 終了タグ
                            break;
                        }

                    }
                } catch (Exception e) {
                }
            }else break;
	    		i1++;
	    	}

	    	// TextViewインスタンスの取得

    		//初期値入力
    		int n = 0;
    		for(int i11 = 0; i11 < item_immunization_mumps_tag.length/5; i11++){
	    		tvParam[n].setText(vaccine[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/5; i11++){
	    		tvParam[n].setText(ymd[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/5; i11++){
	    		tvParam[n].setText(lot[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/5; i11++){
	    		tvParam[n].setText(name[i11]);
	    		n++;
	    	}
	    	for(int i11 = 0; i11 < item_immunization_mumps_tag.length/5; i11++){
	    		tvParam[n].setText(other[i11]);
	    		n++;
	    	}

        }


    }
}