package mad.pokedex.network;

import mad.pokedex.network.services.PokedexService;
import retrofit.RestAdapter;

/**
 * This singleton Client is the main connectors for the api calls in the view controllers using retrofits service.
 */
public class PokedexClient {
    private static final String POKEDEX_BASE_URL = "http://pokeapi.co";
    private PokedexService pokedexService;

    private static PokedexClient instance = null;

    public static PokedexClient getInstance() {
        if(instance == null) {
            instance = new PokedexClient();
        }
        return instance;
    }

    protected PokedexClient() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(POKEDEX_BASE_URL)
                .build();

        pokedexService = restAdapter.create(PokedexService.class);
    }

    public PokedexService getApiService() {
        return pokedexService;
    }
}
