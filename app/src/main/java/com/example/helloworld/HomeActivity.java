package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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

    /**
     * 对外提供公开的静态的启动本Activity的方法
     * @param activity 启动方的上下文
     * @param userName 用户昵称
     * @param pwd 用户密码
     * @param userSex 用户性别
     * @param phone 用户手机号
     * @param userSms 用户是否接受消息推送
     * @param resultCode 请求代码
     */
    public static void actionStart(Activity activity,String userName,String pwd,String userSex,
                                   String phone,String userSms,int resultCode)
    {
        Intent intent=new Intent(activity,HomeActivity.class);
        Bundle bundle = new Bundle();
        UserInfo u = new UserInfo(userName,pwd,userSex,phone,userSms);
        bundle.putSerializable("userInfo",u);
        intent.putExtras(bundle);
        activity.startActivityForResult(intent, resultCode);
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
