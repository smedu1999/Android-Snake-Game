package hu.bme.aut.android.snakegame.model

import android.graphics.Canvas
import android.os.CountDownTimer
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import hu.bme.aut.android.snakegame.view.DrawingView
import java.util.*
import java.util.Timer


class Timer(val layout: DrawingView, val g: Game, val activity: AppCompatActivity) : Timer()
{
    lateinit var timerTask: TimerTask


    fun startTimer()
    {
        var ticks: Int = 10
        timerTask=object :TimerTask()
        {
            override fun run()
            {
                activity.runOnUiThread(Runnable
                {
                    ticks= (ticks+1)%g.delay
                    if(ticks==0)
                    {
                        if(g.checkCollision())
                        {
                            g.endGame()
                        }
                        else
                        {
                            g.snake.move(g.dir)
                            g.checkApple()
                        }
                    }
                    if(!g.endGame)
                        g.render()
                })
            }

        }
        this.scheduleAtFixedRate(timerTask,0,10)
    }
}
