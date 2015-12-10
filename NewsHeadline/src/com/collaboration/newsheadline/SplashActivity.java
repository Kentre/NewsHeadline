package com.collaboration.newsheadline;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;

import com.collaboration.newsheadline.adapter.GuidePagerAdapter;
import com.collaboration.newsheadline.utils.UiUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 * 显示闪屏页内容以及导航页效果
 * 
 * @author u
 *
 */
public class SplashActivity extends BaseActivity {
	@ViewInject(R.id.id_guide_pager)
	private ViewPager mGuidePager;
	@ViewInject(R.id.id_splash_pic)
	private ImageView mSplashView;
	private static final int[] pagerResId = { R.drawable.guide_page1,
			R.drawable.guide_page2 };
	private List<View> imgList = new ArrayList<View>();
	private ScaleAnimation scaleAnim;
	private TextView tv_enter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView();
		initDatas();
		registerListener();
	}

	/**
	 * 初始化视图
	 */
	@Override
	public void initView() {
		setContentView(R.layout.activity_splash);
		ViewUtils.inject(this);

		if (getSharedPreferences("GuidePager", MODE_PRIVATE).getBoolean(
				"isFirstInstall", true)) {
			mSplashView.setVisibility(View.GONE);
			// 设置为第二次进来
			getSharedPreferences("GuidePager", MODE_PRIVATE).edit()
					.putBoolean("isFirstInstall", false).commit();
		} else {
			// 开始动画
			mGuidePager.setVisibility(View.GONE);
			startAnim();
		}
		initPager();
	}

	/**
	 * 初始化ViewPager
	 */
	private void initPager() {
		for (int i = 0; i < pagerResId.length; i++) {
			ImageView img = new ImageView(this);
			img.setImageResource(pagerResId[i]);
			img.setScaleType(ScaleType.FIT_XY);
			imgList.add(img);
		}
		View lastPager = View.inflate(this,
				R.layout.activity_splash_last_pager, null);
		imgList.add(lastPager);
		tv_enter = (TextView) lastPager.findViewById(R.id.enter_app);
	}

	/**
	 * 缩放动画
	 */
	private void startAnim() {
		scaleAnim = new ScaleAnimation(1, 1.2f, 1, 1.2f,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		scaleAnim.setDuration(2000);
		scaleAnim.setFillAfter(true);
		scaleAnim.setInterpolator(new LinearInterpolator());
		mSplashView.startAnimation(scaleAnim);
	}

	/**
	 * 初始化数据
	 */
	@Override
	public void initDatas() {
		mGuidePager.setAdapter(new GuidePagerAdapter(imgList));
	}

	@Override
	public void registerListener() {
		scaleAnim.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {

			}

			@Override
			public void onAnimationRepeat(Animation animation) {

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				// 动画结束跳转主页
				startMainActivity();
			}

		});
		tv_enter.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 点击跳到主页
				startMainActivity();
			}
		});
	}

	// 屏蔽返回键
	@Override
	public void onBackPressed() {

	}

	/**
	 * 跳转主页
	 */
	private void startMainActivity() {
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
}
