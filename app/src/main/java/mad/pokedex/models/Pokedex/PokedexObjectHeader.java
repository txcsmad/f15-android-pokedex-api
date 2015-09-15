package mad.pokedex.models.Pokedex;

import java.util.ArrayList;

/**
 * Created by Drew on 9/10/15.
 */
public class PokedexObjectHeader {
    private String created;
    private String modified;
    private String name;
    private ArrayList<PokedexPokemon> pokemon;
    private String resource_uri;

    public ArrayList<PokedexPokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(ArrayList<PokedexPokemon> pokemon) {
        this.pokemon = pokemon;
    }
}
