/**
 * This is our interface that the Adapter Class will inherit
 * The adapter class needs to appear as though it is also
 * a Gentleman and not a hired hitman.
 */

package main.java;

public interface GentlemansDuel {
    void issueChallenge(String var1);

    int throwGlove();

    int fisticuffs();
}