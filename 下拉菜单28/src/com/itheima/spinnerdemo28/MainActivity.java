package com.itheima.spinnerdemo28;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends Activity {

	private EditText input;
	
	private ImageView downArrow;
	
	
	private List<String> msgList;
	
	private PopupWindow popWin;

	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		input = (EditText) findViewById(R.id.input);
		downArrow = (ImageView) findViewById(R.id.down_arrow);
		
		msgList = new ArrayList<String>();
	
		for (int i = 0; i < 20; i++) {
			msgList.add("1000000000"+i);
		}
		
		initListView();
		
		
		downArrow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				System.out.println("=======");
				//定义 popupWindow
				popWin = new PopupWindow(MainActivity.this);
				popWin.setWidth(input.getWidth()); //设置宽度
				popWin.setHeight(200);	//设置popWin 高度
				
				popWin.setContentView(listView); //为popWindow填充内容
				popWin.setOutsideTouchable(true); // 点击popWin 以处的区域，自动关闭 popWin
				
				popWin.showAsDropDown(input, 0, 0);//设置 弹出窗口，显示的位置
				
			}
		});
		
		
		
		
	}

	private void initListView() {
		listView = new ListView(this);
		listView.setBackgroundResource(R.drawable.listview_background); //设置listView 背景
		listView.setDivider(null);	//设置条目之间的分隔线为null
		listView.setVerticalScrollBarEnabled(false); // 关闭
		listView.setAdapter(new MyListAdapter());
	}

	private class MyListAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return msgList.size();
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder holder;
			if(convertView == null){
				convertView = View.inflate(getApplicationContext(), R.layout.list_item, null);
				holder = new ViewHolder();
				
				holder.delete = (ImageView) convertView.findViewById(R.id.delete);
				holder.tv_msg =(TextView) convertView.findViewById(R.id.tv_list_item);
				convertView.setTag(holder);
			}else{
				holder = (ViewHolder) convertView.getTag();
			}
			
			holder.tv_msg.setText(msgList.get(position));
			
			holder.delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
				//删除对应的条目
					msgList.remove(position);
					
					//刷新listView
					MyListAdapter.this.notifyDataSetChanged();
				}
			});
			convertView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//设置输入框 
					input.setText(msgList.get(position));
					
					popWin.dismiss();
				}
			});
			
			return convertView;
		}
		}

	private class ViewHolder{
		TextView tv_msg;
		ImageView delete;
	}
	
}
