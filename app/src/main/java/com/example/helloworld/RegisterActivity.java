package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding mBinding;
    String name,sex="",pwd,pwdok,phone;
    boolean sms,protocol;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 name=mBinding.editName.getText().toString().trim();
                 pwd=mBinding.editPwd.getText().toString().trim();
                 pwdok=mBinding.editPwdOk.getText().toString().trim();
                 phone=mBinding.editPhone.getText().toString().trim();
                 sms=mBinding.switchSms.isChecked();
                 protocol=mBinding.checkProtocol.isChecked();
                 String toast;
                 //if (name.equals("")||pwd.equals("")||pwdok.equals("")||phone.equals("")||sex.equals(""))
                 if (name.equals(""))
                 {
                     toast="请填写昵称";
                 }
                 else if (phone.equals(""))
                 {
                     toast="请填手机号码";
                 }
                 else if (sex.equals(""))
                 {
                     toast="请选择性别";
                 }
                 else if (pwd.trim().length()!=6)
                 {
                     toast="密码要6位";
                 }
                 else if (!pwd.trim().equals(pwdok))
                 {
                     toast= "再确认密码一致";
                 }
                 else if (phone.length()!=11)
                 {
                     toast="请用中国手机号码";
                 }
                 else if (!protocol)
                 {
                     toast="请同意协议";
                 }
                 else {

                     SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);
                     String temp = sp.getString("phone"+phone,"0");
                     if (!temp.equals("0"))
                     {
                         toast="已被注册";
                     }else {
                         SharedPreferences.Editor editor=sp.edit();
                         editor.putString("phone"+phone,phone);
                         editor.putString("name"+phone,name);
                         editor.putString("sex"+phone,sex);
                         editor.putString("pwd"+phone,pwd);
                         temp=(sms?"1":"0");//判断是否接收消息推送
                         editor.putString("sms"+phone,temp);
                         editor.apply();
                         toast = "注册成功";
                         finish();
                     }

                 }
                 Toast.makeText(RegisterActivity.this,toast,Toast.LENGTH_LONG).show();

            }
        });

        mBinding.radioGroupSex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId==R.id.radio_man) {
                    sex = mBinding.radioMan.getText().toString();
                }else  sex=mBinding.radioWomen.getText().toString();
            }
        });
    }
}
