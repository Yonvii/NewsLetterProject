package id.kotlin.project1.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import id.kotlin.project1.Activity.CreateActivity
import id.kotlin.project1.R
import id.kotlin.project1.ViewHolder.NewsViewHolder
import id.kotlin.project1.entity.News
import id.kotlin.project1.helper.NewsletterDBHelper

class NewsAdapter(news: ArrayList<News>, context: Context): RecyclerView.Adapter<NewsViewHolder>() {
    val mContext = context
    val db = NewsletterDBHelper(mContext)
    val mNews = news
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.layout_news,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = mNews.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.title.setText(mNews.get(position).title)
        holder.body.setText(mNews.get(position).body)
        holder.date.setText(mNews.get(position).date)
        holder.btnUpdate.setOnClickListener {
            val intent = Intent(mContext, CreateActivity::class.java)
            intent.putExtra("id-extra", mNews.get(position).id)
            intent.putExtra("title-extra", mNews.get(position).title)
            intent.putExtra("body-extra", mNews.get(position).body)
            intent.putExtra("date-extra", mNews.get(position).date)
            mContext.startActivity(intent)
        }
        holder.btnDelete.setOnClickListener{
            db.deleteNews(mNews.get(position).id)
            (mContext as Activity).finish()
            mContext.startActivity(mContext.intent)
            Toast.makeText(mContext,"Sukses!",Toast.LENGTH_SHORT).show()
        }
    }
}
