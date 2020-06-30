package com.ustc.iot.fragment.solution;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ustc.iot.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
 * 包名：      com.ustc.iot.fragment.gatewaycenter
 * 文件名：      FragmentAddGateway
 * 创建时间：      2020/5/28 4:42 PM
 *
 */
public class FragmentAddSolution extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_solution,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FlowTextLayout layout = view.findViewById(R.id.flow);
        FlowTextLayout gatewayLayout = view.findViewById(R.id.gateway);
        List<String>  arr = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0){

                arr.add( NickName.generateName2() +" 传感器");
            }else{
                arr.add( NickName.generateName2() +" 传感器");
            }
        }
        layout.setTextContents(arr);
        arr.clear();
        for (int i = 0; i < 15; i++) {
            if (i % 2 == 0){

                arr.add( NickName.generateName2() +" 网关");
            }else{
                arr.add( NickName.generateName2() +" 网关");
            }
        }
        gatewayLayout.setTextContents(arr);
    }
}
