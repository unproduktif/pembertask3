package com.example.pember_task_3

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etNama = findViewById<EditText>(R.id.etNama)
        val etNim = findViewById<EditText>(R.id.etNim)
        val spProdi = findViewById<Spinner>(R.id.spProdi)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)

        val cbBadminton = findViewById<CheckBox>(R.id.cbBadminton)
        val cbBasket = findViewById<CheckBox>(R.id.cbBasket)
        val cbCoding = findViewById<CheckBox>(R.id.cbCoding)

        val btn = findViewById<Button>(R.id.btnSubmit)

        val prodiList = arrayOf("Pilih Program Studi...", "Informatika", "Sistem Informasi", "Teknik Komputer")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, prodiList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spProdi.adapter = adapter

        btn.setOnClickListener {
            val nama = etNama.text.toString().trim()
            val nim = etNim.text.toString().trim()
            val prodi = spProdi.selectedItem.toString()

            if (nama.isEmpty()) {
                etNama.error = "Nama wajib diisi!"
                etNama.requestFocus()
                return@setOnClickListener
            }
            if (nim.isEmpty()) {
                etNim.error = "NIM wajib diisi!"
                etNim.requestFocus()
                return@setOnClickListener
            }

            if (prodi == "Pilih Program Studi...") {
                Toast.makeText(this, "Silakan pilih Program Studi terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val gender = if (rgGender.checkedRadioButtonId != -1) {
                findViewById<RadioButton>(rgGender.checkedRadioButtonId).text.toString()
            } else {
                Toast.makeText(this, "Pilih jenis kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val hobiList = mutableListOf<String>()
            if (cbBadminton.isChecked) hobiList.add("Badminton")
            if (cbBasket.isChecked) hobiList.add("Basket")
            if (cbCoding.isChecked) hobiList.add("Coding")

            val hobi = if (hobiList.isEmpty()) {
                Toast.makeText(this, "Pilih minimal satu hobi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else {
                hobiList.joinToString(", ")
            }

            val data = Mahasiswa(nama, nim, prodi, gender, hobi)
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("DATA", data)
            startActivity(intent)
        }
    }
}