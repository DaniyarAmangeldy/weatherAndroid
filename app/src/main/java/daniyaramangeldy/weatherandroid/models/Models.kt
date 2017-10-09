package daniyaramangeldy.weatherandroid.models

/**
 * Created by daniyaramangeldy on 27.09.17.
 */


data class WeatherResponse(val city: City,val list: List<WeatherData>)



data class City(val name: String)

data class WeatherData(val dt: Long,val temp: Temperature,val weather: List<Weather>)

data class Temperature(val day: Float,val min: Float,val max: Float)

data class Weather(val main: String, val icon: String)