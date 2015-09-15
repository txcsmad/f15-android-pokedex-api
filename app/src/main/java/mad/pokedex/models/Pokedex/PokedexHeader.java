package mad.pokedex.models.Pokedex;

import java.util.ArrayList;

/**
 * Created by Drew on 9/10/15.
 */
public class PokedexHeader {
    private PokedexMetaHeader meta;
    private ArrayList<PokedexObjectHeader> objects;

    public PokedexMetaHeader getMeta() {
        return meta;
    }

    public void setMeta(PokedexMetaHeader meta) {
        this.meta = meta;
    }

    public ArrayList<PokedexObjectHeader> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<PokedexObjectHeader> objects) {
        this.objects = objects;
    }
}
