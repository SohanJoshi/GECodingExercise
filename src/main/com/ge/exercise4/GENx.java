package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GENx extends GEEngine {
    private static final Logger logger = LogManager.getLogger(GENx.class);

    private static final String ENGINE_MODEL = GENx.class.getSimpleName();

    public GENx(String serialNumber, double flightHours, int numRebuilds) {
    	 super(serialNumber, flightHours, numRebuilds,
         		4, 20_000, 13_552, 14_103, 74_170);
    }

    public GENx(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GENx(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + getSerialNumber();
    }

}
