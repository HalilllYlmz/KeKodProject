package com.halil.kekodproject.presentation

import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentKindnessBinding

class KindnessFragment : BaseFragment<FragmentKindnessBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentKindnessBinding {
        return FragmentKindnessBinding.inflate(inflater, container, false)
    }
}