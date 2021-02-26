package cn.ondu.basecommon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    private var _viewBinding: T? = null
    protected val mViewBinding = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = viewBinding()
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(savedInstanceState)
        initView(savedInstanceState)
        viewListener()
        liveDataListener()
    }

    protected open fun initView(savedInstanceState: Bundle?) {}
    protected open fun initData(savedInstanceState: Bundle?) {}
    protected open fun viewListener() {}
    protected open fun liveDataListener() {}
    protected abstract fun viewBinding(): T

    override fun onDestroyView() {
        super.onDestroyView()
        if (_viewBinding != null) {
            _viewBinding = null
        }
    }
}