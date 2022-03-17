package com.example.tpfiles;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapterPersonnes  extends ArrayAdapter<User> {

    private int resource;
    public ListAdapterPersonnes(@NonNull Context context, int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.resource=resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView=convertView;
        if(listItemView==null){
            listItemView= LayoutInflater.from(getContext()).inflate(resource,parent,false);
        }
        TextView textviewNom = listItemView.findViewById(R.id.textviewNom);
        TextView textviewPrenom = listItemView.findViewById(R.id.textviewPrenom);
        TextView textviewEmail = listItemView.findViewById(R.id.textviewEmail);
        textviewNom.setText(String.valueOf(getItem(position).getNom()));
        textviewPrenom.setText(String.valueOf(getItem(position).getPrenom()));
        textviewEmail.setText(String.valueOf(getItem(position).getEmail()));
        
        return listItemView;
    }
}
