package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GEPassport extends GEEngine {
    private static final Logger logger = LogManager.getLogger(GEPassport.class);

    private static final String ENGINE_MODEL = GEPassport.class.getSimpleName();

    public GEPassport(String serialNumber, double flightHours, int numRebuilds) {
    	super(serialNumber, flightHours, numRebuilds,
         		0, 50_000, 4_505, 5_230, 20_650);
    }

    public GEPassport(String serialNumber, double flightHours) {
        this(serialNumber, flightHours, 0);
    }

    public GEPassport(String serialNumber) {
        this(serialNumber, 0.0);
    }

    public String toString() {
        return ENGINE_MODEL + " SN: " + getSerialNumber();
    }

}
