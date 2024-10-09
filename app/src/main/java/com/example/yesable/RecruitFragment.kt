package com.example.yesable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.yesable.databinding.FragmentRecruitBinding

class RecruitFragment : Fragment() {

    private var _binding: FragmentRecruitBinding? = null
    private val binding get() = _binding!! // 안전하게 접근하기 위한 getter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Fragment의 View Binding 설정
        _binding = FragmentRecruitBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adapter 설정
        val adapter = RecruitAdapter(RecruitList.recruitList)
        binding.recyclerViewRecruit.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 메모리 누수를 방지하기 위해 뷰를 해제
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecruitFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                    putString("ARG_PARAM2", param2)
                }
            }
    }
}
