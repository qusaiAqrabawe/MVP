package org.qusai.qusaiandroid.mvpkotlin.manger

import android.util.Log
import okhttp3.ResponseBody
import org.json.JSONObject
import org.qusai.qusaiandroid.mvpkotlin.client.RetrofitClient
import org.qusai.qusaiandroid.mvpkotlin.listener.ServerListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RequestManger{

  constructor(){
Log.d("aa","aa")
  }
fun getApi( apiName:String,serverListener: ServerListener){
    RetrofitClient.instance.getRequest(apiName).enqueue(object : Callback<ResponseBody> {
        override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
        }

        override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
            if (response.isSuccessful){
                var resm:ResponseBody= response.body()!!
var obj:JSONObject= JSONObject(resm.string())
                serverListener.onSucess(obj)
            }

        }
    })
}
    fun postRequest(apiName:String,bodyMap:HashMap<String,String>,serverListener: ServerListener){
        RetrofitClient.instance.postRequest(apiName,bodyMap).enqueue(object :Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful){
                     //                     serverListener.onSucess()
try {
    var resm:ResponseBody= response.body()!!
    var obj: JSONObject = JSONObject(resm.string())
   serverListener.onSucess(obj)
//    serverListener.onFailed("qusai")

}catch (e:Exception){
serverListener.onFailed("qusai")
}
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                serverListener.onFailed("qusai")
            }


        })

    }

}