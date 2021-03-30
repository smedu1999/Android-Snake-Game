package hu.bme.aut.android.snakegame.model

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Point
import android.media.Image
import android.widget.ImageView
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.view.DrawingView
import kotlin.random.Random

class Apple(x:Int=300, y: Int=300, icon: Bitmap) :Drawable(x,y,icon)
{
    override fun render(canvas: DrawingView)
    {
        canvas.addPointToTheList(this)
    }
    fun newPos(canvas: DrawingView)
    {
        x= Random.nextInt(from=0, until=canvas.width/30)*30
        y= Random.nextInt(from=0, until=canvas.height/30)*30
    }

}