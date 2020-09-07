package com.solar.observerpattern

interface Observable {
    fun registerObserver(observer: Observer) // attach, subscribe
    fun unregisterObserver(observer: Observer) // detach, unsubscribe
    fun notifyObserversNewVideo(imageRes: Int)
}