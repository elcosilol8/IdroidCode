package com.ardev.idroid.ui.setting

import android.os.Bundle
import android.view.View
import com.google.android.material.appbar.AppBarLayout
import androidx.appcompat.widget.Toolbar
import com.ardev.idroid.R 
import com.ardev.idroid.base.BaseActivity
import com.ardev.idroid.ext.addSystemWindowInsetToPadding

class SettingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val appbar = findViewById<AppBarLayout>(R.id.appbar)

        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setHomeButtonEnabled(true)
        toolbar.setNavigationOnClickListener { _ -> onBackPressed() }

        appbar.setLiftOnScrollTargetViewId(androidx.preference.R.id.recycler_view)
       // val recyclerView: View? = findViewById(androidx.preference.R.id.recycler_view)
       // recyclerView?.addSystemWindowInsetToPadding(false, false, false, true)
    }
}
