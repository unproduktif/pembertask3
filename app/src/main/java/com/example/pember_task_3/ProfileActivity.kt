package com.example.pember_task_3

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvNama = findViewById<TextView>(R.id.tvNama)
        val tvNim = findViewById<TextView>(R.id.tvNim)
        val tvProdi = findViewById<TextView>(R.id.tvProdi)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvHobi = findViewById<TextView>(R.id.tvHobi)

        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra("DATA", Mahasiswa::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra("DATA")
        }

        if (data != null) {
            tvNama.text = data.nama
            tvNim.text = data.nim
            tvProdi.text = data.prodi
            tvGender.text = data.gender
            tvHobi.text = data.hobi
        }

        val btnSelesai = findViewById<Button>(R.id.btnSelesai)
        btnSelesai.setOnClickListener {
            finish()
        }
    }
}