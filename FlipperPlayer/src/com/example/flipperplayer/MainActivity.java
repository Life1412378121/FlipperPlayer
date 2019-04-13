package com.example.flipperplayer;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity implements OnClickListener {
	// ׼��ͼƬ��Դ
	private int[] imgs = { R.drawable.photo1, R.drawable.photo2,
			R.drawable.photo3 };
	private ViewFlipper flipper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		flipper = (ViewFlipper) findViewById(R.id.images);

		// ��ʼ����ͼ
		for (int i = 0; i < imgs.length; i++) {
			LayoutInflater inflater = LayoutInflater.from(this);
			View convertView = inflater.inflate(R.layout.item_view, null);

			// ����imageview�ؼ�
			ImageView iv = (ImageView) convertView.findViewById(R.id.item_img);
			iv.setImageResource(imgs[i]);
			iv.setScaleType(ImageView.ScaleType.FIT_XY);

			// ����TextView
			TextView view = (TextView) convertView.findViewById(R.id.item_name);
			view.setText("��" + i + "��");

			// ��imageview�ؼ�����ViewFlipper�У�����һ��imageview�ؼ������������ؼ��ڲ����е�λ�ã�Ĭ�Ͼ��и�����
			flipper.addView(convertView);
		}
		// ͼƬ���ŵ�ʱ��
		flipper.setFlipInterval(5000);
		// �Ƿ������Զ�����
		flipper.setAutoStart(true);
		// ����isFlipping�������ж�ViewFlipper�Ƿ��ڽ���ҳ����ֲ������л���isAutoStart�Ƿ������Զ�����
		if (flipper.isAutoStart() && !flipper.isFlipping()) {
			// ��������ʼ����
			flipper.startFlipping();
		}

		findViewById(R.id.s).setOnClickListener(this);
		findViewById(R.id.x).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.s:
			flipper.showPrevious();
			break;

		default:
			flipper.showNext();
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
