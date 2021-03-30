package hu.bme.aut.android.snakegame.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.widget.ImageView
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.view.DrawingView

object Config
{
    var bg: Int? = null
    lateinit var body: Bitmap
    lateinit var head: Bitmap
    var diff: Int = 2
}