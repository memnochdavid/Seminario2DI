package com.example.seminario2di

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
//
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Ej03Activity : AppCompatActivity() {
    private lateinit var semaforo: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ej03)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        semaforo = findViewById(R.id.sem)

        lifecycleScope.launch {
                cambia_color(R.drawable.semverde, 2000,) // verde
                cambia_color(R.drawable.semrojo, 2000,)  // rojo
                cambia_color(R.drawable.semambar, 1000,) // ambar

        }

    }

    private suspend fun cambia_color(drawable: Int, temp: Long) {
        withContext(Dispatchers.Main) {
            semaforo.setImageResource(drawable)
        }
        delay(temp)
    }

}