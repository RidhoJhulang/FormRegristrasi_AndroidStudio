package id.jhulang.formpendaftaran

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            validation()
        }
        setDataSpinnerGender()
    }

    fun setDataSpinnerGender(){
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.gender_list, android.R.layout.select_dialog_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerGender.adapter = adapter

    }

    fun validation() {
        val namaInput = edtName.text.toString()
        val emailInput = edtEmail.text.toString()
        val telpInput = edtTlp.text.toString()
        val alamatInput = edtAddress.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()

        when {
            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            emailInput.isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTlp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"
            emailInput.isValidEmail().equals(false) -> edtEmail.error = "Email tidak valid"
            genderInput.equals("Choose Gender") -> tampilToast("Gender can't be empety")
            else -> {
                navigasiKeProfilDiri()
            }
        }
    }

    fun tampilToast(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
    }

    fun String.isValidEmail(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(this).matches()
    }

    fun navigasiKeProfilDiri() {
        val namaInput = edtName.text.toString()
        val emailInput = edtEmail.text.toString()
        val telpInput = edtTlp.text.toString()
        val alamatInput = edtAddress.text.toString()
        val genderInput = spinnerGender.selectedItem.toString()
        val intent = Intent(this,SecondActivity::class.java)

        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("email", emailInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)
        bundle.putString("gender", genderInput)

        intent.putExtras(bundle)

        startActivity(intent)

    }



}


