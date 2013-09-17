//調べる画面の表示

package com.example.dneshiboshiken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends Activity {
    private Button btn_index;
    private Button btn_yahoo;

    /** Called when the activity is first created. */
    //まず呼び出される関数
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_activity);



        btn_index = (Button) findViewById(R.id.Button_index_search);
        btn_index.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
            	Button_index_search_onClick();
            }
        });

        btn_yahoo = (Button) findViewById(R.id.Button_yahoo_search);
        btn_yahoo.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View v) {
            	Button_yahoo_search_onClick();
            }
        });


    }

    private void Button_index_search_onClick() {
        Intent intent_read = new Intent(getApplicationContext(),IndexActivity.class);
        startActivity(intent_read);
    }
    private void Button_yahoo_search_onClick() {
        Intent yahoo_search = new Intent(getApplicationContext(),YahooActivity.class);
        startActivity(yahoo_search);
    }
}