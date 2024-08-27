package com.halil.kekodproject.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentEgoBinding

class EgoFragment : Fragment() {


    private var _binding: FragmentEgoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEgoBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var counter = 1

        val bottomNavigationView =
            requireActivity().findViewById<BottomNavigationView>(R.id.bottomNavView)

        binding.switchEgo.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked) {
                bottomNavigationView.visibility = View.INVISIBLE
                binding.switchHappiness.isEnabled = false
                binding.switchOptimism.isEnabled = false
                binding.switchRespect.isEnabled = false
                binding.switchKindness.isEnabled = false
                binding.switchGiving.isEnabled = false
            }else {
                bottomNavigationView.visibility = View.VISIBLE
                binding.switchHappiness.isEnabled = true
                binding.switchOptimism.isEnabled = true
                binding.switchRespect.isEnabled = true
                binding.switchKindness.isEnabled = true
                binding.switchGiving.isEnabled = true
            }
        }

        binding.switchHappiness.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.happinessFragment, Menu.NONE, "Happiness")
                    .setIcon(R.drawable.ic_happiness)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.happinessFragment)
                counter--
            }
        }

        binding.switchKindness.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.kindnessFragment, Menu.NONE, "Kindness")
                    .setIcon(R.drawable.ic_kindness)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.kindnessFragment)
                counter--
            }
        }

        binding.switchGiving.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.givingFragment, Menu.NONE, "Giving")
                    .setIcon(R.drawable.ic_giving)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.givingFragment)
                counter--
            }
        }
        binding.switchRespect.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked && counter < 5) {
                bottomNavigationView.menu.add(Menu.NONE, R.id.respectFragment, Menu.NONE, "Respect")
                    .setIcon(R.drawable.ic_respect)
                counter++
            }else {
                bottomNavigationView.menu.removeItem(R.id.respectFragment)
                counter--
            }
        }
        binding.switchOptimism.setOnCheckedChangeListener { _, isChecked ->
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}