package com.example.remindmeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * The type Read list.
 */
public class ReadList extends AppCompatActivity {

    /*
    Create list variable
     */

    private ListView lv;

    /*
    Create Array List for the list
     */

    private ArrayList<Pml> tdlList;
    private ArrayList<String> titleList;

    /*
    Create an adapter
     */

    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_list);
        lv = findViewById(R.id.lv);


        /*
        Need to set the list that was created in data helper to tdlList
         */

        tdlList = DataHelper.loadPml(this);
        titleList = new ArrayList<>();
        for (int i = 0; i < tdlList.size(); i++) {   // goes through the list getting titles.
            String str = tdlList.get(i).getTitle();
            titleList.add(str);  //Fills up title list with titles
        }

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titleList);
        lv.setAdapter((ListAdapter) adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long i) {
                /*
                Need to create new detail activity to display the detail for the lists
                 */
                /*
                Also need to create a new intent
                 */
                Intent intent = new Intent(ReadList.this, DetailActivity.class);
                String title = tdlList.get(pos).getTitle();
                String tdl = tdlList.get(pos).getTdl();

                intent.putExtra("EXTRA_TITLE", title);
                intent.putExtra("EXTRA_TDL", tdl);

                startActivity(intent);

            }
        });

    }
}
