package com.example.apiukol.model

data class Contents(
    val response: classResponse
) {
    data class classResponse(
        val player_count: Int,
        val result: Int
    )
}
