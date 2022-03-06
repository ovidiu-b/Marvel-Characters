package es.openbank.character.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.ui.adapter.ComicGridAdapter
import es.openbank.model.comicGrid.ComicBO
import es.openbank.common.wrappers.AsyncResult
import es.openbank.common.wrappers.isSuccess

object ComicGridBinding {

    @BindingAdapter("app:comicsGridList")
    @JvmStatic
    fun comicsGridList(recyclerView: RecyclerView, listResult: AsyncResult<List<ComicBO>>?) {
        if (recyclerView.adapter !is ComicGridAdapter) {
            recyclerView.adapter = ComicGridAdapter()
        }

        if (listResult != null && listResult.isSuccess() && listResult.data != null) {
            (recyclerView.adapter as ComicGridAdapter).submitList(listResult.data)
        }
    }

}