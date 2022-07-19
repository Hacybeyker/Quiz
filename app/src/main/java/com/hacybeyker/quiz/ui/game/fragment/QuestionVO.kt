package com.hacybeyker.quiz.ui.game.fragment

import com.google.android.material.button.MaterialButton
import com.hacybeyker.quiz.domain.entity.AnswerEntity

data class QuestionVO(
    val answerEntity: AnswerEntity,
    val button: MaterialButton
)