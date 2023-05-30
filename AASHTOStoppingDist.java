package com.company;

public interface AASHTOStoppingDist {

    // there is no code in an interface
    // you just describe the contract with the person who implements the interface

    // FOR THE CONSTANTS CLASS, ASK ROAD TYPE, THEN IF IT'S AVERAGE, GOOD OR BAD AND HAVE MANY COEFFICIENTS OF FRICTION (EG.FOR BLACK ICE OR SNOW)

    // CONSTANTS

    int KMH$TO$MS$SQUARED$TIMES$GRAVITY$TIMES$2 = 254;
    double KMH$TO$MS = 0.278;

    // METHODS

    double stoppingDist();
    void setReactionTime(double reactionTime);
    double getReactionTime();
    void setCarSpeed(double carSpeed);
    double getCarSpeed();
    void setRoadSlope(double roadSlope);
    double getRoadSlope();
    void setCoefficientOfFriction(double coefficientOfFriction);
    double getCoefficientOfFriction();
    void setCheckRoadSlope();
    double getCheckRoadSlope();
    void halfDisplay();
    void display();


}
