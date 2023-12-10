package com.example.banco_calamo.activities

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.banco_calamo.R
import com.example.banco_calamo.databinding.ActivityMainBinding
import com.example.banco_calamo.bd.MiBancoOperacional
import com.example.banco_calamo.fragments.AccountsFragment
import com.example.banco_calamo.fragments.MainFragment
import com.example.banco_calamo.pojo.Cliente
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val navigationView = binding.navView
        navigationView?.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.btn_home, R.string.btn_salir)
        drawerLayout.addDrawerListener(toggle)

        val cliente = intent.getSerializableExtra("Cliente") as Cliente?



        if (cliente != null) {
            val frgMain: MainFragment = MainFragment.newInstance(cliente)
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, frgMain).commit()
            navigationView?.setCheckedItem(R.id.nav_home)

        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_home -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment()).commit()
            R.id.nav_config -> supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AccountsFragment()).commit()
            R.id.nav_logout -> Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onBackPressed() {
        super.onBackPressed()
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}