package com.hacybeyker.quiz.domain.entity

data class QuestionEntity(
    private val id: Int,
    private val title: String,
    private val description: String? = null,
    private val type: Int = 1,
    private val answers: List<AnswerEntity>
)