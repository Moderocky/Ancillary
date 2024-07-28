package mx.kenzie.ancillary;

import mx.kenzie.grammar.Any;
import mx.kenzie.grammar.Optional;
import mx.kenzie.scribe.Component;

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

        public Entry[] entries = new Entry[0];

        public static class Entry {

            public @Any({int.class, int[].class, Support.class}) Object formats;
            public String directory;

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

        public @Any({String.class, Component.class}) Object description;
        public int pack_format;
        public @Optional @Any({int.class, int[].class, Support.class}) Object supported_formats;

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
