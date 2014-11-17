package com.itheima.yokumenu28;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends Activity implements OnClickListener {

	
	private ImageView icon_menu;
	private ImageView icon_home;
	
	private RelativeLayout level1;
	private RelativeLayout level2;
	private RelativeLayout level3;
	/**
	 * 判断 第3级菜单是否显示
	 * true 为显示
	 */
	private boolean isLevel3Show = true;
	/**
	 * 判断 第2级菜单是否显示
	 * true 为显示
	 */
	private boolean isLevel2Show = true;
	/**
	 * 判断 第1级菜单是否显示
	 * true 为显示
	 */
	private boolean isLevel1show = true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		icon_home = (ImageView) findViewById(R.id.icon_home);
		icon_menu = (ImageView) findViewById(R.id.icon_menu);
		
		level1 = (RelativeLayout) findViewById(R.id.level1);
		level2 = (RelativeLayout) findViewById(R.id.level2);
		level3 = (RelativeLayout) findViewById(R.id.level3);
		
		icon_home.setOnClickListener(this);
		icon_menu.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.icon_menu:	//处理 menu 图标的点击事件
			// 如果第3级菜单是显示状态，那么将其隐藏
			if(isLevel3Show){
				//隐藏 第3级菜单
				MyUtils.startAnimOut(level3);
			}else{
				// 如果第3级菜单是隐藏状态，那么将其显示
				MyUtils.startAnimIn(level3);
			}
			
			isLevel3Show = !isLevel3Show;
			
			break;
		case R.id.icon_home:	//处理 home 图标 的点击事件
			// 如果第2级菜单是显示状态，那么就隐藏，2，3级菜单
			if(isLevel2Show ){
				MyUtils.startAnimOut(level2);
				isLevel2Show = false;
				
				if(isLevel3Show){ // 如果此时，第3级菜单也显示，那也将其隐藏
					MyUtils.startAnimOut(level3,200);
					isLevel3Show = false;
				}
				
			}else{
				// 如果第2级菜单是隐藏状态，那么就显示2级菜单
				MyUtils.startAnimIn(level2);
				isLevel2Show = true;
			}
			
			break;
		}
	}

	/**
	 * 改变第1级菜单的状态
	 */
	private void changeLevel1State() {
		//如果第1级菜单是显示状态，那么就隐藏 1，2，3级菜单 
		if(isLevel1show){
			MyUtils.startAnimOut(level1);
			isLevel1show = false;
			
			if(isLevel2Show){ // 判断2级菜单是否显示
				MyUtils.startAnimOut(level2,100);
				isLevel2Show = false;
				if(isLevel3Show){ // 判断3级菜单是否显示
					MyUtils.startAnimOut(level3,200);
					isLevel3Show = false;
				}
			}
			
		}else{
			//如果第1级菜单是隐藏状态，那么就显示 1，2级菜单 
			MyUtils.startAnimIn(level1);
			isLevel1show = true;
			
			MyUtils.startAnimIn(level2,200);
			isLevel2Show = true;
			
		}
		
	}
	
	
	
	@Override
	/**
	 * 响应按键的动作
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
	if(keyCode == KeyEvent.KEYCODE_MENU){ // 监听 menu 按键
		changeLevel1State();
	}
		return super.onKeyDown(keyCode, event);
	}

	

}
