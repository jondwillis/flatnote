package com.androsz.flatnote.app;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.androsz.flatnote.R;

public class NotebookActivity extends HostActivity implements
		ActionBar.TabListener {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notebook);

		final ActionBar bar = getActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowHomeEnabled(true);

		/*
		 * int i; for (i = 0; i < Directory.getCategoryCount(); i++)
		 * bar.addTab(bar.newTab().setText(Directory.getCategory(i).getName())
		 * .setTabListener(this));
		 * 
		 * mActionBarView = getLayoutInflater().inflate(
		 * R.layout.action_bar_custom, null);
		 * 
		 * bar.setCustomView(mActionBarView);
		 */
		// bar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM
		// | ActionBar.DISPLAY_USE_LOGO);

		// If category is not saved to the savedInstanceState,
		// 0 is returned by default.
		// if (savedInstanceState != null) {
		// int category = savedInstanceState.getInt("category");
		// bar.selectTab(bar.getTabAt(category));
		// }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		final MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.notebook_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	// private View mActionBarView;

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.new_note:
			startActivity(new Intent(this, NoteActivity.class));
			return true;
		case R.id.delete_notebook:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		// ActionBar bar = getActionBar();
		// int category = bar.getSelectedTab().getPosition();
		// outState.putInt("category", category);
	}

	@Override
	public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
	}

	@Override
	public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
		final TitlesFragment titleFrag = (TitlesFragment) getFragmentManager()
				.findFragmentById(R.id.frag_title);
		titleFrag.populateTitles(tab.getPosition());

		titleFrag.selectPosition(0);
	}

	@Override
	public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
	}
}
