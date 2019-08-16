package com.example.architecture

import dagger.Component

@Component
interface AndroidPlaygroundComponent {

    @Component.Builder
    interface Builder {
        fun build(): AndroidPlaygroundComponent
    }

    fun inject(app: App)
}