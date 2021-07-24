package com.danisable.appfirebaseessentials.data.local.dao

import androidx.room.*
import com.danisable.appfirebaseessentials.data.domain.model.users.Users
import com.danisable.appfirebaseessentials.data.local.entity.UsersEntity

@Dao
interface UsersDao {
    @Query("SELECT * FROM users WHERE email = :email " +
            "AND password = :password")
    fun validUsers(email: String, password:String): List<Users>
    @Insert
    fun createUsers(usersEntity:UsersEntity)
    @Update
    fun updateUsers(usersEntity:UsersEntity)
    @Delete
    fun deleteUsers(usersEntity:UsersEntity)
}