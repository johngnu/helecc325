package com.mkiperszmid.storediscount.core.data.remote

import com.mkiperszmid.storediscount.core.data.remote.dto.ProductListDto
import retrofit2.http.GET

interface ProductApi {
    companion object {
        //const val BASE_URL = "https://gist.githubusercontent.com/palcalde/6c19259bd32dd6aafa327fa557859c2f/raw/ba51779474a150ee4367cda4f4ffacdcca479887/"
        //const val BASE_URL = "http://192.168.0.21:8084/ws/productos/"
        const val BASE_URL = "http://54.39.98.5:8084/ws/productos/"
    }

    @GET("list")
    suspend fun getProducts(): ProductListDto
}
