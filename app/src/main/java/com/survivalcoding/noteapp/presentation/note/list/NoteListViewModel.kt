package com.survivalcoding.noteapp.presentation.note.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.noteapp.domain.model.NoteItem
import com.survivalcoding.noteapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NoteListViewModel(private val repository: NoteRepository) : ViewModel() {
  private val _notes = MutableStateFlow<List<NoteItem>>(listOf())
  val notes: StateFlow<List<NoteItem>> = _notes

  fun getNotes() = repository.getNotes()
  suspend fun deleteNote(noteItem: NoteItem) = repository.deleteNote(noteItem)
  suspend fun upsertNote(noteItem: NoteItem) = repository.upsertNote(noteItem)
}
