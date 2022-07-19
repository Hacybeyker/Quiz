package com.hacybeyker.quiz.ui.game

import com.hacybeyker.commons.base.BaseActivity
import com.hacybeyker.quiz.R
import com.hacybeyker.quiz.databinding.ActivityGameBinding
import com.hacybeyker.quiz.ui.game.fragment.QuestionFragment
import com.hacybeyker.quiz.ui.game.viewmodel.GameViewModel

class GameActivity : BaseActivity<ActivityGameBinding, GameViewModel>() {

    override val viewBinding: ActivityGameBinding
        get() = ActivityGameBinding.inflate(layoutInflater)

    override val viewModelClass: Class<GameViewModel>
        get() = GameViewModel::class.java

    override fun setupView() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fcvGameQuestion, QuestionFragment())
            .commit()
    }

    override fun setupObservers() {

    }

    override fun launchObservers() {

    }

}