package bootcamp.sparta.advancedpractics.main.model

import bootcamp.sparta.advancedpractics.R
import java.util.UUID

data class ContactModel(
    val id: UUID,
    val name: String,
    val phone: String,
    val image: Int,
    val viewType: ContactItemType
)

enum class ContactItemType{
    NONE, FAVORITE, NOT_FAVORITE

}

fun getTypeForEnum(position: Int) : ContactItemType {
    return when(position) {
        1 -> ContactItemType.FAVORITE
        2 -> ContactItemType.NOT_FAVORITE
        else -> ContactItemType.NONE
    }
}

fun getTypeForNumber(type: ContactItemType) : Int {
    return when(type) {
        ContactItemType.FAVORITE -> 1
        ContactItemType.NOT_FAVORITE -> 2
        else -> 0
    }
}

fun dummyList() : ArrayList<ContactModel> {
    return  arrayListOf(
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_1",
            phone = "0802345678",
            image = R.drawable.cat_1,
            viewType = ContactItemType.NOT_FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_2",
            phone = "0802345678",
            image = R.drawable.cat_2,
            viewType = ContactItemType.FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_3",
            phone = "0802345678",
            image = R.drawable.cat_3,
            viewType = ContactItemType.FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_4",
            phone = "0802345678",
            image = R.drawable.cat_4,
            viewType = ContactItemType.FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_5",
            phone = "0802345678",
            image = R.drawable.cat_5,
            viewType = ContactItemType.NOT_FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_6",
            phone = "0802345678",
            image = R.drawable.cat_6,
            viewType = ContactItemType.NOT_FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_7",
            phone = "0802345678",
            image = R.drawable.cat_7,
            viewType = ContactItemType.FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_8",
            phone = "0802345678",
            image = R.drawable.cat_8,
            viewType = ContactItemType.NOT_FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_9",
            phone = "0802345678",
            image = R.drawable.cat_9,
            viewType = ContactItemType.FAVORITE
        ),
        ContactModel(
            id = UUID.randomUUID(),
            name = "cat_10",
            phone = "0802345678",
            image = R.drawable.cat_10,
            viewType = ContactItemType.FAVORITE
        ),
    )
}