package com.itheima.yokumenu28;

import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public class MyUtils {

	/**
	 * 让指定的view 执行 旋转离开的动画
	 * @param view
	 */
	public static void startAnimOut(RelativeLayout view) {
		
		startAnimOut(view, 0);
	}


	/**
	 * 让指定view 延时 执行旋转离开的动画，
	 * @param level3
	 * @param offset	延时的时间
	 */
	public static void startAnimOut(RelativeLayout view, long offset) {
		/*
		 * 默认圆为 为view的左上角，
		 * 水平向右 为 0度
		 * 顺时针旋转度数增加
		 */
		RotateAnimation animation  =new RotateAnimation(0, 180, view.getWidth()/2, view.getHeight());
		animation.setDuration(500);	//	设置运行的时间
		animation.setFillAfter(true);	//动画执行完以后，保持最后的状态
		animation.setStartOffset(offset);	// 设置延时执行的时间
		
		view.startAnimation(animation);
		
	}
	
	
	
	/**
	 * 让指定的view 执行 旋转进入的动画
	 * @param view
	 */
	public static void startAnimIn(RelativeLayout view) {
		
		startAnimIn(view, 0);
	}

	/**
	 * 让指定的view 延时执行 旋转进入的动画
	 * @param level2
	 * @param i	延时的时间
	 */
	public static void startAnimIn(RelativeLayout view, int i) {
		/*
		 * 默认圆为 为view的左上角，
		 * 水平向右 为 0度
		 * 顺时针旋转度数增加
		 */
		RotateAnimation animation  =new RotateAnimation(180, 360, view.getWidth()/2, view.getHeight());
		animation.setDuration(500);	//	设置运行的时间
		animation.setFillAfter(true);	//动画执行完以后，保持最后的状态
		animation.setStartOffset(i);	//设置延时执行的时间
		view.startAnimation(animation);
		
		
	}


}
