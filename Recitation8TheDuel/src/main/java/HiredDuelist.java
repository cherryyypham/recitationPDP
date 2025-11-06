/**
 * Our hired duelist must be disguised as a Gentleman by
 * implementing the Gentleman's Duel interface.
 * However, this class must be able to use the Fighter methods
 * instead of the GentlemansDuel methods in order to
 * effectively fight.
 */

package main.java;

class HiredDuelist implements GentlemansDuel {
    private Fight fighter;

    public HiredDuelist(Fight var1) {
        this.fighter = var1;
    }

    public String getName() {
        return ((Hitman)this.fighter).getName();
    }

    public void issueChallenge(String var1) {
        System.out.println("The hired duelist steps forward on behalf of his employer.");
        this.fighter.drawWeapon(var1);
    }

    public int throwGlove() {
        return this.fighter.firePistols();
    }

    public int fisticuffs() {
        return this.fighter.stabWithSaber();
    }
}