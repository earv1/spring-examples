package com.learning;

public class Batman {

    private CriminalDatabase criminalDatabase;
    private boolean crimeTakingPlace;
    private String criminalName = "";
    private int crimesSolved = 0;

    public Batman(){
        criminalDatabase = new CriminalDatabase();
    }

    public void fightCrime(){

        //do pushups
        for(int x = 0; x<1000; x++){
            if(x%100 == 0){
                System.out.println("I'm batman");
            }
        }

        speakToChiefOfPolice();

        if(crimeTakingPlace) {
            String criminalInformation = criminalDatabase.fetchInformation(criminalName);
            if(criminalInformation!=null && criminalInformation.length()>0){
                solveCrime();
            } else {
                gatherInformation();
                solveCrime();
            }
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
        System.out.println("shhhh i'm batman");
        return "ITS THE JOKER";
    }


    public int getCrimesSolved() {
        return crimesSolved;
    }

    public void setCrimesSolved(int crimesSolved) {
        this.crimesSolved = crimesSolved;
    }
}
