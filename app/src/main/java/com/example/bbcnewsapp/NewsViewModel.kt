package com.example.bbcnewsapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsViewModel: ViewModel() {
    private val _quantity = MutableLiveData<Array<String>>()
    val quantity: LiveData<Array<String>> = _quantity

    init {
        setQuantity(0)
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value =  arrayOf("January", "February", "March","January", "February", "March")
    }

}