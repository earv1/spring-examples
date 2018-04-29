package com.learning.examples.libraries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Batman {

    @Autowired
    private final CriminalDatabase criminalDatabase;

    private boolean crimeTakingPlace;
    private String criminalName = "";
    private int crimesSolved = 0;

    public enum BroodLevel {
        High("I'm the hero this city needs, not deserves"),
        Medium("I'm batman"),
        Low("I'm batman"),
        Happy("Tralalalala");


        String broodSentence;
        BroodLevel(String broodSentence){
            this.broodSentence = broodSentence;
        }

        public String getBroodSentence() {
            return broodSentence;
        }
    }

    public Batman(CriminalDatabase criminalDatabase){
        this.criminalDatabase = criminalDatabase;
    }

    public String fightCrime(BroodLevel broodLevel){

        //Do pushups
        for(int x = 0; x<1000; x++){
            if(x%100 == 0){
                System.out.println("I'm batman");
            }
        }

        //TODO
        //Take this out and put it into a class, then inject this class just like we injected CriminalDatabase.
        //Put in a check to see if the chief of police has been spoken to.
        speakToChiefOfPolice();

        if(crimeTakingPlace) {
            String criminalInformation = criminalDatabase.fetchInformation(criminalName);
            if(criminalInformation!=null && criminalInformation.length()>0){
                solveCrime();
                return broodLevel.getBroodSentence();
            } else {
                gatherInformation();
                solveCrime();
                return "It was tough \n" +
                        broodLevel.getBroodSentence();
            }
        } else {
            return "Time for a vacation";
        }
    }

    private void speakToChiefOfPolice() {
        System.out.println("I'm batman");
        crimeTakingPlace = true;
        criminalName = "joker";
    }

    private void solveCrime() {
        System.out.println("I'm batman");
        crimeTakingPlace = false;
        criminalName = "";
        this.crimesSolved++;

    }

    private String gatherInformation() {
        System.out.println("Shhhh I'm batman");
        return "ITS THE JOKER";
    }

    public int getCrimesSolved() {
        return crimesSolved;
    }

    public void setCrimesSolved(int crimesSolved) {
        this.crimesSolved = crimesSolved;
    }
}
