package com.example.task

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast.makeText


class SecondActivity : AppCompatActivity() {

    lateinit var toolbarTitle:TextView
    lateinit var toolbarIcon:ImageView
    lateinit var taskEt:EditText
    lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        toolbarTitle=findViewById(R.id.toolBarTitle)
        toolbarIcon=findViewById(R.id.toolBarIcon)
        taskEt=findViewById(R.id.task_et)
        button=findViewById(R.id.save_task)
        toolbarIcon.setImageDrawable(getDrawable(R.drawable.icon_close))

        toolbarIcon.setOnClickListener{
            finish()
        }

        toolbarTitle.text = "Add new Task"

        button.setOnClickListener{
            if(taskEt.text.toString().length==0){
                Toast.makeText(SecondActivity@this,"Please enter your Tasks",Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            var task=Task()
            task.taskDescription=taskEt.text.toString()
            MainActivity.list.add(task)
            finish()
        }



    }
}