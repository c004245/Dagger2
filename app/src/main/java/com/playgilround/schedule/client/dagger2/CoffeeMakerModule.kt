package com.playgilround.schedule.client.dagger2

import dagger.Module
import dagger.Provides

@Module
class CoffeeMakerModule {

    @Provides
    fun providerHeater(): Heater {
        return A_Heater()
    }

    @Provides
    fun providePump(heater: Heater): Pump {
        return A_Pump(heater)
    }
}