package com.example.mypizza;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.mypizza.fragments.TeamCharlie;
import com.example.mypizza.fragments.TeamBravo;

public class MainActivity extends AppCompatActivity  implements TeamBravo.OnItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);


    Log.d("DEBUG", getResources().getConfiguration().orientation + "");

    if (savedInstanceState == null) {
      // Instance of first fragment
      TeamBravo firstFragment = new TeamBravo();

      // Add Fragment to FrameLayout (flContainer), using FragmentManager
      FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
      ft.add(R.id.flContainer, firstFragment);                                // add    Fragment
      ft.commit();                                                            // commit FragmentTransaction
    }

    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
      TeamCharlie secondFragment = new TeamCharlie();
      Bundle args = new Bundle();
      args.putInt("position", 0);
      secondFragment.setArguments(args);          // (1) Communicate with Fragment using Bundle
      FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
      ft2.add(R.id.flContainer2, secondFragment);                               // add    Fragment
      ft2.commit();                                                            // commit FragmentTransaction
    }
  }

  @Override
  public void onPizzaItemSelected(int position) {
    Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();

    // Load Pizza Detail Fragment
    TeamCharlie secondFragment = new TeamCharlie();

    Bundle args = new Bundle();
    args.putInt("position", position);
    secondFragment.setArguments(args);          // (1) Communicate with Fragment using Bundle


    if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.flContainer2, secondFragment) // replace flContainer
          //.addToBackStack(null)
          .commit();
    }else{
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.flContainer, secondFragment) // replace flContainer
          .addToBackStack(null)
          .commit();
    }
  }
}
