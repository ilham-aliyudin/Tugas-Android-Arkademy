package com.example.androidroomtraining.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(subscriber: Subscriber): Long

    @Update
    suspend fun updateSubscriber(subscriber: Subscriber)

    @Delete
    suspend fun deleteSubscriber(subscriber: Subscriber)

    @Query("delete from subscriber_data_table")
    suspend fun deleteAll()

    @Query("select * from subscriber_data_table")
    fun getAllSubscriber(): LiveData<List<Subscriber>>
}