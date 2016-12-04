package unicauca.movil.muiltiscreen.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.muiltiscreen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public static ListFragment instance(){
        return new ListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_list, container, false);
    }

}
