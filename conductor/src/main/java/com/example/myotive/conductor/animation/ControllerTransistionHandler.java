package com.example.myotive.conductor.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bluelinelabs.conductor.changehandler.AnimatorChangeHandler;
import com.example.myotive.conductor.R;

/**
 * Created by michaelyotive_hr on 12/31/16.
 */

public class ControllerTransistionHandler extends AnimatorChangeHandler {
    @NonNull
    @Override
    protected Animator getAnimator(@NonNull ViewGroup container, @Nullable View from, @Nullable View to, boolean isPush, boolean toAddedToContainer) {
        //container.getContext().getResources().getAnimation();
        Animation slideIn = AnimationUtils.loadAnimation(container.getContext(), R.anim.slide_in_right);
        Animation slideOut = AnimationUtils.loadAnimation(container.getContext(), R.anim.slide_out_right);

        if(isPush){
            // to == enter
            if(to != null){
                to.startAnimation(slideIn);
            }

            if(from != null){
                from.startAnimation(slideOut);
            }
        }
        else{
            // to == pop
            if(to != null){
                to.startAnimation(slideOut);
            }

            if(from != null){
                from.startAnimation(slideIn);
            }
        }

        return new AnimatorSet();
    }

    @Override
    protected void resetFromView(@NonNull View from) {

    }
}
