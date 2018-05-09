package com.learning;

public class Batman {

    private final CriminalDatabase criminalDatabase;
    private boolean crimeTakingPlace;
    private String criminalName = "";
    private int crimesSolved = 0;

    public Batman(CriminalDatabase criminalDatabase){
        this.criminalDatabase = criminalDatabase;
    }

    public void fightCrime(){

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
            if(criminalInformation!=null && criminalInformation.length()>0){ solveCrime();
            } else {
                gatherInformation();
                solveCrime();
            }
        }
    }

    private void speakToChiefOfPolice() {
        System.out.println("I'm batman");
        //Make Nemesis get used here
        //Put the crimeTakingPlace variable into get method in the nemesis Class
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
