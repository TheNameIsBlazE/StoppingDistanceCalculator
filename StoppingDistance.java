package com.company;

import static com.company.ProjectConstants.*;

import java.lang.Math;

public class StoppingDistance implements AASHTOStoppingDist {

    // FIELDS ---------------------------------------------------
    private double stoppingDist;
    private double reactionTime;
    private double carSpeed;
    private double roadSlope;
    private double coefficientOfFriction;
    private double checkRoadSlope;

    // CHECK REACTION TIME IS USED TO ENSURE THAT THE REACTION TIME AND THE ROAD SLOPE DO NOT SUM TO LESS THAN 0


    // METHODS ----- IMPLEMENTED FROM INTERFACE

    public double stoppingDist() {

        // CALCULATION OF STOPPING DISTANCE ---------------------------------------------------------------

        stoppingDist = ((KMH$TO$MS * getReactionTime() * getCarSpeed()) + (Math.pow(getCarSpeed(), 2) / (KMH$TO$MS$SQUARED$TIMES$GRAVITY$TIMES$2 * (getCoefficientOfFriction() + getRoadSlope()))));

        // ROUNDING THE STOPPING DISTANCE -----------------------------------------------------------
        stoppingDist = Math.round(stoppingDist * 100);

        return stoppingDist / 100;
    }

    public void setReactionTime(double reactionTime) {
        this.reactionTime = reactionTime;
    }

    public double getReactionTime() {
        return reactionTime;
    }

    public void setCarSpeed(double carSpeed) {
        this.carSpeed = carSpeed;
    }

    public double getCarSpeed() {
        return carSpeed;
    }

    public void setRoadSlope(double roadSlope) {
        this.roadSlope = roadSlope / 100;
    }

    public double getRoadSlope() {
        return roadSlope;
    }

    public void setCoefficientOfFriction(double coefficientOfFriction) {
        this.coefficientOfFriction = coefficientOfFriction;
    }

    public double getCoefficientOfFriction() {
        return coefficientOfFriction;
    }

    public void setCheckRoadSlope() {

        // THE FOLLOWING CALCULATION WILL ENSURE THAT, WHEN THE USER ENTERS A VALUE
        // THE COEFFICIENT OF FRICTION + THE ROAD SLOPE IS NOT EQUAL TO 0
        // IF THIS HAPPENS, THE STOPPING DISTANCE WILL BE INFINITY, WHICH WOULD NOT MAKE SENSE
        // THIS WILL LATER BE USED AS A BOUNDARY TO ENSURE THE USER DOES NOT ENTER A VALUE THAT CAUSES THIS
        checkRoadSlope = ((Math.round((0 - getCoefficientOfFriction()) * 100)));
    }

    public double getCheckRoadSlope() {
        return checkRoadSlope;
    }

    public void halfDisplay() {
        // THIS DISPLAY WILL BE USED TO SHOW ALL STATISTICS SO THE USER CAN CONFIRM WHAT THEY WANT

        System.out.println(HALFSEPARATOR);

        // GETTING CAR SPEED -------------------------------------------------------------------------
        System.out.println("Car Speed: " + getCarSpeed() + "km/h");

        // GETTING ROAD SLOPE ------------------------------------------------------------------------
        System.out.print("Road Slope: " + (getRoadSlope() * 100) + "%");

        // IF STATEMENTS FOR ROAD SLOPE --------------------------------------------------------------------------

        // IF THE ROAD SLOPE LESS THAN ZERO, DOWNHILL WILL PRINT, ALONG WITH THE PERCENTAGE ------------------------------------------------------------------
        if (getRoadSlope() < 0) {
            System.out.println(" (" + Math.abs(getRoadSlope() * 100) + "% downhill)");

            // IF THE ROAD SLOPE IS GREATER THAN ZERO, UPHILL WILL PRINT -------------------------------
        } else if (getRoadSlope() > 0) {
            System.out.println(" uphill");

            // IF THE ROAD SLOPE IS ZERO, FLAT ROAD WILL PRINT ---------------------------------------------
        } else if (getRoadSlope() == 0) {
            System.out.println(" (flat road)");
        }

        // GETTING REACTION TIME ---------------------------------------------------------------------
        System.out.print("Reaction Time: " + getReactionTime() + " seconds");

        // IF STATEMENTS TO PRINT STATUS -------------------------------------------------------------

        if (getReactionTime() == STATUSALERT) {
            System.out.println(" (alert driver)");
        } else if (getReactionTime() == STATUSAVERAGE) {
            System.out.println(" (average driver)");
        } else if (getReactionTime() == STATUSOLDORTIRED) {
            System.out.println(" (tired or older driver)");
        } else if (getReactionTime() == STATUSINTOXICATED) {
            System.out.println(" (very elderly or intoxicated driver)");
        }

        // GETTING COEFFICIENT OF FRICTION -----------------------------------------------------------

        System.out.print("Coefficient of Friction: " + getCoefficientOfFriction());

        // IF STATEMENTS TO PRINT ROAD QUALITY -------------------------------------------------------

        if (getCoefficientOfFriction() == DRYROAD) {
            System.out.println(" (dry road)");
        } else if (getCoefficientOfFriction() == WETROAD) {
            System.out.println(" (wet road)");
        } else if (getCoefficientOfFriction() == LIGHTLYSNOWROAD) {
            System.out.println(" (road with some snow)");
        } else if (getCoefficientOfFriction() == AVERAGESNOWROAD) {
            System.out.println(" (road with a moderate amount of snow)");
        } else if (getCoefficientOfFriction() == SOMEWHATICYROAD) {
            System.out.println(" (somewhat icy road)");
        } else if (getCoefficientOfFriction() == VERYSNOWYROADORAVERAGEICYROAD) {
            System.out.println(" (very snowy road or moderately icy road)");
        } else if (getCoefficientOfFriction() == VERYICYROAD) {
            System.out.println(" (very icy road)");
        }

        System.out.println(HALFSEPARATOR);

    }

    public void display() {
        System.out.println("Your stopping distance is about " + stoppingDist() + "m");
    }
} // END stoppingDistance CLASS
