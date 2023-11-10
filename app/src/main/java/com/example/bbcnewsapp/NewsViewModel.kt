package com.example.bbcnewsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbcnewsapp.model.Articles
import com.example.bbcnewsapp.model.RetrofitInstance
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    private val _quantity = MutableLiveData<Array<String>>()
    val quantity: LiveData<Array<String>> = _quantity

    private val _articles = MutableLiveData<List<Articles>>()
    val articles:LiveData<List<Articles>> = _articles

    init {
        setQuantity(0)
    }

    fun setQuantity(numberCupcakes: Int) {
        _quantity.value =  arrayOf("January", "February", "March","January", "February", "March")

        viewModelScope.launch {
            Log.e("Executing","Execution")
            try {
                val result  =  RetrofitInstance.apiService.getNews()
                _articles.value = result.articles
                Log.e("Test",result.totalResults.toString())
            }catch (e:Exception){

            }

        }
    }

}