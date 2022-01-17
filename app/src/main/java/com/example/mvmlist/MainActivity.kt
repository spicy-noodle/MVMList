package com.example.mvmlist

import androidx.appcompat.app.AppCompatActivity
import com.example.mvmlist.MainData
import com.example.mvmlist.MainAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.mvmlist.R
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var arrayList: ArrayList<MainData>? = null
    private var mainAdapter: MainAdapter? = null
    private var recyclerView: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    override fun onCreate(savedinstanceState: Bundle?) {
        super.onCreate(savedinstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById<View>(R.id.rv) as RecyclerView
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = linearLayoutManager
        arrayList = ArrayList()
        mainAdapter = MainAdapter(arrayList)
        recyclerView!!.adapter = mainAdapter

        //추가 버튼가져오기//
        val btn_add = findViewById<View>(R.id.btn_add) as Button
        //리스트 추가 버튼 액션 구현//
        btn_add.setOnClickListener {
            val mainData = MainData(R.mipmap.ic_launcher, "매일두유..", "매일유업")
            arrayList!!.add(mainData)
            //add나 remove 같은 액션이 이루어진후 새로고침 하도록//
            mainAdapter!!.notifyDataSetChanged()
        }
    }
}