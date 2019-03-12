package id.jhulang.formpendaftaran

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        ambilData()
    }
    private fun ambilData() {

        val bundle = intent.extras

        val nama = bundle.getString("nama")
        val email = bundle.getString("email")
        val telp = bundle.getString("telp")
        val alamat = bundle.getString("alamat")
        val gender = bundle.getString("gender")

        txtName.text = nama
        txtEmail.text = email
        txtTlp.text = telp
        txtAddress.text = alamat
        txtGender.text = gender

    }
}
