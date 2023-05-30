package com.company;

import java.util.Scanner;

import static com.company.ProjectConstants.*;

public class Main {

    // SPEED ERROR --------------------------------------------------------------------------------------

    public static void speedError() {
        System.out.println(SEPARATOR);
        System.out.println("\t\tINPUT ERROR: Speed must be GREATER THAN or EQUAL TO 0km/h and LESS THAN 565km/h!");
    } // END speedError METHOD

    // roadSlopeError METHOD ----------------------------------------------------------------------------

    public static void roadSlopeError() {
        System.out.println(SEPARATOR);
        System.out.println("\t\tINPUT ERROR: Input must be set to FLAT or SLOPED!");
    } // END roadSlopeError METHOD

    // ReactionTimeError METHOD -------------------------------------------------------------------------

    public static void reactionTimeError() {
        System.out.println(SEPARATOR);
        System.out.println("\t\tINPUT ERROR: Response must be an INTEGER between 1 and 4!");
    } // END reactionTimeError METHOD

    // CoefficientOfFrictionError METHOD -------------------------------------------------------------------------

    public static void coefficientOfFrictionError() {
        System.out.println(SEPARATOR);
        System.out.println("\t\tINPUT ERROR: Response must be an INTEGER between 1 and 7!");
    } // END reactionTimeError METHOD

    // ResponseError METHOD -------------------------------------------------------------------------

    public static void responseError() {
        System.out.println(SEPARATOR);
        System.out.println("\t\tINPUT ERROR: Response must be YES or NO!");
    } // END ResponseError METHOD

    // progInfo METHOD ----------------------------------------------------------------------------------

    public static void progInfo() {
        System.out.println(SEPARATOR);
        System.out.println("Hello!");
        System.out.println("This program will use your car speed, reaction time, road slope, and road conditions to calculate your car's stopping distance!");
        System.out.println("It will then output these results for you!");
    } // END progInfo METHOD

    // knownErrors METHOD ----------------------------------------------------------------------------------

    public static void knownErrors() {

        // THE FOLLOWING ARE KNOWN ISSUES WITH THE PROGRAM
        System.out.println(SEPARATOR);
        System.out.println("KNOWN PROGRAM ERRORS AND NOTES:");

        // ERROR 001 - JAVA ISSUE WITH DOUBLE PRECISION VALUES NOT DISPLAYING CORRECTLY AFTER CALCULATIONS IN SOME INSTANCES

        System.out.println(MINORSEPARATOR);
        System.out.println("ERROR 001:");
        System.out.println("\tIn confirmation messages, the program may display values extremely close to what was entered (eg. 54.9999999999 instead of 55.0).");
        System.out.println("\tPlease disregard this.  If the program displays information of this nature,");
        System.out.println("\tplease proceed with the calculations if it is close to what you entered.");

        // ERROR 002 - JAVA ISSUE WITH .CONTAINS STATEMENTS

        System.out.println(MINORSEPARATOR);
        System.out.println("ERROR 002:");
        System.out.println("\tIf the program asks for a word, and the word is surrounded by other characters (eg. ggyesgg),");
        System.out.println("\tThe program will proceed as if only the word was entered.");

        // ERROR 003 - PRIORITIZATION OF YES/NO IN THE EVENT THAT BOTH WORDS ARE ENTERED IN ONE STRING

        System.out.println(MINORSEPARATOR);
        System.out.println("ERROR 003:");
        System.out.println("\tIf the program asks for a yes or no answer and both words are entered, yes will be prioritized.");

        // ERROR 004 - PRIORITIZATION OF FLAT/SLOPED IN THE EVENT THAT BOTH WORDS ARE ENTERED IN ONE STRING

        System.out.println(MINORSEPARATOR);
        System.out.println("ERROR 004:");
        System.out.println("\tWhen the program asks if the road is flat or sloped, if both words are entered as an answer, flat will be prioritized.");

        // ERROR 005 - JAVA ISSUE WITH THE SETTING OF DOUBLE PRECISION VALUES

        System.out.println(MINORSEPARATOR);
        System.out.println("ERROR 005:");
        System.out.println("\tThe program can hold, at most, 16-17 decimal places.");
        System.out.println("\tValues will be rounded after this point.");

        // NOTE 001 - WORDS FOLLOWING RESPONSES

        System.out.println(MINORSEPARATOR);
        System.out.println("NOTE 001:");
        System.out.println("\tIf a word or additional value follows a response, the program will only accept the first response.");
    } // end knownErrors Method

    public static void main(String[] args) {

        // VARIABLES --------------------------------------------------------------------

        // BOOLEANS ------------------------------------------------------------------

        boolean initialResponse;
        boolean checkDone;
        boolean done;
        boolean roadSlopeInfo;
        boolean roadSlopeSet;

        // STRINGS --------------------------------------------------------------------

        String response;
        String confirmInformation;
        String roadSlopeType;
        String garbage;

        // INTEGERS --------------------------------------------------------------------

        int option;

        // SCANNER ----------------------------------------------------------------------

        Scanner s = new Scanner(System.in);

        // OBJECTS ----------------------------------------------------------------------

        StoppingDistance stoppingDistance = new StoppingDistance();

        // START -------------------------------------------------------------------------

        progInfo();
        knownErrors();

        // ASKING THE USER IF THEY WOULD LIKE TO CONTINUE --------------------------------

        do {
            System.out.println(SEPARATOR);
            initialResponse = false;
            System.out.println("Would you like enter new statistics? (yes/no)");
            response = s.nextLine();

            // IF THE USER SAYS YES -----------------------------------------------------------------------

            if (response.toUpperCase().contains("YES")) {

                // DO LOOP FOR THE FINAL CHECK, ASKING THEM IF THEIR INFO IS CORRECT -----------------------

                do {

                    // THIS LOOP WILL NOT BE USED UNTIL FAR INTO THE PROGRAM (FOR THE FINAL CHECK)

                    checkDone = false;

                    // MAIN PROGRAM CODE BEGINS HERE -----------------------------------------
                    do {
                        done = false;
                        System.out.println(SEPARATOR);

                        // SETTING CAR SPEED -----------------------------------------------------------------

                        System.out.println("Please enter your car's speed in kilometers per hour (km/h)");
                        System.out.println("NOTE: Do not include the km/h symbol in your response");
                        System.out.println("NOTE: Speed must be less than " + MINIMUMSPEED + "km/h and greater than " + MAXIMUMSPEED + "km/h");

                        // IF THE RESPONSE CONTAINS A DOUBLE -----------------------------------------------

                        if (s.hasNextDouble()) {
                            stoppingDistance.setCarSpeed(s.nextDouble());

                            // CHECK WITHIN THE PROVIDED SPEED BOUNDS (0 AND 565, THE LATTER BEING ABOUT THE MAXIMUM SPEED OF A CAR) --------
                            if (stoppingDistance.getCarSpeed() < MINIMUMSPEED || stoppingDistance.getCarSpeed() > MAXIMUMSPEED) {
                                speedError();

                                // IF THE RESPONSE CLEARS ALL CHECKS -------------------------------------------

                            } else {
                                done = true;
                                System.out.println(SEPARATOR);
                                System.out.println("Car speed successfully set to " + stoppingDistance.getCarSpeed() + "km/h.");
                            }

                            // IF THE USER DOES NOT ENTER A DOUBLE PRECISION VALUE FOR THE CAR SPEED ---------------------------------

                        } else {
                            speedError();
                            garbage = s.nextLine();
                        }
                    } while (!done);

                    garbage = s.nextLine();

                    // SETTING THE REACTION TIME -----------------------------------------------------------------------

                    do {
                        done = false;
                        System.out.println(SEPARATOR);
                        System.out.println("Please enter the corresponding integer for a reaction time:");
                        System.out.println("1. Reaction time of 1 second - fully alert, responsible, experienced driver");
                        System.out.println("2. Reaction time of 1.5 seconds - driver of average skill");
                        System.out.println("3. Reaction time of 2 seconds - tired or older driver");
                        System.out.println("4. Reaction time of 2.5 second - Very elderly or intoxicated");

                        // SWITCH CASE FOR DIFFERENT REACTION TIMES -------------------------------------------

                        if (s.hasNextInt()) {
                            option = s.nextInt();

                            switch (option) {

                                // IF REACTION TIME IS SET TO ALERT AND RESPONSIBLE (1) ------------------------

                                case 1: {
                                    stoppingDistance.setReactionTime(STATUSALERT);
                                    done = true;
                                    break;
                                }

                                // IF REACTION TIME IS AVERAGE (1.5/2) ------------------------------------------

                                case 2: {
                                    stoppingDistance.setReactionTime(STATUSAVERAGE);
                                    done = true;
                                    break;
                                }

                                // IF REACTION TIME IS SET TO TIRED OR OLDER (2/3) -------------------------------

                                case 3: {
                                    stoppingDistance.setReactionTime(STATUSOLDORTIRED);
                                    done = true;
                                    break;
                                }

                                // IF REACTION TIME IS SET TO VERY ELDERLY OR INTOXICATED ------------------------

                                case 4: {
                                    stoppingDistance.setReactionTime(STATUSINTOXICATED);
                                    done = true;
                                    break;
                                }

                                // IF AN INTEGER THAT IS NOT FROM 1-4 IS ENTERED -----------------------------------

                                default: {
                                    reactionTimeError();
                                    break;
                                }

                            } // END SWITCH STATEMENT

                            // IF AN INTEGER IS NOT ENTERED WHEN ASKING FOR THE REACTION TIME ---------------------

                        } else {
                            reactionTimeError();
                            garbage = s.nextLine();
                        }

                    } while (!done);

                    // PRINTING A SUCCESS STATEMENT ------------------------------------------------------------------

                    System.out.println(SEPARATOR);
                    System.out.println("Reaction time successfully set to " + stoppingDistance.getReactionTime() + " seconds.");

                    // SETTING THE COEFFICIENT OF FRICTION -----------------------------------------------------
                    garbage = s.nextLine();

                    do {

                        // CASE STATEMENT MENU FOR COEFFICIENTS OF FRICTION -------------------------------------

                        done = false;
                        System.out.println(SEPARATOR);
                        System.out.println("Please select the type of ground you are driving on:");
                        System.out.println("1. Dry road - Coefficient of Friction of 0.82");
                        System.out.println("2. Wet road - Coefficient of Friction of 0.55");
                        System.out.println("3. Road with some snow - Coefficient of Friction of 0.5");
                        System.out.println("4. Road with a moderate amount of snow - Coefficient of Friction of 0.35");
                        System.out.println("5. Road with some ice - Coefficient of Friction of 0.3");
                        System.out.println("6. Very snowy road or moderately icy road - Coefficient of Friction of 0.2");
                        System.out.println("7. Very icy road - Coefficient of Friction of 0.1");

                        // IF USER ENTERS AN INTEGER --------------------------------------------------

                        if (s.hasNextInt()) {
                            option = s.nextInt();

                            switch (option) {

                                // DRY ROAD ------------------------------------------------------------

                                case 1: {
                                    stoppingDistance.setCoefficientOfFriction(DRYROAD);
                                    done = true;
                                    break;
                                }

                                // WET ROAD ------------------------------------------------------------

                                case 2: {
                                    stoppingDistance.setCoefficientOfFriction(WETROAD);
                                    done = true;
                                    break;
                                }

                                // LIGHTLY SNOW ROAD ------------------------------------------------------------

                                case 3: {
                                    stoppingDistance.setCoefficientOfFriction(LIGHTLYSNOWROAD);
                                    done = true;
                                    break;
                                }

                                // AVERAGE SNOW ROAD ------------------------------------------------------------

                                case 4: {
                                    stoppingDistance.setCoefficientOfFriction(AVERAGESNOWROAD);
                                    done = true;
                                    break;
                                }

                                // SOMEWHAT ICY ROAD ------------------------------------------------------------

                                case 5: {
                                    stoppingDistance.setCoefficientOfFriction(SOMEWHATICYROAD);
                                    done = true;
                                    break;
                                }

                                // VERY SNOWY OR AVERAGE ICY ROAD ------------------------------------------------------------

                                case 6: {
                                    stoppingDistance.setCoefficientOfFriction(VERYSNOWYROADORAVERAGEICYROAD);
                                    done = true;
                                    break;
                                }

                                // VERY SNOWY ROAD ------------------------------------------------------------

                                case 7: {
                                    stoppingDistance.setCoefficientOfFriction(VERYICYROAD);
                                    done = true;
                                    break;
                                }

                                // IF AN INTEGER FROM 1-7 IS NOT ENTERED -------------------------------------

                                default: {
                                    coefficientOfFrictionError();
                                    break;
                                }

                            } // END SWITCH STATEMENT


                            // IF USER ENTERS GARBAGE WHEN ASKING FOR THE COEFFICIENT OF FRICTION ----------

                        } else {
                            coefficientOfFrictionError();
                            garbage = s.nextLine();
                        }


                    } while (!done);

                    // PRINTING A SUCCESS STATEMENT -----------------------------------------------------

                    System.out.println(SEPARATOR);
                    System.out.println("Coefficient of friction successfully set to " + stoppingDistance.getCoefficientOfFriction() + ".");

                    garbage = s.nextLine();

                    // SETTING THE SLOPE (GRADE) OF THE ROAD ------------------------------------------

                    // ERROR CHECKING FOR THE COEFFICIENT OF FRICTION AND ROADSLOPE ------------------

                    // SET THE CHECK REACTION TIME VARIABLE (WHAT THE REACTION TIME MUST BE GREATER THAN) TO THE NEEDED VALUE

                    stoppingDistance.setCheckRoadSlope();

                    // ASKING THE USER IF THE ROAD SLOPE IS SLOPED FLAT -------------------------------------

                    do {
                        roadSlopeInfo = false;
                        roadSlopeSet = false;
                        System.out.println(SEPARATOR);
                        System.out.println("Is the road flat or sloped?");
                        roadSlopeType = s.nextLine();

                        // IF THE USER SAYS THE ROAD IS FLAT --------------------------------------------------------------

                        if (roadSlopeType.toUpperCase().contains("FLAT")) {

                            // THE VARIABLE roadSlopeSet WILL BE USED TO SKIP GIVING A SLOPE IF THE USER ENTERS "FLAT" AS THE HILL

                            roadSlopeSet = true;
                            roadSlopeInfo = true;
                            stoppingDistance.setRoadSlope(FLATROAD);
                            System.out.println(SEPARATOR);
                            System.out.println("Road slope successfully set to flat (0% incline).");

                            // IF THE USER SAYS THE ROAD IS SLOPED ----------------------------------------------------------

                        } else if (roadSlopeType.toUpperCase().contains("SLOPED")) {
                            roadSlopeInfo = true;

                            // IF THE USER DOES NOT ENTER SLOPE OR FLAT FOR THIS QUESTION -------------------------------

                        } else {
                            roadSlopeError();
                        }

                    } while (!roadSlopeInfo);

                    // IF THE USER NEEDS TO ENTER A ROAD SLOPE -----------------------------------------------------------------

                    if (!roadSlopeSet) {

                        do {
                            done = false;
                            System.out.println(SEPARATOR);

                            // SETTING THE ROAD SLOPE -----------------------------------------------------------------

                            System.out.println("Please enter the slope of the hill as a percentage (do NOT include the percent sign)");
                            System.out.println("NOTE: Enter a positive slope for a positive percentage and a negative slope for a negative percentage");
                            System.out.println("NOTE: Percentage must be between " + MINIMUMPOSSIBLEROADSLOPE + "% and " + MAXPOSSIBLEROADSLOPE + "%");
                            System.out.println("NOTE: Calculation will  fail if a road slope of " + stoppingDistance.getCheckRoadSlope() + "%, or slightly less than this, is entered.");

                            // IF STATEMENT FOR TYPE CHECKING ----------------------------------------------------

                            if (s.hasNextDouble()) {
                                stoppingDistance.setRoadSlope(s.nextDouble());

                                // CHECKING IF THE ROAD SLOPE FITS WITHIN THE NEEDED BOUNDARIES (WHAT THE AASHTO CALCULATOR CAN ACCEPT) ---------------------

                                if ((stoppingDistance.getRoadSlope() * 100) < MINIMUMPOSSIBLEROADSLOPE || (stoppingDistance.getRoadSlope() * 100) > MAXPOSSIBLEROADSLOPE) {
                                    System.out.println(SEPARATOR);
                                    System.out.println("\t\tINPUT ERROR: Road slope must be an INTEGER or a DECIMAL between " + MINIMUMPOSSIBLEROADSLOPE + "% and " + MAXPOSSIBLEROADSLOPE + "%");

                                    // IF IT DOES NOT, NOW CHECK THE OTHER TWO RESTRICTIONS -------------------------------------
                                    // IF STOPPING DISTANCE IS NEGATIVE
                                    // IF THE ROAD SLOPE, WHEN ADDED TO THE COEFFICIENT OF FRICTION, EQUALS 0

                                } else {

                                    // IF, WHEN CALCULATED, THE STOPPING DISTANCE IS A NEGATIVE OR THE ROAD SLOPE IS EQUAL TO WHAT IT CANNOT BE (ROAD SLOPE + COEFFICIENT OF FRICTION CAN'T BE 0) -------------------------

                                    if (stoppingDistance.stoppingDist() < 0 || (stoppingDistance.getRoadSlope() * 100) == stoppingDistance.getCheckRoadSlope()) {
                                        System.out.println(SEPARATOR);
                                        System.out.println("\t\tINPUT ERROR: The values that you have entered yield a NEGATIVE or UNDEFINED answer.");
                                        System.out.println("\t\tA road of these conditions would not be safe to drive on.");
                                        System.out.println("\t\tPlease enter a road slope that will result in a non-negative answer.");
                                        System.out.println("\t\tNOTE: Road slopes yielding this answer are generally equal to or slightly less than " + stoppingDistance.getCheckRoadSlope() + "%.");
                                        garbage = s.nextLine();

                                        // IF IT PASSES THESE CHECKS, THEN EVERYTHING WORKS ---------------------
                                    } else {

                                        // SUCCESS MESSAGE -------------------------------------------------------------------

                                        System.out.println(SEPARATOR);
                                        System.out.println("Road slope successfully set to " + stoppingDistance.getRoadSlope() * 100 + "%.");
                                        done = true;
                                    }
                                }

                                // IF THE USER DOES NOT ENTER A DOUBLE PRECISION VALUE FOR THE ROAD SLOPE -------------------

                            } else {
                                System.out.println(SEPARATOR);
                                System.out.println("\t\tINPUT ERROR: Road slope must be an INTEGER or a DECIMAL between " + stoppingDistance.getCheckRoadSlope() + "% and 4500%!");
                                garbage = s.nextLine();

                            }
                        } while (!done);

                        garbage = s.nextLine();
                    }

                    // CONFIRMING IF THE ENTERED INFORMATION IS CORRECT -------------------------------

                    do {
                        done = false;
                        System.out.println(SEPARATOR);
                        System.out.println("You have entered the following data for your car:");
                        stoppingDistance.halfDisplay();
                        System.out.println("Is this information correct?");
                        confirmInformation = s.nextLine();

                        // IF THE USER ENTERS YES TO CONFIRM THEIR INFORMATION IS CORRECT -------------------

                        if (confirmInformation.toUpperCase().contains("YES")) {
                            System.out.println(SEPARATOR);

                            // DONE WILL TAKE THE USER OUT OF THE CHECKING YES/NO DO LOOP
                            // CHECKDONE WILL TAKE THE USER OUT OF THE CONFIRMATION DO LOOP

                            done = true;
                            checkDone = true;

                            // CALCULATIONS AND DISPLAYING FINAL ANSWER ----------------------------------------------------------------
                            stoppingDistance.display();

                            // IF THE USER SAYS THE INFORMATION THEY ENTERED IS INCORRECT ---------------------------

                        } else if (confirmInformation.toUpperCase().contains("NO")) {
                            System.out.println(SEPARATOR);
                            System.out.println("Returning to the beginning of the program.");
                            System.out.println("Please enter the correct information.");
                            done = true;

                            // IF THE USER DOES NOT ENTER YES/NO WHEN CONFIRMING THE STATISTICS ---------------------------

                        } else {
                            responseError();
                        }

                    } while (!done);

                } while (!checkDone);

                // IF THE FIRST RESPONSE (TO SEE IF THEY WANT TO ENTER STATISTICS) IS NO ---------------------

            } else if (response.toUpperCase().contains("NO")) {
                System.out.println(SEPARATOR);
                System.out.println("Thank you for using this program!");
                System.out.println("Have a good day! :)");
                System.out.println(SEPARATOR);
                initialResponse = true;

                // IF THE USER ENTERS GARBAGE FOR THE FIRST RESPONSE ------------------------------------------

            } else {
                responseError();
            }

        } while (!initialResponse);


    } // END MAIN METHOD
} // END MAIN CLASS
