package com.halil.kekodproject.presentation

import BaseFragment
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentGivingBinding

class GivingFragment : BaseFragment<FragmentGivingBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGivingBinding {
        return FragmentGivingBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            titleText.visibility = View.VISIBLE
            val colorAnim = ObjectAnimator.ofArgb(
                titleText, "textColor", Color.RED, Color.BLUE
            )
            colorAnim.duration = 1000 // 1 saniye
            colorAnim.start()
            val background = titleText.background as GradientDrawable
            val gradientAnimation = ValueAnimator.ofFloat(0f, 1f).apply {
                duration = 2000
                repeatCount = ValueAnimator.INFINITE
                repeatMode = ValueAnimator.REVERSE
                addUpdateListener { animator ->
                    val fraction = animator.animatedFraction
                    val startColor = blendColors(Color.parseColor("#FF5722"), Color.parseColor("#FFC107"), fraction)
                    val endColor = blendColors(Color.parseColor("#FFC107"), Color.parseColor("#FF5722"), fraction)
                    background.colors = intArrayOf(startColor, endColor)
                }
            }
            gradientAnimation.start()
        }
    }
    private fun blendColors(color1: Int, color2: Int, ratio: Float): Int {
        val inverseRatio = 1f - ratio
        val r = Color.red(color1) * ratio + Color.red(color2) * inverseRatio
        val g = Color.green(color1) * ratio + Color.green(color2) * inverseRatio
        val b = Color.blue(color1) * ratio + Color.blue(color2) * inverseRatio
        return Color.rgb(r.toInt(), g.toInt(), b.toInt())
    }
}