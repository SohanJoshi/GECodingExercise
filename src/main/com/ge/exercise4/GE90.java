package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE90 extends GEEngine {
    private static final Logger logger = LogManager.getLogger(GE90.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();

    public GE90(String serialNumber, double flightHours, int numRebuilds) {
        super(serialNumber, flightHours, numRebuilds,
        		3, 25_000, 14_502, 15_100, 81_070);
    }

    public GE90(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE90(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + getSerialNumber();
    }

}
