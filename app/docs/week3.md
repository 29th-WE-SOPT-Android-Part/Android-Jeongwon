# Android-Jeongwon
![github_최정원_ver1-30](https://user-images.githubusercontent.com/70698151/135754672-247d3366-22e1-4131-9cc4-69781c943a66.png)


### :star: WEEK3
:exclamation: LEVEL2

# :white_check_mark: 구현한 로직(코드)을 설명하는 내용
## 2-2 리스트에 각기 다른 이미지 넣기
* app 단계의 build.gradle 추가
```
 implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
  ```
* AndroidManifest.xml에 인터넷 사용권한을 추가
  ```
  <uses-permission android:name="android.permission.INTERNET" />
  ```
* Date Class 수정
  ```
  data class FollowerData (
    val imageUrl : String,
    val name : String,
    val introduction : String
    )
  ```
  * 이미지 띄우기
  ```
  followerAdapter.followerList.addAll(
            listOf(
                FollowerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSVFjOGNPXNc3JVvoxPf6VIpate-aDkyt6kxQ&usqp=CAU","최정원", "안드로이드"),
                FollowerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTcg2Ax_SmIK80PqSEhlEkCyC-23qPZROio2A&usqp=CAU","문다빈", "안드로이드 파트장"),
                FollowerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReMu293BUlrOdzfkROuFoP3RvM2RbCmFm7Tg&usqp=CAU","장혜령", "IOS 파트장"),
                FollowerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQ6_eX7RFK5Qd6nfhqjtHlQNwl0GgTN6S3Og&usqp=CAU","김우영", "서버 파트장"),
                FollowerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT_nN0dcvrM4jttfdeFEbEkpqhqcrEfaROzg&usqp=CAU","조승우", "SOPT 회장"),
                FollowerData("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSfOmlStOM6vfmdcDmvzpmQ1pKWqQ9YkX6ZJA&usqp=CAU","김해리", "SOPT 부회장")
            )
        )
  ```
  ```
  fun onBind(data : FollowerData) {
            Glide.with(binding.ivPhoto)
                .load(data.imageUrl)
                .into(binding.ivPhoto)
            binding.tvName.text = data.name
            binding.tvIntro.text = data.introduction
        }
  ```
  



