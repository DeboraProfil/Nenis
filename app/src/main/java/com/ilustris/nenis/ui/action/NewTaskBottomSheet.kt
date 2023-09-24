package com.ilustris.nenis.ui.action

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.ilustris.nenis.databinding.BottomSheetFragmentBinding
import com.ilustris.nenis.ui.action.model.Action
import com.ilustris.nenis.ui.action.model.ActionType
import java.util.Calendar

class NewTaskBottomSheet (val newTask: (Action) -> Unit): BottomSheetDialogFragment() {

    var newTaskLayoutBinding: BottomSheetFragmentBinding? = null
    var actionType = ActionType.SLEEP

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        newTaskLayoutBinding = BottomSheetFragmentBinding.inflate(inflater, container, false)
        return newTaskLayoutBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newTaskLayoutBinding?.saveTaskButton?.setOnClickListener {
            val task = newTaskLayoutBinding?.taskText?.text
            task?.let {
                newTask(Action(
                    description = it.toString(),
                    time = Calendar.getInstance().timeInMillis,
                    type = actionType
                    ))
                dismiss()
            }
        }

        newTaskLayoutBinding?.actionTypeButton?.setOnClickListener {
            val menu = PopupMenu(requireContext(), view)
            ActionType.values().forEach {
                menu.menu.add(Menu.NONE, it.ordinal, Menu.NONE, it.description);

            }

            menu.setOnMenuItemClickListener {
                val itemPosition = it.itemId
                actionType = ActionType.values() [itemPosition]
                buttonTextUpdate()
                false
            }
             menu.show()
        }

    }
fun buttonTextUpdate (){
    newTaskLayoutBinding?.actionTypeButton?.text = actionType.emoji + actionType.description
}
}
