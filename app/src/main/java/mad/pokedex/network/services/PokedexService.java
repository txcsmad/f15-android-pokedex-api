package mad.pokedex.network.services;

import mad.pokedex.models.Pokedex.PokedexHeader;
import mad.pokedex.models.Pokemon.PokemonDetails;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * This is the retrofit interface that connects the api calls into actual objects.
 */
public interface PokedexService {

    @GET("/api/v1/pokedex/")
    void getPokedex(Callback<PokedexHeader> pokedexList);

    @GET("/api/v1/pokemon/{id}")
    void getPokemonDetails(@Path("id") int pokedexId, Callback<PokemonDetails> pokemonDetails);

}
