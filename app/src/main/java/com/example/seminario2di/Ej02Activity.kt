package com.example.seminario2di

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ej02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ej02)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var carta01=findViewById<ImageView>(R.id.carta01)
        var carta02=findViewById<ImageView>(R.id.carta02)
        var carta03=findViewById<ImageView>(R.id.carta03)

        carta01.setOnClickListener{
            carta01.setImageResource(R.drawable.carta01)
            var contador:Long=3

            var tiempo=object: CountDownTimer(contador*1000,1000){
                override fun onTick(millisUntilFinished: Long) {
                    contador--
                }
                override fun onFinish() {
                    carta01.setImageResource(R.drawable.reverso)
                }
            }
            tiempo.start()

        }
        carta02.setOnClickListener{
            carta02.setImageResource(R.drawable.carta02)
            var contador:Long=3

            var tiempo=object: CountDownTimer(contador*1000,1000){
                override fun onTick(millisUntilFinished: Long) {
                    contador--
                }
                override fun onFinish() {
                    carta02.setImageResource(R.drawable.reverso)
                }
            }
            tiempo.start()
        }
        carta03.setOnClickListener{
            carta03.setImageResource(R.drawable.carta03)
            var contador:Long=3

            var tiempo=object: CountDownTimer(contador*1000,1000){
                override fun onTick(millisUntilFinished: Long) {
                    contador--
                }
                override fun onFinish() {
                    carta03.setImageResource(R.drawable.reverso)
                }
            }
            tiempo.start()
        }

    }
}