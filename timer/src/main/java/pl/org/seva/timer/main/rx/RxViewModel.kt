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

package pl.org.seva.timer.main.rx

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.kodein.di.LazyDelegate
import kotlin.reflect.KProperty

open class RxViewModel : ViewModel() {
    private val cd = CompositeDisposable()

    protected fun <T> disposableLiveData(observable: Observable<T>) = object : LazyDelegate<MutableLiveData<T>> {
        override fun provideDelegate(receiver: Any?, prop: KProperty<Any?>) = lazy {
           MutableLiveData<T>().apply {
               cd.add(observable.subscribe { this.postValue(it) })
           }
        }
    }

    override fun onCleared() {
        cd.dispose()
    }
}
