package com.zasa.xyzrest

/**
 **@Project -> XYZRest
 **@Author -> Sangeeth on 9/9/2022
 */
data class BranchResult(
    val description: String,
    val id: String,
    val image_url: String,
    val latitude: Double,
    val longitude: Double,
    val name: String
)
