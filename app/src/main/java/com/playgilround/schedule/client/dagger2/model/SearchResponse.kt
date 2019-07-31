package com.playgilround.schedule.client.dagger2.model

data class SearchResponse(
    val total_count: Int,
    val imcomplete_results: Boolean,
    val items: ArrayList<User>

)