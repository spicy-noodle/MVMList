package com.example.mvmlist

import com.example.mvmlist.MainData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvmlist.MainAdapter.CustomViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.mvmlist.R
import android.widget.Toast
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import java.util.ArrayList

class MainAdapter(private val arrayList: ArrayList<MainData>?) :
    RecyclerView.Adapter<CustomViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.iv_profile.setImageResource(arrayList!![position].iv_profile)
        holder.tv_name.text = arrayList[position].tv_name
        holder.tv_content.text = arrayList[position].tv_content
        holder.itemView.tag = position
        holder.itemView.setOnClickListener { view ->
            val curName = holder.tv_name.text.toString()
            Toast.makeText(view.context, curName, Toast.LENGTH_SHORT).show()
        }
        holder.itemView.setOnLongClickListener { true }
    }

    override fun getItemCount(): Int {
        return arrayList?.size ?: 0
    }

    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var iv_profile: ImageView
        var tv_name: TextView
        var tv_content: TextView

        init {
            iv_profile = itemView.findViewById<View>(R.id.iv_profile) as ImageView
            tv_name = itemView.findViewById<View>(R.id.tv_name) as TextView
            tv_content = itemView.findViewById<View>(R.id.tv_content) as TextView
        }
    }
}