package kg.geeks.game.players;

public class Aurora extends Hero {
    private boolean isInvisible;
    private int invisibleRounds;
    private boolean disappeared;

    public Aurora(int health, int damage, String name) {
        super(health, damage, SuperAbility.INVISIBLE, name);
        this.isInvisible = false;
        this.invisibleRounds = 2;
        this.disappeared = false;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!disappeared && invisibleRounds > 0) {
            isInvisible = true;
            invisibleRounds--;
            System.out.println(getName() + " Vendetta " + invisibleRounds + " round");
        }

        if (isInvisible) {
            System.out.println("You can't touch me, you freak. " + getName() + " Vendetta ");
        } else {
            boss.setHealth(boss.getHealth() - getDamage());
            System.out.println(getName() + " Vendetta " + getDamage() + " damage");
        }
    }

    public void disappear() {
        if (!disappeared && invisibleRounds == 2) {
            disappeared = true;
            invisibleRounds = 2;
            System.out.println(getName() + " Vendetta " + invisibleRounds + " round");
        } else {
            System.out.println(getName() + " ooops!");
        }
    }
}