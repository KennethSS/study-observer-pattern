package com.solar.observerpattern

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_normal.*
import kotlinx.android.synthetic.main.fragment_normal.view.*
import java.util.Observable

class FirstFragment : Fragment(), Observer, java.util.Observer {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_normal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.fragment_subscribe.setOnClickListener {
            MainActivity.youtuber.registerObserver(this)
            MainActivity.javaUtilObserver.addObserver(this)
            Toast.makeText(view.context, "Subscribe!", Toast.LENGTH_SHORT).show()
        }
        view.fragment_unsubscribe.setOnClickListener {
            MainActivity.youtuber.unregisterObserver(this)
            MainActivity.javaUtilObserver.deleteObserver(this)
            Toast.makeText(view.context, "UnSubscribe!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun newVideo(imageRes: Int) {
        context?.let {
            Toast.makeText(it, "First Fragment New Video!", Toast.LENGTH_SHORT).show()
        }
        fragment_image.setImageResource(imageRes)
    }

    override fun update(p0: Observable?, p1: Any?) {
        Log.d("update", p1.toString())
        p1?.let {
            if (it is String) {
                fragment_text.text = it
            }
        }
    }
}