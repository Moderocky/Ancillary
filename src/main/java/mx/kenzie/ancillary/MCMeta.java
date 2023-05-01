package mx.kenzie.ancillary;

import mx.kenzie.argo.meta.Optional;

import java.io.File;

public class MCMeta extends Element {

    public @Optional Meta meta;
    public @Optional Pack pack = new Pack();

    public MCMeta() {
    }

    public MCMeta(File file) {
        super(file);
    }

    public static class Meta {
        public @Optional String game_version;
        public @Optional String pack_resolution;
        public @Optional Integer pack_type;
        public @Optional String pack_version;
        public @Optional String consists;
    }

    public static class Pack {
        public String description;
        public int pack_format;
    }
}
