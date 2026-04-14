package de.hska.iwi.ads.solution.generics;

import de.hska.iwi.ads.generics.Box;

public class Cardbox extends Box {

    public Cardbox(int volume, Object content) {
        super(volume, content);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
