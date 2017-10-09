package daniyaramangeldy.weatherandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "ActivityActivityActivityActivityActivity"
        supportFragmentManager.beginTransaction()
                .add(R.id.container,MainFragment.newInstance())
                .commitNow()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putInt("KEY",1)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.action_settings){
//            startActivity(Intent(this@MainActivity,SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }





}
