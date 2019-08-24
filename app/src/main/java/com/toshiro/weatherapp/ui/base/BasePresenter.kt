package com.toshiro.weatherapp.ui.base

import androidx.annotation.CallSuper
import com.toshiro.weatherapp.utils.Constant
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BasePresenter<V>(@Volatile var view: V?) {


    companion object {
        var mCompositeDisposables: CompositeDisposable = CompositeDisposable()
    }

    protected fun view(): V? {
        return view
    }


    @CallSuper
    fun unbindView() {
        mCompositeDisposables.clear()
        mCompositeDisposables.dispose()
        this.view = null
    }

    fun addDisposable(disposable: Disposable) {
        mCompositeDisposables.add(disposable)
    }
}