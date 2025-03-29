package org.company.test.di

import org.company.test.presenter.video.VideoViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::VideoViewModel)
}