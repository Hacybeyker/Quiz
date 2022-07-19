package com.hacybeyker.quiz.ui.home.fragment.level.adapter

import androidx.recyclerview.widget.DiffUtil
import com.hacybeyker.quiz.domain.entity.LevelEntity

class LevelDiffUtilCallback : DiffUtil.ItemCallback<LevelEntity>() {

    override fun areItemsTheSame(oldItem: LevelEntity, newItem: LevelEntity): Boolean {
        return oldItem.id == newItem.id && oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: LevelEntity, newItem: LevelEntity): Boolean {
        return oldItem == newItem
    }
}
