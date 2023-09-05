package bootcamp.sparta.advancedpractics.main

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import bootcamp.sparta.advancedpractics.databinding.ItemContactListFavoriteBinding
import bootcamp.sparta.advancedpractics.databinding.ItemContactListNotFavoriteBinding
import bootcamp.sparta.advancedpractics.main.model.ContactItemType
import bootcamp.sparta.advancedpractics.main.model.ContactModel
import bootcamp.sparta.advancedpractics.main.model.getTypeForEnum
import bootcamp.sparta.advancedpractics.main.model.getTypeForNumber

class ListRecyclerViewAdapter(private val list: ArrayList<ContactModel>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return getTypeForNumber(list[position].viewType)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (getTypeForEnum(viewType)) {
            ContactItemType.FAVORITE -> {
                val view = ItemContactListFavoriteBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return FavoriteHolder(view, list)
            }

            ContactItemType.NOT_FAVORITE -> {
                val view = ItemContactListNotFavoriteBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NotFavoriteHolder(view, list)
            }

            else -> {
                val view = ItemContactListNotFavoriteBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return NotFavoriteHolder(view, list)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = list[position]
        when (item.viewType) {
            ContactItemType.FAVORITE -> (holder as FavoriteHolder).bind(item)
            ContactItemType.NOT_FAVORITE -> (holder as NotFavoriteHolder).bind(item)
            else -> (holder as NotFavoriteHolder).bind(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NotFavoriteHolder(
        private val binding: ItemContactListNotFavoriteBinding,
        private val list: ArrayList<ContactModel>
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ContactModel) = with(binding) {
            itemNotImage.setImageResource(item.image)
            itemNotName.text = item.name
            itemNotPhone.text = item.phone

            // 즐겨찾기 이벤트
            itemNotIconFavorite.setOnClickListener {
                list[list.indexOf(item)] = list.find { it.id == item.id }?.copy(
                    viewType = ContactItemType.FAVORITE
                )!!
                notifyItemChanged(list.indexOf(item))
            }
            // 통화버튼
            itemNotIconCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${item.phone}"))
                it.context.startActivity(intent)
            }
        }
    }

    inner class FavoriteHolder(
        private val binding: ItemContactListFavoriteBinding,
        private val list: ArrayList<ContactModel>
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ContactModel) = with(binding) {
            itemImage.setImageResource(item.image)
            itemName.text = item.name
            itemPhone.text = item.phone

            // 즐겨찾게 이벤트
            itemIconFavorite.setOnClickListener {
                list[list.indexOf(item)] = list.find { it.id == item.id }?.copy(
                    viewType = ContactItemType.NOT_FAVORITE
                )!!
                notifyItemChanged(list.indexOf(item))
            }
            // 통화버튼
            itemIconCall.setOnClickListener {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel: ${item.phone}"))
                it.context.startActivity(intent)
            }
        }
    }
}