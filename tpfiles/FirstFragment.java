package com.example.tpfiles;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tpfiles.databinding.FragmentFirstBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private static final String FILE_NAME="myFile1.txt";
    List<User> users = new ArrayList<>();
    ListView usersView;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        View v =inflater.inflate(R.layout.fragment_first,container,false);
        usersView = v.findViewById(R.id.listPersonnes);
        ListAdapterPersonnes adapter = new ListAdapterPersonnes(getActivity(),R.layout.useritem,users);
        usersView.setAdapter(adapter);
        FloatingActionButton buttonAdd = v.findViewById(R.id.buttonAdd);



        try {
            FileInputStream fis = getActivity().openFileInput(FILE_NAME);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            StringBuilder text=new StringBuilder();
            String ligne="";
            while ((ligne=br.readLine())!=null){
                String data[] = ligne.split(" ");
                User u = new User(data[0], data[1], data[2]);
                users.add(u);

            }
            adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

            }
        });



        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        return v;

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        users.clear();
    }

}