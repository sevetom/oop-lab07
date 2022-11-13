package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31),
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);
       
        private final int days;

        Month(final int days) {
            this.days = days;
        }

        public static Month fromString(String name) {
            Objects.requireNonNull(name);
            try {
                return valueOf(name);
            } catch (IllegalArgumentException e) {
                Month matched = null;
                name = name.toLowerCase();
                for (final Month month : values()) {
                    final String m = month.toString().toLowerCase();
                    if (m.startsWith(name)) {
                        if (matched != null) {
                            throw new IllegalArgumentException("Month name is ambigous");
                        }
                        matched = month;
                    }
                }
                if (matched == null) {
                    throw new IllegalArgumentException("No match found");
                }
                return matched;
            }
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDays();
    }

    private static class SortByDays implements Comparator<String> {
        @Override
        public int compare(final String s1, final String s2) {
            final Month m1 = Month.fromString(s1);
            final Month m2 = Month.fromString(s2);
            return Integer.compare(m1.days, m2.days);
        }
    }


    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }

    private static class SortByMonthOrder implements Comparator<String> {
        @Override
        public int compare(final String s1, final String s2) {
            return Month.fromString(s1).compareTo(Month.fromString(s2));
        }
    }
}
