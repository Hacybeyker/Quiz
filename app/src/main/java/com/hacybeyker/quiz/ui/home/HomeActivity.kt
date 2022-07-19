package com.hacybeyker.quiz.ui.home

import com.hacybeyker.commons.base.BaseActivity
import com.hacybeyker.quiz.R
import com.hacybeyker.quiz.databinding.ActivityHomeBinding
import com.hacybeyker.quiz.ui.home.fragment.learned.LearnedFragment
import com.hacybeyker.quiz.ui.home.fragment.level.LevelFragment
import com.hacybeyker.quiz.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {

    private val fragmentLevel = LevelFragment.newInstance("", "")
    private val fragmentSmart = LearnedFragment()

    override val viewBinding: ActivityHomeBinding
        get() = ActivityHomeBinding.inflate(layoutInflater)

    override val viewModelClass: Class<HomeViewModel>
        get() = HomeViewModel::class.java

    override fun setupView() {
        supportFragmentManager.beginTransaction().replace(R.id.flHome, fragmentLevel).commit()

        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.itemHome -> {
                    supportFragmentManager.beginTransaction().replace(R.id.flHome, fragmentLevel)
                        .commit()
                }
                R.id.itemSmart -> {
                    supportFragmentManager.beginTransaction().replace(R.id.flHome, fragmentSmart)
                        .commit()
                }
            }
            true
        }
    }

    override fun setupObservers() {
        // TODO add your code
    }

    override fun launchObservers() {
        // TODO add your code
    }
}
