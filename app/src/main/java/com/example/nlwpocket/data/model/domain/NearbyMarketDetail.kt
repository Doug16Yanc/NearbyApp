package com.example.nlwpocket.data.model.domain

import kotlinx.serialization.Serializable

@Serializable
data class NearbyMarketDetail(
    val id : String,
    val categoryId : String,
    val name : String,
    val description : String,
    val coupons : Int,
    val rules : List<NearbyRule>,
    val latitude : Double,
    val longitude : Double,
    val address : String,
    val phone : String,
    val cover : String
)