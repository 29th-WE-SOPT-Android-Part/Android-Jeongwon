# Android-Jeongwon
![github_최정원_ver1-30](https://user-images.githubusercontent.com/70698151/135754672-247d3366-22e1-4131-9cc4-69781c943a66.png)


### :star: WEEK4

# :white_check_mark: 실행화면
<p float="left">
<img src = "" width="30%" height="30%">
</p>


:exclamation: LEVEL1

# :white_check_mark: POSTMAN테스트
## 회원가입 완료
<p float="left">
<img src = "" width="30%" height="30%">
</p>

## 로그인 완료
<p float="left">
<img src = "" width="30%" height="30%">
</p>

# :white_check_mark: 구현한 로직(코드)을 설명하는 내용
## 1. 라이브러리 추가 및 AndroidManifest 설정
* build.gradle(app)에 추가
    ```
    // 서버 연결을 위한 Retrofit2
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    // Retrofit2에서 gson 사용을 위한 컨버터
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    //gson
    implementation "com.google.code.gson:gson:2.8.6"
    ```

## 2. 서버 Request / Response 객체 설계
* RequestSignUpData.kt
    ```
    data class RequestSignUpData(
        @SerializedName("email")
        val id : String,
        val name : String,
        val password : String
    )
    ```
* ResponseSignUpData.kt
    ```
    data class ResponseSignUpData(
        val status : Int,
        val success : Boolean,
        val message : String,
        val data : Data
    ) {
        data class Data(
        val id : Int,
        val name : String,
        val email : String
        )
    }
    ```

## 3. Retrofit Interface 설계
* SignUpService.kt
  ```
  interface SignUpService {
      @Headers("Content-Type: application/json")
      @POST("user/signup")
      fun postJoin(
          @Body body : RequestSignUpData
      ) : Call<ResponseSignUpData>
  }
  ```

## 4. Retrofit Interface 실제 구현체(객체) 만들기
* ServiceCreator.kt
  ```
  object ServiceCreator {
      private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"
  
      private val retrofit : Retrofit = Retrofit.Builder()
          .baseUrl(BASE_URL)
          .addConverterFactory(GsonConverterFactory.create())
          .build()
  
      val SignInService: SignInService = retrofit.create(com.example.androidassignment.SignInService::class.java)
      val SignUpService: SignUpService = retrofit.create(com.example.androidassignment.SignUpService::class.java)
  }
  ```

## 5. Callback 등록하여 통신 요청
* SignUpActivity.kt
  ```
  private fun initNetwork() {
          val requestSignUpData = RequestSignUpData(
              id = binding.etId.text.toString(),
              name = binding.etName.text.toString(),
              password = binding.etPw.text.toString()
          )
  
          val call: Call<ResponseSignUpData> = ServiceCreator.SignUpService.postJoin(requestSignUpData)
  
          call.enqueue(object : Callback<ResponseSignUpData> {
              override fun onResponse(
                  call: Call<ResponseSignUpData>,
                  response: Response<ResponseSignUpData>
              ) {
                  if (response.isSuccessful) {
                      val data = response.body()?.data
  
                      Toast.makeText(this@SignUpActivity, "${data?.email}님 회원가입 완료", Toast.LENGTH_LONG).show()
                      finish()
                  } else
                      Toast.makeText(this@SignUpActivity, "회원가입 실패", Toast.LENGTH_LONG).show()
              }
  
              override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                  Log.e("NetworkTest", "error")
              }
          })
      }
  ```

# :white_check_mark: 이번 과제를 통해 배운 내용, 성장한 내용
:heavy_plus_sign: API 명세서를 기반으로 서버 통신 구현하는 방법   
:heavy_plus_sign: POSTMAN 테스트 방법   



  




