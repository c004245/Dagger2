package com.playgilround.schedule.client.dagger2

import android.util.Log
import javax.inject.Inject

class CoffeeMaker @Inject constructor(private val heater: Heater, private val pump: Pump) {

    fun brew() {
        heater.on()
        pump.pump()
        Log.d(TAG, "Coffee...")
        heater.off()
    }


    companion object {
        val TAG = CoffeeMaker::class.java.simpleName
    }
}