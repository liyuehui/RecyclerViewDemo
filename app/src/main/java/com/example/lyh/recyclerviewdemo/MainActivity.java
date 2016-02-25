package com.example.lyh.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private ArrayList personList = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_view);
        recyclerView.setHasFixedSize(true);
        ABaseLinearLayoutManager layoutManager = new ABaseLinearLayoutManager(this);
        layoutManager.setOnRecyclerViewScrollLocationListener(recyclerView, new OnRecyclerViewScrollLocationListener() {
            @Override
            public void onTopWhenScrollIdle(RecyclerView recyclerView) {

            }

            @Override
            public void onBottomWhenScrollIdle(RecyclerView recyclerView) {

            }
        });
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        layoutManager.getRecyclerViewScrollManager().addScrollListener(recyclerView, new OnRecyclerViewScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            }
        });

        recyclerView.setLayoutManager(layoutManager);

//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);


        initData();
        adapter = new PersonAdapter(personList);
        recyclerView.setAdapter(adapter);


    }

    private void initData() {
        Person person = null;
        for (int i = 0; i < 100; i++) {
            person = new Person(new String("Tom" + i), new String(i + ""));
            personList.add(person);
        }
    }

    class Person {
        Person(String name, String age) {
            this.name = name;
            this.age = age;
        }

        String name;
        String age;
    }

    class PersonAdapter extends RecyclerView.Adapter {

        private ArrayList list;

        PersonAdapter(ArrayList list) {
            this.list = list;
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            PersonViewHolder holder = (PersonViewHolder) viewHolder;
            Person person = (Person) list.get(i);
            holder.tv_age.setText(person.age);
            holder.tv_name.setText(person.name);
            holder.position = i;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

            View view = View.inflate(MainActivity.this, R.layout.item_view, null);


            return new PersonViewHolder(view);
        }

        class PersonViewHolder extends RecyclerView.ViewHolder {
            public int position;
            public View rootView;
            public TextView tv_age;
            public TextView tv_name;
            public RelativeLayout relativeLayout;

            public PersonViewHolder(View itemView) {
                super(itemView);
                relativeLayout = (RelativeLayout) itemView.findViewById(R.id.recycler_view_test_item_person_view);
                tv_name = (TextView) itemView.findViewById(R.id.tv_name);
                tv_age = (TextView) itemView.findViewById(R.id.tv_age);
                relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {

                        list.remove(position);
                        PersonAdapter.this.notifyDataSetChanged();
                        return false;
                    }
                });
            }

        }

    }


}
