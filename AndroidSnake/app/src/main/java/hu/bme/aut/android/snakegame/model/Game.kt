package hu.bme.aut.android.snakegame.model

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.roomDB.AppDatabase
import hu.bme.aut.android.snakegame.roomDB.Score
import hu.bme.aut.android.snakegame.view.DrawingView
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.security.AccessController.getContext


class Game(activity: AppCompatActivity)
{

    var dir=Direction.right
    var delay: Int = 20
    var score: Int = 0
    var endGame=false
    lateinit var timer:Timer
    var entities= mutableListOf<Drawable>()
    lateinit var appleBitmap :Bitmap
    lateinit var bodyBitmap: Bitmap
    lateinit var headBitmap: Bitmap
    lateinit var snake: Snake
    val act = activity


    lateinit var apple:Apple
    lateinit var canvas: DrawingView

    fun startGame(can: DrawingView)
    {

        when(Config.diff)
        {
            1->delay=20
            2->delay=10
            3->delay=5
        }

        canvas=can
        headBitmap =Config.head
        bodyBitmap = Config.body
        appleBitmap= BitmapFactory.decodeResource(canvas.context.resources, R.drawable.apple)
        snake = Snake(canvas, 90,90,headBitmap)
        apple = Apple(300,300,appleBitmap)
        entities.add(apple)
        entities.add(snake)
        render()
        timer = Timer(can, this,act)
        timer.startTimer()
    }
    fun render()
    {
        canvas.entities?.clear()
        act.score_textView.text= "Score:$score"
        for ( item in entities)
        {
            item.render(canvas)
        }
        canvas.invalidate()
    }

    fun checkApple()
    {
        if(snake.body[0].x==apple.x&&snake.body[0].y==apple.y)
        {
            snake.body.add(Snake.Snakeelem(snake.body[snake.body.size-1].x,snake.body[snake.body.size-1].y,bodyBitmap,false))
            score++
            apple.newPos(canvas)
            if(delay!=1)
                delay--
        }
    }
    fun checkCollision() :Boolean
    {

        for (i in snake.body.size-1 downTo 1)
        {
            if(snake.body[0].x==snake.body[i].x&&snake.body[0].y==snake.body[i].y)
            {
                endGame=true
            }
        }

        if (snake.body[0].x >= canvas.width)
        {
            endGame=true
        }

        if (snake.body[0].y >= canvas.height)
        {
            endGame=true
        }
        if (snake.body[0].x < 0 )
        {
            endGame=true
        }
        if (snake.body[0].y < 0)
        {
            endGame=true
        }
        return endGame

    }
    fun endGame()
    {
        timer.timerTask.cancel()

        act.lifecycleScope.launch(Dispatchers.IO)
        {
            val sc = Score(0,score)
            save(sc)
            withContext(Dispatchers.Main)
            {
                Toast.makeText(canvas.context, "Game Over\n  Score: " + score, Toast.LENGTH_LONG)
                    .show()
            }
        }


    }

    suspend fun save(score: Score)
    {
        val db= AppDatabase.getInstance(canvas.context)
        db.scoreDao().insert(score)

    }

}