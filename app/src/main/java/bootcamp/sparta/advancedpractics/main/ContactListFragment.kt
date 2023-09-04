package bootcamp.sparta.advancedpractics.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bootcamp.sparta.advancedpractics.R
import bootcamp.sparta.advancedpractics.databinding.ContactListFragmentBinding

// TODO: Rename parameter arguments, choose names that match
class ContactListFragment : Fragment() {
    private var _binding : ContactListFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ContactListFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}