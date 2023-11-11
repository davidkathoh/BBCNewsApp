package com.example.bbcnewsapp

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bbcnewsapp.model.Articles
import com.example.bbcnewsapp.model.RetrofitInstance
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val _article = MutableLiveData<Articles>()
    val article: LiveData<Articles> = _article

    private val _articles = MutableLiveData<List<Articles>>()
    val articles:LiveData<List<Articles>> = _articles

    private val _error = MutableLiveData<Boolean>()
    val error:LiveData<Boolean> = _error


    init {
       getNews()
    }

    fun getNews() {
        viewModelScope.launch {
            try {
                val result  =  RetrofitInstance.apiService.getNews(source =getApplication<Application>().getString(R.string.sourceId) )
                _articles.value = result.articles.sortedByDescending { it.publishedAt }
            }catch (e:Exception){
                _error.value = true
            }

        }
    }

    fun setArticle(articles: Articles){
        _article.value = articles


    }


}