package com.example.lecturee3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lecturee3.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding
        get() = requireNotNull(_binding) {
            "Error with _binding"
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentListBinding.inflate(inflater, container, false)
            .also {
                _binding = it
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val listOfItems = List(30) {
                NoteItem(index = it, noteText = "item $it")
            }

            recyclerVieww.layoutManager = LinearLayoutManager(view.context)
            recyclerVieww.adapter = NotesAdapter(listOfItems) {
                // Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                pushFragment(it.index)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}