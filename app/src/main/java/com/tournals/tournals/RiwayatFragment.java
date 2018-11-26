package com.tournals.tournals;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Rencana> rencanaArrayList;
    public RiwayatFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_riwayat, container, false);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.riwayatToolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
        addData();

        recyclerView = (RecyclerView) view.findViewById(R.id.rvRiwayat);

        RiwayatAdpater adapter = new RiwayatAdpater(getContext(), rencanaArrayList);



        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }
    void addData(){
        rencanaArrayList = new ArrayList<>();
        rencanaArrayList.add(new Rencana("Trip Malang", "Sedang berlangsung", "01/12/2018", "03/12/2018"));
        rencanaArrayList.add(new Rencana("Trip Jombang", "Perjalanan selesai", "15/08/2018", "20/08/2018"));
        rencanaArrayList.add(new Rencana("Trip Gresik", "Perjalanan selesai", "01/08/2018", "02/08/2018"));
        rencanaArrayList.add(new Rencana("Trip Jember", "Perjalanan selesai", "02/07/2018", "04/07/2018"));
    }
}