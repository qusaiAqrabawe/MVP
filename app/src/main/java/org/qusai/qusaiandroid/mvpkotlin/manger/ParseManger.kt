package org.qusai.qusaiandroid.mvpkotlin.manger

import com.google.gson.Gson
import org.json.JSONObject
import org.qusai.qusaiandroid.mvpkotlin.model.BaseResponse
import org.qusai.qusaiandroid.mvpkotlin.model.NewsObj

class ParseManger{
    constructor(){

    }
    fun getBaseResponse(json:JSONObject): BaseResponse {
        var gson:Gson=Gson()

        var baseResponse: BaseResponse =gson.fromJson(json.toString(),
            BaseResponse::class.java)

        return baseResponse
    }
    fun getData(json:JSONObject): NewsObj {
        var gson:Gson=Gson()

        var baseResponse: NewsObj =gson.fromJson(json.toString(),
            NewsObj::class.java)

        return baseResponse
    }
}