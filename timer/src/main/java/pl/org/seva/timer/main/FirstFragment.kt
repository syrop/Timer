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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import kotlinx.android.synthetic.main.first_fragment.*
import pl.org.seva.timer.R
import pl.org.seva.timer.main.extension.inflate
import pl.org.seva.timer.main.extension.nav
import pl.org.seva.timer.main.extension.viewModel
import pl.org.seva.timer.main.extension.invoke


class FirstFragment : Fragment() {

    private val vm by viewModel<ViewModel>()

    private val avm by viewModel<MainActivity.ActivityViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.first_fragment, container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        next_fab.setOnClickListener { nav(R.id.action_firstFragment_to_secondFragment) }

        (timer seconds vm.seconds to this) { seconds.text = it.toString() }
        (timer minutes vm.minutes to this) { minutes.text = it.toString() }

        (avm.seconds to this) { stable_seconds.text = it.toString() }
        (avm.minutes to this) { stable_minutes.text = it.toString() }
    }

    class ViewModel : androidx.lifecycle.ViewModel() {
        val seconds by lazy { MutableLiveData<Int>() }
        val minutes by lazy { MutableLiveData<Int>() }
    }
}
