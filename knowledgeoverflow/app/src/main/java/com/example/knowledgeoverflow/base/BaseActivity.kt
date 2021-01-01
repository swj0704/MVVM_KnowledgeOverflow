package com.example.knowledgeoverflow.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.knowledgeoverflow.R
import com.example.knowledgeoverflow.BR
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*

abstract class BaseActivity <VM : BaseViewModel, VB : ViewDataBinding> : AppCompatActivity(){

    abstract val resource : Int
    lateinit var binding: VB
    abstract val viewModel : VM


    protected abstract fun init()
    protected abstract fun observerViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        performDataBinding()
        observerViewModel()
        init()
    }

    private fun performDataBinding(){
        binding = DataBindingUtil.setContentView(this, layoutRes())
        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
    }

    @LayoutRes
    private fun layoutRes() : Int{
        val split = ((Objects.requireNonNull<Type>(javaClass.genericSuperclass) as ParameterizedType).actualTypeArguments[0] as Class<*>)
                .simpleName.replace("Binding$".toRegex(), "")
                .split("(?<=.)(?=\\p{Upper})".toRegex())
                .dropLastWhile { it.isEmpty() }.toTypedArray()

        val name = StringBuilder()
        for (i in split.indices) {
            name.append(split[i].toLowerCase(Locale.ROOT))
            if (i != split.size - 1) name.append("_")
        }
        return R.layout::class.java.getField(name.toString()).getInt(R.layout::class.java)
    }

    override fun onBackPressed() {
        this.finish()
    }
}