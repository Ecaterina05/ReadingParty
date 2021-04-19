package com.example.readingparty;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class HelloFragment extends Fragment {

    Button btnSignOut;
    public static final String MyPREFERENCES = "MyPrefs" ;
    private static final String KEY_USER="username";
    //private static final String KEY_PASSWORD="password";



    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inf = inflater.inflate(R.layout.hello_fragment, container, false);
        TextView welcomeTxt = (TextView) inf.findViewById(R.id.welcomeTxt);
        SharedPreferences sharedPreferences = getActivity().getApplicationContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String username = sharedPreferences.getString(KEY_USER, null);
        if(username!=null){
        welcomeTxt.setText("Welcome, "+username.toUpperCase()+"!");}
        return inf;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getApplicationContext().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        btnSignOut=getActivity().findViewById(R.id.signOutBtn);
        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(getActivity(),MainActivityLog.class);
                startActivity(intent);

            }
        });


    }
}