package unicauca.movil.muiltiscreen;

import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.muiltiscreen.fragments.ColorFragment;
import unicauca.movil.muiltiscreen.fragments.ListFragment;

public class MainActivity extends AppCompatActivity implements ListFragment.OnColorSelectedListener{

    FragmentManager manager;
    boolean phone, land, secondScreen;

    ColorFragment color;
    ListFragment list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_main);

        secondScreen = false;
        manager = getSupportFragmentManager();
        phone = getResources().getBoolean(R.bool.phone);
        land = getResources().getBoolean(R.bool.land);

        list = ListFragment.instance();
        color = ColorFragment.instance(0);
        putFragment(R.id.container1, list);


        if(land && !phone)
            putFragment(R.id.container2, color);


    }

    private void putFragment(@IdRes int idContainer, Fragment fragment){
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(idContainer, fragment);
        ft.commit();
    }

    @Override
    public void onColorSelected(int posColor) {

        if(land && !phone){
            color.setColor(posColor);
        }else{
            color = ColorFragment.instance(posColor);
            putFragment(R.id.container1, color);
            secondScreen = true;
        }

    }

    @Override
    public void onBackPressed() {
        if(secondScreen)
            putFragment(R.id.container1, list);
        else
            super.onBackPressed();
    }
}
