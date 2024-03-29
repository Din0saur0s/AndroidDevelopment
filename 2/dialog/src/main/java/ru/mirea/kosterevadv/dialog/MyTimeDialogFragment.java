package ru.mirea.kosterevadv.dialog;


import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import java.util.Calendar;

public class MyTimeDialogFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    Calendar dateAndTime=Calendar.getInstance();
    @NonNull
    @Override
    public Dialog onCreateDialog (Bundle savedInstanceState) {


        return new TimePickerDialog(getActivity(), this,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true);
    }


    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

    }
}
