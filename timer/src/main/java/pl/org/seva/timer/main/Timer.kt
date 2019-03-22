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
import androidx.lifecycle.LifecycleOwner
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import pl.org.seva.timer.main.extension.observe
import java.util.concurrent.TimeUnit

val timer by instance<Timer>()

@SuppressLint("CheckResult")
class Timer {

    private val timer = Observable.interval(20, TimeUnit.SECONDS, Schedulers.io())

    private val seconds= BehaviorSubject.createDefault(0)
    private val minutes = BehaviorSubject.createDefault(0)

    init {
        timer.subscribe { seconds.onNext(it.toInt()) }
        seconds.filter { it % 60 == 0 }
                .map { it / 60 }
                .subscribe { minutes.onNext(it) }
    }

    fun observeSeconds(owner: LifecycleOwner, observer: (Int) -> Unit) {
        seconds.observe(owner, observer)
    }

    fun observeMinutes(owner: LifecycleOwner, observer: (Int) -> Unit) {
        minutes.observe(owner, observer)
    }
}
