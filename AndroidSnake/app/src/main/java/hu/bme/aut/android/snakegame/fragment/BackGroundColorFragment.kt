package hu.bme.aut.android.snakegame.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.model.Config
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.options_bgcolor.*

class BackGroundColorFragment : Fragment(R.layout.options_bgcolor){
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_background1.setOnClickListener()
        {
            Config.bg=null
        }
        btn_background2.setOnClickListener()
        {
            Config.bg=Color.RED
        }
        btn_background3.setOnClickListener()
        {
            Config.bg=Color.BLACK
        }
        btn_background4.setOnClickListener()
        {
            Config.bg=Color.BLUE
        }
        btn_background5.setOnClickListener()
        {
            Config.bg=Color.YELLOW
        }
        btn_background6.setOnClickListener()
        {
            Config.bg=Color.MAGENTA
        }

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.options_bgcolor, container, false)
    }
}