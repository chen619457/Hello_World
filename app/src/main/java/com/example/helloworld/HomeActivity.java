package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.helloworld.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent=getIntent();
        String phone = intent.getStringExtra("data_phone");
        mBinding.userPhone.setText(phone);


        SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
        String userName =sp.getString("name"+phone,"0");
        String userSex =sp.getString("sex"+phone,"0");
        String userSms =sp.getString("sms"+phone,"0").equals("1")?"接受":"不接受";
        mBinding.userName.setText(userName);
        mBinding.userSex.setText(userSex);
        String temp=mBinding.userSms.getText().toString()+":"+userSms;
        mBinding.userSms.setText(temp);

    }
}
