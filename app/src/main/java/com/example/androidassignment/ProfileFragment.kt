package com.example.androidassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.androidassignment.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding ?: error("Binding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        binding.btnFollower.isSelected = true

        initImage()
        initTransactionEvent()

        return binding.root
    }

    private fun initImage() {
        Glide.with(this)
            .load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVFjOGNPXNc3JVvoxPf6VIpate-aDkyt6kxQ&usqp=CAU")
            .circleCrop()
            .into(binding.ivPhoto)
    }

    private fun initTransactionEvent() {
        val followerFragment = FollowerListFragment()
        val repositoryFragment = RepositoryListFragment()

        getActivity()?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.containerList, followerFragment)?.commit()

        btnRepository(repositoryFragment)
        btnFollower(followerFragment)
    }

    private fun btnRepository(repositoryFragment: Fragment) {
        binding.btnRepository.setOnClickListener {
            binding.btnFollower.isSelected = false
            binding.btnRepository.isSelected = true
            val transaction = getActivity()?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerList, repositoryFragment)
            transaction?.commit()
        }
    }

    private fun btnFollower(followerFragment: Fragment) {
        binding.btnFollower.setOnClickListener {
            binding.btnFollower.isSelected = true
            binding.btnRepository.isSelected = false
            val transaction = getActivity()?.supportFragmentManager?.beginTransaction()
            transaction?.replace(R.id.containerList, followerFragment)
            transaction?.commit()
        }
    }


}