package com.lorkin.treerecycleview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private RecyclerView ry;
    private TreeAdapter treeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ry.setLayoutManager(linearLayoutManager);
        ry.setAdapter(treeAdapter = new TreeImplAdapter(this));

        StringBuilder builder = new StringBuilder();
        try {
            InputStream open = getResources().getAssets().open("mockData.json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(open));
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ItemData item = new Gson().fromJson(builder.toString(), ItemData.class);

        treeAdapter.setDatas(item.getData());
//        treeAdapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position, Object o) {
//                TreeItem item1 = (TreeItem) o;
//                Toast.makeText(MainActivity.this, item1.getObj(), Toast.LENGTH_LONG).show();
//            }
//        });

    }

    private void initView() {
        ry = (RecyclerView) findViewById(R.id.ry);
    }

}