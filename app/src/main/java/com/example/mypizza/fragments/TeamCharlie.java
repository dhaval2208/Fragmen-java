package com.example.mypizza.fragments;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mypizza.R;
import com.codepath.mypizza.data.Pizza;

/**
 * Created by Shyam Rokde on 8/5/16.
 */
public class TeamCharlie extends Fragment {
  int sc;
  TextView score;
  Button inc,dec;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {

    // Inflate the xml file for the fragment
    View view = inflater.inflate(R.layout.fragment_charlie, parent, false);
    score = view.findViewById(R.id.score);
    inc = view.findViewById(R.id.increase);
    dec = view.findViewById(R.id.decrease);
    return view;
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    // Set values for view here
    inc.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sc++;
        score.setText("Team Bravo Score is  : " + sc);
      }
    });
    dec.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sc--;
        score.setText("Team Bravo Score is  : " + sc);

      }
    });
  }

}
