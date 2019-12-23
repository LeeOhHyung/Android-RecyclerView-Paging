package kr.ohyung.paging.model.local

import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single

/**
 * Created by Lee Oh Hyoung on 2019-12-23.
 */
@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPost(post: Post): Completable

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPostList(list: List<Post>): Completable

    @Query("SELECT * FROM posts")
    fun loadAllPosts(): Single<List<Post>>

    @Delete
    fun deletePost(post: Post): Completable

    @Query("DELETE FROM posts")
    fun deleteAllPosts(): Completable

    @Query("SELECT COUNT(*) FROM posts")
    fun countAllPosts(): Single<Int>
}