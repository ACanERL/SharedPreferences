package com.example.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sharedPref = getSharedPreferences("userPref", MODE_PRIVATE)
        binding.apply {
                createAccBtn.setOnClickListener {
                    val intent= Intent(this@MainActivity,CreateAccActivity::class.java)
                    startActivity(intent)
                }
        }

      binding.loginBtn.setOnClickListener {
          val username=binding.userTxtName.text.toString()
          val pass=binding.userTxtPassword.text.toString()
          val userName = sharedPref.getString("user_name",null)
          val password = sharedPref.getString("password",null)

          if(userName==username && pass==password){
              val intent= Intent(this@MainActivity,HomeActivity::class.java)
              startActivity(intent)
              finish()
              Toast.makeText(this@MainActivity,"Login Success !!", Toast.LENGTH_SHORT).show()
          }
          else{
              Toast.makeText(this@MainActivity,"Account not matched !!", Toast.LENGTH_SHORT).show()
          }
      }
    }
}