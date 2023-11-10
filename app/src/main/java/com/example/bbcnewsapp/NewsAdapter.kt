package com.example.bbcnewsapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bbcnewsapp.model.Articles
import com.google.android.material.card.MaterialCardView


class NewsAdapter(private val listener:OnNewsClicklistener):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    lateinit var context:Context
    lateinit var clicklistener: OnNewsClicklistener
    private var dataSet: List<Articles> = listOf()

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val headLine: TextView
        val cover:ImageView
        val card:MaterialCardView

        init {
            headLine = view.findViewById(R.id.tvHeadline);
            cover = view.findViewById(R.id.imgCover)
            card = view.findViewById(R.id.cardNews)

        }
    }
    fun setdata(data: List<Articles>){
        dataSet = data
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.news_item, parent, false)
        context = parent.context
        clicklistener = listener
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        val article = dataSet[position]
        holder.headLine.text = article.title
        Glide.with(context).load(article.urlToImage).into(holder.cover)
        holder.card.setOnClickListener {
            clicklistener.onClick(position)
        }
    }

    override fun getItemCount(): Int {
        return  dataSet.size
    }

    interface OnNewsClicklistener{
        fun onClick(position: Int)
    }

}