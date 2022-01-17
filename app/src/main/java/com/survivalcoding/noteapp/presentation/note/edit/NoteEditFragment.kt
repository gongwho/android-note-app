package com.survivalcoding.noteapp.presentation.note.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.survivalcoding.noteapp.databinding.FragmentNoteEditBinding
import com.survivalcoding.noteapp.domain.model.NoteItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NoteEditFragment : Fragment() {
  private var _binding: FragmentNoteEditBinding? = null
  private val binding get() = _binding!!
  private val args: NoteEditFragmentArgs by navArgs()
  private val viewModel by viewModels<NoteEditViewModel>()

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    _binding = FragmentNoteEditBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    val note: NoteItem? = args.note

    binding.editTextTitle.setText(args.note?.title)
    binding.editTextContent.setText(args.note?.content)
    binding.saveNoteButton.setOnClickListener {
      lifecycleScope.launch {
        viewModel.upsertNote(
          note?.copy(
            title = binding.editTextTitle.text.toString(),
            content = binding.editTextContent.text.toString()
          ) ?: NoteItem(
            title = binding.editTextTitle.text.toString(),
            content = binding.editTextContent.text.toString(),
            color = 80 + 80 * 256 + 80 * 256 * 256
          )
        )
      }
      findNavController().popBackStack()
    }
  }

  override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
  }
}
