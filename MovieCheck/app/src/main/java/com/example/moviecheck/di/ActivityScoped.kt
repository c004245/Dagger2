package com.example.moviecheck.di

import javax.inject.Scope
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScoped
