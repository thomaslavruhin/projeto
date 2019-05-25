package br.com.faculdade.myapplication.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class SupportDto(
    val where : String = "",
    val problem : String = "",
    @PrimaryKey val uuid : String = UUID.randomUUID().toString()
)