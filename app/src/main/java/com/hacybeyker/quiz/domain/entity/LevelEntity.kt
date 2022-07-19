package com.hacybeyker.quiz.domain.entity

data class LevelEntity(
    val id: Int,
    val name: String,
    val category: String,
    val image: Int,
    val description: String,
    val isShow: Boolean = true,
    val isDisable: Boolean = true,
    val isComplete: Boolean = false,
    val statisticsEntity: StatisticsEntity? = null,
    val questions: List<QuestionEntity>
)
