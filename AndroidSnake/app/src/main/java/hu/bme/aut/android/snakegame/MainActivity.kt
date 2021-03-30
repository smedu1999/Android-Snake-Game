package hu.bme.aut.android.snakegame

import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CalendarContract
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.snakegame.adapter.ScoreAdapter
import hu.bme.aut.android.snakegame.fragment.ScoreFragment
import hu.bme.aut.android.snakegame.model.Config
import hu.bme.aut.android.snakegame.roomDB.AppDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_score.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity(), FragmentListener
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Config.body = BitmapFactory.decodeResource(this.resources, R.drawable.green)
        Config.head = BitmapFactory.decodeResource(this.resources, R.drawable.red)

        btn_options.setOnClickListener()
        {
            startActivity(Intent(this, OptionsActivity::class.java))
        }
        btn_start.setOnClickListener()
        {
            startActivity(Intent(this, GameActivity::class.java))
        }
        btn_score.setOnClickListener()
        {
            btn_score.visibility= View.GONE
            btn_options.visibility= View.GONE
            btn_start.visibility= View.GONE
            supportFragmentManager.beginTransaction().add(R.id.fragment_root,ScoreFragment(this)).addToBackStack("SCORE_FRAGMENT").commit()
            Toast.makeText(this, "Score menu", Toast.LENGTH_SHORT).show()
        }
    }

    override fun close() {
        btn_score.visibility= View.VISIBLE
        btn_options.visibility= View.VISIBLE
        btn_start.visibility= View.VISIBLE
    }


}

interface FragmentListener
{
    fun close()
}