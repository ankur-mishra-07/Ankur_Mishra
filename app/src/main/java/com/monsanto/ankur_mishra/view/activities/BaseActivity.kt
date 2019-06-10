package com.monsanto.ankur_mishra.view.activities

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.monsanto.ankur_mishra.BR
import com.monsanto.ankur_mishra.R
import com.monsanto.ankur_mishra.model.BlogPage
import com.monsanto.ankur_mishra.viewModel.BaseActivityViewModel

class BaseActivity : AppCompatActivity(){

    // Private fields ---------------------------------------------------------
    private var viewModel: BaseActivityViewModel? = null

    // Protected methods ------------------------------------------------------

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var blog = BlogPage()
        blog.firstData = "Data First...."
        blog.secondData = "Data Two...."
        blog.thirdData = "Data Third...."
        var binding = DataBindingUtil.setContentView<ViewDataBinding>(this, R.layout.activity_main)
        viewModel = BaseActivityViewModel(blog)
        binding.setVariable(BR.viewModel, viewModel)
    }
}