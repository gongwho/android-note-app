package com.survivalcoding.noteapp.presentation.note.edit

import androidx.lifecycle.ViewModel
import com.survivalcoding.noteapp.domain.model.NoteItem
import com.survivalcoding.noteapp.domain.repository.NoteRepository

class NoteEditViewModel(private val repository: NoteRepository) : ViewModel() {
  suspend fun upsertNote(noteItem: NoteItem) = repository.upsertNote(noteItem)
}
