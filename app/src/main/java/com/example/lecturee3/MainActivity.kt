package com.example.lecturee3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
// лекция пять - ресайклеры, адаптер, вью холдер


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//            enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        addFragment(ListFragment())

    }

    fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}

fun Fragment.pushFragment(counter: Int) {
    (requireActivity() as MainActivity).addFragment(CounterFragment.getInstance(counter))
}