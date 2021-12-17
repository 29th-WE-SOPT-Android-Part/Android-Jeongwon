package com.example.androidassignment.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidassignment.data.RequestSignInData
import com.example.androidassignment.data.ResponseSignInData
import com.example.androidassignment.data.SOPTSharedPreferences
import com.example.androidassignment.data.ServiceCreator
import com.example.androidassignment.databinding.ActivitySignInBinding
import com.example.androidassignment.ui.home.HomeActivity
import com.example.androidassignment.util.shortToast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {
            initNetwork()
        }

        initJoinBtn()
//        getSignIn()
        initBtnAutoLoginEvent()

        setContentView(binding.root)

    }

    private fun initNetwork() {
        val requestSignInData = RequestSignInData(
            id = binding.etId.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call: Call<ResponseSignInData> = ServiceCreator.SignInService.postLogin(requestSignInData)

        call.enqueue(object : Callback<ResponseSignInData> {
            override fun onResponse(
                call: Call<ResponseSignInData>,
                response: Response<ResponseSignInData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignInActivity, "${data?.email}님 반갑습니다!", Toast.LENGTH_LONG).show()
                    startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
                } else
                    Toast.makeText(this@SignInActivity, "로그인에 실패하셨습니다", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ResponseSignInData>, t: Throwable) {
                Log.e("NetworkTest", "error:$t")
            }
        })
    }



    private fun initJoinBtn() {
        binding.btnJoin.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

//    private fun getSignIn() {
//        SOPTSharedPreferences.setAutoLogin(this, true)
//        Toast.makeText(this@SignInActivity, "로그인 성공!", Toast.LENGTH_SHORT).show()
//        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
//        startActivity(intent)
//        finish()
//
//    }

    private fun initBtnAutoLoginEvent() {
        binding.btnAutoLogin.setOnClickListener {
            SOPTSharedPreferences.getAutoLogin(this)
            shortToast("자동로그인 되었습니다.")
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            finish()
        }
    }
}