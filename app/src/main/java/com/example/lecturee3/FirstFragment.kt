package com.example.lecturee3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lecturee3.databinding.FragmentFirstBinding
import com.example.lecturee3.databinding.FragmentListBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "OMG Oo"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFirstBinding.inflate(inflater, container, false)
            .also {
                this._binding = it
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(binding) {

            parentFragmentManager.setFragmentResultListener(
                "res", viewLifecycleOwner
            ) { _, bundle ->
                textResult.text = bundle.getString("key")
            }

            button.setOnClickListener {

                pushSecondFragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}