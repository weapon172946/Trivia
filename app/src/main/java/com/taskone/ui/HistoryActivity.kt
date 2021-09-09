package com.taskone.ui

import android.os.Bundle
import android.text.format.DateFormat
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.taskone.R
import com.taskone.adapter.HistoryAdapter
import com.taskone.base.TriviaApp
import com.taskone.model.QuestionModel
import java.util.*
import kotlin.collections.ArrayList

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        var allItems = TriviaApp.getInstance().appDb!!.listDao().all
        var model = ArrayList<QuestionModel>()
        for (item in allItems) {
            val mJsonString = item.jsonString
            val parser = JsonParser()
            val mJson = parser.parse(mJsonString)
            val gson = Gson()
            val response = gson.fromJson(
                mJson,
                QuestionModel::class.java
            )
            response.created = getDate(item.createdAt!!.toLong())
            model.add(response)
        }
        findViewById<RecyclerView>(R.id.rvHistory).adapter = HistoryAdapter(model)
    }

    fun getDate(time: Long): String {
        val cal = Calendar.getInstance(Locale.ENGLISH)
        cal.timeInMillis = time
        return DateFormat.format("dd/MM/yyyy hh:mm a", cal).toString()
    }
}