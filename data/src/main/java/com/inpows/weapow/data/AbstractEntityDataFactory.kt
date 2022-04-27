package com.inpows.weapow.data

abstract class AbstractEntityDataFactory<T> {
    abstract fun createData(@Source source: String?): T
}
