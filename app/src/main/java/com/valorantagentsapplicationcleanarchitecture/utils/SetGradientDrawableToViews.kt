package com.valorantagentsapplicationcleanarchitecture.utils

import android.graphics.Color
import android.graphics.drawable.GradientDrawable

fun createGradientDrawable(colors: List<String?>?, angle: Int): GradientDrawable {
    val colorInts = mutableListOf<Int>()

    if (colors != null) {
        for (colorString in colors) {
            try {
                // Add '#' symbol to the color string if it's missing
                val formattedColorString =
                    if (!colorString?.startsWith("#")!!) "#$colorString" else colorString
                val colorInt = Color.parseColor(formattedColorString)
                colorInts.add(colorInt)
            } catch (e: IllegalArgumentException) {
                // Handle invalid color string
                e.printStackTrace()
            }
        }
    }

    // Convert the list of color ints to an array
    val colorIntArray = colorInts.toIntArray()

    val gradientDrawable = GradientDrawable()
    gradientDrawable.colors = colorIntArray
    when (angle) {
        in 45..134 -> gradientDrawable.orientation = GradientDrawable.Orientation.BL_TR
        in 135..224 -> gradientDrawable.orientation = GradientDrawable.Orientation.BOTTOM_TOP
        in 225..314 -> gradientDrawable.orientation = GradientDrawable.Orientation.BR_TL
        else -> gradientDrawable.orientation = GradientDrawable.Orientation.LEFT_RIGHT
    }
    // Add other properties if needed (e.g., corner radius, stroke)
    return gradientDrawable
}