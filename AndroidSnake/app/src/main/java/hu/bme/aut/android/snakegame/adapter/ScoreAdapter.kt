package hu.bme.aut.android.snakegame.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.snakegame.R
import hu.bme.aut.android.snakegame.roomDB.Score

class ScoreAdapter(private var items:List<Score>) :RecyclerView.Adapter<ScoreAdapter.ScoreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ScoreViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val item = items[position]
        holder.idTextView.text = item.id.toString()
        holder.valueTextView.text = item.value.toString()
        holder.item = item
    }

    override fun getItemCount(): Int {
        return items.size
    }
    inner class ScoreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val idTextView: TextView
        val valueTextView: TextView
        var item: Score? = null

        init {
            idTextView = itemView.findViewById(R.id.score_id_textview)
            valueTextView = itemView.findViewById(R.id.score_value_textview)
        }
    }
}