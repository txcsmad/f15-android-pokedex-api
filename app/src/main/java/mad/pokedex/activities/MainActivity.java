package mad.pokedex.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import mad.pokedex.R;
import mad.pokedex.models.Pokedex.PokedexHeader;
import mad.pokedex.models.Pokedex.PokedexPokemon;
import mad.pokedex.network.PokedexClient;
import mad.pokedex.network.services.PokedexService;
import mad.pokedex.views.SpacesItemDecoration;
import mad.pokedex.views.adapters.PokedexAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<PokedexPokemon> pokedexList;
    private PokedexAdapter pokedexAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupToolbar((Toolbar) findViewById(R.id.toolbar));
        setupRecyclerView((RecyclerView) findViewById(R.id.recyclerview));

        getPokedex();

    }

    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
    }

    private void setupRecyclerView(RecyclerView recyclerview) {
        pokedexList = new ArrayList<>();

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.addItemDecoration(new SpacesItemDecoration(25));

        pokedexAdapter = new PokedexAdapter(pokedexList);
        recyclerview.setAdapter(pokedexAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void getPokedex() {
        PokedexService hackTxService = PokedexClient.getInstance().getApiService();
        hackTxService.getPokedex(new Callback<PokedexHeader>() {
            @Override
            public void success(PokedexHeader pokedexHeader, Response response) {
                Log.v(TAG, "pokedex retrieved!");

                pokedexList.clear();
                pokedexList.addAll(pokedexHeader.getObjects().get(0).getPokemon());
                Collections.sort(pokedexList, new Comparator<PokedexPokemon>() {
                    public int compare(PokedexPokemon pokemon1, PokedexPokemon pokemon2) {
                        return pokemon1.getPokedexId() - pokemon2.getPokedexId();
                    }
                });
                for(int position = pokedexList.size() - 1; position >= 0; position--) {
                    if(pokedexList.get(position).getPokedexId() < 1000)
                        break;
                    pokedexList.remove(position);
                }
                pokedexAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {
                Log.v(TAG, error.toString());
            }
        });
    }
}
