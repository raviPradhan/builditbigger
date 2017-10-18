package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;*/


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements EndpointsAsyncTask.JokeCallback{

    Button showButton;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        showButton = (Button) root.findViewById(R.id.bt_tellJoke);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(getContext(), MainActivityFragment.this, true).execute();
            }
        });
        return root;
    }

    @Override
    public void showJoke(String result) {
        joke = result;
        startActivity(new Intent(getContext(), ShowJokeActivity.class).putExtra("joke", result));
    }
}
