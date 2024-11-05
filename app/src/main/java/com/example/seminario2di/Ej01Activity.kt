package com.example.seminario2di

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ej01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.ej01)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var temporizador=findViewById<TextView>(R.id.cuenta_atras)
        var contador:Long=10

        var tiempo=object:CountDownTimer(contador*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                contador--

                temporizador.text=contador.toString()
            }
            override fun onFinish() {
                val intent= Intent(this@Ej01Activity,Ej01BoomActivity::class.java)
                startActivity(intent)
            }
        }
        tiempo.start()
    }
}