package com.example.uap

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.uap.databinding.ActivityEditAllBinding

class EditAllActivity : AppCompatActivity() {
    private lateinit var editBinding: ActivityEditAllBinding

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

        editBinding.edtAllName.setText(namaUser)
        editBinding.spinnerAllGender.setSelection(getGenderIndex(genderUser))
        editBinding.edtAllEmail.setText(emailUser)
        editBinding.edtAllTelp.setText(telpUser)
        editBinding.edtAllAddress.setText(alamatUser)

        editBinding.btnEditSaveAll.setOnClickListener { saveData() }
    }

    private fun getGenderIndex(gender: String?): Int {
        val genderArray = resources.getStringArray(R.array.jenis_kelamin)
        return genderArray.indexOf(gender).coerceAtLeast(0)
    }

    private fun saveData() {
        val namaEdit = editBinding.edtAllName.text.toString()
        val genderEdit = editBinding.spinnerAllGender.selectedItem.toString()
        val emailEdit = editBinding.edtAllEmail.text.toString()
        val telpEdit = editBinding.edtAllTelp.text.toString()
        val alamatEdit = editBinding.edtAllAddress.text.toString()

        val result = Intent().apply {
            putExtra("nama", namaEdit)
            putExtra("gender", genderEdit)
            putExtra("email", emailEdit)
            putExtra("telp", telpEdit)
            putExtra("alamat", alamatEdit)
        }

        setResult(Activity.RESULT_OK, result)
        finish()
    }
}
