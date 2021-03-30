package hu.bme.aut.android.snakegame.fragment

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.model.Config
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.options_snakecolor.*


class SnakeColorFragment: Fragment(R.layout.options_snakecolor)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        head_imbtn1.setOnClickListener()
        {
            Config.head= BitmapFactory.decodeResource(this.resources, R.drawable.red)
        }
        head_imbtn2.setOnClickListener()
        {
            Config.head= BitmapFactory.decodeResource(this.resources, R.drawable.blue)
        }

        body_imbtn1.setOnClickListener()
        {
            Config.body= BitmapFactory.decodeResource(this.resources, R.drawable.green)
        }
        body_imbtn2.setOnClickListener()
        {
            Config.body= BitmapFactory.decodeResource(this.resources, R.drawable.red)
        }


    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.options_snakecolor, container, false)
    }
}
