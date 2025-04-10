package com.example.ativ02.ui.contato

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContatoViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acessando Galeria"
    }
    val text: LiveData<String> = _text
}