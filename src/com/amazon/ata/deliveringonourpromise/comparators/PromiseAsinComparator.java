package com.amazon.ata.deliveringonourpromise.comparators;

import com.amazon.ata.deliveringonourpromise.types.Promise;

import java.util.Comparator;

public class PromiseAsinComparator implements Comparator<Promise> {
    @Override
    public int compare(Promise p1, Promise p2) {
        if (p1.getAsin() == null && p2.getAsin() == null) {
            return 0;
        } else if (p1.getAsin() == null) {
            return -1;
        } else if (p2.getAsin() == null) {
            return 1;
        }
        return p1.getAsin().compareTo(p2.getAsin());
    }
}
