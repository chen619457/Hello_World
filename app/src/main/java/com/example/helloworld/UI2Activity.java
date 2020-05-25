package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.databinding.ActivityUI2Binding;

//import com.example.helloworld.databinding.ActivityUI2Binding;

public class UI2Activity extends AppCompatActivity {

   // private ActivityUI2Binding mBinding;


    private TextView mTextView;
    private Button mButtonLeft,mButtonRight,mButtonOk;
    private Switch mSwitch;
    private ProgressBar mProgressBar;
    private EditText mEditTextNumber;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioButtonAndroid,mRadioButtonApple,mRadioButtonAli;
    private ImageView mImageView;
    private SeekBar mSeekBar;
    private CheckBox mCheckBoxAndroid,mCheckBoxJava,mCheckBoxSQL;
    private RatingBar mRatingBar;
    private String android="",java="",sql="";
    private ActivityUI2Binding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding=ActivityUI2Binding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        mTextView=findViewById(R.id.text_view);
//        mButtonLeft=findViewById(R.id.button_left);
//        mButtonRight=findViewById(R.id.button_right);
//        mSwitch=findViewById(R.id.button_switch);
//        mEditTextNumber=findViewById(R.id.edit_number);
//        mButtonOk=findViewById(R.id.button_ok);
//        mProgressBar=findViewById(R.id.progress_bar);
//        mRadioGroup=findViewById(R.id.radio_group);
//        mImageView=findViewById(R.id.image_view);
//        mRadioButtonAndroid=findViewById(R.id.radio_android);
//        mRadioButtonApple=findViewById(R.id.radio_apple);
//        mRadioButtonAli=findViewById(R.id.radio_ali);
//        mSeekBar=findViewById(R.id.seek_bar);
//        mCheckBoxAndroid=findViewById(R.id.check_android);
//        mCheckBoxJava=findViewById(R.id.check_java);
//        mCheckBoxSQL=findViewById(R.id.check_sql);
//        mRatingBar=findViewById(R.id.rating_bar);

        mBinding.buttonLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // mTextView.setText(getResources().getString(R.string.Button_left));
                mBinding.textView.setText(getResources().getString(R.string.Button_left));
            }
        });


        mBinding.buttonRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mBinding.textView.setText(getResources().getString(R.string.Button_Right));
            }
        });


        mBinding.buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = mBinding.editNumber.getText().toString();
                int temp;
                try {
                    temp=Integer.parseInt(s);//(mEditTextNumber.getText().toString());
                }
                catch (NumberFormatException e){
                    temp=100;
                }
                mBinding.progressBar.setProgress(temp);
                mBinding.seekBar.setProgress(temp);
                mBinding.textView.setText(s);
                // mProgressBar.setProgress(Integer.parseInt(mEditTextNumber.getText().toString()));
                if (temp<=30)
                {
                    // mImageView.setImageResource(R.drawable.android);
                    mBinding.radioAndroid.setChecked(true);
                }
                else if (temp<=60)
                {
                    // mImageView.setImageResource(R.drawable.apple);
                    mBinding.radioApple.setChecked(true);
                }
                else {
                   mBinding.radioAli.setChecked(true);
                }
                mTextView.setText(s);
            }
        });
       mBinding.buttonSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mBinding.textView.setText(isChecked?getResources().getString(R.string.open):getResources().getString(R.string.close));
            }
        });


        mBinding.checkAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    android = getResources().getString(R.string.Button_android);
                }else{
                    android="";
                }
                mBinding.textView.setText(android+java+sql);
            }
        });

        mBinding.checkJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    java = getResources().getString(R.string.java);
                }else{
                    java="";
                }
                mBinding.textView.setText(android+java+sql);
            }
        });

        mBinding.checkSql.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sql = getResources().getString(R.string.sql);
                }else{
                    sql="";
                }
                mBinding.textView.setText(android+java+sql);
            }
        });

        mBinding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId)
                {
                    case R.id.radio_android:
                        mBinding.imageView.setImageResource(R.drawable.android);break;
                    case R.id.radio_apple:
                        mBinding.imageView.setImageResource(R.drawable.apple);break;
                    case R.id.radio_ali:
                        mBinding.imageView.setImageResource(R.drawable.ia_100000019);break;
                    default:break;
                }
            }
        });

        mBinding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mBinding.textView.setText(String.valueOf(progress));
                mBinding.editNumber.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mBinding.ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),rating+getResources().getString(R.string.appraise),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
