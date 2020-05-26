package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

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

        mBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
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
                     toast="填昵称";
                 }
                 else if (phone.equals(""))
                 {
                     toast="填手机号码";
                 }
                 else if (sex.equals(""))
                 {
                     toast="选择性别";
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
                     toast = "注册成功";
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
