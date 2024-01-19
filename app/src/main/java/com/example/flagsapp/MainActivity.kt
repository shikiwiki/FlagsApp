package com.example.flagsapp

import android.annotation.SuppressLint
import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    private val countries: ArrayList<Country> by lazy { arrayListOf() }
    private val flags: Array<Int> by lazy { getCountryFlagIds() }
    private lateinit var names: List<String>

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        val resources = applicationContext.resources
        setContentView(R.layout.activity_main)

        names = getCountryNames(resources)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        getCountries()
    }

    private fun getCountryFlagIds() = arrayOf(
        R.drawable.flag_of_austria_svg,
        R.drawable.flag_of_poland_svg,
        R.drawable.flag_of_italy_svg,
        R.drawable.flag_of_colombia_svg,
        R.drawable.flag_of_madagascar_svg,
        R.drawable.flag_of_thailand_svg,
        R.drawable.flag_of_denmark_svg,
        R.drawable.flag_of_switzerland__pantone__svg
    )

    private fun getCountryNames(resources: Resources): List<String> =
        resources.getStringArray(R.array.country_names).toList()

    private fun getCountries() {
        for (i in flags.indices) {
            val country = Country(names[i], flags[i])
            countries.add(country)
        }
        recyclerView.adapter = CountryAdapter(countries)
    }


}