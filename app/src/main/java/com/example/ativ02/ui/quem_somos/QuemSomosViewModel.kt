package com.example.ativ02.ui.quem_somos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuemSomosViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Acessando Quem Somos"
    }
    val text: LiveData<String> = _text
}