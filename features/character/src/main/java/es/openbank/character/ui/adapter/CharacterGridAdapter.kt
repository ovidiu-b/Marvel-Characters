package es.openbank.character.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import es.openbank.character.databinding.RowItemGridBinding
import es.openbank.common.extensions.getLayoutInflater
import es.openbank.model.characterGrid.CharacterBO
import es.openbank.model.common.StandardVariantImagePath

class CharacterGridAdapter: ListAdapter<CharacterBO, CharacterViewHolder>(CharacterDiffCallback()) {

    private var listener: RowItemClickListener? = null

    fun setListener(listener: RowItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(RowItemGridBinding.inflate(parent.getLayoutInflater(), parent, false))
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

}

class CharacterViewHolder(private val binding: RowItemGridBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(character: CharacterBO, listener: RowItemClickListener?) {
        binding.id = character.id
        binding.title = character.name
        binding.imageUrl = character.thumbnail.getUrlVariant(StandardVariantImagePath.XLARGE)
        binding.listener = listener
    }
}

class CharacterDiffCallback: DiffUtil.ItemCallback<CharacterBO>() {
    override fun areItemsTheSame(oldItem: CharacterBO, newItem: CharacterBO): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterBO, newItem: CharacterBO): Boolean {
        return oldItem == newItem
    }
}
