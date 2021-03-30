package hu.bme.aut.android.snakegame.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import hu.bme.aut.android.snakegame.FragmentListener
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.adapter.ScoreAdapter
import hu.bme.aut.android.snakegame.roomDB.AppDatabase
import hu.bme.aut.android.snakegame.roomDB.Score
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_score.*
import kotlinx.android.synthetic.main.options_bgcolor.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScoreFragment(var listener: FragmentListener): Fragment(R.layout.fragment_score)
{
    lateinit var adapter: ScoreAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch(Dispatchers.IO)
        {
            val db = AppDatabase.getInstance(context!!)
            var scores = db.scoreDao().getAll()
            withContext(Dispatchers.Main)
            {
                if (scores != null)
                    adapter = ScoreAdapter(scores)
                score_recyclerView.adapter=adapter
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_score, container, false)
    }

    override fun onDestroy() {
        listener.close()
        super.onDestroy()
    }


}