package com.danisable.appfirebaseessentials.data.domain.model.users

import androidx.room.ColumnInfo

data class Users(
    val id: String,
    var email: String,
    val name: String,
    val password: String
)
