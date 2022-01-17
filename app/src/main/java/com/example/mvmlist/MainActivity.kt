package com.example.mvmlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.mvmlist.MainData
import com.example.mvmlist.MainAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
            // dialog 생성함 추가버튼 클릭 -> 팝업으로 연결
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.popup_activtty, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("데이터를 입력")

            mBuilder.show()
            //확인 버튼 클릭 이벤트-
            val okButton = mDialogView.findViewById<Button>(R.id.okBtn)
            okButton.setOnClickListener {
                //Toast 메세지 -우와- 가 아니라 팝업의 값 -name.content를 item으로 전달해야함
                //Toast.makeText(this, "우와", Toast.LENGTH_SHORT).show()

            }

            //취소 버튼 클릭 이벤트-
            val noButton = mDialogView.findViewById<Button>(R.id.cancelBtn)
            noButton.setOnClickListener {

                //아무것도없는디요..
            }

            val mainData = MainData(R.mipmap.ic_launcher, "매일두유..", "매일유업")
            arrayList!!.add(mainData)
            //add나 remove 같은 액션이 이루어진후 새로고침 하도록//
            mainAdapter!!.notifyDataSetChanged()
        }
    }



}