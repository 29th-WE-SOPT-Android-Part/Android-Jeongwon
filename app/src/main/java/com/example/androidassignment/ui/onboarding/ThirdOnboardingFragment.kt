package com.example.androidassignment.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidassignment.R
import com.example.androidassignment.databinding.FragmentFirstOnboardingBinding
import com.example.androidassignment.databinding.FragmentThirdOnboardingBinding
import com.example.androidassignment.ui.signin.SignInActivity

class ThirdOnboardingFragment : Fragment() {
    private var _binding: FragmentThirdOnboardingBinding? = null
    private val binding get() = _binding ?: error("Bingding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThirdOnboardingBinding.inflate(layoutInflater, container, false)

        binding.btnStart.setOnClickListener {
            val intent = Intent(activity, SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}