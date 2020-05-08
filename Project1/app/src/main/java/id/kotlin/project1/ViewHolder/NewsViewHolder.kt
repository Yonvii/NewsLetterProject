package id.kotlin.project1.ViewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_news.view.*

class NewsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val title = itemView.title_list
    val body = itemView.body_list
    val date = itemView.date_list
    val btnUpdate = itemView.update
    val btnDelete = itemView.delete_btn
}