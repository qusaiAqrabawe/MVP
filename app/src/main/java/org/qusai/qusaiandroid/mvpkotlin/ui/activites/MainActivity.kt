package org.qusai.qusaiandroid.mvpkotlin.ui.activites

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import org.qusai.qusaiandroid.mvpkotlin.R
import org.qusai.qusaiandroid.mvpkotlin.listener.ServerListener
import org.qusai.qusaiandroid.mvpkotlin.model.NewsObj
import org.qusai.qusaiandroid.mvpkotlin.ui.adapter.NewsAdapterClass
import org.qusai.qusaiandroid.mvpkotlin.ui.base.BaseActivity
import java.util.*

class MainActivity : BaseActivity() {
    var body=HashMap<String,String>()
    var layoutManger:LinearLayoutManager?=null
    var newsAdapterClass: NewsAdapterClass?=null
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        body.put("userName","qusai")
        body.put("password","123")
         layoutManger= LinearLayoutManager(context)
         layoutManger!!.orientation=LinearLayoutManager.VERTICAL
         dataRv.setHasFixedSize(true)
         dataRv.layoutManager=layoutManger
//        login()
         getData()
    }
    public fun getData(){
        requestManger!!.getApi("news.php", object :
            ServerListener {
            override fun onSucess(data: JSONObject) {
                 var newsObj: NewsObj =parseManger!!.getData(data)
                Log.d("sss",newsObj.message)
                newsAdapterClass=
                    NewsAdapterClass(
                        context,
                        newsObj.news
                    )
                dataRv.adapter=newsAdapterClass

            }

            override fun onFailed(message: String) {
                Toast.makeText(context,message,Toast
                    .LENGTH_LONG).show()
             }

            override fun onNoInterNetConnection(message: String) {
                Toast.makeText(context,message,Toast
                    .LENGTH_LONG).show()
             }

        })
    }
    public fun login(){
        requestManger!!.postRequest("login.php",body,object :
            ServerListener {
            override fun onSucess(data: JSONObject) {
                var base= parseManger!!.getBaseResponse(data)
                Log.d("sucess",""+base.toString())
            }

            override fun onFailed(message: String) {
                Log.d("failed",""+message)

            }

            override fun onNoInterNetConnection(message: String) {
            }

        });

    }
}
