package org.simonita.simonita;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Riesto on 26/01/2017.
 */

public class ModelAdapter extends ArrayAdapter<String> {

    private final AppCompatActivity context;
    private final String[] mName;
    private final String[] mKota;

    public ModelAdapter(AppCompatActivity context, String[] mName, String[] mKota){
        super(context, R.layout.activity_listview, mName);

        this.context = context;
        this.mName = mName;
        this.mKota = mKota;
    }

    public View getView(int position, View view, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_listview, null, true);

        TextView txtName = (TextView) v.findViewById(R.id.nama);
        TextView txtKota = (TextView) v.findViewById(R.id.kota);

        txtName.setText("Nama: " + mName[position]);
        txtKota.setText("Kota: " + mKota[position]);

        return v;
    }
}
