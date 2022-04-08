package com.ubaya.advuts160419047.model

import com.google.gson.annotations.SerializedName

data class Kost(
    var id: String?,
    @SerializedName("kost_name")
    var name:String?,
    var alamat:String?,
    var fasilitas:String?,
    var harga:Int?,
    @SerializedName("photo_url")
    var photoUrl:String?
)