package com.bornidea.re_circulapp.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.bornidea.re_circulapp.model.APIService
import com.bornidea.re_circulapp.model.request.LoginRequest
import com.bornidea.re_circulapp.model.request.RegisterRequest
import com.bornidea.re_circulapp.model.response.LoginResponse
import com.bornidea.re_circulapp.model.utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

class RegisterRepository {
    fun registerUser(registerRequest: RegisterRequest): LiveData<LoginResponse> {
        val refService = RetrofitInstance
            .getRetrofitInstance()
            .create(APIService::class.java)

        val responseLogin: LiveData<LoginResponse> = liveData {
            val response = refService.registerUser(registerRequest)
            val bodyResponse = response.body()
            emit(bodyResponse ?: LoginResponse(codigo = 404))
        }
        return responseLogin
    }
}