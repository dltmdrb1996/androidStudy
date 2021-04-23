package com.example.hiltex

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    fun provideMemoDB(@ApplicationContext context: Context)=
        Room.databaseBuilder(context, MemoDatabase::class.java,"Memo.db").build()
}