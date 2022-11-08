package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private enum Month {
        JANUARY("january",31),
        FEBRUARY("february",28),
        MARCH("march",31),
        APRIL("april",30),
        MAY("may",31),
        JUNE("june",30),
        JULY("july",31),
        AUGUST("agust",31),
        SEPTEMBER("september",30),
        OCTOBER("october",31),
        NOVEMBER("november",30),
        DECEMBER("december",31);

        private final String name;       
        private final int days;

        Month(final String name ,final int days) {
            this.name = name;
            this.days = days;
        }

        private Month fromString(String)
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
