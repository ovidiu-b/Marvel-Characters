package es.openbank.character.ui.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.ui.adapter.CharacterGridAdapter
import es.openbank.character.ui.adapter.RowItemClickListener
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.repository.util.AsyncResult

object CharactersGridBinding {

    @BindingAdapter(value = ["app:charactersGridList", "app:charactersGridListener"])
    @JvmStatic
    fun charactersGridList(
        recyclerView: RecyclerView,
        listResult: AsyncResult<List<CharacterBO>>?,
        listener: RowItemClickListener?
    ) {
        if (recyclerView.adapter !is CharacterGridAdapter) {
            recyclerView.adapter = CharacterGridAdapter().apply { setListener(listener) }
        }

        if (listResult != null && listResult.status == AsyncResult.Status.SUCCESS && listResult.data != null) {
            (recyclerView.adapter as CharacterGridAdapter).submitList(listResult.data)
        }
    }

}