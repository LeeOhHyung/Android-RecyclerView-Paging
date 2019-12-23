package kr.ohyung.paging.model.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Created by Lee Oh Hyoung on 2019-12-23.
 */
@Database(entities = [Post::class], version = 2, exportSchema = false)
abstract class PostDatabase: RoomDatabase() {

    abstract fun postDao() : PostDao
}