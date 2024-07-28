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
        try (InputStream stream = new FileInputStream(file)) {
            this.load(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(InputStream stream) {
        final Json json = new Json(stream);
        json.toObject(this);
    }

    public void save(File file) {
        try (OutputStream stream = new FileOutputStream(file)) {
            this.save(stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(OutputStream stream) {
        final Json json = new Json(stream);
        json.write(this, "\t");
    }

}
