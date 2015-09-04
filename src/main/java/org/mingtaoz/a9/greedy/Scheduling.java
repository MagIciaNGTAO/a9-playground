package org.mingtaoz.a9.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class Event {
    public String id;
    public long startTimepoint;
    public long endTimepoint;

    public Event(String id, long startTimepoint, long endTimepoint) {
        this.id = id;
        this.startTimepoint = startTimepoint;
        this.endTimepoint = endTimepoint;
    }

    @Override
    public String toString() {
        return "Event:" + id;
    }
}

class Room {
    public int id;
    public long endTimepoint;

    public Room(int id, long endTimepoint) {
        this.id = id;
        this.endTimepoint = endTimepoint;
    }

    @Override
    public String toString() {
        return "Room:" + id;
    }
}

public class Scheduling {

    public static boolean isConflict(Event event1, Event event2) {
        if (event1.startTimepoint < event2.startTimepoint) {
            return event1.endTimepoint > event2.startTimepoint;
        } else {
            return event2.endTimepoint > event1.startTimepoint;
        }
    }

    public static void sortAscd(List<Event> events) {
        Collections.sort(events, new Comparator<Event>() {
            @Override
            public int compare(Event a, Event b) {
                return a.startTimepoint > b.startTimepoint ? 1 : -1;
            }
        });
    }

    public static Map<Event, Room> arrange(List<Event> events) {
        Map<Event, Room> ret = new HashMap<>();

        sortAscd(events);

        PriorityQueue<Room> queue = new PriorityQueue<Room>(events.size(), new Comparator<Room>() {
            @Override
            public int compare(Room a, Room b) {
                return a.endTimepoint > b.endTimepoint ? 1 : -1;
            }
        });

        int rooms = 1;

        for (Event e : events) {
            if (!queue.isEmpty() && queue.peek().endTimepoint <= e.startTimepoint) {
                Room existRoom = queue.poll();
                existRoom.endTimepoint = e.endTimepoint;
                queue.offer(existRoom);
                ret.put(e, existRoom);
            } else {
                Room newRoom = new Room(rooms, e.endTimepoint);
                queue.offer(newRoom);
                ret.put(e, newRoom);
                rooms++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Event event1 = new Event("1", 1, 5);
        Event event2 = new Event("2", 3, 6);
        Event event3 = new Event("3", 2, 3);
        Event event4 = new Event("4", 5, 7);

        List<Event> events = new LinkedList<Event>();
        events.add(event1);
        events.add(event2);
        events.add(event3);
        events.add(event4);
        sortAscd(events);

        Map<Event, Room> result = arrange(events);

        for (Entry<Event, Room> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " in " + entry.getValue());
        }
    }

}
