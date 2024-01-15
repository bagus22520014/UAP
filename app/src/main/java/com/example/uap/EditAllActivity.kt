package com.example.uap

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uap.databinding.ActivityEditAllBinding
import com.example.uap.databinding.ActivityEditProfilBinding

class EditAllActivity : AppCompatActivity() {
    private lateinit var editBinding : ActivityEditAllBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editBinding = ActivityEditAllBinding.inflate(layoutInflater)
        setContentView(editBinding.root)
        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        val genderUser = intentData?.getString("gender")
        val emailUser = intentData?.getString("email")
        val telpUser = intentData?.getString("telp")
        val alamatUser = intentData?.getString("alamat")
        editBinding.edtProfilName.setText(namaUser)
        editBinding.btnEditSave.setOnClickListener { saveData() }
    }
    private fun saveData() {
         val namaEdit = editBinding.edtProfilName.text.toString()
        if (!namaEdit.isEmpty()) {
            val result = Intent()
            result.putExtra("nama", namaEdit)
            setResult(Activity.RESULT_OK, result)
        }else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}