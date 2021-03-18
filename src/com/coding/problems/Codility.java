package com.coding.problems;

import java.util.Calendar;
import java.util.HashSet;
import java.util.TreeSet;

public class Codility {
    enum Month {
        January(1),
        February(2),
        March(3),
        April(4),
        May(5),
        June(6),
        July(6),
        August(8),
        September(9),
        October(10),
        November(11),
        December(12);
        private int value;

        public int getValue() {
            return value;
        }

        Month(int value) {
            this.value = value;
        }
    }

    enum Day {
        Monday(1),
        Tuesday(2),
        Wednesday(3),
        Thursday(4),
        Friday(5),
        Saturday(6),
        Sunday(7);
        private int value;

        public int getValue() {
            return value;
        }

        Day(int value) {
            this.value = value;
        }
    }

    public int solution(int Y, String A, String B, String W) {
        boolean isLeapYear = Y % 4 == 0;
        int beginningMonth = Month.valueOf(A).getValue();
        int endingMonth = Month.valueOf(B).getValue();
        Day day = Day.valueOf(W);

        Calendar cacheCalendar = Calendar.getInstance();
        cacheCalendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        cacheCalendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, 1);
        cacheCalendar.set(Calendar.MONTH, beginningMonth);
        cacheCalendar.set(Calendar.YEAR, Y);
        int date = cacheCalendar.get(Calendar.DATE);

        return date;
    }


    public String solution(String[] A, String[] B, String P) {

        TreeSet<String> sortedContacts = new TreeSet<>();
        for (int i = 0; i < B.length; i++)
            if (B[i].contains(P))
                sortedContacts.add(A[i]);

        return sortedContacts.isEmpty() ? "NO CONTACT" :
                sortedContacts.first();
    }

    public String solution2(String[] A, String[] B, String P) {
        int n = A.length;
        HashSet<String> contacts = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (B[i].contains(P)) {
                contacts.add(A[i]);
            }
        }
        TreeSet<String> sortedContactSet = new TreeSet(contacts);
        if (sortedContactSet.isEmpty()) {
            return "NO CONTACT";
        } else {
            return sortedContactSet.first();
        }

    }

    public String solution(String S) {
        String str = S.replaceAll(" ", "").replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        sb.append(str, 0, 3);
        for (int i = 3; i < str.length(); i = i + 3) {
            int end = Math.min(i + 3, str.length());
            sb.append("-").append(str, i, end);
        }
        if (sb.substring(sb.length() - 2, sb.length() - 1).equals("-")) {
            sb.delete(sb.length() - 2, sb.length() - 1);
            sb.insert(sb.length() - 3, "-");
        }
        return sb.toString();
    }
}

