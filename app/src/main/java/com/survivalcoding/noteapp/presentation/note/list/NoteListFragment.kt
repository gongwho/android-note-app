package com.survivalcoding.noteapp.presentation.note.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.survivalcoding.noteapp.databinding.FragmentNoteListBinding

class NoteListFragment : Fragment() {
  private var _binding: FragmentNoteListBinding? = null
  private val binding get() = _binding!!

  private val viewModel by activityViewModels<NoteListViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentNoteListBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.addNoteButton.setOnClickListener {
      // TODO: 2022/01/13 nav to edit fragment
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
