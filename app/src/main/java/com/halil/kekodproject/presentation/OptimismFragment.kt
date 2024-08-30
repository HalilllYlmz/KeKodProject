package com.halil.kekodproject.presentation

import BaseFragment
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.BounceInterpolator
import com.google.android.material.animation.AnimatorSetCompat.playTogether
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentOptimismBinding

class OptimismFragment : BaseFragment<FragmentOptimismBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentOptimismBinding {
        return FragmentOptimismBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
//            titleText.alpha = 0f
//            titleText.scaleX = 0f
//            titleText.scaleY = 0f
//            titleText.visibility = View.VISIBLE
//            val colorAnim = ObjectAnimator.ofArgb(titleText, "textColor", Color.BLUE, Color.RED)
//            val fadeIn = ObjectAnimator.ofFloat(titleText, "alpha", 1f)
//            val scaleX = ObjectAnimator.ofFloat(titleText, "scaleX", 1f)
//            val scaleY = ObjectAnimator.ofFloat(titleText, "scaleY", 1f)
//            val animatorSet = AnimatorSet().apply {
//                playTogether(colorAnim, fadeIn, scaleX, scaleY)
//                duration = 1000
//            }
//            animatorSet.start()

            /*
            titleText.alpha = 0f
            titleText.scaleX = 0f
            titleText.scaleY = 0f
            titleText.setBackgroundResource(R.drawable.bg_text)
            val background = titleText.background as GradientDrawable
            val colorAnimation = ValueAnimator.ofArgb(Color.LTGRAY, Color.DKGRAY).apply {
                duration = 1000 // 1 saniye
                addUpdateListener { animator ->
                    background.setColor(animator.animatedValue as Int)
                }
            }
            val fadeIn = ObjectAnimator.ofFloat(titleText, "alpha", 1f)
            val scaleX = ObjectAnimator.ofFloat(titleText, "scaleX", 1f)
            val scaleY = ObjectAnimator.ofFloat(titleText, "scaleY", 1f)
            val animatorSet = AnimatorSet().apply {
                playTogether(colorAnimation, fadeIn, scaleX, scaleY)
                duration = 1000 // 1 saniye
            }
            animatorSet.start()
            */

            titleText.alpha = 0f
            titleText.scaleX = 0f
            titleText.scaleY = 0f

            titleText.setBackgroundResource(R.drawable.bg_text)
            val background = titleText.background as GradientDrawable
            val gradientAnimation = ValueAnimator.ofFloat(0f, 1f).apply {
                duration = 2000 // 2 saniye
                addUpdateListener { animator ->
                    val fraction = animator.animatedFraction
                    val startColor = blendColors(Color.RED, Color.YELLOW, fraction)
                    val endColor = blendColors(Color.BLUE, Color.GREEN, fraction)
                    background.colors = intArrayOf(startColor, endColor)
                }
            }
            val fadeIn = ObjectAnimator.ofFloat(titleText, "alpha", 1f)
            val scaleX = ObjectAnimator.ofFloat(titleText, "scaleX", 1f)
            val scaleY = ObjectAnimator.ofFloat(titleText, "scaleY", 1f)
            val animatorSet = AnimatorSet().apply {
                playTogether(gradientAnimation, fadeIn, scaleX, scaleY)
                duration = 2000 // 2 saniye
            }
            animatorSet.start()
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