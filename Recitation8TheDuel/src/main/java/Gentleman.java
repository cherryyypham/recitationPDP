/**
 * Our Gentleman class is unable to actually fight!
 * A gentleman would never commit actual violence.
 * It would be so unseemly of him!
 */

package main.java;

class Gentleman implements GentlemansDuel {
    private String name;
    private boolean takingFights;
    private int honor;

    public Gentleman(String var1) {
        this.name = var1;
        this.takingFights = true;
        this.honor = 100;
    }

    public String getName() {
        return this.name;
    }

    public int getHonor() {
        return this.honor;
    }

    public void setTakingFightsStatus(boolean var1) {
        this.takingFights = var1;
    }

    public void loseHonor(int var1) {
        this.honor -= var1;
        if (this.honor < 0) {
            this.honor = 0;
        }

    }

    public void issueChallenge(String var1) {
        System.out.println("A gentleman's beefing with his opponent and want to challenge them to a fight.");
        System.out.println("The gentleman issued a challenge with " + var1 + ".");
    }

    public int throwGlove() {
        System.out.printf("Whoosh, did his glove missed his opponent? It seems to not be doing much damages.");
        return (int)(Math.random() * (double)3.0F);
    }

    public int fisticuffs() {
        System.out.print("His fists are not his strongest assets.");
        return (int)(Math.random() * (double)10.0F);
    }

    public boolean acceptDuel(boolean var1) {
        System.out.println("A gentleman got challenged to a fight.");
        if (var1) {
            System.out.println("Duel accepted. A gentleman never says no to a fight.");
            return true;
        } else {
            System.out.println("The gentleman's keeping his peace by not accepting the duel.");
            return false;
        }
    }
}
