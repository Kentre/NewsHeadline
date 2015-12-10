package com.collaboration.newsheadline.utils;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.util.TypedValue;
import android.view.View;
import android.widget.Toast;

import com.collaboration.newsheadline.BaseApplication;


public class UiUtils {
	/**
	 * 拿到资源
	 * @return
	 */
	public static Resources getResource() {
		return BaseApplication.getApplication().getResources();
	}
	/**
	 * 拿到上下文
	 * @return
	 */
	public static Context getContext() {
		return BaseApplication.getApplication();
	}

	/** dip转换px */
	public static int dip2px(int dip) {
		final float scale = getResource().getDisplayMetrics().density;
		return (int) (dip * scale + 0.5f);
	}

	/** px转换dip */

	public static int px2dip(int px) {
		final float scale = getResource().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	/** dp转换px **/
	public static float dp2px(int dp) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
				getContext().getResources().getDisplayMetrics());
	}

	/***
	 * 加载View
	 * 
	 * @param id
	 * @return
	 */
	public static View inflate(int id) {
		return View.inflate(getContext(), id, null);
	}
	/**
	 * 显示Toast
	 * @param text
	 */
	public static void showToast(String text) {
		Toast.makeText(UiUtils.getContext(), text, 0).show();
	}
	
	/**
	 * 判断是否运行在UI线程
	 * @return
	 */
	public static boolean isRunInMainThread() {
		if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
			return true;
		} else {
			return false;
		}
	}

}
