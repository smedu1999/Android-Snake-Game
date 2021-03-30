package hu.bme.aut.android.snakegame

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import hu.bme.aut.android.snakegame.adapter.OptionsAdapter
import hu.bme.aut.android.snakegame.fragment.BackGroundColorFragment
import hu.bme.aut.android.snakegame.fragment.SnakeColorFragment
import hu.bme.aut.android.snakegame.model.Config
import hu.bme.aut.android.snakegame.model.Drawable
import kotlinx.android.synthetic.main.activity_options.*
import kotlinx.android.synthetic.main.options_snakecolor.*

class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)

        vpOptions.adapter = OptionsAdapter(supportFragmentManager)


    }

}