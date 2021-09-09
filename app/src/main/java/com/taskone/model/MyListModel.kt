package com.taskone.model

data class MyListModel(
    var id: Int = 0,
    var question: String = "",
    var type: Int = 0,
    var answer: String = "",
    var list: ArrayList<AnswerMcQ>

) {
    data class AnswerMcQ(
        var uid: Int = 0,
        var options: String = "",
        var isSelected: Boolean = false
    ) {

    }
}
