package com.jonathanfinerty.liquid.presentation.activities;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jonathanfinerty.liquid.R;
import com.jonathanfinerty.liquid.presentation.fragments.BudgetFragment;
import com.jonathanfinerty.liquid.presentation.fragments.ListExpenseFragment;

public class OverviewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager_overview);
        viewpager.setAdapter(new LiquidPagerAdapter(getFragmentManager()));

        PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pagerTabStrip_overview);
        pagerTabStrip.setTextColor(getResources().getColor(R.color.blue_dark));
        pagerTabStrip.setTabIndicatorColorResource(R.color.blue_dark);
        pagerTabStrip.setDrawFullUnderline(true);

        Button button = (Button) findViewById(R.id.overview_activity_button_add_expense);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addExpenseIntent = new Intent(OverviewActivity.this, AddExpenseActivity.class);
                startActivity(addExpenseIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_set_budget:
                Intent setBudgetActivity = new Intent(this, SetBudgetActivity.class);
                startActivity(setBudgetActivity);
                return true;
            case R.id.action_add_expense:
                Intent addExpenseIntent = new Intent(this, AddExpenseActivity.class);
                startActivity(addExpenseIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    public static class LiquidPagerAdapter extends FragmentPagerAdapter {

        public LiquidPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: {
                    return new BudgetFragment();
                }
                case 1: {
                    return new ListExpenseFragment();
                }
            }

            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: {
                    return "Budget";
                }
                case 1: {
                    return "Expenses";
                }
            }

            return null;
        }
    }
}