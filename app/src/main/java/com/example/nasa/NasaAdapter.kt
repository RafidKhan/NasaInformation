package com.example.nasa

import android.content.Context
import com.example.nasa.model.NasaResponse
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class NasaAdapter(itemList: NasaResponse, context: Context) :
    RecyclerView.Adapter<NasaAdapter.ViewHolder>(){

    var itemList: NasaResponse? = null
    var context: Context? = null

    init {
        this.itemList = itemList
        this.context = context
    }
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
        val tvDate: TextView? = itemView?.findViewById(R.id.date)
        val tvCopyright: TextView? = itemView?.findViewById(R.id.copyright)
        val tvMediaType: TextView? = itemView?.findViewById(R.id.mediaType)
        val tvhdurl: TextView? = itemView?.findViewById(R.id.hdurl)
        val tvServiceVersion: TextView? = itemView?.findViewById(R.id.serviceVersion)
        val tvExplataion: TextView? = itemView?.findViewById(R.id.explanation)
        val tvTitle: TextView? = itemView?.findViewById(R.id.titleTV)
        val tvurl: TextView? = itemView?.findViewById(R.id.url)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaAdapter.ViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_nasa, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: NasaAdapter.ViewHolder, position: Int) {
        holder.tvDate?.setText(itemList?.date)
        holder.tvCopyright?.setText(itemList?.copyright)
        holder.tvMediaType?.setText(itemList?.mediaType)
        holder.tvhdurl?.setText(itemList?.hdurl)
        holder.tvServiceVersion?.setText(itemList?.serviceVersion)
        holder.tvExplataion?.setText(itemList?.explanation)
        holder.tvTitle?.setText(itemList?.title)
        holder.tvurl?.setText(itemList?.url)

    }

    override fun getItemCount(): Int {
        return itemList!!.toString().length
    }


}