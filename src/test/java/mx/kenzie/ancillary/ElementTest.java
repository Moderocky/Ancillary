package mx.kenzie.ancillary;

import mx.kenzie.argo.Json;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;

public class ElementTest {

    @Test
    public void save() {
        final StringWriter writer = new StringWriter();
        final MCMeta mcMeta = new MCMeta();
        mcMeta.pack.pack_format = 10;
        mcMeta.pack.description = "hello there";
        final Json json = new Json(writer);
        json.write(mcMeta, "\t");
        assert writer.toString().length() > 0;
    }

    @Test
    public void font() {
        final ByteArrayOutputStream stream = new ByteArrayOutputStream();
        final Font font = new Font();
        final Json json = new Json(stream);
        font.providers = new Font.Provider[]{
            font.new Provider()
        };
        json.write(font);
        assert font.providers.length > 0;
        assert stream.toString().equals(Json.toJson(font)) : stream;
    }

}
