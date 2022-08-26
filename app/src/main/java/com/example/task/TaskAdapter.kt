package com.example.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val list:ArrayList<com.example.task.Task>, val context: Context): RecyclerView.Adapter<TaskAdapter.Task>(){

    class Task(item: View) :RecyclerView.ViewHolder(item){
        lateinit var taskTitle:TextView
        lateinit var taskDesc:TextView
        lateinit var viewGroup:View


        init {
            taskTitle = item.findViewById(R.id.taskName)
            taskDesc = item.findViewById(R.id.taskDescription)
            viewGroup= item.findViewById(R.id.viewGroup)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Task {
        val taskView=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskAdapter.Task(taskView)
    }

    override fun onBindViewHolder(holder: Task, position: Int) {
        holder.taskTitle.text = list.get(position).taskTitle
        holder.taskDesc.text = list.get(position).taskDescription
        holder.viewGroup.setOnClickListener{
            Toast.makeText(context,list.get(position).taskTitle + ":was clicked",Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}