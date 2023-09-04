package bootcamp.sparta.advancedpractics.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import bootcamp.sparta.advancedpractics.R
import bootcamp.sparta.advancedpractics.databinding.MyPageFragmentBinding

class MyPageFragment : Fragment() {
    private var _binding : MyPageFragmentBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MyPageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MyPageFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}