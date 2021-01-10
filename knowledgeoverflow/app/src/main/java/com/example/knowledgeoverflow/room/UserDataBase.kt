package com.example.knowledgeoverflow.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserDataBase (
    @PrimaryKey(autoGenerate = true) var id : Int,
    @ColumnInfo(name = "name") var name : String,
    @ColumnInfo(name = "email") var email : String,
    @ColumnInfo(name = "password") var password : String,
    @ColumnInfo(name = "join_time") var join_time : String

)