package com.hacybeyker.quiz

import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hacybeyker.quiz.ui.home.HomeActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTestRobolectric {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun showActivityDefault() {
        activityScenarioRule.scenario.moveToState(Lifecycle.State.RESUMED)
        activityScenarioRule.scenario.onActivity { activity ->
            val message = activity.findViewById<TextView>(R.id.tvMessage)
            Assert.assertEquals(message.text, activity.resources.getString(R.string.hello_world))
        }
    }
}
