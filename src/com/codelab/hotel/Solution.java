package com.codelab.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A hotel manager has to process N advance bookings of rooms for the next season. His hotel has K rooms. Bookings contain an arrival date and a departure date. He wants to find out whether there are enough rooms in the hotel to satisfy the demand. Write a program that solves this problem in time O(N log N) .
 * <p>
 * Input:
 * <p>
 * <p>
 * First list for arrival time of booking.
 * Second list for departure time of booking.
 * Third is K which denotes count of rooms.
 * <p>
 * Output:
 * <p>
 * A boolean which tells whether its possible to make a booking.
 * Return 0/1 for C programs.
 * O -> No there are not enough rooms for N booking.
 * 1 -> Yes there are enough rooms for N booking.
 * Example :
 * <p>
 * Input :
 * Arrivals :   [1 3 5]
 * Departures : [2 6 8]
 * K : 1
 * <p>
 * Return : False / 0
 * <p>
 * At day = 5, there are 2 guests in the hotel. But I have only one room.
 */
public class Solution {
    public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {
        arrive.sort(null);
        depart.sort(null);
        int arrI = 0, depI = 0;
        int maxGuests = 0;
        int currentGuests = 0;
        while (arrI < arrive.size() && depI < depart.size()) {
            if (arrive.get(arrI) < depart.get(depI)) {
                arrI++;
                currentGuests++;
                maxGuests = Math.max(maxGuests, currentGuests);
            }
            else {
                depI++;
                currentGuests--;
            }
        }
        return maxGuests <= K;
    }
}
