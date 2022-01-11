package com.survivalcoding.noteapp

import android.app.Application
import androidx.room.Room
import com.survivalcoding.noteapp.data.datasource.NoteDatabase

class App : Application() {
  val db = Room.databaseBuilder(
    applicationContext,
    NoteDatabase::class.java, "note-room-db"
  ).build()
}
