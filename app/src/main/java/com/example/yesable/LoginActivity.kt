package com.example.yesable
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        val backbutton = findViewById<TextView>(R.id.back_button)
//        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
//        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val idEdit = findViewById<EditText>(R.id.idEdit)
        val pwEdit = findViewById<EditText>(R.id.pwEdit)
        val idCheck = findViewById<CheckBox>(R.id.idCheckBox)
        val idSave = findViewById<TextView>(R.id.idFind)
        val pwSave = findViewById<TextView>(R.id.pwFind)
        val signButton = findViewById<TextView>(R.id.signText)
        val loginButton = findViewById<Button>(R.id.g_login_button)

        backbutton.setOnClickListener {
            finish()
        }

        // 아이디 입력 필드
        // 텍스트가 변경될 때마다 동적으로 변경
        idEdit.addTextChangedListener(object : TextWatcher {
            // 텍스트 변경하기 직전 호출
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            // 텍스트 변경될 때 호출
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                idEdit.hint = if (s.isNullOrEmpty()) "아이디를 입력해주세요" else ""
            }

            // 텍스트 변경된 후 호출
            override fun afterTextChanged(s: Editable?) {
            }
        })

        // 비밀번호 입력 필드
        pwEdit.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                pwEdit.hint = if (s.isNullOrEmpty()) "비밀번호를 입력해주세요" else ""
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

//        // 아이디 저장 기능
//        // 아이디 저장 체크박스 상태 불러오기
//        val isChecked = sharedPreferences.getBoolean("CHECK_ID_SAVE", false) // 값이 저장되어 있으면 해당 값 반환, 없으면 false 반환
//        idCheck.isChecked = isChecked // 체크 상태 설정 (boolean 값 할당
//        if (isChecked) {
//            // 저장된 아이디 불러오기
//            val savedId = sharedPreferences.getString("SAVED_ID", "") // 값이 저장되어 있으면 해당 문자열 반환, 없으면 빈 문자열 반환
//            idEdit.setText(savedId) // 입력 필드에 불러온 아이디 값 설정
//        }
//
//        // 아이디 저장 체크박스 상태 변경하기
//        idCheck.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked) {
//                // 체크박스가 선택된 경우 아이디 저장
//                editor.putBoolean("CHECK_ID_SAVE", true)
//                editor.putString("SAVED_ID", idEdit.text.toString()) // 아이디 입력 텍스트 저장
//            } else {
//                // 체크박스 선택 해제된 경우 아이디 삭제
//                editor.putBoolean("CHECK_ID_SAVE", false)
//                editor.remove("SAVED_ID")
//            }
//            editor.apply() // 비동기적 데이터 저장
//        }


        // 아이디 찾기 화면 전환
        idSave.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        // 비밀번호 찾기 화면 전환
        pwSave.setOnClickListener {
            val intent = Intent(this, StartActivity::class.java)
            startActivity(intent)
        }

        // 회원가입 화면 전환
        signButton.setOnClickListener {
            val intent = Intent(this, IndividualMemberRegistrationActivity::class.java)
            startActivity(intent)
        }

        // 로그인 화면 전환
        loginButton.setOnClickListener {
            var intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
//            showAlert()
        }


//
//        val fragments = listOf(
//            Login_Activity()
//        )
//
//        val titles = listOf("일반회원", "기업회원")
//
//        viewPager.adapter = ViewPagerAdapter(this, fragments)
//
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = titles[position]
//        }.attach()

    }
}