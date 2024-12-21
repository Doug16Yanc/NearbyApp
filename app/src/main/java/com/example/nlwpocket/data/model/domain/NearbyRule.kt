package com.example.nlwpocket.data.model.domain

import kotlinx.serialization.Serializable

@Serializable
data class NearbyRule(
    val id : String,
    val description : String,
    val marketId : String
)
