package ngoctan.traininng.multiproject.domain.repository

import kotlinx.coroutines.flow.Flow
import ngoctan.traininng.multiproject.data.model.Weather

interface AppRepository {
    fun getCurrentWeather(cityName: String): Flow<Weather>
}