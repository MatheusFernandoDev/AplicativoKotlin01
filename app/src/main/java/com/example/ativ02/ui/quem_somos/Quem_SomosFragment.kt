package com.example.ativ02.ui.quem_somos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.ativ02.databinding.FragmentQuemSomosBinding


class Quem_SomosFragment : Fragment() {

    private var _binding: FragmentQuemSomosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val quem_somosViewModel =
            ViewModelProvider(this).get(QuemSomosViewModel::class.java)

        _binding = FragmentQuemSomosBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textQuem
        quem_somosViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}