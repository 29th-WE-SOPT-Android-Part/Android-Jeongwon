package com.example.androidassignment

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidassignment.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        initDoneRegisterBtn()

        setContentView(binding.root)

    }

    fun initDoneRegisterBtn() {
        binding.btnDoneRegister.setOnClickListener {
            // 유저가 항목을 다 채우지 않았을 경우
            if (binding.etName.text.isNullOrBlank() || binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            // 유저가 항목을 다 채웠을 경우
            else {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                finish()
            }

        }
    }
}