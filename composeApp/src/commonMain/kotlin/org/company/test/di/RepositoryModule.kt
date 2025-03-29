package org.company.test.di

import org.company.test.data.repository.VideoRepositoryImpl
import org.company.test.domein.repository.video.VideoRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<VideoRepository> { VideoRepositoryImpl(get()) }
}