package com.example.lecturee3

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.lecturee3.databinding.FragmentFirstBinding
import com.example.lecturee3.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "OMG Oo"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSecondBinding.inflate(inflater, container, false)
            .also {
                this._binding = it
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var textResult = ""

        with(binding) {

            editText.addTextChangedListener {

                textResult = it?.toString() ?: ""
//           одно и то же     textResult = it?.toString().orEmpty()


            }
            button.setOnClickListener {
                parentFragmentManager.setFragmentResult(
                    "res", bundleOf("key" to textResult)
                )
                parentFragmentManager.popBackStack()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}