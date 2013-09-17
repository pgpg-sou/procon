package com.example.dneshiboshiken;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Toast;

public class MyCountDownTimer extends CountDownTimer {

	long caution;
	
	public MyCountDownTimer(long millisInFuture, long countDownInterval, long alerm) {
		super(millisInFuture, countDownInterval);
		caution = alerm;
	}

	@Override
	public void onFinish() {
		// カウントダウン完了後に呼ばれる
		Log.d("test", "終了");
	}

	@Override
	public void onTick(long millisUntilFinished) {
		if(caution > millisUntilFinished) {
			caution = 0;
			MainActivity ma = new MainActivity();
			Log.d("alerm", "通知です");
		} else {
			Log.d("dou", String.valueOf(millisUntilFinished));			
		}
	}


	
}
