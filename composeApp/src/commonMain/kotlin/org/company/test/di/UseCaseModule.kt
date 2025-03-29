package org.company.test.di

import org.company.test.data.repository.VideoRepositoryImpl
import org.company.test.domein.repository.video.VideoRepository
import org.company.test.domein.usecase.GetVideoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetVideoUseCase(get()) }
}