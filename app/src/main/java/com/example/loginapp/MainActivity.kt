package com.example.loginapp
//SHA1: 13:DF:70:E8:23:93:7F:C6:7D:EF:44:41:36:F2:53:83:D6:E6:CD:70
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        auth= FirebaseAuth.getInstance()
        Login.setOnClickListener{
            if (checking()){
                val email=email.text.toString()
                val password=password.text.toString()
                auth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener(this){
                        task->
                        if(task.isSuccessful){
                            Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
                            val intent=Intent(this,home::class.java)
                            startActivity(intent)

                        }
                        else
                        {
                            Toast.makeText(this,"Wrong details",Toast.LENGTH_LONG).show()
                        }
                    }
            }
            else{
                Toast.makeText(this,"Enter Details",Toast.LENGTH_LONG).show()
            }

        }
    }
    private fun checking():Boolean
    {
     if(email.text.toString().isNotEmpty()
         && password.text.toString().isNotEmpty()){
         return true
     }else{
         return false
     }
    }
}


