package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Thor extends Hero {
    public Thor(int health, int damage,  String name) {
        super(health, damage, SuperAbility.Stun, name);
    }
    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boolean thorMjolnir = RPG_Game.random.nextBoolean();
        if (thorMjolnir) {
            boss.setDamage(0);
            System.out.println("The Boss is Stunned");
        } else {
            boss.setDamage(50);
        }
    }

}
