package eu.deadbread.eventures.repository

import eu.deadbread.eventures.entities.Category
import eu.deadbread.eventures.entities.Distance
import eu.deadbread.eventures.entities.Event
import eu.deadbread.eventures.entities.EventId
import eu.deadbread.eventures.entities.EventInfo
import eu.deadbread.eventures.entities.Location
import eu.deadbread.eventures.entities.User
import eu.deadbread.eventures.entities.UserId

class EventsRepository {

    // mocked
    fun getEventsInArea(location: Location, areaRadius: Distance): List<Event> {
        val user1 = User(UserId("user-1"), "User1")
        val user2 = User(UserId("user-2"), "User2")
        val user3 = User(UserId("user-3"), "User3")

        val eventInfo1 = EventInfo(Location(54.69274428155682, 25.272431834095023), "BaltasTiltas", "event-1", Category.Community)
        val event1 = Event(EventId("event-1"), user1 , listOf(user2, user3), eventInfo1)

        val eventInfo2 = EventInfo(Location(54.69576530142639, 25.27225588402165), "Sakura park", "event-2", Category.PerformingArts)
        val event2 = Event(EventId("event-2"), user3 , listOf(user1), eventInfo2)

        return listOf(event1, event2)
    }
}