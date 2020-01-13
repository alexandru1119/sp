package Package1;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class JSONIBuilder implements IBuilder {

    public IElement document;

    //Acest path reprezinta locatia lui book.json... In cazul meu este cea de mai jos.
    public final String bookJSONPath = "C:\\Others\\DP\\LabDpJava\\src\\book.json";
    @Override
    public IElement GetResult() {
        return document;
    }

    @Override
    public void Build() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            HashMap<String, Object> map = mapper.readValue(new File(bookJSONPath),
                    HashMap.class);
            document = processMap(map);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public IElement BuildSection(HashMap<String, Object> map) {
        Section section = new Section((String)map.get("title"));
        Collection<HashMap<String, Object>> children = (Collection)map.get("children");
        children.forEach((childMap) -> {

            IElement e = this.processMap(childMap);
            if (e != null) {
                try {
                    section.AddElement(e);
                } catch (Exception var5) {
                    var5.printStackTrace();
                }
            }
        });
        return section;
    }

    @Override
    public IElement BuildParagraph(HashMap<String, Object> map) {
        return new Paragraph((String)map.get("text"));
    }

    @Override
    public IElement BuildImage(HashMap<String, Object> map) {
        return new Image((String)map.get("url"));
    }

    @Override
    public IElement BuildImageProxy(HashMap<String, Object> map) {
        return new ImageProxy((String)map.get("url"));
    }

    @Override
    public IElement BuildTable(HashMap<String, Object> map) {
        return new Table((String)map.get("text"));
    }

    private IElement processMap(HashMap<String, Object> map) {
        String classElement = (String)map.get("class");

        if("Section".equals(classElement))
            return this.BuildSection(map);
        else if("Paragraph".equals(classElement))
            return this.BuildParagraph(map);
        else if("Image".equals(classElement))
            return this.BuildImage(map);
        else if("ImageProxy".equals(classElement))
            return this.BuildImageProxy(map);
        return null;
    }
}
