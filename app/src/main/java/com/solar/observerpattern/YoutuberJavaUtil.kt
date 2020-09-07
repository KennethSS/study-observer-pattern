package com.solar.observerpattern

import java.util.Observable

class YoutuberJavaUtil : Observable() {
    override fun notifyObservers(arg: Any?) {
        setChanged()
        super.notifyObservers(arg)
    }
}