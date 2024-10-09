package com.example.yesable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yesable.databinding.FragmentNotificationBinding

class NotificationFragment : Fragment() {

    private var _binding: FragmentNotificationBinding? = null
    private val binding get() = _binding!! // 안전하게 접근하기 위한 getter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Fragment의 View Binding 설정
        _binding = FragmentNotificationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adapter 설정
        val adapter = NotificationAdapter(NotificationList.notificationList)
        binding.recyclerViewNoti.adapter = adapter

//        // 구분선 추가
//        val itemDecoration = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
//        binding.recyclerViewNoti.addItemDecoration(itemDecoration)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 메모리 누수를 방지하기 위해 뷰를 해제
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putString("ARG_PARAM1", param1)
                    putString("ARG_PARAM2", param2)
                }
            }
    }
}
