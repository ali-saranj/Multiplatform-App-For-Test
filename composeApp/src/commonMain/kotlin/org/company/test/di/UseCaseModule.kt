package org.company.test.di

import org.company.test.domein.home.usecase.GetVideoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetVideoUseCase(get()) }
}