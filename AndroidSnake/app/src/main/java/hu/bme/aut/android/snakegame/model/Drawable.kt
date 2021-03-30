package hu.bme.aut.android.snakegame.model

import android.graphics.Bitmap
import android.graphics.Canvas
import hu.bme.aut.android.snakegame.view.DrawingView

abstract class Drawable(var x: Int, var y: Int, var icon: Bitmap)
{
    abstract fun render(canvas: DrawingView)
}