package hu.bme.aut.android.snakegame.roomDB

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate=true) val id: Int,
    var value:Int
)
