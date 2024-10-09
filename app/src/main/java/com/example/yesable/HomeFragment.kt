package com.example.yesable

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.yesable.databinding.FragmentHomeBinding
import com.example.yesable.databinding.FragmentRecruitBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!! // 안전하게 접근하기 위한 getter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Fragment의 View Binding 설정
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // 뷰를 inflate 한 후에 findViewById를 호출
        val searchBtn = view?.findViewById<ImageView>(R.id.search)

        // 클릭 리스너 설정
        searchBtn?.setOnClickListener {
            // 클릭 시 SearchResultActivity로 이동
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adapter 설정
        val adapter = MainRecommendAdapter(MainRecommendList.recruitList)
        binding.recyclerViewMainRecommend.adapter = adapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // 메모리 누수를 방지하기 위해 뷰를 해제
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    // 매개변수 처리
                }
            }
    }
}
