package com.example.uap

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uap.databinding.ActivityEditProfilBinding

class EditProfilActivity : AppCompatActivity() {
    private lateinit var editBinding : ActivityEditProfilBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editBinding = ActivityEditProfilBinding.inflate(layoutInflater)
        setContentView(editBinding.root)
        val intentData = intent.extras
        val namaUser = intentData?.getString("nama")
        editBinding.edtProfilName.setText(namaUser)
        editBinding.btnEditSave.setOnClickListener { saveData() }
    }
    private fun saveData() {
        val namaEdit = editBinding.edtProfilName.text.toString()
        if (!namaEdit.isEmpty()) {
            val result = Intent()
            result.putExtra("nama", namaEdit)
            setResult(Activity.RESULT_OK, result)
        } else {
            setResult(Activity.RESULT_CANCELED)
        }
        finish()
    }
}