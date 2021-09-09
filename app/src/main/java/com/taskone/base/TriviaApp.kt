package com.taskone.base

import android.app.Application
import androidx.room.Room
import com.taskone.db.AppDatabase

class TriviaApp : Application() {

    companion object {
        private var instance: TriviaApp? = null
        fun getInstance(): TriviaApp {
            return instance!!
        }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    var appDb: AppDatabase? = null
        get() {
            if (field == null)
                field = Room.databaseBuilder(this, AppDatabase::class.java, "TaskOneDb")
                    .allowMainThreadQueries().build()
            return field!!
        }

}