package com.halil.kekodproject.presentation

import BaseFragment
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            titleText.alpha = 0f
            titleText.scaleX = 0f
            titleText.scaleY = 0f
            titleText.translationY = 200f
            titleText.visibility = View.VISIBLE
            val fadeIn = ObjectAnimator.ofFloat(titleText, "alpha", 1f)
            val scaleX = ObjectAnimator.ofFloat(titleText, "scaleX", 1f)
            val scaleY = ObjectAnimator.ofFloat(titleText, "scaleY", 1f)
            val translateY = ObjectAnimator.ofFloat(titleText, "translationY", 0f)
            val animatorSet = AnimatorSet()
            animatorSet.playTogether(fadeIn, scaleX, scaleY, translateY)
            animatorSet.duration = 1000 // 1 saniye
            animatorSet.start()
        }
    }
}