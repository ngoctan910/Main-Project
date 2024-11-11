package ngoctan.traininng.multiproject.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkBuilder {
    companion object {
        private var instance: NetworkBuilder? = null

        fun getInstance(): NetworkBuilder {
            if (instance == null)
                instance = NetworkBuilder()

            return instance!!
        }
    }

    fun getApiService(): ApiService {
        val okHttpClient = OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.openweathermap.org")
            .build()

        return retrofit.create(ApiService::class.java)
    }
}