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
import kotlinx.android.synthetic.main.second_fragment.*
import pl.org.seva.timer.R
import pl.org.seva.timer.main.extension.inflate
import pl.org.seva.timer.main.extension.viewModel
import pl.org.seva.timer.main.extension.observe

class SecondFragment : Fragment() {

    private val vm by viewModel<ViewModel>()

    private val avm by viewModel<MainActivity.ActivityViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.second_fragment, container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        timer.secondsWithLiveData(vm.seconds).observe(this) { seconds.text = it.toString() }
        timer.minutesWithLiveData(vm.minutes).observe(this) { minutes.text = it.toString() }

        avm.seconds.observe(this) { stable_seconds.text = it.toString() }
        avm.minutes.observe(this) { stable_minutes.text = it.toString() }
    }

    class ViewModel : androidx.lifecycle.ViewModel() {
        val seconds by lazy { MutableLiveData<Int>() }
        val minutes by lazy { MutableLiveData<Int>() }
    }
}
