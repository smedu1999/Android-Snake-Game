package hu.bme.aut.android.snakegame

import android.annotation.SuppressLint
import android.app.Application
import android.graphics.Color
import android.media.Image
import android.media.audiofx.DynamicsProcessing
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import hu.bme.aut.android.snakegame.model.*
import kotlinx.android.synthetic.main.activity_game.*
import org.w3c.dom.Text

class GameActivity() : AppCompatActivity() {

    lateinit var game:Game
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        if(Config.bg!=null)
            canvas.setBackgroundColor(Config.bg!!)
        game=Game(this)
        game.startGame(canvas)

        btn_left.setOnClickListener()
        {
            if (game.dir != Direction.right)
            {
                game.dir = Direction.left
            }
        }
        btn_right.setOnClickListener()
        {
            if (game.dir != Direction.left)
            {
                game.dir = Direction.right
            }
        }
        btn_up.setOnClickListener()
        {
            if (game.dir != Direction.down)
            {
                game.dir = Direction.up
            }
        }
        btn_down.setOnClickListener()
        {
            if (game.dir != Direction.up)
            {
                game.dir = Direction.down
            }
        }
        btn_newGame.setOnClickListener()
        {
            game.timer.timerTask.cancel()
            game=Game(this)
            game.startGame(canvas)
        }
        btn_back.setOnClickListener()
        {
            this.finish()
        }
    }



}










