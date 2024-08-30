package com.halil.kekodproject.presentation

import BaseFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.halil.kekodproject.R
import com.halil.kekodproject.databinding.FragmentRespectBinding

class RespectFragment : BaseFragment<FragmentRespectBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRespectBinding {
        return FragmentRespectBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            titleText.alpha = 0f
            titleText.scaleX = 0f
            titleText.scaleY = 0f
            titleText.rotation = 0f
            titleText.visibility = View.VISIBLE
            titleText.animate()
                .alpha(1f)
                .scaleX(1f)
                .scaleY(1f)
                .rotation(360f)
                .setDuration(1000) // 1 saniye
                .start()
        }
    }

}