package com.example.mvvmlivadatafirestore3_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {
    lateinit var mMainViewModel : MainViewModel
    private var mMainAdapter : MainAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        mMainViewModel.mMutableLiveData.observe(this, mObserver)
    }
    private var mObserver : Observer<ArrayList<MainModel>?> = Observer<ArrayList<MainModel>?> { mArrayList->
        mMainAdapter = MainAdapter(this@MainActivity, mArrayList)
        rec_main.setHasFixedSize(true)
        rec_main.layoutManager = LinearLayoutManager(this)
        rec_main.adapter = mMainAdapter



    }
}