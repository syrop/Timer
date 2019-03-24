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
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import pl.org.seva.timer.main.extension.plus
import pl.org.seva.timer.main.rx.RxViewModel
import java.util.concurrent.TimeUnit

val timer by instance<Timer>()

@SuppressLint("CheckResult")
class Timer {

    private val timer = Observable.interval(1, TimeUnit.SECONDS, Schedulers.io())

    private val seconds = BehaviorSubject.createDefault(0)
    private val minutes = BehaviorSubject.createDefault(0)

    val secondsObservable: Observable<Int> = seconds.delay(DELAY_MS, TimeUnit.MILLISECONDS)
    val minutesObservable: Observable<Int> = minutes.delay(DELAY_MS, TimeUnit.MILLISECONDS)


    init {
        timer.subscribe { seconds.onNext(it.toInt()) }
        seconds.filter { it % 60 == 0 }
                .map { it / 60 }
                .subscribe { minutes.onNext(it) }
    }

    infix fun seconds(liveData: MutableLiveData<Int>) = secondsObservable + liveData

    infix fun minutes(liveData: MutableLiveData<Int>) = minutesObservable + liveData

    class ViewModel : RxViewModel() {
        val seconds by disposableLiveData(timer.secondsObservable)
        val minutes by disposableLiveData(timer.minutesObservable)
    }

    companion object {
        const val DELAY_MS = 200L
    }
}
