package com.playgilround.schedule.client.dagger2

import dagger.Component

@Component(modules = [CoffeeMakerModule::class])
interface CoffeeComponent {

    //provision method
    fun make(): CoffeeMaker

    //member-injection method
    fun inject(coffeeMaker: CoffeeMaker)

}