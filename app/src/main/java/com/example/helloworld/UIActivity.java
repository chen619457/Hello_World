package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.TextureView;
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

public class UIActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener , SeekBar.OnSeekBarChangeListener,RatingBar.OnRatingBarChangeListener {

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




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u_i);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mTextView=findViewById(R.id.text_view);
        mButtonLeft=findViewById(R.id.button_left);
        mButtonRight=findViewById(R.id.button_right);
        mSwitch=findViewById(R.id.button_switch);
        mEditTextNumber=findViewById(R.id.edit_number);
        mButtonOk=findViewById(R.id.button_ok);
        mProgressBar=findViewById(R.id.progress_bar);
        mRadioGroup=findViewById(R.id.radio_group);
        mImageView=findViewById(R.id.image_view);
        mRadioButtonAndroid=findViewById(R.id.radio_android);
        mRadioButtonApple=findViewById(R.id.radio_apple);
        mRadioButtonAli=findViewById(R.id.radio_ali);
        mSeekBar=findViewById(R.id.seek_bar);
        mCheckBoxAndroid=findViewById(R.id.check_android);
        mCheckBoxJava=findViewById(R.id.check_java);
        mCheckBoxSQL=findViewById(R.id.check_sql);
        mRatingBar=findViewById(R.id.rating_bar);


        mButtonLeft.setOnClickListener(this);
        mButtonRight.setOnClickListener(this);
        mSwitch.setOnCheckedChangeListener(this);
        mButtonOk.setOnClickListener(this);
        mRadioGroup.setOnCheckedChangeListener(this);
        mSeekBar.setOnSeekBarChangeListener(this);
        mCheckBoxAndroid.setOnCheckedChangeListener(this);
        mCheckBoxJava.setOnCheckedChangeListener(this);
        mCheckBoxSQL.setOnCheckedChangeListener(this);
        mRatingBar.setOnRatingBarChangeListener(this);



    }

    @Override
    public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.button_left:
                    mTextView.setText(getResources().getString(R.string.Button_left));
                    break;
                case R.id.button_right:
                    mTextView.setText(getResources().getString(R.string.Button_Right));
                    break;
                case R.id.button_ok:
                    String s = mEditTextNumber.getText().toString();
                    int temp;
                    try {
                        temp=Integer.parseInt(s);//(mEditTextNumber.getText().toString());
                    }
                    catch (NumberFormatException e){
                        temp=100;
                    }
                    mProgressBar.setProgress(temp);
                    mSeekBar.setProgress(temp);
                    mTextView.setText(s);
                 // mProgressBar.setProgress(Integer.parseInt(mEditTextNumber.getText().toString()));
                    if (temp<=30)
                    {
                       // mImageView.setImageResource(R.drawable.android);
                        mRadioButtonAndroid.setChecked(true);
                    }
                    else if (temp<=60)
                    {
                       // mImageView.setImageResource(R.drawable.apple);
                        mRadioButtonApple.setChecked(true);
                    }
                    else {
                        mRadioButtonAli.setChecked(true);
                    }
                    mTextView.setText(s);
                  break;
                default:
                    break;
            }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
       // mTextView.setText(isChecked ?
        switch (buttonView.getId())
        {
            case R.id.button_switch:
                mTextView.setText(isChecked?getResources().getString(R.string.open):getResources().getString(R.string.close));
                break;
            case R.id.check_android:
                if (isChecked){
                    android = getResources().getString(R.string.Button_android);
                }else{
                    android="";
                }
                mTextView.setText(android+java+sql);
                break;
            case R.id.check_java:
                if (isChecked){
                    java = getResources().getString(R.string.java);
                }else{
                    java="";
                }
                mTextView.setText(android+java+sql);
                break;
            case R.id.check_sql:
                if (isChecked){
                    sql = getResources().getString(R.string.sql);
                }else{
                    sql="";
                }
                mTextView.setText(android+java+sql);
                break;
        }

                //getResources().getString(R.string.open):
                //getResources().getString(R.string.close));
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId)
        {
            case R.id.radio_android:mImageView.setImageResource(R.drawable.android);break;
            case R.id.radio_apple:mImageView.setImageResource(R.drawable.apple);break;
            case R.id.radio_ali:mImageView.setImageResource(R.drawable.ia_100000019);break;
            default:break;
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mTextView.setText(String.valueOf(progress));
        mEditTextNumber.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        Toast.makeText(getApplicationContext(),rating+getResources().getString(R.string.appraise),Toast.LENGTH_SHORT).show();

    }
}
