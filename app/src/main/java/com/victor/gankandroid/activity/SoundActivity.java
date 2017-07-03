package com.victor.gankandroid.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.victor.gankandroid.R;
import com.victor.gankandroid.widget.SolidToast;
import com.victor.gankandroid.widget.SoundView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SoundActivity extends AppCompatActivity {

    @BindView(R.id.sound_view)
    SoundView mSoundView;
    @BindView(R.id.btn_toast)
    Button mBtnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_toast)
    public void onViewClicked() {
        SolidToast toast = new SolidToast.Builder()
                .context(this)
                .animation(R.style.custom_toast_anim_view)
                .text("test")
                .duration(Toast.LENGTH_SHORT)
                .build();
        toast.show();
    }
}
