package hu.bme.aut.android.snakegame.roomDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Score::class), version = 1)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun scoreDao(): ScoreDao
    companion object
    {
        private  lateinit var db: AppDatabase
        fun getInstance(context: Context):AppDatabase {
            if(this::db.isInitialized)
            {
                return db
            }
            else
            {
                db= Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"ScoreDatabase").build()
                return db
            }
        }
    }
}