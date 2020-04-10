package org.qusai.qusaiandroid.mvpkotlin.presenters

import org.json.JSONObject
import org.qusai.qusaiandroid.mvpkotlin.listener.ServerListener
import org.qusai.qusaiandroid.mvpkotlin.listener.ShowResponse
import org.qusai.qusaiandroid.mvpkotlin.manger.ParseManger
import org.qusai.qusaiandroid.mvpkotlin.manger.RequestManger

class NewsPresenter {
    var manger:RequestManger?=null
    var parserManger:ParseManger?=null
    constructor(manger:RequestManger,parserManger:ParseManger){
        this.manger=manger
        this.parserManger=parserManger

    }

    public fun getData(showResponse: ShowResponse){
        manger!!.getApi("news.php", object :
            ServerListener {
            override fun onSucess(data: JSONObject) {
                showResponse.showData(data)
 //                newsAdapterClass=
//                    NewsAdapterClass(
//                        context,
//                        newsObj.news
//                    )
//                dataRv.adapter=newsAdapterClass

            }

            override fun onFailed(message: String) {
//                Toast.makeText(context,message, Toast
//                    .LENGTH_LONG).show()
            }

            override fun onNoInterNetConnection(message: String) {
//                Toast.makeText(context,message, Toast
//                    .LENGTH_LONG).show()
            }

        })
    }

}