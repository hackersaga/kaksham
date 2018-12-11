package in.gov.kurukshetra.kaksham;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mixpanel.android.mpmetrics.MixpanelAPI;

import org.json.JSONObject;

public class MixpanelActivity extends AppCompatActivity {

    private MixpanelAPI mixpanel;

    private String tagName = "Default Tag";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mixpanel = MixpanelAPI.getInstance(this, Constants.MIXPANEL_TOKEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(null != mixpanel){

        }
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


    @Override
    protected void onDestroy() {
        mixpanel.flush();
        super.onDestroy();
    }

    public void screenOpened(String screenName){
        try {
            JSONObject props = new JSONObject();
            props.put("Screen", screenName);
            mixpanel.track("Screen Opened", props);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void classButtonClicked(String classNumber){
        try {
            JSONObject props = new JSONObject();
            props.put("classNumber", classNumber);
            mixpanel.track("Class Button Clicked", props);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void trackClassSubject(String classNumber, String subject){
        try {
            JSONObject props = new JSONObject();
            props.put("classNumber", classNumber);
            props.put("subject", subject);
            mixpanel.track("Class Subject Selection", props);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void subjectButtonClicked(String subject){
        try {
            JSONObject props = new JSONObject();
            props.put("subject", subject);
            mixpanel.track("Subject Button Clicked", props);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public MixpanelAPI getMixpanel() {
        return mixpanel;
    }
}
