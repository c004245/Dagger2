package com.playgilround.schedule.client.dagger2

interface Heater {
    fun on()
    fun off()
    fun isHot(): Boolean
}