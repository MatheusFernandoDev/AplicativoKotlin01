package com.example.ativ02.ui.bem_estar_do_aluno

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.ativ02.R

class BemEstarDoAlunoFragment : Fragment() {

    companion object {
        fun newInstance() = BemEstarDoAlunoFragment()
    }

    private val viewModel: BemEstarDoAlunoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_bem_estar_do_aluno, container, false)
    }
}