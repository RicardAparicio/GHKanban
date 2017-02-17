package inqbarna.com.ghkanban.activities;
/**
 * @author Ricard Aparicio <ricard.aparicio@inqbarna.com>
 * @version 1.0 17/02/17
 */

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import inqbarna.com.ghkanban.R;
import inqbarna.com.ghkanban.databinding.MainActivityBinding;
import inqbarna.com.ghkanban.viewmodel.MainVM;

public class MainActivity extends AppCompatActivity {

    public static Intent getCallingIntent(Context context) {
        Intent i = new Intent(context, MainActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.tabs.setupWithViewPager(binding.pager);
        binding.setModel(new MainVM(getSupportFragmentManager()));
    }
}