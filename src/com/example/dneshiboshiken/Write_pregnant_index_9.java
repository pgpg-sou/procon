//処理内容はIndexRead.javaと同様
//保護者の記録　目次
package com.example.dneshiboshiken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.dneshiboshiken.R;
import com.example.dneshiboshiken.R.id;
import com.example.dneshiboshiken.R.layout;

public class Write_pregnant_index_9 extends Activity {

	private Button write_9_1_button;
	private Button write_9_2_button;
	private Button write_9_3_button;
	private Button write_9_4_button;
	private Button write_9_5_button;
	private Button write_9_6_button;
	private Button write_9_7_button;
	private Button write_9_8_button;
	private Button write_9_9_button;
	private Button write_9_10_button;
	private Button write_9_11_button;
	private Button write_9_12_button;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_pregnant_9_index);

        write_9_1_button = (Button) findViewById(R.id.write_9_1_button);
        write_9_1_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
            	write_9_button_1_onClick();
            }
        });

        write_9_2_button = (Button) findViewById(R.id.write_9_2_button);
        write_9_2_button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
            	write_9_button_2_onClick();
            }
        });
        write_9_3_button = (Button) findViewById(R.id.write_9_3_button);
        write_9_3_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_3_onClick();
                }
        });

        write_9_4_button = (Button) findViewById(R.id.write_9_4_button);
        write_9_4_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_4_onClick();
                }
        });

        write_9_5_button = (Button) findViewById(R.id.write_9_5_button);
        write_9_5_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_5_onClick();
                }
        });

        write_9_6_button = (Button) findViewById(R.id.write_9_6_button);
        write_9_6_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_6_onClick();
                }
        });

        write_9_7_button = (Button) findViewById(R.id.write_9_7_button);
        write_9_7_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_7_onClick();
                }
        });

        write_9_8_button = (Button) findViewById(R.id.write_9_8_button);
        write_9_8_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_8_onClick();
                }
        });

        write_9_9_button = (Button) findViewById(R.id.write_9_9_button);
        write_9_9_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_9_onClick();
                }
        });

        write_9_10_button = (Button) findViewById(R.id.write_9_10_button);
        write_9_10_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_10_onClick();
                }
        });

        write_9_11_button = (Button) findViewById(R.id.write_9_11_button);
        write_9_11_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_11_onClick();
                }
        });

        write_9_12_button = (Button) findViewById(R.id.write_9_12_button);
        write_9_12_button.setOnClickListener(new View.OnClickListener(){

                public void onClick(View v) {
                        write_9_button_12_onClick();
                }
        });
    }


    private void write_9_button_1_onClick() {
        Intent intent_write_9_1 = new Intent(getApplicationContext(),Read1.class);
        startActivity(intent_write_9_1);
    }

    private void write_9_button_2_onClick() {
        Intent intent_write_9_2 = new Intent(getApplicationContext(),Read1.class);
        startActivity(intent_write_9_2);
    }
	private void write_9_button_3_onClick() {
		Intent intent_write_9_3 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_3);
	}
	private void write_9_button_4_onClick() {
		Intent intent_write_9_4 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_4);
	}
	private void write_9_button_5_onClick() {
		Intent intent_write_9_5 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_5);
	}

	private void write_9_button_6_onClick() {
		Intent intent_write_9_6 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_6);
	}

	private void write_9_button_7_onClick() {
		Intent intent_write_9_7 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_7);
	}

	private void write_9_button_8_onClick() {
		Intent intent_write_9_8 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_8);
	}

	private void write_9_button_9_onClick() {
		Intent intent_write_9_9 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_9);
	}

	private void write_9_button_10_onClick() {
		Intent intent_write_9_10 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_10);
	}

	private void write_9_button_11_onClick() {
		Intent intent_write_9_11 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_11);
	}

	private void write_9_button_12_onClick() {
		Intent intent_write_9_12 = new Intent(getApplicationContext(),Read1.class);
		startActivity(intent_write_9_12);
	}

}
