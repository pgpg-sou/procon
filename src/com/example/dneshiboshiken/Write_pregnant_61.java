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
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;
//import android.denshiboshi.Write6.MyView;

public class Write_pregnant_61 extends Activity {

	//目次の項目だけボタンを定義
	private Button button_Write_pregnant_61_back;
	private Button button_Write_pregnant_61_home;
	private Button button_Write_pregnant_61_next;

	EditText et[];
	int graphFlag;
	LinearLayout layout;

	String fileName;

	//グラフ領域のパラメータ
	Paint paint;
	float offsetYUpper=20;
	float offsetYDowner=50;
	float offsetX=40;
	float height;
	float width;
	float row=15;
	float line=22;
	float widthLength=width-offsetX;
	float heightLength=height-offsetYUpper-offsetYDowner;
	//ラベルのパラメータ
	float maxNumY=18;		//一番上に来る数字
	float minNumY=-4;		//一番下に来る数字
	float labelYNum=11;	//ラベルを入れる個数
	float differenceYNum;	//次の数字との差(下に向かうのでマイナス)
	float maxNumX=14;		//右に来る数字
	float minNumX=0;		//左に来る数字
	float labelXNum=row;	//ラベルを入れる個数
	float differenceXNum;	//次の数字との差
	//グラフの座標用パラメータ
	float centerPositionY;
	//サンプルデータ
	float samplePointDay[];
	float samplePointWeight[];

	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_pregnant_61);	//画面レイアウトを指定(res/layout/index_read.xml)
        fileName="write_6.txt";		//ファイル名


        //それぞれのボタンにクリック時の処理を表示
        button_Write_pregnant_61_back = (Button) findViewById(R.id.Button_Write_pregnant_61_back);
        button_Write_pregnant_61_back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            button_Write_pregnant_61_back_onClick();
            }
        });

        button_Write_pregnant_61_home = (Button) findViewById(R.id.Button_Write_pregnant_61_home);
        button_Write_pregnant_61_home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_61_home_onClick();
            }
        });

        button_Write_pregnant_61_next = (Button) findViewById(R.id.Button_Write_pregnant_61_next);
        button_Write_pregnant_61_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	button_Write_pregnant_61_next_onClick();
            }
        });
        
      //保存してグラフを表示する
      		Button saveButton = (Button)findViewById(R.id.Button01);
      		saveButton.setOnClickListener(new OnClickListener() {
//      			@Override
      			public void onClick(View arg0) {
      				saveButtonClick();
      			}
      		});
      		graphFlag=-1;

      		//記入欄
      		et=new EditText[4];
      		et[0]=(EditText)findViewById(R.id.EditText_write_pregnant_61_01);
      		et[1]=(EditText)findViewById(R.id.EditText_write_pregnant_61_02);
      		et[2]=(EditText)findViewById(R.id.EditText_write_pregnant_61_03);
      		et[3]=(EditText)findViewById(R.id.EditText_write_pregnant_61_04);

      	//空欄にする
    		for(int i=0;i<et.length;i++){
    			et[i].setText("");
    		}

      		
      		//記録年月日に現在に日付を入れる
      		Calendar cld=Calendar.getInstance();
      		et[0].setText(String.valueOf(cld.get(Calendar.YEAR)));
      		et[1].setText(String.valueOf(cld.get(Calendar.MONTH)+1));
      		et[2].setText(String.valueOf(cld.get(Calendar.DAY_OF_MONTH)));
      		graphFlag=-1;
        
        
        
        
        
        
    }
    
    private void saveButtonClick() {
		boolean parseFlag;
		InputStream in;
		OutputStream out;
		BufferedWriter writer;
		BufferedReader reader;
		Calendar birth;
		Calendar today;
		int[] daysOld;
		double[] value;
		String buf;
		String dateValue[];
		int nowDaysOld=0;
		String forGraph="mWeight.txt";
		// 保存
		try{
			//グラフ用データの保存
			//なければファイルを作成
			try{
				in = openFileInput(forGraph);
				reader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
				reader.close();
			}catch(Exception e){
				out=openFileOutput(forGraph,MODE_PRIVATE);
				writer =new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
				writer.close();
				out.close();
			}

			//既に保存されているデータを入力
			in = openFileInput(forGraph);
			reader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
			int i = 0;
			while((buf = reader.readLine())!= null)
				i++;
			in.close();
			reader.close();
			in = openFileInput(forGraph);
			reader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
			dateValue = new String[i+2];
			daysOld = new int[i+3];
			value=new double[i+3];
			for(i=0;i<daysOld.length;i++){
				daysOld[i]=0;
				value[i]=0.0;
			}
			i=0;
			//配列に代入
			while((buf = reader.readLine())!= null){
				dateValue=buf.split(",");
				if(dateValue.length==2){
					try{
						daysOld[i]=Integer.parseInt(dateValue[0]);
						value[i]=Double.parseDouble(dateValue[1]);
						i++;
					}catch(Exception e){}
				}
			}

			//日齢の計算
			birth=Calendar.getInstance();
			today=Calendar.getInstance();
			in = openFileInput("maternalDay.txt");
			reader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
			nowDaysOld=365;
			try{
				birth.set(Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()));
				today.set(Integer.parseInt(et[0].getText().toString()),Integer.parseInt(et[1].getText().toString()),Integer.parseInt(et[2].getText().toString()));
				long def=today.getTimeInMillis()-birth.getTimeInMillis();
				nowDaysOld=(int) (def/60/60/24/1000);
			}catch(Exception e){
			}
			in.close();
			reader.close();

			//新たなデータを付加
			daysOld[i]=nowDaysOld;
			value[i]=Double.parseDouble(et[3].getText().toString());

			//日齢順にソート
			for(i=0;i<daysOld.length;i++){
				for(int j=daysOld.length-1;j>i;j--){
					if(daysOld[j]<daysOld[j-1]){
						int tmp;
						double tnp;
						tmp=daysOld[j];
						daysOld[j]=daysOld[j-1];
						daysOld[j-1]=tmp;
						tnp=value[j];
						value[j]=value[j-1];
						value[j-1]=tnp;
					}
				}
			}
			out=openFileOutput(forGraph,MODE_PRIVATE);
			writer =new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
			for(i=0;i<daysOld.length;i++){
				if(value[i]!=0.0){
					writer.append(String.valueOf(daysOld[i])+","+String.valueOf(value[i]) + "\n");
				}
			}
			writer.close();
			out.close();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		try{
			in = openFileInput(forGraph);
			reader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
			int i = 0;
			while((buf = reader.readLine())!= null)
				i++;
			in.close();
			reader.close();
			in = openFileInput(forGraph);
			reader =new BufferedReader(new InputStreamReader(in,"UTF-8"));
			String s[] = new String[i+2];
			samplePointDay=new float[s.length-2];
			samplePointWeight=new float[s.length-2];
			i=0;
			//文字入力部ファイル→画面
			while((s[i] = reader.readLine())!= null)
				i++;
			int arrayCaunter=0;
			for(i=0;i<samplePointDay.length;i++){
				dateValue=s[i].split(",");
				if(dateValue.length==2){
					try{
						Float.parseFloat(dateValue[0]);
						Float.parseFloat(dateValue[1]);
					    parseFlag=true;
					}catch(NumberFormatException e){
					    parseFlag=false;
					}
					if(parseFlag){
						//横軸の年齢に同期
						samplePointDay[arrayCaunter]=Float.parseFloat(dateValue[0])/(float)30.0;
						samplePointWeight[arrayCaunter]=Float.parseFloat(dateValue[1]);
						arrayCaunter++;
					}
				}
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
		}		//グラフへの切り替え
		if(graphFlag==-1){
			layout = new LinearLayout(this);
			layout.addView(new MyView(this));
			addContentView(layout, new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		}
		else{
			layout.setVisibility(View.VISIBLE);
		}

		graphFlag=1;
	}
	private void returnMain() {
		//記入画面に戻る
		layout.setVisibility(View.GONE);
		graphFlag=0;
	}
	
	//グラフ記入用のクラス
    class MyView extends View {
    	public MyView(Context context) {
    		super(context);
    	// TODO Auto-generated constructor stub
    	}

    	//クリックしたら前の画面に戻る
    	public boolean onTouchEvent(MotionEvent event){
    		returnMain();
    		return true;
    	}

    	//グラフ記述用
    	protected void onDraw(Canvas canvas) {
    		widthLength=width-offsetX;
    		heightLength=height-offsetYUpper-offsetYDowner;
    		maxNumY=18;		//一番上に来る数字
    		minNumY=-4;		//一番下に来る数字
    		labelYNum=11;	//ラベルを入れる個数
    		differenceYNum=-(maxNumY-minNumY)/labelYNum;	//次の数字との差(下に向かうのでマイナス)
    		maxNumX=15;		//右に来る数字
    		minNumX=0;		//左に来る数字
    		labelXNum=row;	//ラベルを入れる個数
    		differenceXNum=(maxNumX-minNumX)/labelXNum;	//次の数字との差
    		//グラフの座標用パラメータ
    		centerPositionY=offsetYUpper+heightLength*maxNumY/(maxNumY-minNumY);

    		//画面サイズの取得
    		height=getHeight();
    		width=getWidth();
    		//背景の設定
 			canvas.drawColor(Color.WHITE);
 			//描画領域の設定
    		paint = new Paint();
    		//線の色・太さの設定
    		paint.setColor(Color.BLACK);
			paint.setStrokeWidth(1);

			//主軸
			canvas.drawLine(offsetX,offsetYUpper,offsetX,heightLength+offsetYUpper, paint);
			canvas.drawLine(offsetX,heightLength+offsetYUpper,widthLength+offsetX,heightLength+offsetYUpper, paint);
			//X軸に平行
			for(int i=0; i<line; i++) {
				canvas.drawLine(offsetX,offsetYUpper+heightLength/line*i,widthLength+offsetX,offsetYUpper+heightLength/line*i, paint);
				//値の挿入
				if(i%(line/labelYNum)==0){
					if((int)(maxNumY+differenceYNum*i/(line/labelYNum))==0){
						canvas.drawText("基準値", 0, offsetYUpper+5+heightLength/line*i, paint);
					}else{
						canvas.drawText(String.valueOf((int)(maxNumY+differenceYNum*i/(line/labelYNum))), offsetX-20, offsetYUpper+5+heightLength/line*i, paint);
					}
				}
			}
			//Y軸に平行
			for(int i=0; i<row; i++) {
				canvas.drawLine(offsetX+widthLength/row*i,offsetYUpper,offsetX+widthLength/row*i,heightLength+offsetYUpper, paint);
				//値の挿入
				if(i%(row/labelXNum)==0){
					canvas.drawText(String.valueOf((int)(minNumX+differenceXNum*i)), offsetX-5+widthLength/row*i,heightLength+20+offsetYUpper, paint);
					}
				}
			//ラベル(縦)
			canvas.drawText("体", 0,heightLength/2+offsetYUpper-20, paint);
			canvas.drawText("重", 0,heightLength/2+offsetYUpper+0, paint);
			canvas.drawText("[kg]", 0,heightLength/2+offsetYUpper+20, paint);
			//ラベル(横)
			String labelX="妊娠からの月数";
			float textWidth=paint.measureText(labelX);
			canvas.drawText(labelX, offsetX+widthLength/2-textWidth/2,height-offsetYDowner/3, paint);

    		//赤線を引いてみる
			paint.setStrokeWidth(3);
    		paint.setColor(Color.RED);
			canvas.drawLine(offsetX,centerPositionY,offsetX+widthLength,centerPositionY, paint);

			//データを折れ線グラフに

    		paint.setColor(Color.BLUE);
    		for(int i=0;i<samplePointDay.length-1;i++){
    			//基準値との差を計算
    			float differenceY=samplePointWeight[i]-samplePointWeight[0];
    			//座標値に変換
    			float fromX=offsetX+(samplePointDay[i]/maxNumX)*widthLength;
    			float fromY=centerPositionY-(differenceY/(maxNumY-minNumY))*heightLength;
    			differenceY=samplePointWeight[i+1]-samplePointWeight[0];
    			float toX=offsetX+(samplePointDay[i+1]/maxNumX)*widthLength;
    			float toY=centerPositionY-(differenceY/(maxNumY-minNumY))*heightLength;
    			canvas.drawLine(fromX,fromY,toX,toY, paint);
    		}
    		invalidate();
    	}
    }
    
    
    
    //ボタンクリックによって呼び出される処理
    //classの呼び出し(EMCHH.java)で行った内容と同様
    private void button_Write_pregnant_61_back_onClick() {
        Intent intent_read_1 = new Intent(getApplicationContext(),Write_pregnant_51.class);
        startActivity(intent_read_1);
    }

    private void button_Write_pregnant_61_home_onClick() {
        Intent intent_read_2 = new Intent(getApplicationContext(),IndexWrite_pregnant.class);
        startActivity(intent_read_2);
    }

    private void button_Write_pregnant_61_next_onClick() {
        Intent intent_read_3 = new Intent(getApplicationContext(),Write_pregnant_71.class);
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
    		 intent1.setClass(Write_pregnant_61.this, Write_pregnant_62.class);
    		 startActivity(intent1);
    		 return true;
    	 case 1:
    		 Intent intent2 = new Intent();
    		 intent2.setClass(Write_pregnant_61.this, MainActivity.class);
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
