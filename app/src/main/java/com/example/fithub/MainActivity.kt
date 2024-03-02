package com.example.fithub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fithub.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var  bottomnaviView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        bottomnaviView = findViewById(R.id.bottomNaviView)


        bottomnaviView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.gym -> {replaceFragment(gymFragment())
                             true }
                R.id.yoga -> {replaceFragment(yogaFragment())
                             true}
                R.id.chat -> {replaceFragment(chatBotFragment())
                true}
                R.id.user -> {replaceFragment(userFragment())
                true}
                else -> {
                    false
                }

            }
        }
        replaceFragment(gymFragment())

    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager  =supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}