package com.danisable.appfirebaseessentials.main

interface  MainInteractor {

    interface Presenter {
        fun cancel()
        fun getUsers()
        fun createUsers(password:String,name:String,email:String)
        fun validUsers(password:String,email:String)
    }

    interface View {
        fun setUser(value: String)
        fun showMain()
        fun showInvalidUser()
    }

}