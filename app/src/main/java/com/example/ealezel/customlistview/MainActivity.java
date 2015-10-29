package com.example.ealezel.customlistview;

import android.app.ListActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ealezel.customlistview.classes.State;

public class MainActivity extends ListActivity {



    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        Resources res = getResources();

        State[] states = {

                new State (res.getString(R.string.kindred), res.getString(R.string.kindred_t), R.drawable.kindred),
                new State (res.getString(R.string.kennen), res.getString(R.string.kennen_t), R.drawable.kennen),
                new State (res.getString(R.string.jinx), res.getString(R.string.jinx_t), R.drawable.jinx),
                new State (res.getString(R.string.amumu), res.getString(R.string.amumu_t), R.drawable.amumu),
                new State (res.getString(R.string.ashe), res.getString(R.string.ashe_t), R.drawable.ashe),
                new State (res.getString(R.string.azir), res.getString(R.string.azir_t), R.drawable.azir),
                new State (res.getString(R.string.chogath), res.getString(R.string.chogath_t), R.drawable.chogath),
                new State (res.getString(R.string.fiora), res.getString(R.string.fiora_t), R.drawable.fiora),
                new State (res.getString(R.string.irelia), res.getString(R.string.irelia_t), R.drawable.irelia),
                new State (res.getString(R.string.kalista), res.getString(R.string.kalista_t), R.drawable.kalista),
                new State (res.getString(R.string.leona), res.getString(R.string.leona_t), R.drawable.leona),
                new State (res.getString(R.string.malphite), res.getString(R.string.malphite_t), R.drawable.malphite),
                new State (res.getString(R.string.malzahar), res.getString(R.string.malzahar_t), R.drawable.malzahar),
                new State (res.getString(R.string.nami), res.getString(R.string.nami_t), R.drawable.nami),
                new State (res.getString(R.string.orianna), res.getString(R.string.orianna_t), R.drawable.orianna),
        };

        setListAdapter(new StateAdapter(states));
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                State selectedState = (State)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        getListView().setOnItemClickListener(itemListener);
    }
    private State getModel(int position) {
        return(((StateAdapter)getListAdapter()).getItem(position));
    }
    class StateAdapter extends ArrayAdapter<State> {

        private LayoutInflater mInflater;

        StateAdapter(State[] list) {
            super(MainActivity.this,R.layout.activity_main,  list);
            mInflater = LayoutInflater.from(MainActivity.this);
        }
        public View getView(int position, View convertView,
                            ViewGroup parent) {
            ViewHolder holder;
            View row=convertView;
            if(row==null){

                row = mInflater.inflate(R.layout.activity_main, parent, false);
                holder = new ViewHolder();
                holder.imageView = (ImageView) row.findViewById(R.id.flag);
                holder.nameView = (TextView) row.findViewById(R.id.name);
                holder.capitalView = (TextView) row.findViewById(R.id.capital);
                row.setTag(holder);
            }
            else{

                holder = (ViewHolder)row.getTag();
            }

            State state = getModel(position);

            holder.imageView.setImageResource((state.getFlagResource()));
            holder.nameView.setText(state.getName());
            holder.capitalView.setText(state.getCapital());

            return row;
        }

        class ViewHolder {
            public ImageView imageView;
            public TextView nameView, capitalView;
        }
    }
}
