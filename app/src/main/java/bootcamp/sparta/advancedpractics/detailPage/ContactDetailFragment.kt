package bootcamp.sparta.advancedpractics.detailPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bootcamp.sparta.advancedpractics.R
import bootcamp.sparta.advancedpractics.databinding.ContactDetailFragmentBinding

class ContactDetailFragment : Fragment() {
    private var _binding : ContactDetailFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = ContactDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ContactDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}