package com.halil.kekodproject.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.google.android.material.materialswitch.MaterialSwitch
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentEgoBinding

class EgoFragment : BaseFragment() {


//    private var _binding: FragmentEgoBinding? = null
//    private val binding get() = _binding!!

    private lateinit var switchEgo: MaterialSwitch
    private lateinit var switchKindness: MaterialSwitch
    private lateinit var switchGiving: MaterialSwitch
    private lateinit var switchRespect: MaterialSwitch
    private lateinit var switchOptimism: MaterialSwitch
    private lateinit var switchHappiness: MaterialSwitch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return getPersistentView(inflater, container, savedInstanceState, R.layout.fragment_ego)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasInitializedRootView) {
            hasInitializedRootView = true
//            setListeners()
//            loadViews()
        }

        switchEgo = requireActivity().findViewById(R.id.switchEgo)
        switchKindness = requireActivity().findViewById(R.id.switchKindness)
        switchGiving = requireActivity().findViewById(R.id.switchGiving)
        switchRespect = requireActivity().findViewById(R.id.switchRespect)
        switchOptimism = requireActivity().findViewById(R.id.switchOptimism)
        switchHappiness = requireActivity().findViewById(R.id.switchHappiness)

        var counter = 1

        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)

        switchEgo.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                bottomNavigationView.visibility = View.INVISIBLE
                switchHappiness.isEnabled = false
                switchOptimism.isEnabled = false
                switchRespect.isEnabled = false
                switchKindness.isEnabled = false
                switchGiving.isEnabled = false
            }else {
                bottomNavigationView.visibility = View.VISIBLE
                switchHappiness.isEnabled = true
                switchOptimism.isEnabled = true
                switchRespect.isEnabled = true
                switchKindness.isEnabled = true
                switchGiving.isEnabled = true
            }
        }

        switchHappiness.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.happinessFragment, Menu.NONE, "Happiness")
                    .setIcon(R.drawable.ic_happiness)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.happinessFragment)
                counter--
            }
        }

        switchKindness.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.kindnessFragment, Menu.NONE, "Kindness")
                    .setIcon(R.drawable.ic_kindness)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.kindnessFragment)
                counter--
            }
        }

        switchGiving.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.givingFragment, Menu.NONE, "Giving")
                    .setIcon(R.drawable.ic_giving)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.givingFragment)
                counter--
            }
        }
        switchRespect.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.respectFragment, Menu.NONE, "Respect")
                    .setIcon(R.drawable.ic_respect)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.respectFragment)
                counter--
            }
        }
        switchOptimism.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.optimisimFragment, Menu.NONE, "Optimism")
                    .setIcon(R.drawable.ic_optimism)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.optimisimFragment)
                counter--
            }
        }


    }


}