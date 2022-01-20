package es.openbank.character.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.databinding.RowItemGridBinding
import es.openbank.common.extensions.getLayoutInflater
import es.openbank.model.comicGrid.ComicBO
import es.openbank.model.common.StandardVariantImagePath

class ComicGridAdapter: ListAdapter<ComicBO, ComicViewHolder>(ComicDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        return ComicViewHolder(RowItemGridBinding.inflate(parent.getLayoutInflater(), parent, false))
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class ComicViewHolder(private val binding: RowItemGridBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(comic: ComicBO) {
        binding.id = comic.id
        binding.title = comic.title
        binding.imageUrl = comic.thumbnail.getUrlVariant(StandardVariantImagePath.XLARGE)
    }
}

class ComicDiffCallback: DiffUtil.ItemCallback<ComicBO>() {
    override fun areItemsTheSame(oldItem: ComicBO, newItem: ComicBO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ComicBO, newItem: ComicBO): Boolean {
        return oldItem == newItem
    }
}
