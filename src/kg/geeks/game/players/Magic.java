package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Magic extends Hero {
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int boost = RPG_Game.random.nextInt(5) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getDamage() > 0) {
                heroes[i].setDamage(heroes[i].getDamage() + boost);
            }
        }
    }
}
