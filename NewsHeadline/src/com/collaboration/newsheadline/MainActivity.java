package com.collaboration.newsheadline;

import android.os.Bundle;
import android.widget.Toast;

import com.collaboration.newsheadline.manager.ActivityCollector;
import com.collaboration.newsheadline.utils.UiUtils;

public class MainActivity extends BaseActivity {
	private long backTime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	@Override
	public void initView() {
			
	}

	@Override
	public void initDatas() {
		
	}
	
	/**
	 * 二次退出
	 */
	@Override
	public void onBackPressed() {
		if (System.currentTimeMillis() - backTime > 2000) {
			backTime = System.currentTimeMillis();
			UiUtils.showToast("再按一次退出");
		} else {
			ActivityCollector.finishAll();
		}
	}
	
}
