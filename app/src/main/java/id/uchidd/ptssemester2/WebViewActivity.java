package id.uchidd.ptssemester2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.webView)
    WebView webView;
    WebSettings webSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);

        Bundle getData = getIntent().getExtras();
        String getLink = getData.getString("LINK WEB");

        showLink("" + getLink);

    }

    public void showLink(String linkWeb){

        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(linkWeb);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(WebViewActivity.this, MainActivity.class));
        finish();
    }
}
