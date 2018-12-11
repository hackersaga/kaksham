package in.gov.kurukshetra.kaksham;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.mixpanel.android.mpmetrics.MixpanelAPI;


public class HomeActivity extends MixpanelActivity {


    private Button class2, class3, class4, class5,
            class6, class7, class8, class9, class10 ;

    private ImageView bg;
    private final String SCREEN_NAME = "Home - Select Class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        bg = (ImageView) findViewById(R.id.bg);
        class2 = (Button) findViewById(R.id.class2);
        class3 = (Button) findViewById(R.id.class3);
        class4 = (Button) findViewById(R.id.class4);
        class5 = (Button) findViewById(R.id.class5);
        class6 = (Button) findViewById(R.id.class6);
        class7 = (Button) findViewById(R.id.class7);
        class8 = (Button) findViewById(R.id.class8);
        class9 = (Button) findViewById(R.id.class9);
        class10 = (Button) findViewById(R.id.class10);

        bg.setAlpha(0.6f);


        Common.setOnClick(onClickListener, class2, class3, class4, class5, class6, class7, class8, class9, class10);
        class3.setOnClickListener(onClickListener);
        class5.setOnClickListener(onClickListener);
        class7.setOnClickListener(onClickListener);


        screenOpened(SCREEN_NAME);

    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.class2:{
                    openSubjectScreen(2);
                    break;
                }
                case R.id.class3:{
                    openSubjectScreen(3);
                    break;
                }
                case R.id.class4:{
                    openSubjectScreen(4);
                    break;
                }
                case R.id.class5:{
                    openSubjectScreen(5);
                    break;
                }
                case R.id.class6:{
                    openSubjectScreen(6);
                    break;
                }
                case R.id.class7:{
                    openSubjectScreen(7);
                    break;
                }
                case R.id.class8:{
                    openSubjectScreen(8);
                    break;
                }
                case R.id.class9:{
                    openSubjectScreen(9);
                    break;
                }
                case R.id.class10:{
                    openSubjectScreen(10);
                    break;
                }

            }
        }
    };

    private void openSubjectScreen(int classNumber){
        Intent intent = new Intent(HomeActivity.this, SubjectActivity.class);
        intent.putExtra("class", String.valueOf(classNumber));
        classButtonClicked(String.valueOf(classNumber));
        startActivity(intent);
    }

}
