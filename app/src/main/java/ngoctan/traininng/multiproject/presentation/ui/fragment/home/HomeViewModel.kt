package ngoctan.traininng.multiproject.presentation.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ngoctan.traininng.multiproject.data.model.Weather
import ngoctan.traininng.multiproject.data.repository.AppRepositoryImp

class HomeViewModel {
    val appRepository = AppRepositoryImp()
    private var _currentWeather = MutableLiveData<Weather>()
    val currentWeather: LiveData<Weather> = _currentWeather

    fun getWeatherByCityName(city: String) {
        CoroutineScope(Dispatchers.IO).launch {
            appRepository.getCurrentWeather(city).collect { weather ->
                _currentWeather.postValue(weather)
            }
        }

    }

}