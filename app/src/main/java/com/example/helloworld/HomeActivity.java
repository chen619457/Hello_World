package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityHomeBinding;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;
    private long exitTime=0;
    public static final String EXIT_HOME="exit_home";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        Intent intent=getIntent();
       // String phone = intent.getStringExtra("data_phone");
        UserInfo u=(UserInfo)intent.getSerializableExtra("userInfo");
        String phone = Objects.requireNonNull(u).getPhone();
        String userName =u.getUserName();
        String userSex =u.getSex();
        String userSms =u.getSms();

        mBinding.userPhone.setText(phone);


//        SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
//        String userName =sp.getString("name"+phone,"0");
//        String userSex =sp.getString("sex"+phone,"0");
//        String userSms =sp.getString("sms"+phone,"0").equals("1")?"接受":"不接受";
        mBinding.userName.setText(userName);
        mBinding.userSex.setText(userSex);
        String temp=mBinding.userSms.getText().toString()+":"+userSms;
        mBinding.userSms.setText(temp);
        intent.putExtra(EXIT_HOME,"你已退出账号");
        setResult(RESULT_OK,intent);

    }

    @Override
    public void onBackPressed() {
        exit();

    }
    private  void  exit()
    {
        long time=2000;
        if (System.currentTimeMillis()-exitTime>2000)
        {
            exitTime=System.currentTimeMillis();
            Toast.makeText(getApplicationContext(),"快速点击两次,可退出当前账号",Toast.LENGTH_SHORT).show();
        }else {
            finish();
        }
    }
}
