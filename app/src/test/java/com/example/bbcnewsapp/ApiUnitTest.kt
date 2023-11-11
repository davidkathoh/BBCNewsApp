package com.example.bbcnewsapp

import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.example.bbcnewsapp.model.Api
import com.example.bbcnewsapp.model.Articles
import com.example.bbcnewsapp.model.News
import com.example.bbcnewsapp.model.RetrofitInstance
import com.example.bbcnewsapp.model.Source
import com.google.gson.Gson
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.fail
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import retrofit2.Retrofit
import java.net.HttpURLConnection
@RunWith(MockitoJUnitRunner::class)
class ApiUnitTest {


    private lateinit var testApi: Api
   


    @Before
    fun setUp() {
        testApi = RetrofitInstance.apiService


    }
    @Test
     fun testNewsRequest() = runTest {
        val actualResponse = testApi.getNews()
        assertEquals("ok", actualResponse.status)

    }


}