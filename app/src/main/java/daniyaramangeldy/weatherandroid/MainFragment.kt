package daniyaramangeldy.weatherandroid


import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.google.gson.Gson
import daniyaramangeldy.weatherandroid.Utils.getDateByDT
import daniyaramangeldy.weatherandroid.models.WeatherResponse
import kotlinx.android.synthetic.main.fragment_main.*
import okhttp3.*
import java.io.IOException

class MainFragment : Fragment() {

    val URL = "http://api.openweathermap.org/data/2.5/forecast/daily"

    companion object {

        fun newInstance(): MainFragment {
            val fragment = MainFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?) =
            LayoutInflater.from(context)
            .inflate(R.layout.fragment_main,container,false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val client = OkHttpClient()
        val builder = Uri.Builder()
        builder
                .encodedPath(URL)
                .appendQueryParameter("q","Almaty")
                .appendQueryParameter("cnt","16")
                .appendQueryParameter("appid","70036e60bd96aef0b0c812f889829cde")
                .appendQueryParameter("units","metric")
        val request = Request.Builder()
                .url(builder.build().toString())
                .build()
        client.newCall(request).enqueue(object: Callback {
            override fun onFailure(call: Call?, e: IOException?) {

            }

            override fun onResponse(call: Call?, response: Response?) {
                val gson = Gson()
                val json = response?.body()?.string().toString()
                val response = gson.fromJson(json, WeatherResponse::class.java)
                setWeatherDataToView(response)
            }

        })


    }

    private fun setWeatherDataToView(weatherData: WeatherResponse){
        getActivity().runOnUiThread {
            cityName.text = weatherData.city.name
            val temp = weatherData.list.get(0).temp
            weatherTemp.text = "${temp.min.toInt()} - ${temp.max.toInt()}°C" // 15 - 17°C
            weatherDescription.text = weatherData.list.get(0).weather.get(0).main
            date.text = weatherData.list.get(0).dt.getDateByDT()
            weatherList.layoutManager = LinearLayoutManager(context)
            weatherList.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))
            weatherList.adapter = WeatherAdapter(weatherData.list, activity as Context)
        }
    }

}
