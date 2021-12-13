package com.example.androidassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.androidassignment.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        setResultSignUp()
        initLoginBtn()
        initRegisterBtn()

        setContentView(binding.root)

    }

    private fun setResultSignUp(){
        getResultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result->
            if (result.resultCode == RESULT_OK) {
                val id = result.data?.getStringExtra("id") ?: ""
                val password = result.data?.getStringExtra("password") ?: ""
                binding.etId.setText(id)
                binding.etPw.setText(password)
            }
        }
    }


    private fun initLoginBtn() {
        binding.btnLogin.setOnClickListener {
            // 유저가 항목을 다 채우지 않았을 경우
            if(binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank()){
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
            // 유저가 항목을 다 채웠을 경우
            else {
                Toast.makeText(this, "${binding.etId.text}님 환영합니다!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initRegisterBtn() {
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            getResultText.launch(intent)
        }
    }

}