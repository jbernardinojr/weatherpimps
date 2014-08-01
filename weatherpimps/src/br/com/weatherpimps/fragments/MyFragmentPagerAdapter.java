package br.com.weatherpimps.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import br.com.weatherpimps.R;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

	final int PAGE_COUNT = 5;

	/** Constructor of the class */
	public MyFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/** This method will be invoked when a page is requested to create */
	@Override
	public Fragment getItem(int page) {
		page++;
		MyFragment myFragment = new MyFragment();
		Bundle data = new Bundle();
		data.putInt("current_page", page);
		data.putString("uncolored", getUncoloredText(page));
		data.putString("colored", getColoredText(page));
		data.putInt("img", R.drawable.rain);
		myFragment.setArguments(data);
		return myFragment;
	}

	/** Returns the number of pages */
	@Override
	public int getCount() {
		return PAGE_COUNT;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return "Page #" + (position + 1);
	}
	
	private String getUncoloredText(int position) {
		String nome = null;
		switch (position) {
		case 1:
			nome = "Tira as\ngalinhas\nda rua\nque vai";
			break;
		case 2:
			nome = "Bronzeador\nna careca\nque a chapa";
			break;
		case 3:
			nome = "Coloque\nas roupas\nno varal.";
			break;
		case 4:
			nome = "Bate a\nbunda no rio\nhoje vai estar";
			break;
		case 5:
			nome = "Bate a\nbunda no tambor\nhoje vai estar";
			break;
		}
		return nome;
	}

	private String getColoredText(int position) {
		String nome = null;
		switch (position) {
		case 1:
			nome = "Chover!";
			break;
		case 2:
			nome = "Vai esquentar!";
			break;
		case 3:
			nome = "Vai dar Sol!";
			break;
		case 4:
			nome = "Frio!";
			break;
		case 5:
			nome = "Calor!";
			break;
		}
		return nome;
	}
}
