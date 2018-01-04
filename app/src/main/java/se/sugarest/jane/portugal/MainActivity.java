package se.sugarest.jane.portugal;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import se.sugarest.jane.portugal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Set up ToolBar
        setSupportActionBar(mBinding.appBar.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
}
