package com.example.huzhengbiao.fragmentanimationdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;

/**
 * 主要功能:
 * author huzhengbiao
 * date : On 2018/10/18
 */
public class ExampleFragment extends Fragment {

    public static ExampleFragment newInstance() {
        ExampleFragment fragment = new ExampleFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = getView().findViewById(R.id.switch_);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ExampleFragment.this.getFragmentManager().beginTransaction()
                        .replace(R.id.content, ExampleFragment.newInstance())
                        .commitAllowingStateLoss();
            }
        });
    }


    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return FlipAnimation.create(FlipAnimation.LEFT, enter, 500);
    }
}
