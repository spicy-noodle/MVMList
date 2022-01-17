package com.example.mvmlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mvmlist.MainAdapter.CustomViewHolder
import java.util.*

//maindata의 아이템을 담을 arrylist를 만든다
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
        //itemview 클릭시 이벤트 구현
        //클릭시 보여준다
        holder.itemView.setOnClickListener { view ->
            //curname 변수를 - curname변수 = tv_name이며 문자형태로 가져온다(toString).
            val curName = holder.tv_name.text.toString()
            //Toast창을 텍스트로 띄운다.-내용은?, curname, Toast길이(시간은)짧게 . 보여준다.
            Toast.makeText(view.context, curName, Toast.LENGTH_SHORT).show()
        }
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