package com.survivalcoding.noteapp.data.datasource

import com.survivalcoding.noteapp.data.datasource.database.NoteDao
import com.survivalcoding.noteapp.domain.model.NoteItem

class NoteRoomDataSource(private val noteDao: NoteDao) : NoteDataSource {
  override fun getNotes(): List<NoteItem> = noteDao.getAll()

  override suspend fun getNoteById(id: Int): NoteItem? = noteDao.getById(id)

  override suspend fun upsertNote(noteItem: NoteItem) = noteDao.upsert(noteItem)

  override suspend fun deleteNote(noteItem: NoteItem) = noteDao.delete(noteItem)
}
