package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityResetPwdBinding;
import com.example.helloworld.databinding.ActivityUpdatePwdBinding;

public class UpdatePwdActivity extends AppCompatActivity {
    private ActivityUpdatePwdBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityUpdatePwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonUpdatePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pwd = mBinding.editPwd.getText().toString().trim();
                String pwdok = mBinding.editOkPwd.getText().toString().trim();
                if (!pwd.equals(pwdok)){
                    Toast.makeText(UpdatePwdActivity.this,"密码不一致，请重新输入",Toast.LENGTH_LONG).show();
                }else{
                    SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
                    String phone = getIntent().getStringExtra("phone_");
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("pwd_"+phone,pwd).apply();
                    Toast.makeText(UpdatePwdActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(UpdatePwdActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}