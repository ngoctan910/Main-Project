package ngoctan.traininng.multiproject.presentation.ui.fragment.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ngoctan.traininng.multiproject.R
import ngoctan.traininng.multiproject.data.model.Weather
import ngoctan.traininng.multiproject.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
    val viewModel = HomeViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnClick.setOnClickListener {
            viewModel.getWeatherByCityName(binding.edtCityName.text.toString())
        }

        viewModel.currentWeather.observe(viewLifecycleOwner) {
            Log.d("city", it.main.temp.toInt().toString())
        }
    }
}