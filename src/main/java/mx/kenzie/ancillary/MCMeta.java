package mx.kenzie.ancillary;

import java.io.File;

public class MCMeta extends Element {
    
    public final Meta meta = new Meta();
    public final Pack pack = new Pack();
    
    public MCMeta() {
    }
    
    public MCMeta(File file) {
        super(file);
    }
    
    public static class Meta {
        public String game_version;
        public String pack_resolution;
        public int pack_type;
        public String pack_version;
        public String consists;
    }
    
    public static class Pack {
        public String description;
        public int pack_format;
    }
}
