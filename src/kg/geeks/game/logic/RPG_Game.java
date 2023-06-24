package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {
        Boss boss = new Boss(5000, 100, "Roshan");

        Warrior warrior = new Warrior(280, 10, "Morta");
        Medic doc = new Medic(250, 5, 15, "Omnik");
        Magic magic = new Magic(270, 20, "Puck");
        Berserk berserk = new Berserk(260, 15, "Ursa");
        Medic assistant = new Medic(300, 10, 5, "WD");
        Witcher witcher = new Witcher(250, 0, "Dazzle");
        Thor thor = new Thor(260, 10, "Zeus");
        Hacker hacker = new Hacker(240, 10, "Terrorblade");
        Golem golem = new Golem(320, 5, "Zomb");
        Bomber bomber = new Bomber(100, 0, "Miner");
        Antman antman = new Antman(250, 15, "Tiny");
        Aurora aurora = new Aurora(200, 10, "Riki");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, witcher, thor, hacker, golem, bomber, antman, aurora};

        printStats(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void printStats(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
        }
        return allHeroesDead;
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && heroes[i].getAbility() != boss.getDefence()) {
                heroes[i].attack(boss);
                heroes[i].applySuperPower(boss, heroes);
            }
        }
        printStats(boss, heroes);
    }
}