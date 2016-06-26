package com.tf.ui;

import com.tf.fragment.FoundationFragment;
import com.tf.fragment.TimeFragment;
import com.tf.fragment.UserFragment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.os.Build;

public class MainActivity extends BaseActivity {
	private RadioGroup tab;
	private android.support.v4.app.Fragment timeFragment,foundationFragment,userFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		addListener();
		timeFragment = new TimeFragment();
		foundationFragment = new FoundationFragment();
		userFragment = new UserFragment();

		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.content_container, timeFragment);
		ft.commit();
	}

	private void addListener() {
		tab.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int id) {
				switch (id) {
				case R.id.rb_time:
					addFragment(timeFragment);
					break;
				case R.id.rb_foundation:
					addFragment(foundationFragment);
					break;
				case R.id.rb_user:
					addFragment(userFragment);
					break;
				}
			}
		});
	}

	private void initView() {
		tab = (RadioGroup) findViewById(R.id.rg_tab);
	}

	private void addFragment(android.support.v4.app.Fragment f) {
		FragmentManager fm = this.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		ft.replace(R.id.content_container, f);
		ft.commit();
	}

	@Override
	public void onClick(View v) {

	}

}
