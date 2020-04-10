package org.qusai.qusaiandroid.mvpkotlin.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*
import org.qusai.qusaiandroid.mvpkotlin.model.NewsData
import org.qusai.qusaiandroid.mvpkotlin.R


class NewsAdapterClass : RecyclerView.Adapter<NewsAdapterClass.NewsHolder> {
    var context: Context?=null
var newsList:ArrayList<NewsData>?=null
    constructor(ctx: Context?, newsList:ArrayList<NewsData>){
        context=ctx
        this.newsList=newsList;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHolder {
        var view:View=LayoutInflater.from(context).inflate(R.layout.row,parent,false)
       var newsHolder: NewsHolder =
           NewsHolder(view)
        return newsHolder
     }

    override fun getItemCount(): Int= newsList!!.size



    override fun onBindViewHolder(holder: NewsHolder, position: Int) {
        holder.phone!!.setText(newsList!!.get(position).phone)
    }



    public class NewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var phone:TextView?=null
         init {
            itemView.setOnClickListener(this)

                  phone=itemView.phone
         }

         override fun onClick(p0: View?) {
             Log.d("Ex",position.toString())

        }

    }
}