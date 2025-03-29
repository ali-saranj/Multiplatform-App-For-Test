package org.company.test.di

fun initKoin() {
    startKoin {
        modules(appModule)
    }
}
