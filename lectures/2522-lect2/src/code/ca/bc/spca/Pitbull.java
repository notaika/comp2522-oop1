package ca.bc.spca;

import java.io.IOException;

public class Pitbull extends Dog {
    boolean alive;

    Pitbull(final int birthYear,
        final String name,
            final boolean isAlive)
    throws IOException {
        super(birthYear, name);
        this.alive = true;
    }
}