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
            case "Bug":
            case "Dragon":
            case "Fairy":
            case "Fire":
            case "Ghost":
            case "Ground":
            case "Normal":
            case "Psychic":
            case "Steel":
            case "Dark":
            case "Electric":
            case "Fighting":
            case "Flying":
            case "Grass":
            case "Ice":
            case "Poison":
            case "Rock":
            case "Water":
                int id = context.getResources().getIdentifier(getName().toLowerCase(), "color", context.getPackageName());
                result = context.getColor(id);
                break;
            default:
                result = context.getColor(R.color.accent);
                break;
        }

        return result;
    }

    public int getTypeTextColor(Context context) {
        int result;

        switch (getName()) {
            case "Fairy":
            case "Grass":
            case "Normal":
            case "Steel":
            case "Electric":
            case "Flying":
            case "Ice":
                result = context.getColor(android.R.color.primary_text_light);
                break;
            default:
                result = context.getColor(android.R.color.white);
                break;
        }

        return result;
    }
}
