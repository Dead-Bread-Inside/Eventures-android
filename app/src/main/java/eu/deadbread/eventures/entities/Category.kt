package eu.deadbread.eventures.entities

data class Category(val title: String, val colorHex: String, val children: List<Category> = emptyList())