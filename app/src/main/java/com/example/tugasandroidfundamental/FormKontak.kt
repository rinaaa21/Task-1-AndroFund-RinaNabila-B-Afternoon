package com.example.tugasandroidfundamental

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class FormKontak : AppCompatActivity(), View.OnClickListener {

    private lateinit var etNama:EditText
    private lateinit var etNoTelepon:EditText
    private lateinit var informasi:TextView

    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if(result.resultCode == Activity.RESULT_OK){
            val data:Intent? = result.data
            val returnString:String? = data?.getStringExtra("informasi")
            informasi.text = returnString
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_kontak)

        informasi = findViewById(R.id.information)
        etNama = findViewById(R.id.edt_name)
        etNoTelepon = findViewById(R.id.edt_tlp)

        val bundle = intent.extras
        if (bundle != null){
            etNama.setText(bundle.getString("nama"))
            etNoTelepon.setText(bundle.getString("notelp"))
        }

        val btnSave: Button = findViewById(R.id.btn_save)
        btnSave.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btn_save -> {
                val intent = Intent(this@FormKontak, SimpanKontak::class.java)
                intent.putExtra("Kontak",Kontak(etNama.text.toString(),etNoTelepon.text.toString()))
                resultLauncher.launch(intent)
            }
        }
    }
}