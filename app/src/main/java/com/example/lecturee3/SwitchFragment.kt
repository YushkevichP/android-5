package com.example.lecturee3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.lecturee3.databinding.FragmentSwitchBinding

class SwitchFragment : Fragment() {
    private var _binding: FragmentSwitchBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "OMG Oo"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSwitchBinding.inflate(inflater, container, false)
            .also {
                this._binding = it
            }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        with(binding) {
            //сразу получаем зна чение включен он или нет и потом сетим в чекбокс
            var switchChecked = requireArguments().getBoolean("second")

            switchButton.isChecked = switchChecked

            switchButton.setOnCheckedChangeListener { _, isChecked ->
                switchChecked = isChecked
            }

            button.setOnClickListener {
                parentFragmentManager.setFragmentResult(
                    "SWITCH_KEY", bundleOf(
                        "key_switch" to switchChecked
                    )
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