package com.ilustris.nenis.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ilustris.nenis.databinding.FragmentHomeBinding
import com.ilustris.nenis.ui.action.NewTaskBottomSheet
import com.ilustris.nenis.ui.action.model.Action
import com.ilustris.nenis.ui.home.adapter.ActionAdapter

class HomeFragment : Fragment() {

    private var homeBinding: FragmentHomeBinding? = null

    private val actionList = ArrayList<Action>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater,container,false)
        return homeBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeBinding?.addNewTask?.setOnClickListener{
            NewTaskBottomSheet{item ->
                listUpdate(item)
            }.show(parentFragmentManager, "NewTaskBottomSheet")
        }
    }
    fun listUpdate (newItem: Action)
    {
        actionList.add(newItem)
        homeBinding?.recyclerViewTasks?.adapter=ActionAdapter(actionList)
    }
}