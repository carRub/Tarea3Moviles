package com.example.tarea3.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.tarea3.AdapterProduct;
import com.example.tarea3.R;
import com.example.tarea3.beans.ItemProduct;

import java.util.ArrayList;
import java.util.Iterator;

public class FragmentElectronics extends Fragment implements AdapterProduct.OnPhoneClickListener {

    private RecyclerView recyclerView;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ItemProduct> myDataSet = new ArrayList<ItemProduct>();

    public FragmentElectronics() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_electronics, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState){

        //View view = inflater.inflate(R.layout.fragment_activity_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_electronics_recycler_view);

        //mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));



        ItemProduct itemProduct = new ItemProduct(4, "Refrigerador", "BestBuy", "Zapopan, Jalisco", "33 12345678",
                "El mejor refrigerador del mercado con un 20% de descuento");

        ItemProduct itemProduct1 = new ItemProduct(5, "Microondas", "BestBuy", "Zapopan, Jalisco", "33 87654321",
                "Microondas de calidad de regalo en la compra de tu refrigerador");


        myDataSet.add(itemProduct);
        myDataSet.add(itemProduct1);


        mAdapter = new AdapterProduct(myDataSet, this);
        recyclerView.setAdapter(mAdapter);

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){

        ItemProduct item = data.getParcelableExtra("ITEM");
        Iterator<ItemProduct> iterator = myDataSet.iterator();
        int position = 0;
        while (iterator.hasNext()){
            if(myDataSet.get(position).getCode() == item.getCode()){
                myDataSet.set(position, item);
                break;
            }
            position ++;
        }
        mAdapter.notifyDataSetChanged();
    }

    public void onPhoneClick(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL,
                Uri.parse("tel:" + phone));
        getContext().startActivity(intent);
    }

    @Override
    public void onTabItem(String item) {
        Toast.makeText(getContext(), item,
                Toast.LENGTH_LONG).show();
    }
}
