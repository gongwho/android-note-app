package com.survivalcoding.noteapp.presentation.note.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.survivalcoding.noteapp.domain.model.NoteItem
import com.survivalcoding.noteapp.domain.usecase.UpsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteEditViewModel @Inject constructor(private val upsertNoteUseCase: UpsertNoteUseCase) : ViewModel() {
  suspend fun upsertNote(noteItem: NoteItem) = viewModelScope.launch { upsertNoteUseCase(noteItem) }
}
