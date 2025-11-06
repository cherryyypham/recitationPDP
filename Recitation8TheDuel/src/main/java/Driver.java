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

import java.io.PrintStream;

public class Driver {
    public static void main(String[] var0) {
        System.out.println("Once upon a time, 2 angry gentlemans got caught in a beef...\n");
        Gentleman var1 = new Gentleman("Lord Farquaad");
        Gentleman var2 = new Gentleman("Sir Reginald");
        System.out.println("Lord Farquaad challenges Sir Reginald into a series of duels. Each gentleman hires a" +
                " champion to fight for them since it is unseemly to settle their dispute by commiting an act of" +
                " violence on their own.\n");
        System.out.println(var1.getName() + " hires a champion...");
        HiredDuelist var3 = new HiredDuelist(new Hitman("Chad"));
        System.out.println("His name is " + var3.getName() + ".");
        System.out.println(var2.getName() + " hires a champion...");
        HiredDuelist var4 = new HiredDuelist(new Hitman("Chuck"));
        System.out.println("His name is " + var4.getName() + ".");
        int var5 = 0;
        String[] var6 = new String[]{"long range weapon", "close range weapon"};

        while(var1.getHonor() > 0 && var2.getHonor() > 0) {
            ++var5;
            int var9 = (int)(Math.random() * (double)2.0F);
            String var10 = var6[var9];
            System.out.println("\nDuel Number #" + var5 + " - " + var10 + "!");
            var1.issueChallenge(var10);
            var2.acceptDuel(true);
            int var7;
            int var8;
            if (var9 == 0) {
                var7 = var3.throwGlove();
                var8 = var4.throwGlove();
            } else {
                var7 = var3.fisticuffs();
                var8 = var4.fisticuffs();
            }

            if (var7 > var8) {
                var2.loseHonor(var7 - var8);
                PrintStream var10000 = System.out;
                String var10001 = var2.getName();
                var10000.println(var10001 + " loses honor! Current honor: " + var2.getHonor());
            } else if (var8 > var7) {
                var1.loseHonor(var8 - var7);
                PrintStream var11 = System.out;
                String var13 = var1.getName();
                var11.println(var13 + " loses honor! Current honor: " + var1.getHonor());
            } else {
                System.out.println("The duel is a draw!");
            }

            PrintStream var12 = System.out;
            String var14 = var1.getName();
            var12.println("Current Honor: " + var14 + " - " + var1.getHonor() + "; " + var2.getName() + " - " + var2.getHonor());
        }

        System.out.println("After " + var5 + " arduous duels...");
        if (var1.getHonor() > 0) {
            System.out.println("\n" + var1.getName() + " emerges victorious with his honor intact!");
        } else {
            System.out.println("\n" + var2.getName() + " emerges victorious with his honor intact!");
        }

    }
}
