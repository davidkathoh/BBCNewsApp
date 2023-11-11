package com.example.bbcnewsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bbcnewsapp.model.Articles

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class NewsListFragment : Fragment(),NewsAdapter.OnNewsClicklistener {



    private val newsViewModel: NewsViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return  inflater.inflate(R.layout.fragment_news_list, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val adapter = NewsAdapter(this)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycleView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())


        newsViewModel.articles.observe(viewLifecycleOwner){
            adapter.setdata(it)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun onClick(article: Articles) {
        newsViewModel.setArticle(article)
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }
}