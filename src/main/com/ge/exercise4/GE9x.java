package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GE9x extends GEEngine {
	private static final Logger logger = LogManager.getLogger(GE9x.class);

    private static final String ENGINE_MODEL = GE90.class.getSimpleName();

    public GE9x(String serialNumber, double flightHours, int numRebuilds) {
        super(serialNumber, flightHours, numRebuilds,
        		5, 30_000, 15_505, 15_900, 100_00);
    }

    public GE9x(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GE9x(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + getSerialNumber();
    }

}
