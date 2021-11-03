package com.application.mob4git;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentHome extends Fragment implements View.OnTouchListener{

    View mainView;
    View divider;
    float oldYvalue;
    Button button_horizontal;
    Button button_vertical;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_home, container, false);
        divider = mainView.findViewById(R.id.divider);
        button_horizontal = mainView.findViewById(R.id.button_horizontal);
        button_vertical = mainView.findViewById(R.id.button_vertical);

        divider.setOnTouchListener(this);



        return mainView;

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int height = ((ViewGroup) v.getParent()).getHeight() - v.getHeight();

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            oldYvalue = event.getY();
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            v.setY(event.getRawY()-(oldYvalue+v.getHeight()));
        }else if(event.getAction() == MotionEvent.ACTION_UP){
            if(v.getY() > height-400){
                v.setY(height-400);
            }else if(v.getY() <400){
                v.setY(400);
            }else if(v.getY() <0 || v.getY() > height){
                if(v.getY() < 0){
                    v.setY(400);
                }else{
                    v.setY(height-400);
                }
            }
        }
        return true;
    }
}
