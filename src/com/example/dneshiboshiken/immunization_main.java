//教育機能の目次
package com.example.dneshiboshiken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Calendar;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

//import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.provider.MediaStore.Images;
import android.util.Log;
import android.util.Xml;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Environment;



public class immunization_main extends Activity implements View.OnClickListener{

	static String immunization_flag;

	//目次の項目だけボタンを定義
	private EditText editText_day1;
	private DatePickerDialog.OnDateSetListener varDateSetListener_day1;
	private EditText editText_day2;
	private DatePickerDialog.OnDateSetListener varDateSetListener_day2;
	private EditText editText_day3;
	private DatePickerDialog.OnDateSetListener varDateSetListener_day3;

	private Button button_Write_cancel;
	private Button button_Write_save;
	private Button button_Write_gallery;
	private Button button_Write_camera;

	private Button button_dpt;
	private Button button_bcg;
	private Button button_mr;
	private Button button_japan;
	private Button button_dt;
	private Button button_hib;
	private Button button_seven;
	private Button button_hpv;
	private Button button_varicella;
	private Button button_mumps;
	private Button button_b;
  //ここはクラス内で実行
	static int REQUEST_ACTION_PICK = 1;
	static final int REQUEST_CAPTURE_IMAGE = 100;
	private static final String APPLICATION_NAME = "PATOM";
	private static final String PATH = Environment.getExternalStorageDirectory().getPath() + "/Yukari/Photo/" + APPLICATION_NAME;

	final boolean[] checkedItems = new boolean[50];
	final CheckBox[] checkbox = new CheckBox[50];

	private String[] item_immunization_CheckBox_tag = {
			"checkBox_immunization_dpt1",
			"checkBox_immunization_dpt2",
			"checkBox_immunization_dpt3",
			"checkBox_immunization_dpt4",
			"checkBox_immunization_bcg1",
			"checkBox_immunization_mr1",
			"checkBox_immunization_mr2",
			"checkBox_immunization_japan1",
			"checkBox_immunization_japan2",
			"checkBox_immunization_japan3",
			"checkBox_immunization_dt1",
			"checkBox_immunization_hib1",
			"checkBox_immunization_hib2",
			"checkBox_immunization_hib3",
			"checkBox_immunization_hib4",
			"checkBox_immunization_seven1",
			"checkBox_immunization_seven2",
			"checkBox_immunization_seven3",
			"checkBox_immunization_seven4",
			"checkBox_immunization_hpv1",
			"checkBox_immunization_hpv2",
			"checkBox_immunization_hpv3",
			"checkBox_immunization_varicella1",
			"checkBox_immunization_varicella2",
			"checkBox_immunization_mumps1",
			"checkBox_immunization_mumps2",
			"checkBox_immunization_b1",
			"checkBox_immunization_b2",
			"checkBox_immunization_b3"
			};

	public static int[] item_immunization_CheckBox = {
		R.id.checkBox_immunization_dpt1,
		R.id.checkBox_immunization_dpt2,
		R.id.checkBox_immunization_dpt3,
		R.id.checkBox_immunization_dpt4,
		R.id.checkBox_immunization_bcg1,
		R.id.checkBox_immunization_mr1,
		R.id.checkBox_immunization_mr2,
		R.id.checkBox_immunization_japan1,
		R.id.checkBox_immunization_japan2,
		R.id.checkBox_immunization_japan3,
		R.id.checkBox_immunization_dt1,
		R.id.checkBox_immunization_hib1,
		R.id.checkBox_immunization_hib2,
		R.id.checkBox_immunization_hib3,
		R.id.checkBox_immunization_hib4,
		R.id.checkBox_immunization_seven1,
		R.id.checkBox_immunization_seven2,
		R.id.checkBox_immunization_seven3,
		R.id.checkBox_immunization_seven4,
		R.id.checkBox_immunization_hpv1,
		R.id.checkBox_immunization_hpv2,
		R.id.checkBox_immunization_hpv3,
		R.id.checkBox_immunization_varicella1,
		R.id.checkBox_immunization_varicella2,
		R.id.checkBox_immunization_mumps1,
		R.id.checkBox_immunization_mumps2,
		R.id.checkBox_immunization_b1,
		R.id.checkBox_immunization_b2,
		R.id.checkBox_immunization_b3,};


	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immunization_main);	//画面レイアウトを指定(res/layout/index_read.xml)

    	button_dpt=(Button)findViewById(R.id.button_immunization_dpt);
    	button_bcg=(Button)findViewById(R.id.button_immunization_bcg);
    	button_mr=(Button)findViewById(R.id.button_immunization_mr);
    	button_japan=(Button)findViewById(R.id.button_immunization_japan);
    	button_dt=(Button)findViewById(R.id.button_immunization_dt);
    	button_hib=(Button)findViewById(R.id.button_immunization_hib);
		button_seven=(Button)findViewById(R.id.button_immunization_seven);
		button_hpv=(Button)findViewById(R.id.button_immunization_hpv);
		button_varicella=(Button)findViewById(R.id.button_immunization_varicella);
		button_mumps=(Button)findViewById(R.id.button_immunization_mumps);
		button_b=(Button)findViewById(R.id.button_immunization_b);

		button_dpt.setOnClickListener(this);
		button_bcg.setOnClickListener(this);
		button_mr.setOnClickListener(this);
		button_japan.setOnClickListener(this);
		button_dt.setOnClickListener(this);
		button_hib.setOnClickListener(this);
		button_seven.setOnClickListener(this);
		button_hpv.setOnClickListener(this);
		button_varicella.setOnClickListener(this);
		button_mumps.setOnClickListener(this);
		button_b.setOnClickListener(this);

        //初期値読み込み
        File dir = new File(Environment.getExternalStorageDirectory().getPath());
        if(dir.exists()){

            File file = new File(dir.getAbsolutePath()+"/Yukari/Write/immunization/immunizationfile.xml");
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
                            if(tag.equals(item_immunization_CheckBox_tag[0])) {checkedItems[0] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[1])) {checkedItems[1] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[2])) {checkedItems[2] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[3])) {checkedItems[3] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[4])) {checkedItems[4] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[5])) {checkedItems[5] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[6])) {checkedItems[6] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[7])) {checkedItems[7] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[8])) {checkedItems[8] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[9])) {checkedItems[9] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[10])) {checkedItems[10] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[11])) {checkedItems[11] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[12])) {checkedItems[12] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[13])) {checkedItems[13] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[14])) {checkedItems[14] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[15])) {checkedItems[15] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[16])) {checkedItems[16] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[17])) {checkedItems[17] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[18])) {checkedItems[18] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[19])) {checkedItems[19] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[20])) {checkedItems[20] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[21])) {checkedItems[21] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[22])) {checkedItems[22] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[23])) {checkedItems[23] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[24])) {checkedItems[24] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[25])) {checkedItems[25] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[26])) {checkedItems[26] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[27])) {checkedItems[27] = Boolean.valueOf( value );}
                            else if(tag.equals(item_immunization_CheckBox_tag[28])) {checkedItems[28] = Boolean.valueOf( value );}
                            }
                            break;
                        case XmlPullParser.END_TAG: // 終了タグ
                            break;
                        }

                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "エラー発生", Toast.LENGTH_SHORT);
                }
            }

            for (int i1 = 0; i1 < item_immunization_CheckBox.length; i1++) {
            	CheckBox chkbox = (CheckBox)findViewById(item_immunization_CheckBox[i1]);
            	chkbox.setChecked(checkedItems[i1]);
            }

        }
        //画像読み込み
            /*if(dir.exists()){
                File view = new File(dir.getAbsolutePath()+"/Yukari/Photo/imageView_write_checkup_1p.png");
                if (view.exists()) {
                        Bitmap _bm = BitmapFactory.decodeFile(view.getPath());
                        ((ImageView)findViewById(R.id.imageview_write_checkup_1)).setImageBitmap(_bm);
                }else{
                    //存在しない
                }
            }
        }*/

    }

    //詳細ボタン
    public void onClick(View v){
    	Intent intent=new Intent();
    	switch(v.getId()){
    	case R.id.button_immunization_dpt:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_dpt");
	        break;

    	case R.id.button_immunization_bcg:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_bcg");
	        break;

    	case R.id.button_immunization_mr:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_mr");
	        break;

    	case R.id.button_immunization_japan:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_japan");
	        break;

    	case R.id.button_immunization_dt:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_dt");
	        break;

    	case R.id.button_immunization_hib:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_hib");
	        break;

    	case R.id.button_immunization_seven:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_seven");
	        break;

    	case R.id.button_immunization_hpv:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_hpv");
	        break;

    	case R.id.button_immunization_varicella:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_varicella");
	        break;

    	case R.id.button_immunization_mumps:
    		intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_mumps");
	        break;

    	case R.id.button_immunization_b:
	        intent.setClassName("com.example.dneshiboshiken", "com.example.dneshiboshiken.immunization_b");
	        break;
    	}
    	startActivity(intent);


    }

	//チェックボックスダイアログ
	public void onclick_checkbox_immunization(View v) {
		Text text;
		//チェックボックスの中身を手に入れる
		for (int i1 = 0; i1 < item_immunization_CheckBox.length; i1++) {
			CheckBox checkbox1 = (CheckBox) findViewById(item_immunization_CheckBox[i1]);
			checkedItems[i1] = checkbox1.isChecked();
			}
    	//ディレクトリの作成
    	String target_path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Yukari/Write/immunization";
    	File dir = new File(target_path);
    	if(!dir.exists()){
    	    dir.mkdirs();
    	}
    	DocumentBuilderFactory dbfactory = DocumentBuilderFactory.newInstance();
    	try {
    		 DocumentBuilder dbuilder = dbfactory.newDocumentBuilder();
    	     Document document = dbuilder.newDocument();
    	     Element root = document.createElement("members");

    	   //CheckBoxの中身を保存
    	     for (int i1 = 0; i1 < item_immunization_CheckBox_tag.length; i1++) {
    	    	 Element element1 = document.createElement(item_immunization_CheckBox_tag[i1]);
    	    	 String string1 =  String.valueOf( checkedItems[i1] );//booleanとstring変換
    	    	 text = document.createTextNode(string1);
    	    	 element1.appendChild(text);
    	    	 root.appendChild(element1);
    	     }

    	     document.appendChild(root);

    	     TransformerFactory tffactory = TransformerFactory.newInstance();
    	     Transformer transformer = tffactory.newTransformer();

    	//保存ファイルの作成
    	String filePath = Environment.getExternalStorageDirectory() + "/Yukari/Write/immunization/immunizationfile.xml";
        File file = new File(filePath);
        file.getParentFile().mkdir();
        transformer.transform(new DOMSource(document), new StreamResult(file));


    	} catch (ParserConfigurationException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	 }catch (TransformerConfigurationException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	 } catch (TransformerException e) {
    	     // TODO Auto-generated catch block
    	     e.printStackTrace();
    	 }

    	//Toast.makeText(this, "保存が完了しました", Toast.LENGTH_LONG).show();
	}



  //バックキー

}
