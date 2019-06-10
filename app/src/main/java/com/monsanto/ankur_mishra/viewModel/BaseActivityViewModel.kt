package com.monsanto.ankur_mishra.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.view.View
import com.monsanto.ankur_mishra.BR
import com.monsanto.ankur_mishra.model.BlogPage
import com.monsanto.ankur_mishra.repositry.BlogService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*


class BaseActivityViewModel(private val blogPage: BlogPage) : Observer, BaseObservable() {

    /// Register itself as the observer of Model
    init {
        blogPage.addObserver(this)
    }

    override fun update(p0: Observable?, p1: Any?) {
        if (p1 is String) {
            when (p1) {
                "firstData" -> notifyPropertyChanged(BR.firstData)
                "secondData" -> notifyPropertyChanged(BR.secondData)
                "thirdData" -> notifyPropertyChanged(BR.thirdData)
            }
        }
    }


    val firstData: String
        @Bindable get() {
            return blogPage.firstData
        }

    val secondData: String
        @Bindable get() {
            return blogPage.secondData
        }

    val thirdData: String
        @Bindable get() {
            return blogPage.thirdData
        }

    fun onButtonClick(view: View) {
        callWebBlogFetcher()
    }

    private fun callWebBlogFetcher() {
        this.blogPage.firstData = "Fetching for Data First...."
        this.blogPage.secondData = "Fetching for Data Two...."
        this.blogPage.thirdData = "Fetching for Data Third...."
        BlogService.createBlogService()
                .getBlogPage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { blog ->
                    this.blogPage.firstData = fetchFirstResult(blog)
                    this.blogPage.secondData = fetchSecondResult(blog)
                    this.blogPage.thirdData = fetchThirdResult(blog)
                }
    }

    private fun fetchThirdResult(blog: String?): String {
        val deli = "\n\t "

        val strBuffer = StringBuffer()

        // create StringTokenizer object
        val st = StringTokenizer(blog, deli)

        // create ArrayList object
        val wordArray = ArrayList<String>()

        // iterate through StringTokenizer tokens
        while (st.hasMoreTokens()) {
            // add tokens to AL
            wordArray.add(st.nextToken())
        }

        var wrc = 1    //Variable for getting Repeated word count

        for (i in 0 until wordArray.size)
        //Outer loop for Comparison
        {
            for (j in i + 1 until wordArray.size)
            //Inner loop for Comparison
            {
                if (wordArray[i] == wordArray[j])
                //Checking for both strings are equal
                {
                    wrc += 1    //if equal increment the count
                    wordArray[j] = "0" //Replace repeated words by zero
                }
            }
            if (wordArray[i] !== "0") {
                strBuffer.append(wordArray[i] + "--" + wrc + "\n")
            }
            wrc = 1
        }
        return strBuffer.toString()
    }

    private fun fetchSecondResult(blog: String?): String {
        val chArray = blog!!.toCharArray()
        var index = 10
        var charArray = arrayListOf<Char>()
        while (index < chArray.size) {
            charArray.add(blog[index])
            index += 10
        }
        return charArray.toString()
    }

    private fun fetchFirstResult(blog: String?): String {
        return blog!!.toCharArray()[10].toString()
    }

}