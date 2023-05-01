package mx.kenzie.ancillary;

public class Font extends Element {

    public Provider[] providers = new Provider[0];

    public class Provider {
        public String type;
        public String file;
        public int height, ascent;
        public String[] chars = new String[0];
    }

}
