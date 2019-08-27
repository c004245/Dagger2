package com.example.moviecheck

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class FragmentScoped {

}

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScoped {

}