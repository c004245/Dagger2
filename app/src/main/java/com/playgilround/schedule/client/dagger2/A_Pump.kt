package com.playgilround.schedule.client.dagger2

import android.util.Log

class A_Pump constructor(private val heater: Heater) : Pump {

    override fun pump() {
        if (heater.isHot()) {
            Log.d(TAG, "A Pump ===> Pumping")
        }
    }

    companion object {
        val TAG = A_Pump::class.java.simpleName
    }
}