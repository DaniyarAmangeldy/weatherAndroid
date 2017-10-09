package daniyaramangeldy.weatherandroid

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import daniyaramangeldy.weatherandroid.Utils.getDateByDT
import daniyaramangeldy.weatherandroid.WeatherAdapter.WeatherArgs.EXTRA_DATETIME
import daniyaramangeldy.weatherandroid.WeatherAdapter.WeatherArgs.EXTRA_DESCRIPTION
import daniyaramangeldy.weatherandroid.WeatherAdapter.WeatherArgs.EXTRA_ICON
import daniyaramangeldy.weatherandroid.WeatherAdapter.WeatherArgs.EXTRA_MAXTEMP
import daniyaramangeldy.weatherandroid.WeatherAdapter.WeatherArgs.EXTRA_MINTEMP
import daniyaramangeldy.weatherandroid.models.WeatherData
import kotlinx.android.synthetic.main.item_weather.view.*

/**
 * Created by daniyaramangeldy on 02.10.17.
 */
class WeatherAdapter(val list: List<WeatherData>,val context: Context): RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    object WeatherArgs{

            const val EXTRA_DATETIME = "datetime"
            const val EXTRA_MINTEMP = "mintemp"
            const val EXTRA_MAXTEMP = "maxtemp"
            const val EXTRA_DESCRIPTION = "description"
            const val EXTRA_ICON = "icon"

    }


    override fun getItemCount() = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_weather,parent,false)
        return WeatherViewHolder(view,context)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder?, position: Int) {
        val data = list.get(position)
        holder?.bind(data)
    }

    inner class WeatherViewHolder(itemView: View?,context: Context) : RecyclerView.ViewHolder(itemView){


        init {
            itemView?.setOnClickListener {
                val intent = Intent(context,WeatherDetailActivity::class.java)
                with(intent) {
                    putExtra(EXTRA_DATETIME,list.get(adapterPosition).dt)
                    putExtra(EXTRA_MINTEMP,list.get(adapterPosition).temp.min)
                    putExtra(EXTRA_MAXTEMP,list.get(adapterPosition).temp.max)
                    putExtra(EXTRA_DESCRIPTION,list.get(adapterPosition).weather.get(0).main)
                    putExtra(EXTRA_ICON,list.get(adapterPosition).weather.get(0).icon)
                }
                context.startActivity(intent)

                context.startActivity(intent)
            }
        }

        fun bind(data: WeatherData){
            val temp = data.temp
            itemView.weatherDesc.text = data.weather.get(0).main
            itemView.weatherDate.text = data.dt.getDateByDT()
            itemView.weatherTemp.text = "${temp.min.toInt()} - ${temp.max.toInt()}°C"
        }
    }
}