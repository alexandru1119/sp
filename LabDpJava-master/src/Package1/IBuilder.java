package Package1;

import java.util.HashMap;

public interface IBuilder {

    IElement GetResult();
    void Build();

    IElement BuildSection(HashMap<String, Object> map);
    IElement BuildParagraph(HashMap<String, Object> map);
    IElement BuildImage(HashMap<String, Object> map);
    IElement BuildImageProxy(HashMap<String, Object> map);
    IElement BuildTable(HashMap<String, Object> map);

}
