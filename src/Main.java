import java.util.Random;
import java.util.Scanner;

public class Main {

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

        presentHeroes();
        presentEnemies();
        String[] heroChoice = listPlayers[readUserInput("Choisissez un personnage ! Seong Gi-hun (0) - "
                + "Kang Sae-byeok (1) - Cho Sang-woo (2)", 2)];

        String heroName = heroChoice[0];
        heroMarbles = Short.parseShort(heroChoice[1]);
        heroMalus = Short.parseShort(heroChoice[2]);
        heroBonus = Short.parseShort(heroChoice[3]);

        nbrEncounters = Short.parseShort(listLevels[1][readUserInput("Choisissez une difficulté : Facile (0) - "
                + "Moyen (1) - Impossible (2)", 2)]);

        console("Vous débutez le jeu avec " + heroName + " avec " + heroMarbles + " billes, un bonus de "
                + heroBonus + " bille(s) et un malus de " + heroMalus + " bille(s) !");

        console("Vous devrez affronter " + nbrEncounters + " ennemis pour gagner la partie ! Bonne chance !");

        startFight();
    }

    private static String randomNumber(int min, int max) {
        Random random = new Random();
        return Integer.toString(random.nextInt(max - min + 1) + min);
    }

    private static void presentHeroes() {

        console("------------------------------------");

        for (int i = 0; i < Main.listPlayers.length; i++) {
            console(Main.listPlayers[i][0] + " possède "
                    + Main.listPlayers[i][1] + " billes "
                    + "avec un mallus de "
                    + Main.listPlayers[i][2] + " billes en cas de défaite"
                    + " et un bonus de "
                    + Main.listPlayers[i][3]
                    + " billes en cas de voictoire !");
        }

        console("------------------------------------");


    }

    private static void presentEnemies() {

        console("------------------------------------");

        for (int i = 0; i < Main.listEnemies.length; i++) {
            console(Main.listEnemies[i][0]
                    + " est agé de "
                    + Main.listEnemies[i][2] + " ans");
        }

        console("------------------------------------");
    }

    private static short readUserInput(String prompt, int max) {

        Scanner scanner = new Scanner(System.in);
        short choice;

        while (true) {
            console(prompt);
            choice = scanner.nextShort();

            if (choice >= 0 && choice <= max) {
                break;
            }

            console("Veuillez entrer un chiffre entre " + "0" + " et " + max);
        }
        return choice;
    }

    private static void console(String msg) {
        System.out.println(msg);
    }

    private static void handleEncouter(short userAnswer, short enemyMarbles, short enemyIndex) {

        if ((userAnswer % 2 == 0 && enemyMarbles % 2 == 0) || (userAnswer % 2 != 0 && enemyMarbles % 2 != 0)) {

            console("Bravo, c'est gagné, vous remportez " + enemyMarbles + " bille(s) + "
                    + "votre bonus de " + heroBonus + " bille(s) !");

            heroMarbles += (short) (enemyMarbles + heroBonus);
            listEnemies[enemyIndex][1] = "0";
        } else {
            heroMarbles -= (short) (enemyMarbles + heroMalus);
            listEnemies[enemyIndex][1] = String.valueOf(Short.parseShort(listEnemies[enemyIndex][1]) + enemyMarbles);
            console("HAHAHA, c'est perdu, vous perdez " + enemyMarbles + " bille(s) + votre malus de "
                    + heroMalus + " bille(s) !");
            console("Grâce à vous, votre ennemi a maintenant dans ses mains "
                    + listEnemies[enemyIndex][1] + " bille(s) !");
        }

        console("Votre ennemi avait dans ses mains " + enemyMarbles + " bille(s) !");

        if (heroMarbles > 0) {
            console("Après ce combat, il vous reste " + heroMarbles + " bille(s) !");
        }
    }

    private static void startFight() {
        short count = 1;
        while (heroMarbles > 0 && nbrEncounters > 0) {


            short enemyIndex = Short.parseShort(randomNumber(0, listEnemies.length - 1));
            String ennemyName = listEnemies[enemyIndex][0];
            short ennemyMarbles = Short.parseShort(listEnemies[enemyIndex][1]);
            short enemyAge = Short.parseShort(listEnemies[enemyIndex][2]);

            if (ennemyMarbles <= 0) {
                continue;
            }

            console("Combat n° " + count + " - Vous rencontrez " + ennemyName + " preparez-vous au combat !");

            if (enemyAge >= 70) {

                short cheatAnswer = readUserInput("Votre ennemi à plus de 70 ans, voulez-vous tricher"
                        + " en profitant de son âge ? Oui - (0) Non - (1) ?", 1);

                if (cheatAnswer == 0) {

                    heroMarbles += ennemyMarbles;
                    listEnemies[enemyIndex][1] = "0";
                    console("Votre ennemi a été éliminé sans pitié, et vous remportez "
                            + ennemyMarbles + " bille(s) automatiquement");
                    console("Vous avez désormais " + heroMarbles + " billes en votre possession");

                    continue;

                } else {
                    console("Votre comportement est noble, bonne chance lors de cette rencontre !");
                }
            }

            short userAnswer = readUserInput("L'ennemi a des bille(s) dans sa main, "
                    + "est-ce un nombre pair - (0) ou impair - (1) ?", 1);

            handleEncouter(userAnswer, ennemyMarbles, enemyIndex);
            count++;
            nbrEncounters--;

        }

        if (heroMarbles > 0) {
            console("La partie est finie, vous avez survécu à vos ennemis, "
                    + "FÉLICITATIONS vous pouvez récupérer vos 45,6 milliards de Won sud-coréen !");
        } else {
            console("La partie est finie, vous avez perdu !! BIENVENU EN ENFER !");
        }
    }
}