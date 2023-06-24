package kg.geeks.game.players;

public class Bomber extends Hero {
    private boolean exploded;

    public Bomber(int health, int damage, String name) {
        super(health, damage, SuperAbility.Suicide, name);
        this.exploded = false;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!exploded) {
            for (Hero hero : heroes) {
                if (hero != null && hero.getHealth() <= 0) {
                    boss.setHealth(boss.getHealth() - 100);
                    System.out.println(this.getName() + " SSSSUUIIIIIICIDDDDEEEE!");
                    exploded = true;
                    break;
                }
            }
            if (this.getHealth() <= 0) {
                boss.setHealth(boss.getHealth() - 100);
            }
        }
    }

    @Override
    public void applySuperPower(Hero[] heroes, Boss boss) {

    }
}