package com.solar.observerpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_normal.*
import java.util.Observable
import java.util.Observer

class MainActivity : FragmentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notify_observers.setOnClickListener {
            youtuber.notifyObserversNewVideo(R.drawable.youtube_screenshot)
            javaUtilObserver.notifyObservers("Java Util Observable!")
        }
    }

    companion object {
        val youtuber = Youtuber()
        val javaUtilObserver = YoutuberJavaUtil()
    }
}