package com.example.androidassignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidassignment.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        initLoginBtn()

        initJoinBtn()

        setContentView(binding.root)

    }

    private fun initLoginBtn() {
        binding.btnLogin.setOnClickListener {
            // 유저가 항목을 다 채우지 않았을 경우
            if(binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank()){
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
            }
            // 유저가 항목을 다 채웠을 경우
            else {
                Toast.makeText(this, "환영합니다!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initJoinBtn() {
        binding.btnJoin.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}