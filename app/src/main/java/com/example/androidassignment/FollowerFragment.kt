package com.example.androidassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidassignment.databinding.FragmentFollowerBinding


class FollowerFragment : Fragment() {
    private var _binding: FragmentFollowerBinding? = null
    private val binding get() = _binding!!

    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        followerAdapter = FollowerAdapter()

        binding.rvFollower.adapter = followerAdapter

        followerAdapter.followerList.addAll(
            listOf(
                FollowerData("최정원", "안드로이드"),
                FollowerData("문다빈", "안드로이드 파트장"),
                FollowerData("장혜령", "IOS 파트장"),
                FollowerData("김우영", "서버 파트장"),
                FollowerData("조승우", "SOPT 회장"),
                FollowerData("김해리", "SOPT 부회장")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }

}