package com.danisable.appfirebaseessentials.main

import android.content.Context
import android.net.NetworkCapabilities

import android.util.Log
import com.danisable.appfirebaseessentials.data.domain.model.users.Users
import com.danisable.appfirebaseessentials.utils.Network
import com.danisable.appfirebaseessentials.data.local.PersistenceDatabase
import com.danisable.appfirebaseessentials.data.local.entity.UsersEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.*
import kotlin.coroutines.CoroutineContext

class MainPresenter(
    private val context: Context,
    private val view: MainInteractor.View
): MainInteractor.Presenter, CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    private val database = PersistenceDatabase(context)

    override fun validUsers(email:String, password:String) {
        var usersCount =  database.usersDao().validUsers(email,password).count()
        if(usersCount>0){
            view.showMain()
        }else{
            view.showInvalidUser()
        }
    }

    override fun cancel(){
        job.cancel()
    }

    override fun getUsers() {

    }

    override fun createUsers(password:String, name:String, email:String) {
        database.usersDao().createUsers(UsersEntity(UUID.randomUUID().toString(),email,name,password))
    }

}