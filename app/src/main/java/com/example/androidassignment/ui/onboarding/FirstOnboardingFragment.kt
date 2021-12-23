package com.example.androidassignment.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.androidassignment.R
import com.example.androidassignment.databinding.FragmentFirstOnboardingBinding
import com.example.androidassignment.util.BaseFragment

class FirstOnboardingFragment : BaseFragment<FragmentFirstOnboardingBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFirstOnboardingBinding {
        return FragmentFirstOnboardingBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnNextEvent()
    }

    private fun btnNextEvent() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstOnboardingFragment_to_secondOnboardingFragment)
        }
    }

}


