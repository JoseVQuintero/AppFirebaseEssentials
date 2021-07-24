package com.danisable.appfirebaseessentials.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danisable.appfirebaseessentials.R
import com.danisable.appfirebaseessentials.main.container.ContainerActivity
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity(), MainInteractor.View {
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = MainPresenter(this,this)

        btnLogin.setOnClickListener {
            presenter.validUsers(edtUsuario.text.toString(),edtPassword.text.toString())
        }

        btnAddUser.setOnClickListener {

            presenter.createUsers(edtPassword.text.toString(),edtNombre.text.toString(),edtUsuario.text.toString())
        }
    }

    override fun setUser(value: String) {

    }

    override fun showMain(){
        val intent = Intent(this, ContainerActivity::class.java)
        startActivity(intent)
    }
    override fun showInvalidUser(){
        Toast.makeText(this,"Login is invalid",Toast.LENGTH_SHORT).show()
    }
}