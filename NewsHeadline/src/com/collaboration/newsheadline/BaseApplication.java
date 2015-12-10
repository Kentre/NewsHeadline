package com.collaboration.newsheadline;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;
import android.content.Context;

public class BaseApplication extends Application {
	private static BaseApplication application;
	public static RequestQueue mRequestQueue;
	@Override
	public void onCreate() {
		super.onCreate();
		application=this;
		mRequestQueue =  Volley.newRequestQueue(getApplicationContext());
	}
	public static RequestQueue getRequestQueue(){
		return mRequestQueue;
	}
	public static Context getApplication() {
		return application;
	}
}
