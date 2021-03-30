package hu.bme.aut.android.snakegame.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import hu.bme.aut.android.snakegame.model.Drawable

class DrawingView(context: Context?, attrs: AttributeSet?) : View(context, attrs)
{
    private lateinit var paint: Paint

    var entities: MutableList<Drawable>? = null

    init {
        initPaint()
        initLists()
        setWillNotDraw(false)
    }

    private fun initPaint() {
        paint = Paint()
        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 50F
    }

    private fun initLists() {
        entities = mutableListOf()
    }

    fun addPointToTheList(startPoint: Drawable) {
        entities?.add(startPoint)
    }
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        for (point in entities!!) {
            drawPoint(canvas, point)
        }
    }

    private fun drawPoint(canvas: Canvas, drawable: Drawable?) {
        if (drawable == null) {
            return
        }
        canvas.drawBitmap(drawable.icon, drawable.x.toFloat(), drawable.y.toFloat(),paint)
    }



}