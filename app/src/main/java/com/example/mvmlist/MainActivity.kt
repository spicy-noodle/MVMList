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
import android.widget.EditText
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

            //mDialogView라는 이름으로 AlertDialog를 만들어줌
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.popup_activtty, null)
            //mBuilder라는 이름으로 AlertDialog.의 Builder를 만들어줌
            val mBuilder = AlertDialog.Builder(this)
                //이건 뭐지
                .setView(mDialogView)
                .setTitle("데이터를 입력")
                //dismiss를위해 추가한 문장
                .create()
            //dialog를 보여준다?
            mBuilder.show()

            //확인 버튼 - okBtn 아이디로 찾아서 - okButton 이름으로 생성
            val okButton = mDialogView.findViewById<Button>(R.id.okBtn)
            //버튼 클릭 시 이벤트
            okButton.setOnClickListener {
                // 팝업의 값 -name과 content를 item으로 전달해야함
                // EditText타입의 editText1아이디를 찾아서 name으로 생성 *****mDialogView는 왜 필요하지??*****
                var name = mDialogView.findViewById<EditText>(R.id.editText1)
                var content = mDialogView.findViewById<EditText>(R.id.editText2)

                val mainData = MainData(R.mipmap.ic_launcher, "${name.text}", "${content.text}")
                //이건 뭐지
                arrayList!!.add(mainData)
                //dialog를 닫아준다.
                mBuilder.dismiss()

            }

            //취소 버튼 클릭 이벤트-
            val noButton = mDialogView.findViewById<Button>(R.id.cancelBtn)
            noButton.setOnClickListener {
                //TODO dismiss
                //dialog를 닫아준다.
                mBuilder.dismiss()
            }

            //add나 remove 같은 액션이 이루어진후 새로고침 하도록//
            mainAdapter!!.notifyDataSetChanged()
        }
    }



}