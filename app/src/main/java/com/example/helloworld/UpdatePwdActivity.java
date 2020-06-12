package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.helloworld.databinding.ActivityResetPwdBinding;
import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

public class UpdatePwdActivity extends AppCompatActivity {
    private ActivityUpdatePwdBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
    }
}