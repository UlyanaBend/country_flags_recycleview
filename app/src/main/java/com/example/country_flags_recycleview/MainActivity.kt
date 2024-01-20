package com.example.country_flags_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.country_flags_recycleview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val adapter = CountryAdapter()
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        val countryList = listOf(
            Country(getString(R.string.link_flag_Austria), "Austria"),
            Country(getString(R.string.link_flag_Poland), "Poland"),
            Country(getString(R.string.link_flag_Italy), "Italy"),
            Country(getString(R.string.link_flag_Columbia), "Columbia"),
            Country(getString(R.string.link_flag_Madagascar), "Madagascar"),
            Country(getString(R.string.link_flag_Thailand), "Thailand"),
            Country(getString(R.string.link_flag_Denmark), "Denmark"),
            Country(getString(R.string.link_flag_Switzerland), "Switzerland"),
        )

        binding.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            adapter.submitList(countryList)
        }
    }
}