#Android-Jeongwon

![github_최정원_ver1-30](https://user-images.githubusercontent.com/70698151/135754672-247d3366-22e1-4131-9cc4-69781c943a66.png)

# :star:week7:star:

## 실행화면

<p float="left">
<img src=https://user-images.githubusercontent.com/49150980/146558382-e4c71b40-3848-47e0-8640-9567d4bf6dde.gif width="30%" height="30%">
</p>


## :white_check_mark: Lvel 1 필수과제

### Level 1-1

- 온보딩 화면 만들기(NavigationComponent 활용)
- 맨 마지막 시작하기 버튼을 눌렀을 때는 로그인 화면으로 전환
- 로그인 화면으로 전환되고 나면 이전 NavigationComponent의 Host를 담당하는 Activity는 finish()로 종료

### 라이브러리 추가

```
// NavigationComponent
    implementation 'androidx.navigation:navigation-fragment-ktx:2.3.5'
    implementation 'androidx.navigation:navigation-ui-ktx:2.3.5'
```

### nav_onboarding.xml

- Navigation Graph에 작업 명세

```xml-dtd
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_onboarding"
    app:startDestination="@id/firstOnboardingFragment">
    <fragment
        android:id="@+id/firstOnboardingFragment"
        android:name="com.example.androidassignment.ui.onboarding.FirstOnboardingFragment"
        android:label="fragment_first_onboarding"
        tools:layout="@layout/fragment_first_onboarding" >
        <action
            android:id="@+id/action_firstOnboardingFragment_to_secondOnboardingFragment"
            app:destination="@id/secondOnboardingFragment" />
    </fragment>

    ...

</navigation>
```

### FirstOnboardingFragment

- 프래그먼트 전환 로직 짜기

```kotlin
	  class FirstOnboardingFragment : Fragment() {
    private var _binding: FragmentFirstOnboardingBinding? = null
    private val binding get() = _binding ?: error("Bingding이 초기화 되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstOnboardingBinding.inflate(layoutInflater, container, false)

        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_firstOnboardingFragment_to_secondOnboardingFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
}
```

### Level 1-2

- SharedPreferences 활용해서 자동로그인/자동로그인 해제 구현(hint. Remove, clear)

### SOPTSharedPreferences

- SharedPreferences 생성

```kotlin
object SOPTSharedPreferences {
    private const val STORAGE_KEY = "USER_AUTH"
    private const val AUTO_LOGIN = "AUTO_LOGIN"

    fun getAutoLogin(context: Context): Boolean {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        return preferences.getBoolean(AUTO_LOGIN, false)
    }

    fun setAutoLogin(context: Context, value: Boolean) {
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .putBoolean(AUTO_LOGIN, value)
            .apply()
    }

    fun removeAutoLogin(context: Context){
        val preferences = context.getSharedPreferences(STORAGE_KEY, Context.MODE_PRIVATE)
        preferences.edit()
            .remove(AUTO_LOGIN)
            .apply()
    }
}
```

### SignInActivity

- 자동 로그인 로직 구현

```kotlin
private fun initBtnAutoLoginEvent() {
        binding.btnAutoLogin.setOnClickListener {
            SOPTSharedPreferences.getAutoLogin(this)
            shortToast("자동로그인 되었습니다.")
            startActivity(Intent(this@SignInActivity, HomeActivity::class.java))
            finish()
        }
    }
```

### SettingActivity

- 자동 로그인 해제 로직 구현

```kotlin
 private fun initBtnOffAutoLoginEvent() {
        binding.btnOffAutoLogin.setOnClickListener {
            shortToast("자동 로그인 해제")
            SOPTSharedPreferences.removeAutoLogin(this)
        }
    }
```

### Level 1-3

- 본인이 사용하는 Util 클래스 코드 및 패키징 방식 리드미에 정리

패키징 방식

<p>
<img width="280" alt="패키징 방식" src="https://user-images.githubusercontent.com/49150980/146558516-42cd1d2f-802c-49ba-bd31-f73331497a6f.png">
</p>



- data: 데이터클래스 파일들과 서버 통신에 필요한 파일들을 넣었습니다.
- ui: 화면(Activity, Fragment)를 구성하는 코드를 넣었습니다. 또 이 안에서 각각의 메뉴별로 패키징했습니다.
- util: 프로젝트 모든 곳에서 사용되는 코드를 넣었습니다.

Util 클래스의 경우 ViewExt.kt(토스트 메세지 확장함수) 파일을 추가해주었습니다.

## :white_check_mark: 배운 점

- 온보딩 화면 만들기(NavigationComponent 활용)
- SharedPreferences를 활용하여 자동로그인/자동로그인 해제 구현하는 로직
- 확장함수와 Util 클래스의 필요성