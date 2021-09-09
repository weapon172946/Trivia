package com.taskone.utils

import com.google.gson.Gson
import com.google.gson.JsonParser
import com.taskone.model.MyListModel
import com.taskone.model.QuestionModel


object ListRepo {
    private var list = ArrayList<MyListModel>()
    fun populateList(jsonString: String) {
        val mJsonString = jsonString
        val parser = JsonParser()
        val mJson = parser.parse(mJsonString)
        val gson = Gson()
        val response = gson.fromJson(
            mJson,
            QuestionModel::class.java
        )
        list = response
        System.currentTimeMillis()
    }

    fun getDataList(): ArrayList<MyListModel> {
        return list
    }


}