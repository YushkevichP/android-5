package com.example.lecturee3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
                "SWITCH_KEY", viewLifecycleOwner
            ) { _, bundle ->
                textResult.text = bundle.getBoolean("key_switch").toString()
            }


// -----нриже код для примера с передачей чисел
//            parentFragmentManager.setFragmentResultListener(
//                "res", viewLifecycleOwner
//            ) { _, bundle ->
//                textResult.text = bundle.getString("key")
//            }

            button.setOnClickListener {

                val isChecked = textResult.text
                    .takeIf { it.isNotEmpty() }?.toString()?.toBoolean() ?: false
                //првоерка что какое-то значчение передается, аесли его нет, то изначально фолс. == равносильно if else
//                val isChecked = if (textResult.text.isEmpty()){
//                    false
//                } else {
//                    textResult.text.toString().toBoolean()
//                }


                //pushSecondFragment()
                pushSwitchFragment(isChecked)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}