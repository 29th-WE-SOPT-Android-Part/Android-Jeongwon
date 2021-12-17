package com.example.androidassignment.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidassignment.data.FollowerListData
import com.example.androidassignment.databinding.FragmentFollowerListBinding
import com.example.androidassignment.ui.profile.adapter.FollowerListAdapter


class FollowerListFragment : Fragment() {
    private var _binding: FragmentFollowerListBinding? = null
    private val binding get() = _binding!!

    private lateinit var followerListAdapter: FollowerListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerListBinding.inflate(layoutInflater, container, false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        followerListAdapter = FollowerListAdapter()

        binding.rvFollower.adapter = followerListAdapter

        followerListAdapter.followerList.addAll(
            listOf(
                FollowerListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVFjOGNPXNc3JVvoxPf6VIpate-aDkyt6kxQ&usqp=CAU","최정원", "안드로이드"),
                FollowerListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcg2Ax_SmIK80PqSEhlEkCyC-23qPZROio2A&usqp=CAU","문다빈", "안드로이드 파트장"),
                FollowerListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReMu293BUlrOdzfkROuFoP3RvM2RbCmFm7Tg&usqp=CAU","장혜령", "IOS 파트장"),
                FollowerListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ6_eX7RFK5Qd6nfhqjtHlQNwl0GgTN6S3Og&usqp=CAU","김우영", "서버 파트장"),
                FollowerListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT_nN0dcvrM4jttfdeFEbEkpqhqcrEfaROzg&usqp=CAU","조승우", "SOPT 회장"),
                FollowerListData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfOmlStOM6vfmdcDmvzpmQ1pKWqQ9YkX6ZJA&usqp=CAU","김해리", "SOPT 부회장")
            )
        )
        followerListAdapter.notifyDataSetChanged()
    }

}