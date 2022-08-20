package com.example.mypizza.fragments;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mypizza.R;

/**
 * Created by Shyam Rokde on 8/5/16.
 */
public class TeamBravo extends Fragment {
  int sc;
  TextView score;
  Button inc,dec;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
    // Inflate the xml file for the fragment
    View view = inflater.inflate(R.layout.fragment_bravo, parent, false);
    score = view.findViewById(R.id.score);
    inc = view.findViewById(R.id.increase);
    dec = view.findViewById(R.id.decrease);
    return view;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    inc.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sc++;
        score.setText("Team Charlie Score is  : " + sc);
      }
    });
    dec.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sc--;
        score.setText("Team Charlie Score is  : " + sc);
      }
    });

  }




  //--OnItemSelectedListener listener;
  // This event fires 1st, before creation of fragment or any views
  // The onAttach method is called when the Fragment instance is associated with an Activity.
  // This does not mean the Activity is fully initialized.
  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }


  // Define the events that the fragment will use to communicate
  public interface OnItemSelectedListener {
    // This can be any number of events to be sent to the activity
    void onPizzaItemSelected(int position);
  }

}
