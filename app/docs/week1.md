# Android-Jeongwon

![github_최정원_ver1-30](https://user-images.githubusercontent.com/70698151/135754672-247d3366-22e1-4131-9cc4-69781c943a66.png)

# :star: week1:star:

## 실행화면





## :white_check_mark: Lvel 1 필수과제

- 로그인, 회원가입, 자기소개 페이지 만들기

### SignInActivity

- 아이디,비밀번호 입력이 모두 되어있을 때만 로그인 버튼을 눌렀을 때  HomeActivity로 이동 (이동 시 “ᄋᄋᄋ님 환영합니다"라는 토스트 메시지 출력)
- 만일 모든 입력이 되어있지 않으면 “로그인 실패”라는 토스트 메시지 출력
- 회원가입 버튼을 눌렀을 때는 SignUpActivity로 이동

```kotlin
	  private fun initLoginBtn() {
        binding.btnLogin.setOnClickListener {
            // 유저가 항목을 다 채우지 않았을 경우
            if(binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank()){
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            }
            // 유저가 항목을 다 채웠을 경우
            else {
                Toast.makeText(this, "${binding.etId.text}님 환영합니다!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun initRegisterBtn() {
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            getResultText.launch(intent)
        }
    }

}
```

### activity_sign_in.xml

- 비밀번호 EditTextView는 입력 내용이 가려져야 한다. (inputType속성)
- 모든 EditTextView는 미리보기 글씨가 있어야 한다. (hint속성)

```xml-dtd
android:inputType="textPassword"
android:hint="비밀번호를 입력해주세요"
```

### SignUpActivity

- 이름, 아이디, 비밀번호 입력이 모두 되어있을 때만 회원가입 완료 버튼을 눌렀을 때  다시 SignInActivity로 이동 (이 때는 intent를 쓰는 게 아니라 finish를 활용!)
- 만일 모든 입력이 되어있지 않으면 “입력되지 않은 정보가 있습니다”라는  토스트 메시지 출력

```kotlin
fun initDoneRegisterBtn() {
        binding.btnDoneRegister.setOnClickListener {
            // 유저가 항목을 다 채우지 않았을 경우
            if (binding.etName.text.isNullOrBlank() || binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            // 유저가 항목을 다 채웠을 경우
            else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", binding.etId.text.toString())
                intent.putExtra("password", binding.etPw.text.toString())
                setResult(RESULT_OK, intent)
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                finish()
            }

        }
    }
```

## :white_check_mark: Level 2 도전과제

### Level 2-1

- 회원 가입에 성공한다면 이전 로그인 화면으로 돌아온다. 이 때 아이디와 비밀번호가 입력되어 있어야 한다.
- Hint) `registerForActivityResult`, `putExtra`

:exclamation: [관련내용 안드로이드 공식문서](https://developer.android.com/training/basics/intents/result?hl=ko "활동으로부터 결과 가져오기")

:exclamation: [참고한 링크](https://developer88.tistory.com/351)

### SignInActivity

- ActivityResult를 받기 위한 Callback 등록

  먼저 SignInActivity 에서 할일은 RegisterForActivityResult 함수를 사용해서 Callback을 등록해준다. 이 때 인자로 들어가는 것은 ActivityResultContracts 클래스의 Static 함수들인데, Result를 받기 위해서 Activity를 실행하는 StartActivityForResult()함수를 넣어준다. <br>

  람다식에는 result로 받아온 값을 어떻게 사용하는지 정의해주면 된다. 인자로 받아온 result 객체를 이용하면, resultCode와 data에 접근할 수 있는데, 이 때 resultCode를 이용해서 RESULT_OK인지 확인할 수 있다. 또 result.data를 이용해서 다른 Activity에서 보내온 Intent Data를 이용할 수 있다.

```kotlin
class SignInActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySignInBinding
    private lateinit var getResultText: ActivityResultLauncher<Intent>
  
  ...
  
  private fun setResultSignUp(){
        getResultText = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result->
            if (result.resultCode == RESULT_OK) {
                val id = result.data?.getStringExtra("id") ?: ""
                val password = result.data?.getStringExtra("password") ?: ""
                binding.etId.setText(id)
                binding.etPw.setText(password)
            }
        }
    }
```

- 위에서 정의한 것을 launch 함수로 시작 시켜주기

```kotlin
private fun initRegisterBtn() {
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            getResultText.launch(intent)
        }
    }
```

### SignUpActivity

- SignUpActivity 에서 setResult

  이제 SginUpActivity 에서 데이터를 실어서 SignInActivity로 보내주기만 하면 되는데, 이 부분은 setResult() 함수에 인자로 resultCode와 intent 데이터를 넣어주기만 하면 된다.

```kotlin
fun initDoneRegisterBtn() {
        binding.btnDoneRegister.setOnClickListener {
            // 유저가 항목을 다 채우지 않았을 경우
            if (binding.etName.text.isNullOrBlank() || binding.etId.text.isNullOrBlank() || binding.etPw.text.isNullOrBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            // 유저가 항목을 다 채웠을 경우
            else {
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("id", binding.etId.text.toString())
                intent.putExtra("password", binding.etPw.text.toString())
                setResult(RESULT_OK, intent)
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                finish()
            }

        }
    }
```

### Level 2-2

- HomeActivity에서 깃허브로 이동하는 버튼을 만들고, 본인의 깃허브 페이지로 `암시적 인텐트`를 활용해 이동
- 명시적, 암시적 인텐트의 차이점을 깃허브 리드미 파일에 작성
- :exclamation:[참고한 링크] (https://limkydev.tistory.com/35)

### HomeActivity

```kotlin
private fun initGithubButton(){
        binding.btnGithub.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/garden0401"))
            startActivity(intent)
        }
    }
```

- `명시적 인텐트`: 인텐트에 클래스 객체나 컴포넌트 이름을 지정하여 호출할 대상을 확실히 알 수 있는 경우에 사용한다. 특정 컴포넌트나 액티비티가 명확하게 실행되어야 할 경우에 사용된다.
- `암시적 인텐트`:  인텐트의 액션과 데이터를 지정하긴 했지만, 호출할 대상이 달라질 수 있는 경우에는 암시적 인텐트를 사용한다. 즉, 설치된 애플리케이션들에 대한 정보를 알고있는 안드로이드 시스템이 인텐트를 이용해 요청한 정보를 처리할 수 있는 적절한 컴포넌트를 찾아본 다음 사용자에게 그 대상과 처리 결과를 보여주는 과정을 거치게 된다.

### Level 2-3

- 뷰가 스크롤 가능하게 하기. Hint) `scrollView`, `nestedScrollView`
- `constraintDimensionRatio` 속성을 이용해서 1:1로 사진의 비율을 맞추기

### activity_home.xml

```xml
<ScrollView
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintTop_toBottomOf="@id/tv_title"
        app:layout_constraintBottom_toBottomOf="parent"
        android:layout_marginTop="20dp">

        <androidx.constraintlayout.widget.ConstraintLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent">

    <ImageView
        android:id="@+id/iv_title"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintDimensionRatio="1"
        app:layout_constraintWidth_default="percent"
        app:layout_constraintWidth_percent="0.4"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:src="@drawable/ic_launcher_foreground" />
        
        ...
        
        </androidx.constraintlayout.widget.ConstraintLayout>

    </ScrollView>
```



## :white_check_mark: Level 3 심화과제

### Level 3-1

- 과제를 `DataBinding`을 사용해서 구현해보기

- ViewBinding과 DataBinding의 개념에  대해 리드미 파일에 작성

- `BindingAdapter`를 활용해서 사진도 코드단에서 넣어보기

- 왜 코틀린에선 setOnClickListener를 람다식으로 간결하게 표현할 수 있을까?

  코틀린에서는 자바로 작성된 메소드가 하나인 인터페이스를 구현할 때는 람다식







