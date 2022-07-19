package com.hacybeyker.quiz.domain.entity

data class StatisticsEntity(
    private val good: Int,
    private val bad: Int,
    private val total: Int,
    private val time: String
)
