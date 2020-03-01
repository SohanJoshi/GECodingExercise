package com.ge.exercise4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class GEEngine {
    private static final Logger logger = LogManager.getLogger(GEEngine.class);

    private final String serialNumber;

	private final int maxNumRebuilds;
    private final double flightHoursBeforeRebuild;
    private final double dryWeight;
    private final double wetWeight;
    private final double takeoffThrust;

    private double flightHours;
    private int numRebuilds;

    public GEEngine(String serialNumber, 
    		double flightHours, int numRebuilds, int maxNumRebuilds,
			double flightHoursBeforeRebuild, double dryWeight, 
			double wetWeight, double takeoffThrust) {
		super();
		this.serialNumber = serialNumber;
		this.flightHours = flightHours;
		this.numRebuilds = numRebuilds;
		this.maxNumRebuilds = maxNumRebuilds;
		this.flightHoursBeforeRebuild = flightHoursBeforeRebuild;
		this.dryWeight = dryWeight;
		this.wetWeight = wetWeight;
		this.takeoffThrust = takeoffThrust;
	}


    public double getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(double flightHours) {
        this.flightHours = flightHours;
    }

    public double thrustToWeightRatio() {
        return takeoffThrust / dryWeight;
    }

    public int getNumRebuilds() {
		return numRebuilds;
	}

	public void setNumRebuilds(int numRebuilds) {
		this.numRebuilds = numRebuilds;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public int getMaxNumRebuilds() {
		return maxNumRebuilds;
	}

	public double getFlightHoursBeforeRebuild() {
		return flightHoursBeforeRebuild;
	}

	public double getDryWeight() {
		return dryWeight;
	}

	public double getWetWeight() {
		return wetWeight;
	}

	public double getTakeoffThrust() {
		return takeoffThrust;
	}
    
	public double getHoursBeforeRebuild() {
		return this.flightHours - (this.numRebuilds * this.flightHoursBeforeRebuild);
	}
	
	public double getRemainingServiceLife() {
		double totalLife = this.maxNumRebuilds * this.flightHoursBeforeRebuild;
		if(totalLife == 0.0)
			return 0.0;
		
		return totalLife / flightHours;
	}
}
