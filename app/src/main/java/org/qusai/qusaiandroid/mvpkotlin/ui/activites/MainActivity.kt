package org.qusai.qusaiandroid.mvpkotlin.ui.activites

import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import org.qusai.qusaiandroid.mvpkotlin.R
import org.qusai.qusaiandroid.mvpkotlin.listener.ShowResponse
import org.qusai.qusaiandroid.mvpkotlin.model.NewsObj
import org.qusai.qusaiandroid.mvpkotlin.presenters.NewsPresenter
import org.qusai.qusaiandroid.mvpkotlin.ui.adapter.NewsAdapterClass
import org.qusai.qusaiandroid.mvpkotlin.ui.base.BaseActivity
import java.util.*

class MainActivity : BaseActivity() {
    var body=HashMap<String,String>()
    var layoutManger:LinearLayoutManager?=null
    var newsAdapterClass: NewsAdapterClass?=null
    var newsPresenter:NewsPresenter?=null
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        body.put("userName","qusai")
        body.put("password","123")
         layoutManger= LinearLayoutManager(context)
         layoutManger!!.orientation=LinearLayoutManager.VERTICAL
         dataRv.setHasFixedSize(true)
         dataRv.layoutManager=layoutManger

         getData()
    }
    fun getData(){

        newsPresenter= NewsPresenter(requestManger!!,parseManger!!)
        newsPresenter!!.getData(object:ShowResponse{
            override fun onDataError(message: String) {
            }

            override fun showData(obj: JSONObject) {
var newsObj: NewsObj= parseManger!!.getData(obj)
Log.d("ds","dd")
//
                 newsAdapterClass= NewsAdapterClass(context,newsObj.news)
                dataRv.adapter=newsAdapterClass

            }
        })
    }
 }
