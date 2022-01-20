package es.openbank.character.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.ui.adapter.ComicGridAdapter
import es.openbank.model.comicGrid.ComicBO
import es.openbank.repository.util.AsyncResult

object ComicGridBinding {

    @BindingAdapter("app:comicsGridList")
    @JvmStatic
    fun comicsGridList(recyclerView: RecyclerView, listResult: AsyncResult<List<ComicBO>>?) {
        if (recyclerView.adapter !is ComicGridAdapter) {
            recyclerView.adapter = ComicGridAdapter()
        }

        if (listResult != null && listResult.status == AsyncResult.Status.SUCCESS && listResult.data != null) {
            (recyclerView.adapter as ComicGridAdapter).submitList(listResult.data)
        }
    }

}