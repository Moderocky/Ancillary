package mx.kenzie.ancillary;

import mx.kenzie.argo.Json;

import java.io.*;

public abstract class Element {

    Element() {
    }

    Element(File file) {
        this.load(file);
    }

    public void load(File file) {
        if (file == null || !file.isFile()) return;
        try {
            this.load(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(InputStream stream) {
        try (final Json json = new Json(stream)) {
            json.toObject(this);
        }
    }

    public void save(File file) {
        if (file == null || !file.isFile()) return;
        try {
            this.save(new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(OutputStream stream) {
        try (final Json json = new Json(stream)) {
            json.write(this, "\t");
        }
    }

}
