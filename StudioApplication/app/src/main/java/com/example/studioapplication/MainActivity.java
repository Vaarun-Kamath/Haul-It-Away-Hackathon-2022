package com.example.studioapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
//import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.studioapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(R.layout.activity_main); TODO IDK WHAT HE DID BUT HE REMOVED THE PARAMETERS HERE I DIDNT WANT TO DELETE :)
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemReselectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.home_button:
                    replaceFragment(new HomeFragment());
//                    setContentView(R.layout.fragment_home);
                    break;
                case R.id.person_button:
                    replaceFragment(new PersonFragment());
//                    setContentView(R.layout.fragment_person);
                    break;
                case R.id.settings_button:
                    replaceFragment(new SettingsFragment());
//                    setContentView(R.layout.fragment_home);
                    break;



            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_id,fragment);
        fragmentTransaction.commit();

    }
}