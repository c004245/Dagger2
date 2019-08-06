package com.example.repositoryuser.component

import com.example.repositoryuser.module.AppModule
import com.example.repositoryuser.module.GithubApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = {
        AppModule.class,
        GithubApiModule.class
    }
)

interface AppComponent {


}