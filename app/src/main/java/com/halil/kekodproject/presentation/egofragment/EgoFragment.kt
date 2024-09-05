package com.halil.kekodproject.presentation.egofragment

import BaseFragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentEgoBinding
import com.halil.kekodproject.utilities.Toastic

class EgoFragment : BaseFragment<FragmentEgoBinding>() {

    private val viewModel: EgoViewModel by viewModels()
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEgoBinding {
        return FragmentEgoBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView =
            requireActivity().findViewById(R.id.bottomNavView)
        if (bottomNavigationView.menu.findItem(R.id.egoFragment) == null) {
            bottomNavigationView.menu.add(Menu.NONE, R.id.egoFragment, Menu.NONE, "Ego")
                .setIcon(R.drawable.ic_ego)
        }

        with(binding) {
            switchEgo.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchEgoState(isChecked)
                if (isChecked) {
                    setSwitchStatus(false)
                    setIsCheckedToFalse()
                } else {
                    setSwitchStatus(true)
                }
            }
            switchHappiness.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchHappinessState(isChecked)
            }
            switchKindness.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchKindnessState(isChecked)
            }
            switchOptimism.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchOptimisticState(isChecked)
            }
            switchRespect.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchRespectState(isChecked)
            }
            switchGiving.setOnCheckedChangeListener { _, isChecked ->
                viewModel.setSwitchGivingState(isChecked)
            }
        }

        with(viewModel) {
            switchEgoState.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) {
                    bottomNavigationView.visibility = View.GONE
                } else {
                    bottomNavigationView.visibility = View.VISIBLE
                }
            }
            switchGivingState.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) {
                    updateBottomNavMenu(isChecked, R.id.givingFragment)
                } else {
                    updateBottomNavMenu(isChecked, R.id.givingFragment)
                }
            }
            switchHappinessState.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) {
                    updateBottomNavMenu(isChecked, R.id.happinessFragment)
                } else {
                    updateBottomNavMenu(isChecked, R.id.happinessFragment)
                }
            }
            switchKindnessState.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) {
                    updateBottomNavMenu(isChecked, R.id.kindnessFragment)
                } else {
                    updateBottomNavMenu(isChecked, R.id.kindnessFragment)
                }
            }
            switchOptimisticState.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) {
                    updateBottomNavMenu(isChecked, R.id.optimisimFragment)
                } else {
                    updateBottomNavMenu(isChecked, R.id.optimisimFragment)
                }
            }
            switchRespectState.observe(viewLifecycleOwner) { isChecked ->
                if (isChecked) {
                    updateBottomNavMenu(isChecked, R.id.respectFragment)
                } else {
                    updateBottomNavMenu(isChecked, R.id.respectFragment)
                }
            }
        }

    }

    private fun setSwitchStatus(status: Boolean) {
        with(binding) {
            switchHappiness.isEnabled = status
            switchKindness.isEnabled = status
            switchOptimism.isEnabled = status
            switchGiving.isEnabled = status
            switchRespect.isEnabled = status
        }
    }

    private fun setIsCheckedToFalse() {
        with(binding) {
            switchHappiness.isChecked = false
            switchRespect.isChecked = false
            switchGiving.isChecked = false
            switchOptimism.isChecked = false
            switchKindness.isChecked = false
        }
    }

    private fun updateBottomNavMenu(isChecked: Boolean, itemId: Int) {
        val menu = bottomNavigationView.menu

        if (isChecked) {
            if (menu.findItem(itemId) == null && menu.size() <= 4) {
                menu.add(Menu.NONE, itemId, Menu.NONE, getMenuTitle(itemId))
                    .setIcon(getMenuIcon(itemId))
            }
        } else {
            menu.removeItem(itemId)
        }
    }

    private fun getMenuTitle(itemId: Int): String {
        return when (itemId) {
            R.id.happinessFragment -> "Happiness"
            R.id.kindnessFragment -> "Kindness"
            R.id.optimisimFragment -> "Optimism"
            R.id.givingFragment -> "Giving"
            R.id.respectFragment -> "Respect"
            else -> ""
        }
    }

    private fun getMenuIcon(itemId: Int): Int {
        return when (itemId) {
            R.id.happinessFragment -> R.drawable.ic_happiness
            R.id.kindnessFragment -> R.drawable.ic_kindness
            R.id.optimisimFragment -> R.drawable.ic_optimism
            R.id.givingFragment -> R.drawable.ic_giving
            R.id.respectFragment -> R.drawable.ic_respect
            else -> 0
        }
    }

}
