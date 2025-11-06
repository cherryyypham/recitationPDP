/**
 * The Gentleman wants to hire a Hitman who implements the Fight
 * interface. Being able to actually fight is a pretty big
 * deal if someone wants to effectively win a Gentleman's Duel.
 */

package main.java;

class Hitman implements Fight {
    private String name;

    public Hitman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void drawWeapon(String fightMedium) {
        System.out.println(name +"is drawing out a" + fightMedium + "!!!");
    }

    @Override
    public int firePistols() {
        System.out.println(name + " is firing his pistols at the opponent.");
        return (int)(Math.random() * 20) + 0;
    }

    @Override
    public int stabWithSaber() {
        System.out.println(name + " is stabbing the opponent with a saber");
        return (int)(Math.random() * 10);
    }
}