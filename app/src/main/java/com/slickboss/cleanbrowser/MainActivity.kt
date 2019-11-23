package com.slickboss.cleanbrowser

import android.os.Build
import android.os.Build.*
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.annotation.RequiresApi

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)






    fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }



        val context = this

        webview.webViewClient = MyWebViewClient()

        btnGo.setOnClickListener {
            webview.loadUrl("https://" + edtTxt.text.toString())
        }

        btnBack.setOnClickListener {
            if(webview.canGoBack()) {
                webview.goBack()
                edtTxt.setText(webview.url) } else
                Toast.makeText(context,"No History Available",Toast.LENGTH_SHORT).show()
        }
        btnFront.setOnClickListener {
            if(webview.canGoForward()) {
                webview.goForward()
                edtTxt.setText(webview.url)
            } else
                Toast.makeText(context,"No History Available",Toast.LENGTH_SHORT).show()
        }









}






    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    @Suppress("OverridingDeprecatedMember")
    class MyWebViewClient : WebViewClient(){

        @RequiresApi(VERSION_CODES.LOLLIPOP)
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            view?.loadUrl(request?.url.toString())
            return true
        }

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            view?.loadUrl(url)
            return true
        }

    }




}
