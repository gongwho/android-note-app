package com.survivalcoding.noteapp.data.di

import com.survivalcoding.noteapp.data.datasource.NoteMockDataSource
import com.survivalcoding.noteapp.data.repository.NoteRepositoryImpl
import com.survivalcoding.noteapp.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NoteRepositoryModule {

  @Singleton
  @Provides
  fun provideRepository(): NoteRepository = NoteRepositoryImpl(NoteMockDataSource())
}
