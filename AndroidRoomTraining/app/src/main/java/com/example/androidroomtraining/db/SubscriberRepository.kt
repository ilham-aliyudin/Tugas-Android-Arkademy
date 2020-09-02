package com.example.androidroomtraining.db

class SubscriberRepository(private val dao: SubscriberDAO) {
    val subscriber = dao.getAllSubscriber()

    suspend fun insert(subscriber: Subscriber) {
        dao.insertSubscriber(subscriber)
    }

    suspend fun delete(subscriber: Subscriber) {
        dao.deleteSubscriber(subscriber)
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }

    suspend fun update(subscriber: Subscriber) {
        dao.updateSubscriber(subscriber)
    }
}