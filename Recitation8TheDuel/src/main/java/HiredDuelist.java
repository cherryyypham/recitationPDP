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

    public HiredDuelist(Fight fighter) {
        this.fighter = fighter;
    }

    public String getName() {
        return ((Hitman) fighter).getName();
    }

    @Override
    public void issueChallenge(String fightMedium) {
        System.out.println("The hired duelist steps forward on behalf of his employer.");
        fighter.drawWeapon(fightMedium);
    }

    @Override
    public int throwGlove() {
        // Throwing a glove is adapted to drawing and firing pistols
        return fighter.firePistols();
    }

    @Override
    public int fisticuffs() {
        // Fisticuffs is adapted to saber combat
        return fighter.stabWithSaber();
    }
}