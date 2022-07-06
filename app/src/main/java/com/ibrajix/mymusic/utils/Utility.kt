package com.ibrajix.mymusic.utils

import android.content.Context
import android.content.pm.PackageManager

object Utility {

    //check if user has chrome browser
    fun Context.isPackageInstalled(packageName: String): Boolean {
        return try {
            packageManager.getPackageInfo(packageName, 0)
            true
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

}