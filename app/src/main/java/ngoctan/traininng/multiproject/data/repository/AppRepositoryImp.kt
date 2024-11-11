package ngoctan.traininng.multiproject.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ngoctan.traininng.multiproject.data.model.Weather
import ngoctan.traininng.multiproject.data.network.NetworkBuilder
import ngoctan.traininng.multiproject.domain.repository.AppRepository


class AppRepositoryImp(): AppRepository {
    private val apiService = NetworkBuilder.getInstance().getApiService()

    override fun getCurrentWeather(cityName: String): Flow<Weather> = flow{
        val url = "https://api.openweathermap.org/data/2.5/weather?q=$cityName&appid=5b14bf48d1725eec39f8fc50ce94680c&units=metric"
        val response = apiService.getResponseWeather(url)

        if (response.isSuccessful) {
            response.body()?.let { weather ->
                emit(weather)
            }

        }

    }
}