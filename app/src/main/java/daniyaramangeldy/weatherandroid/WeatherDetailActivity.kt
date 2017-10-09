package daniyaramangeldy.weatherandroid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import daniyaramangeldy.weatherandroid.Utils.getDateByDT
import daniyaramangeldy.weatherandroid.WeatherAdapter.WeatherArgs.EXTRA_DATETIME
import kotlinx.android.synthetic.main.activity_weather_detail.*

class WeatherDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_detail)
        intent = getIntent()
        if(intent.hasExtra(EXTRA_DATETIME)){
            exampleText.text =
                    intent.getLongExtra(EXTRA_DATETIME,-1L).getDateByDT()
        }
    }
}
