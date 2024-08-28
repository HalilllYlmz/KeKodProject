package com.halil.kekodproject.presentation

import BaseFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentEgoBinding

class EgoFragment : BaseFragment<FragmentEgoBinding>() {

    private var counter = 1
    private val maxItems = 5

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentEgoBinding {
        return FragmentEgoBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sabit olarak 'EgoFragment' menüye ekle
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
        if (bottomNavigationView.menu.findItem(R.id.egoFragment) == null) {
            bottomNavigationView.menu.add(Menu.NONE, R.id.egoFragment, Menu.NONE, "Ego")
                .setIcon(R.drawable.ic_ego) // Uygun bir simge ile değiştirin
        }

        // Diğer switch'lerin durumlarını ayarla
        with(binding) {
            switchEgo.setOnCheckedChangeListener { _, isChecked ->
                handleSwitchEgoChange(isChecked)
                if(isChecked) {
                    disableSwitches()
                }
            }

            switchHappiness.setOnCheckedChangeListener { _, isChecked ->
                handleSwitchChange(isChecked, R.id.happinessFragment, "Happiness", R.drawable.ic_happiness)
            }

            switchKindness.setOnCheckedChangeListener { _, isChecked ->
                handleSwitchChange(isChecked, R.id.kindnessFragment, "Kindness", R.drawable.ic_kindness)
            }

            switchGiving.setOnCheckedChangeListener { _, isChecked ->
                handleSwitchChange(isChecked, R.id.givingFragment, "Giving", R.drawable.ic_giving)
            }

            switchRespect.setOnCheckedChangeListener { _, isChecked ->
                handleSwitchChange(isChecked, R.id.respectFragment, "Respect", R.drawable.ic_respect)
            }

            switchOptimism.setOnCheckedChangeListener { _, isChecked ->
                handleSwitchChange(isChecked, R.id.optimisimFragment, "Optimism", R.drawable.ic_optimism)
            }
        }

        // Durumları kaydet
        savedInstanceState?.let {
            with(binding) {
                switchEgo.isChecked = it.getBoolean("switchEgoState", false)
                switchHappiness.isChecked = it.getBoolean("switchHappinessState", false)
                switchKindness.isChecked = it.getBoolean("switchKindnessState", false)
                switchGiving.isChecked = it.getBoolean("switchGivingState", false)
                switchRespect.isChecked = it.getBoolean("switchRespectState", false)
                switchOptimism.isChecked = it.getBoolean("switchOptimismState", false)
            }
        }
    }

    private fun handleSwitchEgoChange(isChecked: Boolean) {
        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)
            ?: return

        if (isChecked) {
            bottomNavigationView.visibility = View.INVISIBLE
            disableSwitches()
            closeSwitch()
        } else {
            bottomNavigationView.visibility = View.VISIBLE
            enableSwitches()
        }
    }

    private fun disableSwitches() {
        with(binding) {
            switchHappiness.isEnabled = false
            switchOptimism.isEnabled = false
            switchRespect.isEnabled = false
            switchKindness.isEnabled = false
            switchGiving.isEnabled = false
        }
    }

    private fun closeSwitch() {
        with(binding) {
            switchHappiness.isChecked = false
            switchOptimism.isChecked = false
            switchRespect.isChecked = false
            switchGiving.isChecked = false
            switchKindness.isChecked = false
        }
    }

    private fun enableSwitches() {
        with(binding) {
            switchHappiness.isEnabled = true
            switchOptimism.isEnabled = true
            switchRespect.isEnabled = true
            switchKindness.isEnabled = true
            switchGiving.isEnabled = true
        }
    }

    private fun handleSwitchChange(isChecked: Boolean, menuItemId: Int, title: String, iconResId: Int) {

        val bottomNavigationView = requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView) ?: return

        if (isChecked && counter < maxItems) {
            if (bottomNavigationView.menu.findItem(menuItemId) == null) {
                bottomNavigationView.menu.add(Menu.NONE, menuItemId, Menu.NONE, title).setIcon(iconResId)
                counter++
                println("Counter $counter")
            }
        }
        else {
            bottomNavigationView.menu.removeItem(menuItemId)
            counter--
            println("Counter $counter")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(binding) {
            outState.putBoolean("switchEgoState", switchEgo.isChecked)
            outState.putBoolean("switchHappinessState", switchHappiness.isChecked)
            outState.putBoolean("switchKindnessState", switchKindness.isChecked)
            outState.putBoolean("switchGivingState", switchGiving.isChecked)
            outState.putBoolean("switchRespectState", switchRespect.isChecked)
            outState.putBoolean("switchOptimismState", switchOptimism.isChecked)
        }
    }
}
