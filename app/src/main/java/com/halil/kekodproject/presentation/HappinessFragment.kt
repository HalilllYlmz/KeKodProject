package com.halil.kekodproject.presentation

import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentHappinessBinding

class HappinessFragment : BaseFragment<FragmentHappinessBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHappinessBinding {
        return FragmentHappinessBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            titleText.rotation = 0f
            titleText.visibility = View.VISIBLE
            titleText.animate()
                .rotation(360f)
                .setDuration(1000)
                .start()
        }
    }
}