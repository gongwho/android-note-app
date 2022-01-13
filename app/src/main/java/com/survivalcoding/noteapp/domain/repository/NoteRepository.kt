package com.survivalcoding.noteapp.domain.repository

import com.survivalcoding.noteapp.domain.model.NoteItem
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

  fun getNotes(): Flow<List<NoteItem>>

  suspend fun getNoteById(id: Int): NoteItem?

  suspend fun upsertNote(noteItem: NoteItem)

  suspend fun deleteNote(noteItem: NoteItem)
}
