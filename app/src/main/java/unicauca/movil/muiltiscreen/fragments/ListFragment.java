package unicauca.movil.muiltiscreen.fragments;


import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import unicauca.movil.muiltiscreen.BR;
import unicauca.movil.muiltiscreen.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements AdapterView.OnItemClickListener
{

    public interface OnColorSelectedListener{
        void onColorSelected(int posColor);
    }

    ViewDataBinding binding;
    OnColorSelectedListener onColorSelectedListener;

    public static ListFragment instance(){
        return new ListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnColorSelectedListener)
            onColorSelectedListener = (OnColorSelectedListener) context;
        else
            throw new RuntimeException(context.toString()
                    +" debe implementar OnColorSelectedListener");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.f_list, container, false);
        binding = DataBindingUtil.bind(v);
        binding.setVariable(BR.onItemClick, this);
        return binding.getRoot();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        onColorSelectedListener.onColorSelected(i);
    }
}
