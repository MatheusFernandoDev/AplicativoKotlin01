package com.example.ativ02.ui.analise_e_desenvolvimento_de_sistemas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Analise_e_desenvolvimento_de_sistemasViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acessando Matéria Análise e Desenvolvimento de Sistemas"
    }
    val text: LiveData<String> = _text
}