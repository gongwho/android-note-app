package com.survivalcoding.noteapp.data.repository

import com.survivalcoding.noteapp.data.datasource.NoteDataSource
import com.survivalcoding.noteapp.domain.model.NoteItem
import com.survivalcoding.noteapp.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteDataSource: NoteDataSource) : NoteRepository {

  override fun getNotes(): List<NoteItem> = noteDataSource.getNotes()

  override suspend fun getNoteById(id: Int): NoteItem? = noteDataSource.getNoteById(id)

  override suspend fun upsertNote(noteItem: NoteItem) = noteDataSource.upsertNote(noteItem)

  override suspend fun deleteNote(noteItem: NoteItem) = noteDataSource.deleteNote(noteItem)
}
