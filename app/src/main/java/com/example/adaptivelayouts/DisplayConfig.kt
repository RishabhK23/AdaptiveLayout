package com.example.adaptivelayouts

import android.app.Activity
import android.content.Context
import androidx.window.layout.WindowMetricsCalculator

fun Context.getDisplaySize(): DisplayType {
    val portraitMobile = 600
    val tabletPortrait = 840

    val metrics = WindowMetricsCalculator.getOrCreate().computeCurrentWindowMetrics(this)
    val width = metrics.bounds.width()
    val density = resources.displayMetrics.density

    val windowSizeInDp = width.div(density)

    return when {
        windowSizeInDp < portraitMobile -> DisplayType.SMALL
        windowSizeInDp > portraitMobile && windowSizeInDp < tabletPortrait -> DisplayType.MEDIUM
        else -> DisplayType.LARGE
    }
}

enum class DisplayType {
    SMALL, MEDIUM, LARGE
}