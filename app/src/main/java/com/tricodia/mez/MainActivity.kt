package com.tricodia.mez



import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Window
import android.webkit.WebView

class MainActivity : AppCompatActivity() {

    private var webView: WebView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.requestFeature(Window.FEATURE_PROGRESS)

        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView)
        if (webView != null) {

            val webSettings = webView!!.settings
            webSettings.javaScriptEnabled = true

            webSettings.builtInZoomControls = true

            webView!!.webViewClient = WebViewClt(this)
            webView!!.webChromeClient = WebChromeClt(this)

            webView!!.loadUrl(getString(R.string.site_url))
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && this.webView!!.canGoBack()) {
            webView!!.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}
