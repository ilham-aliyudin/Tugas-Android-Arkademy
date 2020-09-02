package com.example.androidroomtraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidroomtraining.adapter.SubscriberAdapter
import com.example.androidroomtraining.databinding.ActivityMainBinding
import com.example.androidroomtraining.db.Subscriber
import com.example.androidroomtraining.db.SubscriberDatabase
import com.example.androidroomtraining.db.SubscriberRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel: SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val dao = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository= SubscriberRepository(dao)
        val factory = SubscriberViewModelFactory(repository)
        subscriberViewModel = ViewModelProvider(this, factory)[SubscriberViewModel::class.java]
        binding.myViewModel = subscriberViewModel
        binding.lifecycleOwner = this
        setRecyclerView()
    }

    private fun displaySubscriberList() {
        subscriberViewModel.subscriber.observe(this, Observer {
            binding.rvContainer.adapter = SubscriberAdapter(it)
        })
    }

    private fun setRecyclerView() {
        binding.rvContainer.layoutManager = LinearLayoutManager(this)
        displaySubscriberList()
    }
}