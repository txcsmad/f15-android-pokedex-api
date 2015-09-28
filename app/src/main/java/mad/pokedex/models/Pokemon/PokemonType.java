package mad.pokedex.models.Pokemon;

import android.content.Context;

import mad.pokedex.R;
import mad.pokedex.models.Pokedex.PokedexPokemon;

/**
 * This is a fancy pokemon detail item that gets the color schema for the types of pokemon for that type.
 */
public class PokemonType extends PokemonDetailItem {

    public int getTypeBackgroundColor(Context context) {
        int result;

        switch (getName()) {
            case "bug":
            case "dragon":
            case "fairy":
            case "fire":
            case "ghost":
            case "ground":
            case "normal":
            case "psychic":
            case "steel":
            case "dark":
            case "electric":
            case "fighting":
            case "flying":
            case "grass":
            case "ice":
            case "poison":
            case "rock":
            case "water":
                int id = context.getResources().getIdentifier(getName().toLowerCase(), "color", context.getPackageName());
                result = context.getResources().getColor(id);
                break;
            default:
                result = context.getResources().getColor(R.color.accent);
                break;
        }

        return result;
    }

    public int getTypeTextColor(Context context) {
        int result;

        switch (getName()) {
            case "fairy":
            case "grass":
            case "normal":
            case "steel":
            case "electric":
            case "flying":
            case "ice":
                result = context.getResources().getColor(android.R.color.primary_text_light);
                break;
            default:
                result = context.getResources().getColor(android.R.color.white);
                break;
        }

        return result;
    }
}
