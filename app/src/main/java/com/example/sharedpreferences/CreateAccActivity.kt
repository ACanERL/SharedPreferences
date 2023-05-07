package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityCreateAccBinding

class CreateAccActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateAccBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCreateAccBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("userPref", MODE_PRIVATE)
        val editor =sharedPref.edit()

        binding.apply {
            create.setOnClickListener {
                val userName = username.text.toString()
                val password = password.text.toString()

                editor.apply {
                    putString("user_name",userName)
                    putString("password",password)
                    apply()
                }
                Toast.makeText(this@CreateAccActivity,"Create Account !!",Toast.LENGTH_SHORT).show()
                val intent= Intent(this@CreateAccActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}