package com.ilustris.nenis.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilustris.nenis.R
import com.ilustris.nenis.databinding.TaskLayoutBinding
import com.ilustris.nenis.ui.action.model.Action

class ActionAdapter(                     private var actionList: ArrayList<Action>): RecyclerView.Adapter <ActionAdapter.ActionViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActionViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.task_layout,parent,false)
        return ActionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActionViewHolder, position: Int) {
        holder.bindData()
    }


    override fun getItemCount(): Int {
        return actionList.count()
    }



    inner class ActionViewHolder(itemView: View) : RecyclerView.ViewHolder (itemView){

        fun bindData(){
            val action=actionList [adapterPosition]
            TaskLayoutBinding.bind(itemView).run {
                textTask.text = action.description
                taskIcon.setImageResource(action.type.icon)
            }
        }
    }
}