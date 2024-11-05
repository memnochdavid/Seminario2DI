package com.example.seminario2di

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//
import android.util.Log

class Ej03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej03)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var semaforo=findViewById<ImageView>(R.id.sem)
        var cont_verde_rojo:Long=2
        var cont_amarillo:Long=1
        var stop=false
        var cont=5

        while(!stop){
            if(verde(2,semaforo)){
                if(rojo(2,semaforo)){
                    if(ambar(1,semaforo)){
                        continue
                    }
                }
            }

            cont--
            if(cont==0){
                stop=true
            }


        }


    }


    fun rojo(tiempo:Long,semaforo:ImageView):Boolean{
        var temp=tiempo
        var devuelve=false
        object: CountDownTimer(temp*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                temp--
            }
            override fun onFinish() {
                semaforo.setImageResource(R.drawable.semrojo)
                devuelve=true
            }
        }.start()
        return devuelve
    }


    fun verde(tiempo:Long,semaforo:ImageView):Boolean{
        var temp=tiempo
        var devuelve=false
        var temp_verde=object: CountDownTimer(temp*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                temp--
            }
            override fun onFinish() {
                semaforo.setImageResource(R.drawable.semverde)
                devuelve=true
            }
        }
        temp_verde.start()
        return devuelve
    }

    fun ambar(tiempo:Long,semaforo:ImageView):Boolean{
        var temp=tiempo
        var devuelve=false
        var temp_ambar=object: CountDownTimer(temp*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                temp--
            }
            override fun onFinish() {
                semaforo.setImageResource(R.drawable.semambar)
                devuelve=true
            }
        }
        temp_ambar.start()
        return devuelve
    }



}