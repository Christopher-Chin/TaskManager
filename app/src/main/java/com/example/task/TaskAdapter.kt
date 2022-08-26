package com.example.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val list:ArrayList<com.example.task.Task>): RecyclerView.Adapter<TaskAdapter.Task>(){

    class Task(item: View) :RecyclerView.ViewHolder(item){
        lateinit var taskTitle:TextView
        lateinit var taskDesc:TextView


        init {
            taskTitle = item.findViewById(R.id.taskName)
            taskDesc = item.findViewById(R.id.taskDescription)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Task {
        val taskView=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskAdapter.Task(taskView)
    }

    override fun onBindViewHolder(holder: Task, position: Int) {
        holder.taskTitle.text = list.get(position).taskTitle
        holder.taskDesc.text = list.get(position).taskDescription

    }

    override fun getItemCount(): Int {
        return list.size
    }
}