package com.halil.kekodproject.presentation

import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentEgoBinding
import com.halil.kekodproject.databinding.FragmentGivingBinding

class GivingFragment : BaseFragment<FragmentGivingBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGivingBinding {
        return FragmentGivingBinding.inflate(inflater, container, false)
    }
}