package es.openbank.character.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.ui.adapter.SeriesGridAdapter
import es.openbank.model.seriesGrid.SeriesBO
import es.openbank.common.wrappers.AsyncResult
import es.openbank.common.wrappers.isSuccess

object SeriesGridBinding {

    @BindingAdapter("app:seriesGridList")
    @JvmStatic
    fun seriesGridList(recyclerView: RecyclerView, listResult: AsyncResult<List<SeriesBO>>?) {
        if (recyclerView.adapter !is SeriesGridAdapter) {
            recyclerView.adapter = SeriesGridAdapter()
        }

        if (listResult != null && listResult.isSuccess() && listResult.data != null) {
            (recyclerView.adapter as SeriesGridAdapter).submitList(listResult.data)
        }
    }

}