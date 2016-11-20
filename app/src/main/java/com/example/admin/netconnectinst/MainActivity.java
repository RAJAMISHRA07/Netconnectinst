package com.example.admin.netconnectinst;

import android.app.usage.NetworkStatsManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {
WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView= (WebView) findViewById(R.id.webview1);
        //CHK FOR INTERNET CONNECTION
        //A.GET NETWORK MANAGER OBJECT
        ConnectivityManager manager=(ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        //b.from network manager,get activity information
        NetworkInfo networkInfo=manager.getActiveNetworkInfo();
        //c.chk if network is conncted or not
        if(networkInfo==null || networkInfo.isConnected() == false){
            //means there is no internet
            webView.loadData("<h1>NO INTERNET - CHECK AGAIN<h1>","text/html",null);
                    return;
        }

        webView.getSettings().setJavaScriptEnabled(true);
        //below line will make sure that onclicking any hyper link next page
        //will be loaded inthe activity
        webView.setWebViewClient(new WebViewClient());

        //WITHER YOU CEAN GIVE URL OR CAN SEARCH IN GOOGLE
        webView.loadUrl("http://google.com/search?q="+"android inter view questions");
    }



    //we will handle back button clicks-on webview


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            //ASK WEBVIEW - IF THERE ARE ANY PREVIOUSLY NAVIGATED PAGES
            if (webView.canGoBack()==true){
                //control comes here if there is previous page
                webView.goBack();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}

