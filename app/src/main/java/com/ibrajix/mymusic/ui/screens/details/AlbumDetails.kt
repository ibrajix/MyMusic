package com.ibrajix.mymusic.ui.screens.details

import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.ibrajix.mymusic.R
import com.ibrajix.mymusic.utils.Utility.isPackageInstalled

@Composable
fun OpenAlbumDetails(albumUrl: String){

    val context = LocalContext.current

    val packageName = "com.android.chrome"

    val builder = CustomTabsIntent.Builder()

    builder.setShowTitle(true)

    builder.setInstantAppsEnabled(true)

    builder.setDefaultColorSchemeParams(
        CustomTabColorSchemeParams.Builder()
            .setToolbarColor(ContextCompat.getColor(context, R.color.splash_screen_background_color))
            .build()
    )

    val customBuilder = builder.build()

    if (context.isPackageInstalled(packageName)) {
        //if chrome is available use chrome custom tabs
        customBuilder.intent.setPackage(packageName)
        customBuilder.launchUrl(context, Uri.parse(albumUrl))
    } else {

        //if not available use WebView to launch the url
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(albumUrl))
        ContextCompat.startActivity(context, browserIntent, null)

    }

}