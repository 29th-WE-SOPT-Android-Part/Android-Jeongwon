package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.androidassignment.databinding.ActivitySignUpBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)

        binding.btnJoinFinish.setOnClickListener {
            initNetwork()
        }

        setContentView(binding.root)
    }

    private fun initNetwork() {
        val requestSignUpData = RequestSignUpData(
            id = binding.etId.text.toString(),
            name = binding.etName.text.toString(),
            password = binding.etPw.text.toString()
        )

        val call: Call<ResponseSignUpData> = ServiceCreator.SignUpService.postJoin(requestSignUpData)

        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    Toast.makeText(this@SignUpActivity, "${data?.email}님 회원가입 완료", Toast.LENGTH_LONG).show()
                    finish()
                } else
                    Toast.makeText(this@SignUpActivity, "회원가입 실패", Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.e("NetworkTest", "error")
            }
        })
    }

}