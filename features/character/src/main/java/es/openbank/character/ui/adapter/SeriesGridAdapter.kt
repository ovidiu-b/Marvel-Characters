package es.openbank.character.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.databinding.RowItemGridBinding
import es.openbank.common.extensions.getLayoutInflater
import es.openbank.model.common.StandardVariantImagePath
import es.openbank.model.seriesGrid.SeriesBO

class SeriesGridAdapter: ListAdapter<SeriesBO, SeriesViewHolder>(SeriesDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeriesViewHolder {
        return SeriesViewHolder(RowItemGridBinding.inflate(parent.getLayoutInflater(), parent, false))
    }

    override fun onBindViewHolder(holder: SeriesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class SeriesViewHolder(private val binding: RowItemGridBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(comic: SeriesBO) {
        binding.id = comic.id
        binding.title = comic.title
        binding.imageUrl = comic.thumbnail.getUrlVariant(StandardVariantImagePath.XLARGE)
    }
}

class SeriesDiffCallback: DiffUtil.ItemCallback<SeriesBO>() {
    override fun areItemsTheSame(oldItem: SeriesBO, newItem: SeriesBO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SeriesBO, newItem: SeriesBO): Boolean {
        return oldItem == newItem
    }
}