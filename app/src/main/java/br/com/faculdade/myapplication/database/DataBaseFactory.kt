package br.com.faculdade.myapplication.database

import android.content.Context
import androidx.room.Room

object DataBaseFactory {

    private lateinit var dataBase: AppDatabase

    fun provideDatabase(context: Context): AppDatabase {
        if (::dataBase.isInitialized) return dataBase

        dataBase = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java, DB_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

        return dataBase
    }

    private const val DB_NAME = "projeto_faculdade"

}