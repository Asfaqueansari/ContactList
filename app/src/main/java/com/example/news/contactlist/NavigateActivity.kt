package com.example.news.contactlist

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class NavigateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigate)
    }

    companion object{
         var CONTACT_KEY = "contact_key"
        fun start(context: Context){
            val intent = Intent(context,NavigateActivity::class.java)
            context.startActivity(intent)
        }
    }
}
