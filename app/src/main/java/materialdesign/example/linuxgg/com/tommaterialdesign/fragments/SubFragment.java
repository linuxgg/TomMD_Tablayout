package materialdesign.example.linuxgg.com.tommaterialdesign.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import materialdesign.example.linuxgg.com.tommaterialdesign.R;

/**
 * Created by tom on 16-5-30.
 */
public class SubFragment extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sub_layout, null);

        return rootView;

    }
}
