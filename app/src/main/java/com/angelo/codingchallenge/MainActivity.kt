package com.angelo.codingchallenge

/**
 * Create an android application displaying the list of countries with description. Your list should have
 * Vertical layout
 * A  TextView on each row for countries name and description
You can assume you have list of country object  as below:
Country  {name = “USA” , description =“country in North America”}
Country  {name = “Australia” , description =“country in Australia”}
Country  {name = “Egypt” , description =“An Ancient country”}
Country  {name = “India” , description =“A diverse country”}
Please use MVVM and latest android components . You can use Kotlin/Java  as a language.

Note: You can use internet  for syntax  and  dependencies .Please don’t  paste code snippet directly from  internet.
 */
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.angelo.codingchallenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelFactory().create(MainActivityViewModel::class.java)

        initList()

        viewModel.getCountries().observe(this, Observer {
            adapter.updateCountryList(it)
            adapter.notifyDataSetChanged()
        })

    }

    fun initList() {
        adapter = CountryAdapter()

        binding.countryList.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}