package com.jadoo.risha.astrologer;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class calendar extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    public int currentYear;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        this.currentYear = year;
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        MainActivity o = (MainActivity) getActivity();
        String m = String.valueOf(dayOfMonth)+" - "+String.valueOf(month+1)+" - "+String.valueOf(year);
        o.ShowDate(m, dayOfMonth, month+1, year, currentYear);
    }

   /* @Override
    public void onDateSet(DatePickerDialog view, int year, int month, int day){
        Log.d("OnDateSet", String.valueOf(year));
    }*/
}
