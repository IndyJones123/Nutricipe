package com.capstone.nutricipe.data.remote.api

import com.capstone.nutricipe.data.remote.model.AddImage
import com.capstone.nutricipe.data.remote.model.GetUploaded
import com.capstone.nutricipe.data.remote.model.Login
import com.capstone.nutricipe.data.remote.model.Profile
import com.capstone.nutricipe.data.remote.model.Register
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST("register")
    fun register(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Register>

    @FormUrlEncoded
    @POST("login")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<Login>

    @GET("profile")
    fun getProfile(
        @Header("Authorization") token: String
    ): Call<Profile>

    @Multipart
    @POST("uploadImage")
    fun uploadImage(
        @Header("Authorization") token: String,
        @Part file: MultipartBody.Part,
        @Part("title") title: RequestBody,
        @Part("description") description: RequestBody
    ): Call<AddImage>

    @FormUrlEncoded
    @POST("getUploaded")
    fun getUploaded(
        @Header("Authorization") token: String,
        @Field("idHistory") idHistory: String
    ): Call<GetUploaded>

}