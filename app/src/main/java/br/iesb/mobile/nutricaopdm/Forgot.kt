package br.iesb.mobile.nutricaopdm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Forgot : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)


        //btSendEmail.setOnClickListern{
        //val email = et_Email_Forgot.text.toString()
        //val auth = FirebaseAuth.getInstance()

        //auth.sendPasswordResetEmail(email)
        //Toast.makeText(this, "Você recebera as instruções em seu e-mail", Toast.LENGTH_LONG).show()
        finish()

    }


    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}
