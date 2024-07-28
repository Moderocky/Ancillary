package mx.kenzie.ancillary;

import mx.kenzie.grammar.Any;
import mx.kenzie.grammar.Optional;

import java.io.File;

public class MCMeta extends Element {

    public @Optional Meta meta;
    public @Optional Pack pack = new Pack();
    public @Optional Filter filter;
    public @Optional Overlays overlays;
    public @Optional Object language;

    public MCMeta() {
    }

    public MCMeta(int pack_format) {
        this();
        this.pack.pack_format = pack_format;
    }

    public MCMeta(File file) {
        super(file);
    }

    public static class Filter {

        public Pattern[] block = new Pattern[0];

        public static class Pattern {

            public String namespace, path;

        }

    }

    public static class Overlays {

        public @Any Entry[] entries = new Entry[0];

        public static abstract class Entry {

            public String directory;

        }

        public static class IntEntry extends Entry {

            public int formats;

        }

        public static class ArrayEntry extends Entry {

            public int[] formats;

        }

        public static class SupportEntry extends Entry {

            public Support formats;

        }

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

    /**
     * Multi-version support object.
     */
    public static class Support {

        public int min_inclusive;
        public int max_inclusive;

        public Support() {
        }

        public Support(int min_inclusive, int max_inclusive) {
            this();
            this.min_inclusive = min_inclusive;
            this.max_inclusive = max_inclusive;
        }

    }

}
