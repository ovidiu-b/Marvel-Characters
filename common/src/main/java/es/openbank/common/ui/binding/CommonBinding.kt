package es.openbank.common.ui.binding

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import es.openbank.common.extensions.load
import es.openbank.common.extensions.setInvisible
import es.openbank.common.extensions.setVisible
import es.openbank.common.ui.recyclerView.GridSpacingItemDecoration
import es.openbank.common.util.strings.sanitizeHttp
import es.openbank.repository.util.AsyncResult

object CommonBinding {

    @BindingAdapter("app:imageUrl")
    @JvmStatic
    fun imageUrl(imageView: ImageView, url: String?) {
        if (url != null) {
            imageView.load(url.sanitizeHttp())
        }
    }

    @BindingAdapter("app:showWhenLoading")
    @JvmStatic
    fun <T> showWhenLoading(view: View, asyncResult: AsyncResult<T>?) {
        view.setVisible(asyncResult?.status == AsyncResult.Status.LOADING)
    }

    @BindingAdapter("app:hideWhenLoading")
    @JvmStatic
    fun <T> hideWhenLoading(view: View, asyncResult: AsyncResult<T>?) {
        view.setInvisible(asyncResult?.status == AsyncResult.Status.LOADING)
    }

    @BindingAdapter("app:refreshAsyncResult")
    @JvmStatic
    fun <T> refreshAsyncResult(view: SwipeRefreshLayout, asyncResult: AsyncResult<T>?) {
        view.isRefreshing = asyncResult?.status == AsyncResult.Status.LOADING
    }

    @BindingAdapter("app:showIf")
    @JvmStatic
    fun isVisible(view: View, visible: Boolean) {
        view.isVisible = visible
    }

    @BindingAdapter("app:showIfAsyncResultSuccessButEmpty")
    @JvmStatic
    fun <T> showIfAsyncResultSuccessButEmpty(view: View, asyncResult: AsyncResult<T>?) {
        val isListEmpty = asyncResult?.data is List<*> && (asyncResult.data as List<*>).isEmpty()
        val isSuccess = asyncResult != null && asyncResult.status == AsyncResult.Status.SUCCESS

        view.isVisible = isSuccess && (asyncResult?.data == null || isListEmpty)
    }

    @BindingAdapter(value = [
        "app:setGridSpacingItemDecorationSpanCount",
        "app:setGridSpacingItemDecorationSpacing",
        "app:setGridSpacingItemDecorationIncludeEdge",
    ], requireAll = true)
    @JvmStatic
    fun setGridSpacingItemDecoration(recyclerView: RecyclerView, spanCount: Int?, spacing: Float?, includeEdge: Boolean?) {
        if (
            recyclerView.itemDecorationCount == 0
            && spanCount != null
            && spanCount > 0
            && spacing != null
            && spacing > 0
            && includeEdge != null
        ) {
            recyclerView.addItemDecoration(GridSpacingItemDecoration(spanCount, spacing.toInt(), includeEdge))
        }
    }

}