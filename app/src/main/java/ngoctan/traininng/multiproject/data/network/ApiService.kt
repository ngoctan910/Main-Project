package ngoctan.traininng.multiproject.data.network

import ngoctan.traininng.multiproject.data.model.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getResponseWeather(@Url url: String): Response<Weather>
}