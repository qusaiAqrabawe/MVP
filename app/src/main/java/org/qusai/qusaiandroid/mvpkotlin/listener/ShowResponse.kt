package org.qusai.qusaiandroid.mvpkotlin.listener

import org.json.JSONObject

interface ShowResponse {
    fun showData(obj:JSONObject)
    fun onDataError(message:String)
}