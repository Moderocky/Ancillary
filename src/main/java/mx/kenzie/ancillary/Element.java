package mx.kenzie.ancillary;

import mx.kenzie.argo.Json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public abstract class Element {
    
    Element() {
    }
    
    Element(File file) {
        this.load(file);
    }
    
    public void load(File file) {
        if (file == null || !file.isFile()) return;
        try (final Json json = new Json(new FileInputStream(file))) {
            json.toObject(this);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void save(File file) {
        if (file == null || !file.isFile()) return;
        try (final Json json = new Json(new FileOutputStream(file))) {
            json.write(this, "\t");
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    
}
