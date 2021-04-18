package br.iesb.mobile.nutricaopdm.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.iesb.mobile.nutricaopdm.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_signup.*
import java.util.regex.Pattern

class Signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        bt_signup_confirm.setOnClickListener{
            confirm()
        }

        bt_signup_back.setOnClickListener{
            back()
        }
    }

    private fun confirm(){
        var email = et_signup_email.text.toString()

        var password = et_signup_password.text.toString()

        var confirmPassword = et_signup_confirmpassword.text.toString()

        if(password != confirmPassword){
            Toast.makeText(this, "Password and confirm password are not the same.", Toast.LENGTH_LONG).show()
            return
        }

        var auth = FirebaseAuth.getInstance()

        var authTaskCreateUser = auth.createUserWithEmailAndPassword(email, password)

        authTaskCreateUser.addOnCompleteListener{response ->
            if(response.isSuccessful){
                Toast.makeText(this, "User successfully created.", Toast.LENGTH_LONG).show()
                var newActivity = Intent(this, MainActivity::class.java)
                startActivity(newActivity)
                finish()
            }else{
                Toast.makeText(this, "Error creating the user.", Toast.LENGTH_LONG).show()
            }
        }

    }

    private fun back(){
        var newActivity = Intent(this, MainActivity::class.java)
        startActivity(newActivity)
        finish()
    }
}

fun isEmailValid(et_signup_email: String): Boolean{
    return Pattern.compile ("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
    "\\@" +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
            "(" +
            "\\." +
            "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
            ")+").matcher(et_signup_email).matches()
}
