package com.collaboration.newsheadline.adapter;

import java.util.List;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class GuidePagerAdapter extends PagerAdapter {
	private List<View> mImageList;

	public GuidePagerAdapter(List<View> imgList) {
		mImageList = imgList;
	}

	@Override
	public int getCount() {
		return mImageList.size();
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		return arg0 == arg1;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((View) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(mImageList.get(position));
		return mImageList.get(position);
	}

}
