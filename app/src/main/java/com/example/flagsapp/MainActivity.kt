package com.example.flagsapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    val austriaFlag: ImageView by lazy { findViewById(R.id.austria) }
    val polandFlag: ImageView by lazy { findViewById(R.id.poland) }
    val italyFlag: ImageView by lazy { findViewById(R.id.italy) }
    val columbiaFlag: ImageView by lazy { findViewById(R.id.columbia) }
    val madagascarFlag: ImageView by lazy { findViewById(R.id.madagascar) }
    val thailandFlag: ImageView by lazy { findViewById(R.id.thailand) }
    val denmarkFlag: ImageView by lazy { findViewById(R.id.denmark) }
    val switzerlandFlag: ImageView by lazy { findViewById(R.id.switzerland) }

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showPicture(getUrl(R.string.austriaUrl), austriaFlag)
        showPicture(getUrl(R.string.polandUrl), polandFlag)
        showPicture(getUrl(R.string.italyUrl), italyFlag)
        showPicture(getUrl(R.string.columbiaUrl), columbiaFlag)
        showPicture(getUrl(R.string.madagascarUrl), madagascarFlag)
        showPicture(getUrl(R.string.thailandUrl), thailandFlag)
        showPicture(getUrl(R.string.denmarkUrl), denmarkFlag)
        showPicture(getUrl(R.string.switzerlandUrl), switzerlandFlag)
    }

    private fun getUrl(resource: Int): String {
        return applicationContext.getString(resource)
    }

    fun showPicture(url: String, imageView: ImageView) {

        Glide.with(this@MainActivity)
            .load(url)
            .into(imageView)
    }

}