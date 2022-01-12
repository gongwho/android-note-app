package com.survivalcoding.noteapp.presentation.note.list

import androidx.lifecycle.ViewModel
import com.survivalcoding.noteapp.domain.model.NoteItem
import com.survivalcoding.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow

class NoteListViewModel(private val repository: NoteRepository) : ViewModel() {
  private val notes by lazy { MutableStateFlow(getNotes()) }

  fun getNotes() = repository.getNotes()
  suspend fun deleteNote(noteItem: NoteItem) = repository.deleteNote(noteItem)
  suspend fun upsertNote(noteItem: NoteItem) = repository.upsertNote(noteItem)
}
