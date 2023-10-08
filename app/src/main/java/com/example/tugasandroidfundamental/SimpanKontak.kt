package com.example.tugasandroidfundamental

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SimpanKontak : AppCompatActivity(), View.OnClickListener {

    private lateinit var img:ImageView
    private lateinit var tv:TextView
    private lateinit var vname:TextView
    private lateinit var vtelp:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpan_kontak)
        img = findViewById(R.id.imageView)
        tv = findViewById(R.id.success)
        vname = findViewById(R.id.tv_names)
        vtelp = findViewById(R.id.tv_telp)

        val nama = intent.getParcelableExtra<Kontak>("Kontak")?.nama
        val notelp = intent.getParcelableExtra<Kontak>("Kontak")?.notelp
        vname.text = "Nama: $nama"
        vtelp.text = "No. Telepon: $notelp"

        val btnBack: Button = findViewById(R.id.btn_kembali)
        btnBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_kembali -> {
                val intent = Intent()
                intent.putExtra("informasi","Anda sudah menyimpan 1 kontak")
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
}