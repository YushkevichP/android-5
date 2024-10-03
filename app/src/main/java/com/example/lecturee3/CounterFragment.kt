package com.example.lecturee3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lecturee3.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private var _binding: FragmentCounterBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "ERROR"
        }

    private val textForMessage = "Bye-Bye"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentCounterBinding.inflate(inflater, container, false)
            .also {
                _binding = it
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            var counter = requireArguments().getInt(KEY_COUNTER, 0)
            textView.text = counter.toString()

            textView.setOnClickListener {
                textView.text = textForMessage
            }

            plusButton.setOnClickListener {
                ++counter
                textView.text = counter.toString()
            }

            minusButton.setOnClickListener {
                --counter
                textView.text = counter.toString()
            }

            resetButton.setOnClickListener {
                counter = 0
                textView.text = counter.toString()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    companion object {
        private const val KEY_COUNTER = "key_counter"

        fun getInstance(counter: Int): CounterFragment {
            return CounterFragment().apply {
                arguments = bundleOf(
                    KEY_COUNTER to counter
                )
            }
        }

    }
}