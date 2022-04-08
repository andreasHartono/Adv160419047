package com.ubaya.advuts160419047.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.ubaya.advuts160419047.model.Kost

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    val kostLiveData = MutableLiveData<ArrayList<Kost>>()
    //val kostLiveData2 = MutableLiveData<Kost>()
    val TAG = "detailtag"
    private var queue: RequestQueue? = null
    fun fetch(kostID:Int) {
//        kostLiveData.value = Kost("Kost Han Tipe A1","Tenggilis Mejoyo","K.Mandi Dalam, AC, Kasur, Kloset Duduk",
//                1000000, "https://static.mamikos.com/uploads/cache/data/style/2018-02-22/E5P3kgip-540x720.jpg")
//        kostLiveData2.value = Kost("Kost Rungkut Agung","Rungkut Mejoyo Selatan","K.Mandi Dalam, AC, Kasur, Wifi",
//                1500000, "https://static.mamikos.com/uploads/cache/data/style/2016-07-12/OG98YkEM-540x720.jpg")

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://192.168.1.3/music/kost.php?id=$kostID"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<ArrayList<Kost>>() {}.type
                val result = Gson().fromJson<ArrayList<Kost>>(it,sType)
                kostLiveData.value = result
                Log.d("showvoley",it)
            },
            {
                Log.d("showvoley",it.toString())
            }
        ).apply {
            tag = TAG
        }
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}