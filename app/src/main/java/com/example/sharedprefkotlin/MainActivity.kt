package com.example.sharedprefkotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadData()
        button.setOnClickListener{
            saveData();
        }
    }


    private fun saveData(){
        val insertedName : String = et_name.text.toString()
        tv_name.text = insertedName

        val insertedAge : String = et_age.text.toString()
        tv_age.text = insertedAge

        val sharedPreferences:SharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply{
            putString("STRING_KEY",insertedName)
            putString("STRING_KEY2",insertedAge)
        }.apply()

        Toast.makeText(this,"Data Saved",Toast.LENGTH_SHORT).show()

    }

    private fun loadData(){
        val sharedPreferences:SharedPreferences = getSharedPreferences("sharedPrefs",Context.MODE_PRIVATE)
        val savedString:String?= sharedPreferences.getString("STRING_KEY",null)
        val savedString2:String?= sharedPreferences.getString("STRING_KEY2",null)
        tv_age.text = savedString2
        tv_name.text = savedString
    }

}