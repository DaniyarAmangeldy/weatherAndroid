package daniyaramangeldy.weatherandroid.Utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by daniyaramangeldy on 29.09.17.
 */


fun Long.getDateByDT(): String{
    val calendar = Calendar.getInstance()
    calendar.timeInMillis = TimeUnit.SECONDS.toMillis(this)
    val dateFormat = SimpleDateFormat("MMMM dd",Locale.US)
    return dateFormat.format(calendar.time)
}
