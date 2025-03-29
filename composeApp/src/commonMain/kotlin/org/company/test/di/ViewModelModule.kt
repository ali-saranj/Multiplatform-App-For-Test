package org.company.test.di

import org.company.test.data.repository.VideoRepositoryImpl
import org.company.test.domein.repository.video.VideoRepository
import org.company.test.domein.usecase.GetVideoUseCase
import org.company.test.presenter.video.VideoViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::VideoViewModel)
}