package org.qusai.qusaiandroid.mvpkotlin.ui.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.qusai.qusaiandroid.mvpkotlin.manger.ParseManger
import org.qusai.qusaiandroid.mvpkotlin.manger.RequestManger

open class BaseActivity : AppCompatActivity() {
   public    var context:Context?=null
    public  var parseManger: ParseManger?=null
    public  var requestManger: RequestManger?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context=this
        parseManger= ParseManger()
        requestManger= RequestManger()





    }
}