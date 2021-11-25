package com.example.androidassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidassignment.databinding.FragmentRepositoryListBinding


class RepositoryListFragment : Fragment() {

    private var _binding: FragmentRepositoryListBinding? = null
    private val binding get() = _binding!!

    private lateinit var repositoryListAdapter: RepositoryListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRepositoryListBinding.inflate(layoutInflater,container,false)

        initAdapter()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
        repositoryListAdapter = RepositoryListAdapter()
        binding.rvRepository.adapter = repositoryListAdapter

        repositoryListAdapter.RepositoryList.addAll(
            listOf(
                RepositoryListData("안드로이드 과제 레포지토리", "안드로이드 파트 과제"),
                RepositoryListData("iOS 과제 레포지토리", "iOS 파트 과제"),
                RepositoryListData("서버 과제 레포지토리", "서버 파트 과제"),
                RepositoryListData("기획 과제 레포지토리", "기획 파트 과제"),
                RepositoryListData("웹 과제 레포지토리","웹 파트 과제")
            )
        )
        repositoryListAdapter.notifyDataSetChanged()
    }


}