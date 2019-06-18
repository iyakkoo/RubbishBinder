package sorter;

import java.util.Scanner;

public class Sorter {
    private Rubbish rubbish = new Rubbish(writeRubbishName());

    public void start(){
        putRubbishToSorter();
    }

    private String putRubbishToSorter() {
        if(isInDatabase()){
            lookForRubbishType();
        } else {
            setRubbishTypeForNewRubbish();
        }
        return rubbish.getName();
    }

    private RubbishType setRubbishTypeForNewRubbish() {
        return null;
    }

    private RubbishType lookForRubbishType() {
        return null;
    }

    private String writeRubbishName() {
        Scanner sc = new Scanner(System.in);
        String rubbishName = sc.nextLine();
        return rubbishName;
    }

    protected boolean isInDatabase(){
        return true;
    }

}
