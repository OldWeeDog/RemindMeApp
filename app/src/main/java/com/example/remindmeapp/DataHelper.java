package com.example.remindmeapp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * The type Data helper.
 */
public class DataHelper {

    /**
     * Load pml array list.
     *
     * @param context the context
     * @return the array list
     */
    public static ArrayList<Pml> loadPml(Context context) {
        ArrayList<Pml> pmls = new ArrayList<>();
        String json = "";

        try {
            InputStream is = context.getAssets().open("toDo.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);


        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        try {
            JSONObject obj = new JSONObject(json);
            JSONArray jsonArray = obj.getJSONArray("savedLists");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                /*
                Create new instance of the Pml class
                 */
                Pml pml = new Pml();
                pml.setTitle(jsonObject.getString("title"));
                pml.setTdl(jsonObject.getString("tdl"));

                pmls.add(pml);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*
          Return list that was made
          */
        return pmls;

    }


}
