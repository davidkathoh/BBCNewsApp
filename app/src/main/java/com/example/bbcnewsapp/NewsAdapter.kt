package com.example.bbcnewsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class NewsAdapter(private val dataSet: Array<String>):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    lateinit var context:Context

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val headLine: TextView
        val cover:ImageView

        init {
            headLine = view.findViewById(R.id.tvHeadline);
            cover = view.findViewById(R.id.imgCover)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        context = parent.context
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        holder.headLine.text = dataSet[position]
        Glide.with(context).load("https://picsum.photos/200").into(holder.cover)
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }

}