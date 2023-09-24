package com.ilustris.nenis.ui.action.model

import com.ilustris.nenis.R

data class Action(
    val description : String,
    val time : Long,
    val type: ActionType,

)

enum class ActionType (val description: String, val icon: Int,val emoji: String, val color:Int)
{
    SLEEP ("Dormir", R.drawable.moon_sleep_svgrepo_com,"💤", com.github.mcginty.R.color.material_purple200),
    BATH ("Banheiro", R.drawable.plastic_duck_svgrepo_com,"🦆", com.github.mcginty.R.color.material_blue200),
    EXERCISE ("Exercício", R.drawable.crawling_baby_silhouette_svgrepo_com,"🚼",com.github.mcginty.R.color.material_green200),
    EAT ("Comer", R.drawable.carrot_svgrepo_com,"🥕", com.github.mcginty.R.color.material_orange200),


}