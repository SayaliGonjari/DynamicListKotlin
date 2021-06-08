package com.project.recycleviewlistkotlin

import com.google.gson.annotations.SerializedName

class Model(
    var name: String,

    @SerializedName("email")
    var emailId: String,
    var phone: String,
    var address: Address
)

class Address(var street: String, var suite: String, var city: String, var zipcode: String)
