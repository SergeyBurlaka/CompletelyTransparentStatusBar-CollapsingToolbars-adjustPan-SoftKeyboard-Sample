//package com.b5eg.sergburlaka.keyboard
//
//import android.databinding.ViewDataBinding
//import android.support.v7.recyclerview.extensions.AsyncDifferConfig
//import android.support.v7.util.DiffUtil
//import android.view.ViewGroup
//import android.widget.ListAdapter
//
///**
// * A generic RecyclerView restaurantsListAdapter that uses Data Binding & DiffUtil.
// *
// * @param <T> Type of the items in the list
// * @param <V> The type of the ViewDataBinding
//</V></T> */
//abstract class DataBoundListAdapter<T, V : ViewDataBinding>(
//        appExecutors: AppExecutors,
//        diffCallback: DiffUtil.ItemCallback<T>
//
//) : ListAdapter<T, DataBoundViewHolder<V>>(
//        AsyncDifferConfig.Builder<T>(diffCallback)
//                .setBackgroundThreadExecutor(appExecutors.diskIO())
//                .build()
//) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<V> {
//        val binding = createBinding(parent)
//        return DataBoundViewHolder(binding)
//    }
//
//    protected abstract fun createBinding(parent: ViewGroup): V
//
//    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
//
//        bind(holder.binding, getItem(position))
//
//        holder.binding.executePendingBindings()
//    }
//
//    protected abstract fun bind(binding: V, item: T)
//
//
//}
