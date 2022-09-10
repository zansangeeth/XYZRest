package com.zasa.xyzrest

import retrofit2.Call
import retrofit2.http.GET

/**
 **@Project -> XYZRest
 **@Author -> Sangeeth on 9/9/2022
 */
interface RestaurantApi {
    @GET("branches.json")
    fun getBranches() : Call<List<BranchResult>>
}