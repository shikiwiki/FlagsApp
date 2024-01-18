package com.example.flagsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flagsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var countries: ArrayList<Country>
    private lateinit var flags: Array<Int>
    private lateinit var names: Array<String>

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        flags = arrayOf(
            R.drawable.flag_of_austria_svg,
            R.drawable.flag_of_poland_svg,
            R.drawable.flag_of_italy_svg,
            R.drawable.flag_of_colombia_svg,
            R.drawable.flag_of_madagascar_svg,
            R.drawable.flag_of_thailand_svg,
            R.drawable.flag_of_denmark_svg,
            R.drawable.flag_of_switzerland__pantone__svg
        )

        names = arrayOf(
            "Austria",
            "Poland",
            "Italy",
            "Columbia",
            "Madagascar",
            "Thailand",
            "Denmark",
            "Switzerland"
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        countries = arrayListOf<Country>()
        getCountries()
    }

    private fun getCountries() {
        for (i in flags.indices) {
            val country = Country(names[i], flags[i])
            countries.add(country)
        }
        recyclerView.adapter = CountryAdapter(countries)
    }
}