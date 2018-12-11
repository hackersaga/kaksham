package in.gov.kurukshetra.kaksham;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class DriveWebviewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_webview);

        getSupportActionBar().hide();

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        if(null == url){
            url = "www.google.com";
        }
        webView = (WebView) findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
//        webView.setHorizontalScrollBarEnabled(false);
//        webView.over
    }
}
