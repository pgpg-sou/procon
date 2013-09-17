package com.example.dneshiboshiken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class WriteActivity extends Activity {

	private Button write_button_0_1;
	private Button write_button_0_2;
	private Button write_button_0_3;
	private Button write_button_0_4;
	private Button write_button_0_5;
	private Button write_button_0_6;

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_activity);

        write_button_0_1 = (Button) findViewById(R.id.Button_diary_write);
        write_button_0_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent_write = new Intent(getApplicationContext(),CalendarMode.class);
                startActivity(intent_write);
            }
        });

        write_button_0_2 = (Button) findViewById(R.id.Button_checkup_write);
        write_button_0_2.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_writecheckup = new Intent(getApplicationContext(),WriteCheckup.class);
                startActivity(intent_writecheckup);
        	}
        });

        write_button_0_3 = (Button) findViewById(R.id.Button_lmmunization_write);
        write_button_0_3.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),immunization_main.class);
                startActivity(intent_write);
        	}
        });

        write_button_0_4 = (Button) findViewById(R.id.Button_oldcondition_write);
        write_button_0_4.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),Write_0_31.class);
                startActivity(intent_write);
        	}
        });

        write_button_0_5 = (Button) findViewById(R.id.Button_pregnancy_write);
        write_button_0_5.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),PregnancyActivity.class);
                startActivity(intent_write);
        	}
        });
        write_button_0_6 = (Button) findViewById(R.id.Button_write_condition);
        write_button_0_6.setOnClickListener(new View.OnClickListener(){

        	public void onClick(View v){
                Intent intent_write = new Intent(getApplicationContext(),write_condition.class);
                startActivity(intent_write);
        	}
        });

	}


 }