package hu.bme.aut.android.snakegame.roomDB

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ScoreDao
{
    @Query("SELECT * FROM Score ORDER BY value DESC")
    suspend fun getAll(): List<Score>?

    @Insert
    suspend fun insert(score: Score)

}