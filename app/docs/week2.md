# Android-Jeongwon
![github_최정원_ver1-30](https://user-images.githubusercontent.com/70698151/135754672-247d3366-22e1-4131-9cc4-69781c943a66.png)


### :star: WEEK2
:exclamation: LEVEL1

# :white_check_mark: 구현한 로직(코드)을 설명하는 내용
## 1-1 HomeActivity 하단에 FollowerRecyclerView, RepositoryRecyclerView 만들기
* FollowerRecyclerView(fragment_follower.xml)
```
  <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_follower"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        tools:itemCount="4"
        tools:listitem="@layout/item_follower_list" />
```
* FollowerDTO.kt
```
data class FollowerDTO(
    val name : String,
    val introduction : String
)
```
* FollowerAdapter
```
class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    val followerList = mutableListOf<FollowerDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,false
        )
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int = followerList.size

    class FollowerViewHolder(private val binding: ItemFollowerListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : FollowerDTO) {
            binding.tvName.text = data.name
            binding.tvIntro.text = data.introduction
        }
    }
}
```
* RepositoryAdapter
```
class RepositoryAdapter : RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    val RepositoryList = mutableListOf<RepositoryDTO>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val binding = ItemRepositoryListBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return RepositoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.onBind(RepositoryList[position])
    }

    override fun getItemCount(): Int = RepositoryList.size

    class RepositoryViewHolder(private val binding: ItemRepositoryListBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data : RepositoryDTO) {
            binding.tvTitle.text = data.title
            binding.tvContent.text = data.content
        }
    }
}
```

## 1-2 둘 중 하나의 RecyclerView는 GridLayout으로 만들기
* RepositoryRecyclerView(fragment_repository.xml)
```
<androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_repository"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginStart="10dp"
        android:layout_marginEnd="10dp"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:spanCount="2"
        tools:itemCount="4"
        tools:listitem="@layout/item_repository_list" />
```   

# :white_check_mark: 이번 과제를 통해 배운 내용, 성장한 내용
:heavy_plus_sign: Fragment 활용  
:heavy_plus_sign: RecyclerView를 통해 두 가지 형태의 리스트 생성

# :white_check_mark: 실행화면
<p float="left">
<img src = "https://user-images.githubusercontent.com/49150980/138336693-13beb98d-1982-4994-b8ba-8d47c1cd2772.PNG" width="30%" height="30%">
<img src = "https://user-images.githubusercontent.com/49150980/138336704-da629ae8-c4d3-4b15-bc02-568b5231802b.PNG" width="30%" height="30%">
</p>


