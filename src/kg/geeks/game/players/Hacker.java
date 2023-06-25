package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero {

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.Change, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int damage = RPG_Game.random.nextInt(50) + 1;
        boss.setHealth(boss.getHealth() - damage);
        System.out.println("Boss Health: " + boss.getHealth());

        for (Hero hero : heroes) {
            if (hero != null && hero != this) {
                int heal = RPG_Game.random.nextInt(5) + 5;
                hero.setHealth(hero.getHealth() + heal);
                System.out.println(hero.getName() + " Added +" + heal + " Heal");
            }

        }
    }
}
