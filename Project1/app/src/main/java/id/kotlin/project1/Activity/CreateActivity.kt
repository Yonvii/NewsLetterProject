package id.kotlin.project1.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import id.kotlin.project1.R
import id.kotlin.project1.entity.News
import id.kotlin.project1.helper.NewsletterDBHelper
import kotlinx.android.synthetic.main.create_news.*

class CreateActivity: AppCompatActivity() {
    private val db = NewsletterDBHelper(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_news)
        if (intent.getIntExtra("id-extra",0) == 0) {
            btn_insert.setOnClickListener {
                insert()
                Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateActivity, Home_Activity::class.java)
                startActivity(intent)
            }
        }else {
            title_create.setText(R.string.update_title)
            input_title.setText(intent.getStringExtra("title-extra"))
            input_body.setText(intent.getStringExtra("body-extra"))
            input_date.setText(intent.getStringExtra("date-extra"))
            btn_insert.setOnClickListener{
                update()
                Toast.makeText(this,"Succes Insert Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@CreateActivity, Home_Activity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun insert(){
        val news = News (input_title.text.toString(),
                   input_body.text.toString(),
                   input_date.text.toString())
        this.db.insertNews(news)
    }
    private fun update(){
        val news = News (input_title.text.toString(),
            input_body.text.toString(),
            input_date.text.toString())
        db.updateNews(news, intent.getIntExtra("id-extra",0))
    }
}