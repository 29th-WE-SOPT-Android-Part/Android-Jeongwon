package com.example.androidassignment.ui.profile

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidassignment.data.SOPTSharedPreferences
import com.example.androidassignment.databinding.ActivitySettingBinding
import com.example.androidassignment.util.shortToast

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)

        initBtnOffAutoLoginEvent()

        setContentView(binding.root)
    }

    private fun initBtnOffAutoLoginEvent() {
        binding.btnOffAutoLogin.setOnClickListener {
            shortToast("자동 로그인 해제")
            SOPTSharedPreferences.removeAutoLogin(this)
        }
    }
}