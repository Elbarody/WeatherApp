package com.elbarody.weatherapp.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {/*@Binds
    abstract fun bindTwitterDataSource(twitterRepository: PostTweetDataSource): IPostTweetDataSource*/
}