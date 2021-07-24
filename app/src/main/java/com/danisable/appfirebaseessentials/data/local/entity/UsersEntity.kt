package com.danisable.appfirebaseessentials.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.danisable.appfirebaseessentials.data.domain.model.users.Users
import java.io.Serializable

@Entity(tableName = "users")
data class UsersEntity (
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name="id") val id: String,
        @ColumnInfo(name="email") val email: String,
        @ColumnInfo(name="name") val name: String,
        @ColumnInfo(name="password") val password: String
        ):Serializable {
            companion object{
                fun form (usersEntity:UsersEntity) = Users(
                    usersEntity.id,
                    usersEntity.email,
                    usersEntity.name,
                    usersEntity.password
                )
            }
        }