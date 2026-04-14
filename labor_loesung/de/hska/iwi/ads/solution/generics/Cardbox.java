package de.hska.iwi.ads.solution.generics;

import de.hska.iwi.ads.generics.Box;

public class Cardbox<T> extends Box<T> {

    public Cardbox(int volume, T content) {
        super(volume, content);
    }

    @Override
    public int compareTo(Box<T> other) {
        if (this.volume > other.getVolume()) {
            return 1;
        }  else if (this.volume < other.getVolume()) {
            return -1;
        } else  {
            return 0;
        }
    }
}
