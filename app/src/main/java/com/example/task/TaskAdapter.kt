package com.example.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(val list:ArrayList<com.example.task.Task>): RecyclerView.Adapter<TaskAdapter.Task>(){

    class Task(item: View) :RecyclerView.ViewHolder(item){
        lateinit var taskName:TextView

        init {
            taskName = item.findViewById(R.id.taskName)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Task {
        val taskView=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return TaskAdapter.Task(taskView)
    }

    override fun onBindViewHolder(holder: Task, position: Int) {
        holder.taskName.text = list.get(position).taskDescription
    }

    override fun getItemCount(): Int {
        return list.size
    }
}