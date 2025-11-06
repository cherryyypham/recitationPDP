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

    public Gentleman(String name) {
        this.name = name;
        this.takingFights = true;
        this.honor = 100;
    }

    public String getName() {
        return name;
    }

    public int getHonor() {
        return honor;
    }

    public void setTakingFightsStatus (boolean takingFights) {
        this.takingFights = takingFights;
    }

    public void loseHonor(int amount) {
        honor -= amount;
        if (honor < 0) {
            honor = 0;
        }
    }

    @Override
    public void issueChallenge(String fightMedium) {
        System.out.println("A gentleman's beefing with his opponent and want to challenge them to a fight.");
        System.out.println("The gentleman issued a challenge with " + fightMedium + ".");
    }

    @Override
    public int throwGlove() {
        System.out.printf("Whoosh, did his glove missed his opponent? It seems to not be doing much damages.");
        return (int)(Math.random() * 3);
    }

    @Override
    public int fisticuffs() {
        System.out.print("His fists are not his strongest assets.");
        return (int)(Math.random() * 10);
    }

    public boolean acceptDuel(boolean takingFights) {
        System.out.println("A gentleman got challenged to a fight.");
        if (takingFights) {
            System.out.println("Duel accepted. A gentleman never says no to a fight.");
            return true;
        }
        System.out.println("The gentleman's keeping his peace by not accepting the duel.");
        return false;
    }
}