package com.example.task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var toolbarTitle:TextView
    lateinit var toolbarIcon:ImageView
    lateinit var rv_tasks:RecyclerView
    lateinit var adapter:TaskAdapter

    companion object {
        public var list: ArrayList<Task> = ArrayList()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarTitle = findViewById(R.id.toolBarTitle)
        toolbarIcon = findViewById(R.id.toolBarIcon)
        rv_tasks = findViewById(R.id.tasks_rv)

        toolbarTitle.text = "Task Manager"

        toolbarIcon.setOnClickListener {
                var intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        initAdapter()
    }

    override fun onResume(){
        super.onResume()
        adapter.notifyDataSetChanged()
    }

    fun initAdapter()
    {
        adapter=TaskAdapter(list, applicationContext)
        rv_tasks.layoutManager = LinearLayoutManager(this)
        rv_tasks.adapter = adapter
    }
}


