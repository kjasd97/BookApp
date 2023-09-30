package com.ulyanenko.bookapp.presentation.webview

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewPage(url: String) {

    AndroidView(
        modifier = Modifier.fillMaxSize(),

        factory = {

            WebView(it).apply {
                webViewClient = WebViewClient()
                loadUrl(url)
            }
        },
        update = {
            it.loadUrl(url)
        }
    )


}