package com.collaboration.newsheadline;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.collaboration.newsheadline.manager.ActivityCollector;

public abstract class BaseActivity extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
	/**
	 * 初始化视图
	 */
	public abstract void initView();
	/**
	 * 初始化数据
	 */
	public abstract void initDatas();
	/**
	 * 设置监听
	 */
	public void registerListener(){
		
	}
}
