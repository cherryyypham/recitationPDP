/**
 * This exercise is all about Adapter patterns. To illustrate
 * what an adapter does, we have a fictional scenario of a Gentleman
 * needing to hire a Hitman to fight a duel he has been challenged to.
 * However, the Hitman must appear to be a Gentleman in order
 * to fight in the duel.
 *
 * In the driver class, please initialize an object
 * that adapts the Fight interface by implementing
 * the GentlemansDuel interface and initializing an internal
 * Hitman object.
 */

package main.java;

public class Driver {

    public static void main(String[] args) {
        System.out.println("Once upon a time, 2 angry gentlemans got caught in a beef...\n");
        Gentleman lordFarquaad = new Gentleman("Lord Farquaad");
        Gentleman sirReginald = new Gentleman("Sir Reginald");

        System.out.println("Lord Farquaad challenges Sir Reginald into a series of duels. Each gentleman hires a" +
                " champion to fight for them since it is unseemly to settle their dispute by commiting an act" +
                " of violence on their own.\n");

        System.out.println(lordFarquaad.getName() + " hires a champion...");
        HiredDuelist farquaadChampion = new HiredDuelist(new Hitman("Chad"));
        System.out.println("His name is " + farquaadChampion.getName() + ".");

        System.out.println(sirReginald.getName() + " hires a champion...");
        HiredDuelist reginaldChampion = new HiredDuelist(new Hitman("Chuck"));
        System.out.println("His name is " + reginaldChampion.getName() + ".");

        // Some duel logistics
        int duelCount = 0;
        String[] fightMediums = {"long range weapon", "close range weapon"};
        int farquaadDamage;
        int reginaldDamage;

        while (lordFarquaad.getHonor() > 0 && sirReginald.getHonor() > 0) {
            duelCount++;

            int i = (int)(Math.random() * 2);
            String fightMedium = fightMediums[i];

            System.out.println("\nDuel Number #" + duelCount + " - " + fightMedium + "!");
            lordFarquaad.issueChallenge(fightMedium);
            sirReginald.acceptDuel(true);

            if (i == 0) {
                farquaadDamage = farquaadChampion.throwGlove();
                reginaldDamage = reginaldChampion.throwGlove();
            } else {
                farquaadDamage = farquaadChampion.fisticuffs();
                reginaldDamage = reginaldChampion.fisticuffs();
            }

            if (farquaadDamage > reginaldDamage) {
                sirReginald.loseHonor(farquaadDamage - reginaldDamage);
                System.out.println(sirReginald.getName() + " loses honor! Current honor: " + sirReginald.getHonor());
            } else if (reginaldDamage > farquaadDamage) {
                lordFarquaad.loseHonor(reginaldDamage - farquaadDamage);
                System.out.println(lordFarquaad.getName() + " loses honor! Current honor: " + lordFarquaad.getHonor());
            } else {
                System.out.println("The duel is a draw!");
            }

            System.out.println("Current Honor: " + lordFarquaad.getName() + " - " + lordFarquaad.getHonor() +
                    "; " + sirReginald.getName() + " - " + sirReginald.getHonor());
        }
        System.out.println("After " + duelCount + " arduous duels...");
        if (lordFarquaad.getHonor() > 0) {
            System.out.println(lordFarquaad.getName() + " emerges victorious!");
        } else {
            System.out.println(sirReginald.getName() + " emerges victorious!");
        }
    }

}