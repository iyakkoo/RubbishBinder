package sorter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Sorter {
    private Scanner sc1 = new Scanner(System.in);
    private Scanner sc2 = new Scanner(System.in);
    private Rubbish rubbish = new Rubbish();
    //tymczasowa implementacja bazy danych
    private Map<String, RubbishType> rubbishDatabase = new HashMap<>();

    void start() {
        sorterLogic();
    }

    private void sorterLogic() {
        showMessage(3);
        getNewRubbish();
        putRubbishToSorter();
        showMessage(4);
        start();
    }

    private void getNewRubbish() {
        rubbish.setName(sc1.nextLine());
    }

    private void putRubbishToSorter() {
        if (isInDatabase()) { //usunąć metodę isInDatabase w obecnej postaci, wykorzystać budowę metody getThatRubbishType
            getThatRubbishType();
        } else {
            addNewRubbish();
        }
    }

    private boolean isInDatabase() {
        return rubbishDatabase.containsKey(rubbish.getName());
    }

    private boolean getThatRubbishType() {
        //tymczasowa implementacja poboru typu z bazy danych i symulowany monit o powodzeniu akcji
        rubbishDatabase.get(rubbish.getName());
        return true;
    }

    private void addNewRubbish() {
        showMessage(2);
        showMessage(0);
        setRubbishTypeForNewRubbish();
        addThisRubbishToDatabase();
        showMessage(1);
    }

    private boolean addThisRubbishToDatabase() {
        //tymczasowa implementacja dodawania elementu do bazy danych i zwracania informacji o powodzeniu akcji
        rubbishDatabase.put(rubbish.getName(), rubbish.getRubbishType());
        return true;
    }

    private void showMessage(int messageId) {
        if (messageId == 0) {
            System.out.println("Nastąpi dodanie nowego elementu do pamięci \n" +
                    "Wpisz: \n" +
                    "0 - plastik \n" +
                    "1 - papier \n" +
                    "2 - szkło \n" +
                    "3 - metal \n" +
                    "4 - odpady zmieszane");
        } else if (messageId == 1) {
            System.out.println("Dodałeś do bazy " + rubbish.getName() + " jako " +
                    rubbish.getRubbishType().toString().toLowerCase());
        } else if (messageId == 2) {
            System.out.println("Nie znaleziono tego elementu w bazie");
        } else if (messageId == 3) {
            System.out.println("Podaj nazwę odpadu");
        } else if (messageId == 4) {
            System.out.println("Twój odpad to: " + rubbish.getName() + "\n" + "to jest: " +
                    rubbish.getRubbishType().toString().toLowerCase());
        } else {
            System.out.println("niepoprawnie dobrana wiadomość");
        }
    }

    private void setRubbishTypeForNewRubbish() {
        rubbish.setRubbishType(chooseType());
        if (rubbish.getRubbishType() == null) {
            setRubbishTypeForNewRubbish();
        }
    }

    private RubbishType chooseType() {
        switch (sc2.nextInt()) {
            case 0:
                return RubbishType.PLASTIK;
            case 1:
                return RubbishType.PAPIER;
            case 2:
                return RubbishType.SZKŁO;
            case 3:
                return RubbishType.METAL;
            case 4:
                return RubbishType.MIESZANE;
            default:
                System.out.println("Zła komenda, ponów próbę");
                return null;
        }
    }
}
