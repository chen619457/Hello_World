package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityHomeBinding;
import com.example.helloworld.databinding.ActivityResetPwdBinding;

import java.time.Instant;

public class ResetPwdActivity2 extends AppCompatActivity {
    private ActivityResetPwdBinding mBinding;
    String name,sex="",phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityResetPwdBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=mBinding.editName.getText().toString().trim();
                phone=mBinding.editPhone.getText().toString().trim();

                String toast;
                //if (name.equals("")||pwd.equals("")||pwdok.equals("")||phone.equals("")||sex.equals(""))
                if ("".equals(name))
                {
                    toast="请填写昵称";
                }
                else if ("".equals(phone))
                {
                    toast="请填手机号码";
                }
                else if ("".equals(sex))
                {
                    toast="请选择性别";
                }
                else if (phone.length()!=11)
                {
                    toast="请用中国手机号码";
                }
                else {

                    SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
                    String error="0";
                    String spPhone = sp.getString("phone"+phone,error);
                    String spName = sp.getString("name"+phone,error);
                    String spSex = sp.getString("sex"+phone,error);
                    if (!spPhone.equals(phone)||!spName.equals(name)||spSex.equals(sex))
                    {
                        toast="信息不匹配，无法重置密码";
                    }else {
                        Intent intent = new Intent(ResetPwdActivity2.this,UpdatePwdActivity.class);
                        startActivity(intent);
                        toast = "请填写新的密码";
                    }

                }
                Toast.makeText(ResetPwdActivity2.this,toast,Toast.LENGTH_LONG).show();

            }
        });


        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radio_man) {
                    sex = mBinding.radioMan.getText().toString();
                } else {
                    sex = mBinding.radioWomen.getText().toString();
                }
            }
        });

    }
}