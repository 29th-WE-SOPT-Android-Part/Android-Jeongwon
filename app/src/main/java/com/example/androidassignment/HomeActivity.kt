package com.example.androidassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidassignment.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private var position = FOLLOWER_POSITION
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)

        initTransactionEvent()

        setContentView(binding.root)
    }

    private fun initTransactionEvent() {
        val followerfragment = FollowerFragment()
        val repositoryfragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_main, followerfragment).commit()

        binding.btnRepository.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                FOLLOWER_POSITION -> {
                    transaction.replace(R.id.container_main, repositoryfragment)
                    position = REPOSITORY_POSITION
                }
            }
            transaction.commit()
        }

        binding.btnFollower.setOnClickListener {
            val transaction = supportFragmentManager.beginTransaction()

            when (position) {
                REPOSITORY_POSITION -> {
                    transaction.replace(R.id.container_main, followerfragment)
                    position = FOLLOWER_POSITION
                }
            }
            transaction.commit()
        }

    }

    companion object {
        const val FOLLOWER_POSITION = 1
        const val REPOSITORY_POSITION = 2
    }
}