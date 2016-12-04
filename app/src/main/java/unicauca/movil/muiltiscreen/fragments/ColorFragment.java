package unicauca.movil.muiltiscreen.fragments;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.muiltiscreen.R;
import unicauca.movil.muiltiscreen.databinding.FragmentColorBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorFragment extends Fragment {


    public static final int RED = 0;
    public static final int BLUE = 1;
    public static final int YELLOW = 2;
    public static final int GREEN = 3;
    public static final int ORANGE = 4;
    public static final int VIOLET = 5;

    private static final String ARG_COLOR = "color";

    public static ColorFragment instance(int color){
        ColorFragment colorFragment = new ColorFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        colorFragment.setArguments(args);
        return  colorFragment;
    }

    int color;
    FragmentColorBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
            color =  getArguments().getInt(ARG_COLOR);
        else
            color = RED;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_color, container, false);
        binding.setColor(color);
        return binding.getRoot();
    }

    public void setColor(int color){
        binding.setColor(color);
    }

}
