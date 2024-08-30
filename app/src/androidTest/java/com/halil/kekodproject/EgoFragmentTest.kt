package com.halil.kekodproject

import android.view.View
import android.widget.Switch
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.halil.kekodproject.presentation.EgoFragment
import org.junit.Before
import org.junit.Test

class EgoFragmentTest {

    private lateinit var navController: NavController

    @Before
    fun setUp() {
        navController = TestNavHostController(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun testSwitchEgoChange() {
        val fragmentScenario = launchFragmentInContainer<EgoFragment>(themeResId = R.style.Theme_KeKodProject)

        fragmentScenario.onFragment { fragment ->
            val switchEgo = fragment.view?.findViewById<Switch>(R.id.switchEgo)
            switchEgo?.performClick() // Simulate switch change

            // Verify if BottomNavigationView visibility has been changed
            val bottomNavView = fragment.requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
            assert(bottomNavView.visibility == View.INVISIBLE)
        }
    }

    @Test
    fun testHandleSwitchChange() {
        val fragmentScenario = launchFragmentInContainer<EgoFragment>(themeResId = R.style.Theme_KeKodProject)

        fragmentScenario.onFragment { fragment ->
            val switchHappiness = fragment.view?.findViewById<Switch>(R.id.switchHappiness)
            switchHappiness?.performClick()

            val bottomNavView = fragment.requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
            val menuItem = bottomNavView.menu.findItem(R.id.happinessFragment)

            assert(menuItem != null)
        }
    }
}
