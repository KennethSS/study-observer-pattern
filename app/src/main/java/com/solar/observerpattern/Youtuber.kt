package com.solar.observerpattern

class Youtuber : Observable{
    private val observerList = arrayListOf<Observer>()

    override fun registerObserver(observer: Observer) {
        observerList.add(observer)
    }

    override fun unregisterObserver(observer: Observer) {
        observerList.remove(observer)
    }

    override fun notifyObserversNewVideo(imageRes: Int) {
        observerList.forEach{
            it.newVideo(imageRes)
        }
    }
}