/**
 * The Gentleman wants to hire a Hitman who implements the Fight
 * interface. Being able to actually fight is a pretty big
 * deal if someone wants to effectively win a Gentleman's Duel.
 */

package main.java;

class Hitman implements Fight {
    private String name;

    public Hitman(String var1) {
        this.name = var1;
    }

    public String getName() {
        return this.name;
    }

    public void drawWeapon(String var1) {
        System.out.println(this.name + "is drawing out a" + var1 + "!!!");
    }

    public int firePistols() {
        System.out.println(this.name + " is firing his pistols at the opponent.");
        return (int)(Math.random() * (double)20.0F) + 0;
    }

    public int stabWithSaber() {
        System.out.println(this.name + " is stabbing the opponent with a saber");
        return (int)(Math.random() * (double)10.0F);
    }
}