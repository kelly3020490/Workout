package com.example.workout;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;


public class WorkoutListFragment extends ListFragment {
    static interface Listener{
        void itemClicked(long id);
    }

    private Listener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] names = new String[Workout.workouts.length];
        for(int i = 0; i < names.length; i++){
            names[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
        return super.onCreateView(inflater,container,savedInstanceState);

    }

    public void onAttach(Context context){
        super.onAttach(context);
        this.listener = (Listener) context;
    }

    public void onListItemClick(ListView listView,View itemViem,int position,long id){
        if(listener != null){
            listener.itemClicked(id);
        }
    }

}