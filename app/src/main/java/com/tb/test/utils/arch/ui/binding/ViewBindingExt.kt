package com.tb.test.utils.binding

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * This delegate responsible to bind Fragment's view to proper viewBinding, also handle the
 * view destroy lifecycle event and recycle the binding.
 *
 * Note that, this binding util has a limitation, not allowed to access binding before onViewCreated and after onDestroyView
 *
 * @param viewBindingClass the target viewBinding
 */
class FragmentViewBindingDelegate<VB : ViewBinding>(private val viewBindingClass: Class<VB>) :
    ReadOnlyProperty<Fragment, VB> {

    private var binding: VB? = null

    override fun getValue(thisRef: Fragment, property: KProperty<*>): VB {
        return binding ?: getInstance(thisRef.requireView()).also { binding = it }.also {
            thisRef.viewLifecycleOwner.lifecycle.addObserver(object:DefaultLifecycleObserver{
                override fun onDestroy(owner: LifecycleOwner) {
                    binding = null
                    owner.lifecycle.removeObserver(this)
                }
            })
        }
    }

    private fun getInstance(bindTarget: View): VB {
        return viewBindingClass.getDeclaredMethod("bind", View::class.java).invoke(null, bindTarget) as VB
    }

}

/**
 * Simple helper function to makes binding easier. The reified ViewBinding type will be the type for binding.
 *
 * Usage:
 * ``` kotlin
 * class SomeFragment: Fragment(R.id.fragment_some) { <---- important to set layout here
 *
 *      private val binding: FragmentSomeBinding by bindings()
 *      ...
 *      onViewCreated(...){
 *          //here you can access to the `binding`
 *      }
 *      ...
 * }
 * ...
 * ```
 * **!!Note that, this binding util has a limitation, not allowed to access binding before onViewCreated and after onDestroyView!!**
 */
inline fun<reified VB: ViewBinding> Fragment.bindings(): FragmentViewBindingDelegate<VB> = FragmentViewBindingDelegate(VB::class.java)