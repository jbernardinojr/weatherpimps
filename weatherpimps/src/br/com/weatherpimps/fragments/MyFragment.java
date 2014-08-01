package br.com.weatherpimps.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import br.com.weatherpimps.R;

public class MyFragment extends Fragment {

	int mCurrentPage;
	String uncolored, colored;
	int img;
	private View hiddenPanel;
	View v;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		/** Getting the arguments to the Bundle object */
		Bundle data = getArguments();

		/** Getting integer data of the key current_page from the bundle */
		mCurrentPage = data.getInt("current_page", 0);
		uncolored = data.getString("uncolored");
		colored = data.getString("colored");
		img = data.getInt("img", R.drawable.rain);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		v = inflater.inflate(R.layout.fragment_layout, container, false);
		ImageView image = (ImageView) v.findViewById(R.id.imgFragment);
		
		hiddenPanel = v.findViewById(R.id.hidden_panel);
		image.setImageResource(img);
		TextView txtUncolored = (TextView) v.findViewById(R.id.txtUncolored);
		TextView txtColored = (TextView) v.findViewById(R.id.txtColored);
		txtUncolored.setText(uncolored);
		txtColored.setText(colored);

		v.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(arg0.getContext(), "Page" + mCurrentPage,
						Toast.LENGTH_LONG).show();
				//slideUpDown(v);
			}
		});
		return v;
	}

	public void slideUpDown(final View view) {
		if (!isPanelShown()) {
			// Show the panel
			Animation bottomUp = AnimationUtils.loadAnimation(view.getContext(),
					R.anim.bottom_up);

			hiddenPanel.startAnimation(bottomUp);
			hiddenPanel.setVisibility(View.VISIBLE);
		} else {
			// Hide the Panel
			Animation bottomDown = AnimationUtils.loadAnimation(view.getContext(),
					R.anim.bottom_down);

			hiddenPanel.startAnimation(bottomDown);
			hiddenPanel.setVisibility(View.GONE);
		}
	}

	private boolean isPanelShown() {
		return hiddenPanel.getVisibility() == View.VISIBLE;
	}
}
