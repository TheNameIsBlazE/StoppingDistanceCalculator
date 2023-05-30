package com.company;

public class ProjectConstants {

    // STRINGS
    public static final String SEPARATOR = "======================================================================================================================================================";
    public static final String HALFSEPARATOR = "==================================================================";
    public static final String MINORSEPARATOR = "=====================";

    // SPEED CONSTANTS
    public static final int MINIMUMSPEED = 0;
    public static final int MAXIMUMSPEED = 565;

    // The fastest a car can go is slighly below this.

    // CONSTANTS FOR ROAD SLOPE
    public static final int MAXPOSSIBLEROADSLOPE = 4500;
    public static final int MINIMUMPOSSIBLEROADSLOPE = -4500;
    public static final int FLATROAD = 0;

    // CONSTANTS FOR REACTION TIME
    public static final double STATUSALERT = 1;
    public static final double STATUSAVERAGE = 1.5;
    public static final double STATUSOLDORTIRED = 2;
    public static final double STATUSINTOXICATED = 2.5;

    // CONSTANTS FOR COEFFICIENTS OF KINETIC FRICTION
    public static final double DRYROAD = 0.82;
    public static final double WETROAD = 0.55;
    public static final double LIGHTLYSNOWROAD = 0.5;
    public static final double AVERAGESNOWROAD = 0.35;
    public static final double SOMEWHATICYROAD = 0.3;
    public static final double VERYSNOWYROADORAVERAGEICYROAD = 0.2;
    public static final double VERYICYROAD = 0.1;

    private ProjectConstants() {
        throw new AssertionError();
    }
}
