package in.gov.kurukshetra.kaksham;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Animation animation = AnimationUtils.loadAnimation(this, R.anim.zoomout);
        animation.setInterpolator(new LinearInterpolator());
        animation.setRepeatCount(Animation.INFINITE);
        animation.setDuration(700);

        logo = (ImageView) findViewById(R.id.logo);
        logo.startAnimation(animation);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                Intent mainIntent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(mainIntent);
                finish();

            }
        }, 3000);
    }
}
