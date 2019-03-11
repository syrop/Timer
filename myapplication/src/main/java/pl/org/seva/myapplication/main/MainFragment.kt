package pl.org.seva.myapplication.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.extension.observe
import pl.org.seva.myapplication.main.extension.viewModel
import java.util.concurrent.TimeUnit

class MainFragment : Fragment() {

    private val model by viewModel<MainFragmentViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fragment_main, container)

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Observable.interval(20, TimeUnit.SECONDS, Schedulers.io())
                .take(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    model.liveInt.value = 1
                }

        model.liveInt.observe(this) { value ->
            println("wiktor int: $value")
            text.text = "wiktor $value"
        }
    }
}
