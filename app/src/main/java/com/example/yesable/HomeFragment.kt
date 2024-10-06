package com.example.yesable

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 프래그먼트의 XML을 inflate하여 반환
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // 뷰를 inflate 한 후에 findViewById를 호출
        val searchBtn = view.findViewById<ImageView>(R.id.search)

        // 클릭 리스너 설정
        searchBtn.setOnClickListener {
            // 클릭 시 SearchResultActivity로 이동
            val intent = Intent(activity, SearchActivity::class.java)
            startActivity(intent)
        }

        return view
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
