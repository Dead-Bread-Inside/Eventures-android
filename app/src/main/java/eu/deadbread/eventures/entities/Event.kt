package eu.deadbread.eventures.entities

@JvmInline
value class EventId(val string: String)

data class EventInfo(val location: Location, val title: String, val description: String, val category: Category)

data class Event(val eventId: EventId, val author: User, val participants: List<User>, val info: EventInfo)