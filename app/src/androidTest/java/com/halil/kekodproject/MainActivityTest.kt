package com.halil.kekodproject

import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun testNavHostFragmentIsInitialized() {
        ActivityScenario.launch(MainActivity::class.java).use { scenerio ->
            scenerio.onActivity { activity ->
                val navHostFragment = activity.supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                assert(navHostFragment != null)
            }
        }
    }

}