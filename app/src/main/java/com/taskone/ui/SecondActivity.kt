package com.taskone.ui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.taskone.adapter.ListingAdapter
import com.taskone.base.TriviaApp
import com.taskone.databinding.ActivitySecondBinding
import com.taskone.model.MyDbModel
import com.taskone.utils.ListRepo

class SecondActivity : AppCompatActivity() {


    private var _binding: ActivitySecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ListingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        adapter = ListingAdapter(ListRepo.getDataList())
        binding.rvList.adapter = adapter
        myDbModel = MyDbModel()
        binding.btOver.setOnClickListener {
//            ListRepo.populateList()/**/
            finishAffinity()
            startActivity(Intent(this, SplashActivity::class.java))
        }
        binding.btSave.setOnClickListener {
            addDataToDb()

        }
    }

    private fun addDataToDb() {
        val myDbModel = MyDbModel()
        myDbModel.jsonString = Gson().toJson(ListRepo.getDataList())
        myDbModel.createdAt = System.currentTimeMillis().toString()
        TriviaApp.getInstance().appDb!!.listDao().insertAll(myDbModel)

        AlertDialog.Builder(this).setTitle("Success").setMessage("Your result saved to db!")
            .setPositiveButton("Home") { dialogInterface: DialogInterface, i: Int ->
                binding.btOver.performClick()
            }.show()
    }

    private lateinit var myDbModel: MyDbModel


}