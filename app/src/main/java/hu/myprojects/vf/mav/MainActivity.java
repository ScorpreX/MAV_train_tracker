package hu.myprojects.vf.mav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import hu.myprojects.vf.mav.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void searchTrains(View view) {
        Intent searchTrainsIndent = new Intent(this, DepartureTrainsActivity.class);
        searchTrainsIndent.putExtra(getString(R.string.from), binding.tvFrom.getText().toString());
        searchTrainsIndent.putExtra(getString(R.string.to), binding.tvTo.getText().toString());
        startActivity(searchTrainsIndent);
    }
}