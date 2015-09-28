package mad.pokedex.models.Pokedex;

import android.util.Log;
import android.view.View;

import java.util.Comparator;

/**
 * Created by Drew on 9/10/15.
 */
public class PokedexPokemon {
    // TODO: Link Pokedex Pokemon

    public int getPokedexId() {
        // TODO: Uncomment when linked
        return 0; //Integer.parseInt(getResource_uri().substring(15, getResource_uri().length() - 1));
    }

    public String get3DigitPokeId() {
        String threeDigitId = "" + getPokedexId();
        while (threeDigitId.length() < 3) {
            threeDigitId = '0' + threeDigitId;
        }
        return threeDigitId;
    }

    public String getImageUrl() {
        return "http://assets22.pokemon.com/assets/cms2/img/pokedex/full/" + get3DigitPokeId() + ".png";
    }
}
