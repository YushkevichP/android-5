package com.example.lecturee3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

// лекция 6 -

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, FirstFragment())
                .commit()
        }
    }
}

fun Fragment.pushFragment(counter: Int) {
    (requireActivity() as MainActivity)
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, CounterFragment.getInstance(counter))
        .addToBackStack(null)
        .commit()
}

fun Fragment.pushSecondFragment() {
    (requireActivity() as MainActivity)
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, SecondFragment())
        .addToBackStack(null)
        .commit()
}

fun Fragment.pushSwitchFragment(isChecked:Boolean) {
    (requireActivity() as MainActivity)
        .supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, SwitchFragment().apply {
            arguments = bundleOf("second" to isChecked)
        })
        .addToBackStack(null)
        .commit()
}


//fun addFragment(fragment: Fragment) {
//    supportFragmentManager
//        .beginTransaction()
//        .replace(R.id.container, fragment)
//        .addToBackStack(null)
//        .commit()
//}

//fun Fragment.pushFragment(counter: Int) {
//    (requireActivity() as MainActivity).addFragment(CounterFragment.getInstance(counter))
//}