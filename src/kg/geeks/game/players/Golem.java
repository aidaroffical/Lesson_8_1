package kg.geeks.game.players;

public class Golem extends Hero {
    private int defender;

    public int getDefender() {
        return defender;
    }

    public void setDefender(int defender) {
        this.defender = defender;
    }

    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.Stone, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() == 0 && heroes[i].getHealth() > 0 && this != heroes[i]) {
                defender = boss.getDamage() / 1;
                heroes[i].setHealth(heroes[i].getHealth() - this.defender);
                heroes[i].setHealth(heroes[i].getHealth() - this.defender);
            } else {
                defender = boss.getDamage() / 5;
                heroes[i].setHealth(heroes[i].getHealth() - this.defender);
            }
        }
    }
}
