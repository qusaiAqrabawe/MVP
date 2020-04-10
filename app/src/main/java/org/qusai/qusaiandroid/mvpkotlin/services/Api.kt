package org.qusai.qusaiandroid.mvpkotlin.services

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface Api {
     @POST
     @FormUrlEncoded

     fun postRequest(@Url apiName:String,@FieldMap obj:HashMap<String,String>):Call<ResponseBody>
    @GET
    fun getRequest(@Url apiName:String):Call<ResponseBody>
}