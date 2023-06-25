package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Antman extends Hero{
    private int defaultSize;
    private int currentSize;
    private int sizeModifier;
    public Antman(int health, int damage, String name) {
        super(health, damage, SuperAbility.Grow, name);
        this.defaultSize = defaultSize;
        this.currentSize = defaultSize;
        this.sizeModifier = 0;
    }

        public void setSizeModifier(int sizeModifier) {
            this.sizeModifier = sizeModifier;
        }

        @Override
        public void applySuperPower(Boss boss, Hero[] heroes) {

            int change = RPG_Game.random.nextInt(2);
            if (change == 0) {
                decreaseSize();
                setHealth(getHealth() - 7);
                setDamage(getDamage() - 7);
                System.out.println(this.getName() + " BIG!");
            } else {
                increaseSize();
                setHealth(getHealth() + 7);
                setDamage(getDamage() + 7);
                System.out.println(this.getName() + " Small!");
            }

            if (currentSize > defaultSize) {
                setHealth(getHealth() + 2);
                setDamage(getDamage() + 2);
            } else if (currentSize < defaultSize) {
                setHealth(getHealth() - 2);
                setDamage(getDamage() - 2);
            }

            boss.setHealth(boss.getHealth() - getDamage());

            resetSize();
        }

        public void resetSize() {
            currentSize = defaultSize;
            sizeModifier = 0;
        }

        private void increaseSize() {
            currentSize++;
        }

        private void decreaseSize() {
            currentSize--;
        }
    }
