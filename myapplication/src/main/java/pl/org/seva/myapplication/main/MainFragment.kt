package pl.org.seva.myapplication.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pl.org.seva.myapplication.R
import pl.org.seva.myapplication.main.extension.inflate
import pl.org.seva.myapplication.main.extension.observe
import pl.org.seva.myapplication.main.extension.viewModel

class MainFragment : Fragment() {

    private val model by viewModel<MainFragmentViewModel>()
    

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflate(R.layout.fragment_main, container)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.liveInt.observe(this) { value ->
            println("wiktor int: $value")
        }
    }
}
