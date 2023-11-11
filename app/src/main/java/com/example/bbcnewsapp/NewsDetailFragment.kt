package com.example.bbcnewsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class NewsDetailFragment : Fragment() {

    private val newsViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         return  inflater.inflate(R.layout.fragment_news_detail,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = view.findViewById<TextView>(R.id.tvTitle)
        val description = view.findViewById<TextView>(R.id.tvDescription)
        val content = view.findViewById<TextView>(R.id.tvContent)
        val cover = view.findViewById<ImageView>(R.id.imgBigCover)

        newsViewModel.article.observe(viewLifecycleOwner){
            title.text = it.title
            description.text = it.description
            content.text = it.content
            Glide.with(requireContext()).load(it.urlToImage).into(cover)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}