package mad.pokedex.views.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import mad.pokedex.R;
import mad.pokedex.activities.PokemonDetailActivity;
import mad.pokedex.models.Pokedex.PokedexPokemon;

/**
 * This is the Pokedex adapter that displays an image from the pokemon ( from the pokemon website hehe )
 *  and the name of the pokemon, and once it is clicked it will lead to the detailed pokemon information.
 */
public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokemonListHolder> {

    private ArrayList<PokedexPokemon> pokedexList;

    public PokedexAdapter(ArrayList<PokedexPokemon> pokedexList) {
        this.pokedexList = pokedexList;
    }

    public class PokemonListHolder extends RecyclerView.ViewHolder {

        View view;
        TextView name;
        ImageView image;

        public PokemonListHolder(View itemView, int position) {
            super(itemView);
            view = itemView;
            name = (TextView) itemView.findViewById(R.id.name);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }

    @Override
    public PokemonListHolder onCreateViewHolder(ViewGroup parent, int position) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_pokedex_item,
                parent, false);
        return new PokemonListHolder(v, position);
    }

    // TODO: uncomment the two lines below when the object is linked correctly
    @Override
    public void onBindViewHolder(PokemonListHolder holder, final int position) {
        final PokedexPokemon pokemon = pokedexList.get(position);

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(v.getContext(), PokemonDetailActivity.class);
                detailIntent.putExtra("pokedex_id", pokemon.getPokedexId());
                //detailIntent.putExtra("name", pokemon.getName() + " - #" + pokemon.get3DigitPokeId());
                detailIntent.putExtra("image_url", pokemon.getImageUrl());
                v.getContext().startActivity(detailIntent);
            }
        });
        //holder.name.setText(pokemon.getName());
        Picasso.with(holder.view.getContext()).load(pokemon.getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return pokedexList.size();
    }
}
