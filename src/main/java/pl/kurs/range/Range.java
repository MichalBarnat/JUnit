package pl.kurs.range;

import pl.kurs.range.exceptions.InvalidRangeException;

public class Range {
    private int rangeFrom;
    private int rangeTo;

    public Range(int rangeFrom, int rangeTo) {

        if (rangeFrom > rangeTo) throw new InvalidRangeException("invalid range");

        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
    }

    public boolean isInTheRange(int n) {
        return rangeFrom <= n && rangeTo >= n;
    }

    public int getRangeFrom() {
        return rangeFrom;
    }

    public int getRangeTo() {
        return rangeTo;
    }
}
