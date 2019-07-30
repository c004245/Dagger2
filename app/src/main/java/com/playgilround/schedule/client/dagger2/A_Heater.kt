package com.playgilround.schedule.client.dagger2

import android.util.Log

class A_Heater : Heater {

    private var heating: Boolean = false

    override fun on() {
        Log.d(TAG,"A Heater : ~~~ heating ~~~")
        this.heating = true
    }

    override fun off() {
        this.heating = false
    }

    override fun isHot() : Boolean {
        return heating
    }

    companion object {
        val TAG = A_Heater::class.java.simpleName
    }
}