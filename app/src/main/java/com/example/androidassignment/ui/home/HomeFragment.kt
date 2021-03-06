package com.example.androidassignment.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.androidassignment.R
import com.example.androidassignment.TabFollowerFragment
import com.example.androidassignment.TabFollowingFragment
import com.example.androidassignment.ui.home.adapter.TabViewPagerAdapter
import com.example.androidassignment.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")
    private lateinit var tabViewPagerAdapter: TabViewPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        initImage()
        initAdapter()
        initTabLayout()

        return binding.root
    }

    private fun initImage() {
        Glide.with(this)
            .load(R.drawable.img_github)
            .circleCrop()
            .into(binding.ivGithub)
    }

    private fun initAdapter() {
        val fragmentList = listOf(TabFollowingFragment(), TabFollowerFragment())

        tabViewPagerAdapter = TabViewPagerAdapter(this)
        tabViewPagerAdapter.fragments.addAll(fragmentList)

        binding.vpFollow.adapter = tabViewPagerAdapter
    }

    private fun initTabLayout() {
        val tabLabel = listOf("팔로잉", "팔로워")

        TabLayoutMediator(binding.tlHome, binding.vpFollow) { tab, position ->
            tab.text = tabLabel[position]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}