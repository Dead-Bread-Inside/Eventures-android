package eu.deadbread.eventures.entities

@JvmInline
value class UserId(val string: String)

data class User(val id: UserId, val login: String)