package com.survivalcoding.noteapp.presentation.note.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.survivalcoding.noteapp.domain.model.NoteItem
import com.survivalcoding.noteapp.domain.usecase.DeleteNoteUseCase
import com.survivalcoding.noteapp.domain.usecase.GetAllNotesUseCase
import com.survivalcoding.noteapp.domain.usecase.UpsertNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoteListViewModel @Inject constructor(
  private val getAllNotesUseCase: GetAllNotesUseCase,
  private val deleteNoteUseCase: DeleteNoteUseCase,
  private val upsertNoteUseCase: UpsertNoteUseCase
) : ViewModel() {

  fun getNotes() = getAllNotesUseCase().asLiveData()
  suspend fun deleteNote(noteItem: NoteItem) = deleteNoteUseCase(noteItem)
  suspend fun upsertNote(noteItem: NoteItem) = upsertNoteUseCase(noteItem)
}
