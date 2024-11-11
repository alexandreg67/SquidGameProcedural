import java.util.Random;
import java.util.Scanner;

public class Main {

    private static String heroName;
    private static short heroMarbles;
    private static short heroMalus;
    private static short heroBonus;

    private static short nbrEncounters;


    private static final String[][] listPlayers =
            {
                    {"Seong Gi-Hun", "10", "3", "1"},
                    {"Kang Sae-byeok", "15", "2", "2"},
                    {"Cho Sang-woo", "20", "1", "3"}
            };

    private static final String[][] listEnemies =
            {
                    {"Tao Huang", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Su He", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Tan Ju", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Shao Hyun-su", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Xing Kang", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Soo-Yun Chan", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Kang Liuxian", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Zhen Xiang", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Ding Bao", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Zhong Lei", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Xie Cai", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Tsing Tsao", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Cho-Hea Led", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Kim Nam-Joon", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Jeon Jung-Kook", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Ae-Cha Chul-Moo", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Sundong Xionghuo", randomNumber(1, 20), randomNumber(40, 90)},
                    {"Li Ha-Neul", randomNumber(1, 20), randomNumber(40, 90)},
            };

    private static final String[][] listLevels =
            {
                    {"Facile", "Moyen", "Impossible"},
                    {"4", "12", "18"}
            };

    public static void main(String[] args) {

        presentHeroes(listPlayers);
        presentEnemies(listEnemies);
        String[] heroChoice = listPlayers[readUserInput("Choisissez un personnage ! Seong Gi-hun (0) - "
                + "Kang Sae-byeok (1) - Cho Sang-woo (2)", 0, 2)];

        heroName = heroChoice[0];
        heroMarbles = Short.parseShort(heroChoice[1]);
        heroMalus = Short.parseShort(heroChoice[2]);
        heroBonus = Short.parseShort(heroChoice[3]);

        nbrEncounters = Short.parseShort(listLevels[1][readUserInput("Choisissez une difficulté : Facile (0) - "
                + "Moyen (1) - Impossible (2)", 0,2)]);

        console("Vous débutez le jeu avec " + heroName + " avec " + heroMarbles + " billes, un bonus de "
            + heroBonus + " bille(s) et un malus de " + heroMalus + " bille(s) !");

        console("Vous devrez affronter " + nbrEncounters + "ennemis pour gagner la partie ! Bonne chance !");

        startFight();
    }

    private static String randomNumber(int min, int max) {
        Random random = new Random();
        return Integer.toString(random.nextInt(max - min + 1) + min);
    }

    private static void presentHeroes(String[][] listPlayers) {

        console("------------------------------------");

        for (int i = 0; i < listPlayers.length; i++) {
            console(listPlayers[i][0] + " possède "
                    + listPlayers[i][1] + " billes "
                    + "avec un mallus de "
                    + listPlayers[i][2] + " billes en cas de défaite"
                    + " et un bonus de "
                    + listPlayers[i][3]
                    + " billes en cas de voictoire !");
        }

        console("------------------------------------");


    }

    private static void presentEnemies(String[][] listEnemies) {

        console("------------------------------------");

        for (int i = 0; i < listEnemies.length; i++) {
            console(listEnemies[i][0] + " possède "
                    + listEnemies[i][1] + " billes "
                    + "et est agé de "
                    + listEnemies[i][2] + " ans");
        }

        console("------------------------------------");
    }

    private static short readUserInput(String prompt, int min, int max) {

        Scanner scanner = new Scanner(System.in);
        short choice;

        while (true) {
            console(prompt);
            choice = scanner.nextShort();

            if (choice >= min && choice <= max) {
                break;
            }

            console("Veuillez entrer un chiffre entre " + min + " et " + max);
        }
        return choice;
    }

    private static void console(String msg) {
        System.out.println(msg);
    }

    private static void handleEncouter(short userAnswer, short enemyMarbles, short enemyIndex) {

    }

    private static void startFight() {

    }
}