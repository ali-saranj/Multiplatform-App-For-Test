package org.company.test.di

import org.company.test.core.network.ApiClient
import org.company.test.data.datasource.NetWorkDataSource
import org.company.test.data.datasource.NetWorkDataSourceImpl
import org.koin.dsl.module

val netWorkModule = module {
    single { ApiClient().client }
    single<NetWorkDataSource> { NetWorkDataSourceImpl(get()) }
}