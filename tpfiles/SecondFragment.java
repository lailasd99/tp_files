package com.example.tpfiles;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.PrintWriter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.tpfiles.databinding.FragmentFirstBinding;
import com.example.tpfiles.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private @NonNull FragmentFirstBinding binding;
    Button btnAdd, btnClear;
    EditText f_name, l_name, email;
    private static final String FILE_NAME="myFile1.txt";
    private String fname, lname, Email;
    FileOutputStream fos;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //binding = FragmentFirstBinding.inflate(inflater, container, false);
        View v =inflater.inflate(R.layout.fragment_second,container,false);
        btnAdd = v.findViewById(R.id.btnSave);
        f_name = v.findViewById(R.id.txtFname);
        l_name = v.findViewById(R.id.txtLname);
        email = v.findViewById(R.id.txtEmail);
        btnClear = v.findViewById(R.id.btnClear);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    fname = f_name.getText().toString();
                    lname = l_name.getText().toString();
                    Email = email.getText().toString();
                    fos = getActivity().openFileOutput(FILE_NAME, getContext().MODE_APPEND);
                    PrintWriter pw = new PrintWriter(fos);
                    pw.println(fname + " " + lname + " " + Email);
                    pw.close();
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_FirstFragment);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    f_name.setText("");
                    l_name.setText("");
                    email.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        //binding = FragmentSecondBinding.inflate(inflater, container, false);
        //return binding.getRoot();
        return v;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}