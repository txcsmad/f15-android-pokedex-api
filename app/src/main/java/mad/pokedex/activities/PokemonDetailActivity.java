package mad.pokedex.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mad.pokedex.R;
import mad.pokedex.models.Pokemon.PokemonDetails;
import mad.pokedex.models.Pokemon.PokemonType;
import mad.pokedex.network.PokedexClient;
import mad.pokedex.network.services.PokedexService;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Drew on 9/11/15.
 */
public class PokemonDetailActivity extends AppCompatActivity {

    private static final String TAG = "PokemonDetailActivity";

    private PokemonDetails pokemonDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        setupToolbar((Toolbar) findViewById(R.id.toolbar));

        // TODO: Call the function to get pokemon detail info
    }

    private void setupToolbar(Toolbar toolbar) {
        setSupportActionBar(toolbar);
        setTitle(getIntent().getStringExtra("name"));

        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.abc_ic_ab_back_mtrl_am_alpha));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String image_url = getIntent().getStringExtra("image_url");

        Picasso.with(this).load(image_url).into((ImageView) findViewById(R.id.header));
    }

    // TODO: Uncomment when object is created
//    private void setupPokemonDetails() {
//        // Setup type layout
//        LinearLayout typesLayout = (LinearLayout) findViewById(R.id.typeFrame);
//        typesLayout.removeAllViews();
//
//        ArrayList<PokemonType> typesList = pokemonDetails.getTypes();
//        for(PokemonType type : typesList) {
//            Log.v(TAG, "test");
//            View v = LayoutInflater.from(typesLayout.getContext()).inflate(R.layout.row_pokemon_detail_type,
//                    typesLayout, false);
//
//            RelativeLayout typeBackground = (RelativeLayout) v.findViewById(R.id.typeBackground);
//            typeBackground.setBackgroundColor(type.getTypeBackgroundColor(this));
//
//            TextView typeName = (TextView) v.findViewById(R.id.typeName);
//            typeName.setText(type.getName());
//            typeName.setTextColor(type.getTypeTextColor(this));
//
//            typesLayout.addView(v);
//        }
//
//        // Setup height value
//        TextView height_text = (TextView) findViewById(R.id.height_value);
//        height_text.setText(pokemonDetails.getHeight());
//
//        // Setup weight value
//        TextView weight_text = (TextView) findViewById(R.id.weight_value);
//        weight_text.setText(pokemonDetails.getWeight());
//
//        // Setup hp value
//        TextView hp_text = (TextView) findViewById(R.id.hp_value);
//        hp_text.setText("" + pokemonDetails.getHp());
//
//        // Setup attack value
//        TextView attack_text = (TextView) findViewById(R.id.attack_value);
//        attack_text.setText("" + pokemonDetails.getAttack());
//
//        // Setup speed value
//        TextView speed_text = (TextView) findViewById(R.id.speed_value);
//        speed_text.setText("" + pokemonDetails.getSpeed());
//    }

    // TODO: Function to get the details of the individual pokemon
}
