package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private LottieAnimationView animationView;
    private ListView listView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view=inflater.inflate(R.layout.fragment_placeholder, container, false);
        animationView=view.findViewById(R.id.animation_view2);
        listView = view.findViewById(R.id.list);
        listView.setAdapter(new ListViewAdapter(view.getContext()));
        listView.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        animationView.playAnimation();
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                //  5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                final ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(animationView,"alpha",1.0f,0.0f);
                animatorAlpha.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        if (animatorAlpha.getAnimatedFraction()==1f) {
                            animationView.setVisibility(View.GONE);
                        }
                    }
                });
                listView.setVisibility(View.VISIBLE);
                ObjectAnimator animatorListView =ObjectAnimator.ofFloat(listView,"alpha",0.0f,1.0f);
                animatorListView.setDuration(2000);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animatorAlpha,animatorListView);
                animatorSet.start();
            }
        }, 5000);
    }
}
