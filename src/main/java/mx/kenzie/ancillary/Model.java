package mx.kenzie.ancillary;

import mx.kenzie.grammar.Optional;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class Model extends Element {

    public @Optional String parent, credit;
    public @Optional Map<String, String> textures = new LinkedHashMap<>();
    public @Optional Override[] overrides;
    public @Optional Display display;
    public @Optional Object groups;
    public @Optional Element[] elements;

    public Model() {
    }

    public Model(File file) {
        super(file);
    }

    public static class Element {
        public final double[] from = new double[3], to = new double[3];

    }

    public static class Display {
        public Position thirdperson_righthand,
            thirdperson_lefthand,
            firstperson_righthand,
            firstperson_lefthand,
            ground,
            gui,
            head,
            fixed;

        public static class Position {
            public double[] rotation = new double[3];
            public double[] translation = new double[3];
            public double[] scale = new double[3];
        }

    }

    public static class Override {

        public Predicate predicate;
        public String model;

        public static class Predicate {
            public int custom_model_data;
        }

    }

}
