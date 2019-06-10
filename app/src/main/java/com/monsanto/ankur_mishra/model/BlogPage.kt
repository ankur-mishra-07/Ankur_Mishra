package com.monsanto.ankur_mishra.model

import java.util.*

class BlogPage : Observable() {

    /// The first data
    var firstData: String = ""
        set(value) {
            field = value
            setChangedAndNotify("firstData")
        }

    var secondData: String = ""
        set(value) {
            field = value
            setChangedAndNotify("secondData")
        }

    var thirdData: String = ""
        set(value) {
            field = value
            setChangedAndNotify("thirdData")
        }

    private fun setChangedAndNotify(field: Any) {
        setChanged()
        notifyObservers(field)
    }
}