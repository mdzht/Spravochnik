package kz.test.spravochnik.ui;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import kz.test.spravochnik.R;
import kz.test.spravochnik.di.BaseDaggerActivity;

public abstract class BaseMainActivity extends BaseDaggerActivity {

    @Nullable
    @Bind({R.id.toolbar})
    protected Toolbar mToolbar;

    protected void changeFragment(Fragment fragment) {
        changeFragment(fragment, false);
    }

    protected void changeFragment(Fragment fragment, boolean addToBackStack) {
        if (this.mToolbar != null && Build.VERSION.SDK_INT >= 21) {
            this.mToolbar.setElevation(getResources().getDimension(R.dimen.toolbar_elevation));
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.commitAllowingStateLoss();
    }

    protected void initActionBar() {
        if (this.mToolbar != null) {
            setSupportActionBar(this.mToolbar);
            this.mToolbar.setTitle(getString(R.string.app_name));
            this.mToolbar.setNavigationIcon(R.drawable.ic_back);
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setHomeButtonEnabled(true);
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public Toolbar getToolbar() {
        return this.mToolbar;
    }
}
