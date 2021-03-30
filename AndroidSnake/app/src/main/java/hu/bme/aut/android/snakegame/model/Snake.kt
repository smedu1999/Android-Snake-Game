package hu.bme.aut.android.snakegame.model


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color.green
import android.graphics.Point
import android.widget.ImageView
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.view.DrawingView

class Snake(canvas:DrawingView, startX:Int, startY: Int, icon: Bitmap) :Drawable(startX,startY,icon)
{
    var body = mutableListOf<Snakeelem>()
    var bodyBitmap = Config.body

    init
    {
        var i=20
        while(i!=0)
        {
            if(i==20)
                body.add(Snakeelem(startX+i*30,startY, icon,true))
            else
                body.add(Snakeelem(startX+i*30,startY,bodyBitmap,false))
            i--
        }
    }
    class Snakeelem (var sx: Int,var sy: Int, SElemIcon: Bitmap, isHead: Boolean) :Drawable(sx,sy,SElemIcon)
    {
        override fun render(canvas: DrawingView)
        {
            canvas.addPointToTheList(this)
        }

    }


    fun move(dir: Direction)
    {
        for(i in body.size-1 downTo 1)
        {
            body[i].x=body[i-1].x
            body[i].y=body[i-1].y
        }
        when(dir)
        {
            Direction.right->body[0].x+=30
            Direction.left->body[0].x-=30
            Direction.down->body[0].y+=30
            Direction.up->body[0].y-=30
        }
    }

    override fun render(canvas: DrawingView)
    {

        for (item in body)
        {
            item.render(canvas)
        }
    }
}