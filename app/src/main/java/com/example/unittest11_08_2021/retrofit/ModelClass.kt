package com.example.unittest11_08_2021.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ModelClass {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("realname")

    var realname: String? = null

    @SerializedName("team")

    var team: String? = null

    @SerializedName("firstappearance")

    var firstappearance: String? = null

    @SerializedName("createdby")

    var createdby: String? = null

    @SerializedName("publisher")

    var publisher: String? = null

    @SerializedName("imageurl")

    var imageurl: String? = null

    @SerializedName("bio")

    var bio: String? = null
}