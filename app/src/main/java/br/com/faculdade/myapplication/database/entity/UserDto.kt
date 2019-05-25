package br.com.faculdade.myapplication.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDto(
    @PrimaryKey val name : String = "",
    val password : String = ""
)