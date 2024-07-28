package mx.kenzie.ancillary;

import mx.kenzie.grammar.Optional;
import org.jetbrains.annotations.NotNull;

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
    public boolean ambientocclusion = true;

    public Model() {
    }

    public Model(File file) {
        super(file);
    }

    public static class Element {

        public final double[] from = new double[3], to = new double[3];
        public @Optional Rotation rotation;
        public @Optional boolean shade = true;
        public @NotNull Faces faces = new Faces();

        public static class Faces {

            public @Optional Face down, up, north, south, west, east;

        }

        public static class Face {

            public double[] uv = new double[4];
            public @Optional String texture, cullface;
            public int rotation, tintindex = -1;

        }

        public static class Rotation {

            public final double[] origin = new double[3];
            public String axis;
            public float angle;
            public boolean rescale;

        }

    }

    public static class Display {

        public Position thirdperson_righthand, thirdperson_lefthand, firstperson_righthand, firstperson_lefthand,
            ground, gui, head, fixed;

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
