package com.example.csaper6.hacker;

import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by csaper6 on 10/19/16.
 */
public class ButtonAbility {
    private ArrayList<Boolean> buttons;


    public ButtonAbility(boolean a, boolean b, boolean c, boolean d, boolean e, boolean f)
    {
        buttons = new ArrayList<Boolean>();
        buttons.add(a);
        buttons.add(b);
        buttons.add(c);
        buttons.add(d);
        buttons.add(e);
        buttons.add(f);

    }

    public void changeAbility(Button a, boolean b)
    {
        a.setEnabled(b);
        changeButtonText(a, "BOUGHT");
    }

    public void changeButtonText(Button a, String s)
    {
        a.setText(s);
    }






}
