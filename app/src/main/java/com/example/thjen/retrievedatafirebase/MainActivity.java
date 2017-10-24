package com.example.thjen.retrievedatafirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference data;
    ListView lv;

    ArrayList<String> list;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = (TextView) findViewById(R.id.tv);
        lv = (ListView) findViewById(R.id.lv);

        list = new ArrayList<>();

        data = FirebaseDatabase.getInstance().getReference();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
        lv.setAdapter(adapter);

    //    PhuongTien phuongTien = new PhuongTien("Xe khách", 4);
    //    data.child("Phương Tiện").push().setValue(phuongTien);
        data.child("Phương Tiện").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                PhuongTien phuongTien1 = dataSnapshot.getValue(PhuongTien.class);
                list.add(phuongTien1.getTen() + " - " + phuongTien1.getBanh());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

     //   data.child("Course").push().setValue("Unity");

        data.child("Course").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                tv.append(dataSnapshot.getValue().toString() + "\n");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }


}
