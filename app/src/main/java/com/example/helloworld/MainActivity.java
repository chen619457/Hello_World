package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone=mBinding.editPhone.getText().toString();
                String pwd=mBinding.editPwd.getText().toString();
               if (phone.equals("10086")&&pwd.equals("123456"))
               {
                   Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                   intent.putExtra("data_phone","10086");
                   startActivity(intent);
               }
               else {
                   Toast.makeText(MainActivity.this,"手机号码或密码错误",Toast.LENGTH_LONG).show();
               }

            }
        });
    }
}
