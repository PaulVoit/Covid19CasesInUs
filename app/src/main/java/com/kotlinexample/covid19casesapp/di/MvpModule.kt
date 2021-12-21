package com.kotlinexample.covid19casesapp.di


import com.kotlinexample.covid19casesapp.mvp.contract.presenter.CovidCasesPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MvpModule {
    @Provides
    @Singleton
    fun provideCovidCasesPresenter(): CovidCasesPresenter = CovidCasesPresenter()
}