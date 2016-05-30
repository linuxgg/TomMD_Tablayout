package materialdesign.example.linuxgg.com.tommaterialdesign.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import materialdesign.example.linuxgg.com.tommaterialdesign.R;

/**
 * Created by tom on 16-5-30.
 */
public abstract class BaseFragment extends Fragment {
    private View rootView;
    private TextView textView;
    private ImageView pic;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sub_layout, null);
        textView = (TextView) rootView.findViewById(R.id.sub_text);
        pic = (ImageView) rootView.findViewById(R.id.pic);
        return rootView;
    }

    public void setText(String text) {
        Log.d("", "set title::" + text);
        if (textView != null) {

            textView.setText(text);
        }
    }

    @NonNull
    public View getBaseRootView() {
        return rootView;
    }

    @NonNull
    public ImageView getPic() {
        return pic;
    }
}