/*
 * Copyright (C) 2019 Wiktor Nizio
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * If you like this program, consider donating bitcoin: bc1qncxh5xs6erq6w4qz3a7xl7f50agrgn3w58dsfp
 */

package pl.org.seva.timer.main

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*
import pl.org.seva.timer.R
import pl.org.seva.timer.main.extension.invoke
import pl.org.seva.timer.main.extension.viewModel

class MainActivity: AppCompatActivity() {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    private val avm by viewModel<ActivityViewModel>()

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)

        (timer seconds avm.seconds to this) {}
        (timer minutes avm.minutes to this) {}
    }

    override fun onSupportNavigateUp() = navController.navigateUp()

    class ActivityViewModel : androidx.lifecycle.ViewModel() {
        val seconds by lazy { MutableLiveData<Int>() }
        val minutes by lazy { MutableLiveData<Int>() }
    }
}
