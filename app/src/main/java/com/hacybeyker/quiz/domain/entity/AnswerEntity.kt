package com.hacybeyker.quiz.domain.entity

data class AnswerEntity(
    val id: Int,
    val title: String,
    val isCorrect: Boolean = false
)