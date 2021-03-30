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
import kotlinx.android.synthetic.main.options_difficulty.*

class DifficultyFragment : Fragment(R.layout.options_difficulty)
{
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_easy.setOnClickListener()
        {
            Config.diff=1
        }
        btn_normal.setOnClickListener()
        {
            Config.diff=2
        }
        btn_hard.setOnClickListener()
        {
            Config.diff=3
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.options_difficulty, container, false)
    }
}
