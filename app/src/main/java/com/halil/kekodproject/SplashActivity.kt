package com.halil.kekodproject

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ClipDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val star1 = findViewById<ImageView>(R.id.star1)
        val star2 = findViewById<ImageView>(R.id.star2)
        val star3 = findViewById<ImageView>(R.id.star3)
        val star4 = findViewById<ImageView>(R.id.star4)

        animateStar(star1, 10000)
        Handler(Looper.getMainLooper()).postDelayed({
            animateStar(star2, 10000)
        }, 1000)

        Handler(Looper.getMainLooper()).postDelayed({
            animateStar(star3, 10000) // Tam dolacak
        }, 2000)

        Handler(Looper.getMainLooper()).postDelayed({
            animateStar(star4, 5000) // Yarıda kalacak (max = 5000)
        }, 3000)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 5000)
    }

    private fun animateStar(imageView: ImageView, maxLevel: Int) {
        val drawable = imageView.drawable as ClipDrawable
        val animator = ObjectAnimator.ofInt(drawable, "level", 0, maxLevel)
        animator.duration = 1500
        animator.start()
    }
}
