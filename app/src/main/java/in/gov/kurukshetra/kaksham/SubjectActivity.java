package in.gov.kurukshetra.kaksham;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;


public class SubjectActivity extends AppCompatActivity {


    private Button hindi, maths, english, geography, history, socialstudy, economics, punjabi, evs;
    private ImageView bg;
    private String classNumber;

    private JSONObject urlMap ;
    private JSONObject subjectMap;
    HashMap<String, Object> keyButtonMap = new HashMap<String, Object>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);


        hindi = (Button) findViewById(R.id.hindi);
        maths = (Button) findViewById(R.id.maths);
        english = (Button) findViewById(R.id.english);
        geography = (Button) findViewById(R.id.geography);
        history = (Button) findViewById(R.id.history);
        socialstudy = (Button) findViewById(R.id.socialstudy);
        economics = (Button) findViewById(R.id.economics);
        punjabi = (Button) findViewById(R.id.punjabi);
        evs = (Button) findViewById(R.id.evs);
        bg = (ImageView) findViewById(R.id.bg);
        bg.setAlpha(0.6f);



        Common.setOnClick(onClickListener, hindi, maths, english, geography, history, socialstudy, economics, punjabi, evs);

        keyButtonMap.put("maths", maths);
        keyButtonMap.put("hindi", hindi);
        keyButtonMap.put("english", english);
        keyButtonMap.put("geography", geography);
        keyButtonMap.put("history", history);
        keyButtonMap.put("socialstudy", socialstudy);
        keyButtonMap.put("economics", economics);
        keyButtonMap.put("punjabi", punjabi);
        keyButtonMap.put("evs", evs);


        Intent intent = getIntent();
        classNumber = intent.getStringExtra("class");
        if(null == classNumber){
            classNumber="2";
        }

        try{
            InputStream is = getAssets().open("contentmap.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String myJson = new String(buffer, "UTF-8");

            urlMap = new JSONObject(myJson);
            subjectMap = urlMap.getJSONObject(classNumber);

            Iterator<String> keys = subjectMap.keys();
            for (Iterator i = subjectMap.keys(); i.hasNext(); ){
                String subject = (String) i.next();
                System.out.println("Subject: "+subject);
                ((Button) keyButtonMap.get(subject)).setVisibility(View.VISIBLE);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.hindi:{
                    openSubjectScreen("hindi");
                    break;
                }
                case R.id.maths:{
                    openSubjectScreen("maths");
                    break;
                }
                case R.id.english:{
                    openSubjectScreen("english");
                    break;
                }
                case R.id.geography:{
                    openSubjectScreen("geography");
                    break;
                }
                case R.id.history:{
                    openSubjectScreen("history");
                    break;
                }
                case R.id.punjabi:{
                    openSubjectScreen("punjabi");
                    break;
                }
                case R.id.economics:{
                    openSubjectScreen("economics");
                    break;
                }
                case R.id.socialstudy:{
                    openSubjectScreen("socialstudy");
                    break;
                }
                case R.id.evs:{
                    openSubjectScreen("evs");
                    break;
                }
            }
        }
    };

    private void openSubjectScreen(String subject){
        try {
            Intent intent = new Intent(SubjectActivity.this, DriveWebviewActivity.class);

            String url = subjectMap.getString(subject);
            intent.putExtra("url", url);
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
