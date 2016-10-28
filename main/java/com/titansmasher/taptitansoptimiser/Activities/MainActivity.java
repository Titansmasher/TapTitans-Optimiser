//Dont look here, its horribly messy and badly designed. Shoo, go away!

package com.titansmasher.taptitansoptimiser.Activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimiser.Models.Enums.Artifact;
import com.titansmasher.taptitansoptimiser.Models.Enums.CalculationType;
import com.titansmasher.taptitansoptimiser.Models.Enums.Page;
import com.titansmasher.taptitansoptimiser.Models.Enums.World;
import com.titansmasher.taptitansoptimiser.Models.LiveUpdate;
import com.titansmasher.taptitansoptimiser.Models.Optimiser.PurchaseStep;
import com.titansmasher.taptitansoptimiser.Models.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimiser.Optimisers.RelicOptimiser;
import com.titansmasher.taptitansoptimiser.Save.SaveManager;
import com.titansmasher.taptitansoptimiser.Models.SequencePriority.SequenceArtifact;
import com.titansmasher.taptitansoptimiser.Models.UnityRandom.UnityRandom;
import com.titansmasher.taptitansoptimiser.Optimisers.Sequencer;
import com.titansmasher.taptitansoptimiser.Models.WorldSave;
import com.titansmasher.taptitansoptimiser.OptimiserApp;
import com.titansmasher.taptitansoptimiser.Models.SequencePriority.SequencePriorityModel;
import com.titansmasher.taptitansoptimiser.R;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        
    //I said dont look here! Dont judge me

    private File saveLocation;
    private SharedPreferences preferences;
    private String installMessageShownKey = "installMessageShown";
    private String showUnableToLocateSaveKey = "showUnableToLocateSave";
    private int loadSaveFileRequestKey = 1;
    private OptimiserApp application;
    private SaveManager saveManager;
    private MenuItem newSave;
    private Map<MenuItem, Integer> saveIdMap = new HashMap<>();
    private Map<MenuItem, World> worldItems = new HashMap<>();
    private Map<TabLayout.Tab, Page> pageTabs = new HashMap<>();
    private Map<Page, View> pages = new HashMap<>();
    private ScrollView scrollView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private boolean blockUi;

    //region Method Overrides

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(getString(com.titansmasher.taptitansoptimiser.R.string.app_name), Context.MODE_PRIVATE);
        application = (OptimiserApp) getApplication();
        saveManager = application.saveManager;
        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);

        try {
            application.artifactUnityRandom.put(World.WORLD_1, UnityRandom.getUnityRandom(application.getAssets().open("artifact_order_W1.csv")));
            application.artifactUnityRandom.put(World.WORLD_2, UnityRandom.getUnityRandom(application.getAssets().open("artifact_order_W2.csv")));
        }
        catch (IOException ex){
            Snackbar.make(findViewById(R.id.main_layout), "ERROR: Could not load assets. Things wont work :(", Snackbar.LENGTH_LONG).show();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initPages();

        setEvents();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        TextView navHeader = (TextView) navigationView.getHeaderView(0).findViewById(R.id.textView_Titansmasher);
        navHeader.setText(Html.fromHtml(getString(R.string.appDesc_titansmasher)));
        navHeader.setMovementMethod(LinkMovementMethod.getInstance());

        pageTabs.put(findTabByText(tabLayout, getString(R.string.tab_stats)), Page.Stats);
        pageTabs.put(findTabByText(tabLayout, getString(R.string.tab_optimiser)), Page.Calculator);
        pageTabs.put(findTabByText(tabLayout, getString(R.string.tab_sequencer)), Page.Sequencer);
        pageTabs.put(findTabByText(tabLayout, getString(R.string.tab_faqabout)), Page.FAQHelp);

        viewPager = new ViewPager(this);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String text = (String) tab.getText();
                changePage(pageTabs.get(tab));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        selectTab(application.currentPage);

        this.worldItems.put(findItemById(findItemById(navigationView.getMenu(), R.id.nav_world).getSubMenu(), R.id.nav_world_1), World.WORLD_1);
        this.worldItems.put(findItemById(findItemById(navigationView.getMenu(), R.id.nav_world).getSubMenu(), R.id.nav_world_2), World.WORLD_2);
        selectWorld(this.application.currentWorld);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (item == this.newSave) {
            final EditText input = new EditText(this);
            final View view = findViewById(R.id.main_layout);

            new AlertDialog.Builder(this)
                    .setTitle("Enter save name")
                    .setView(input)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            String text = input.getText().toString();
                            if (text.length() >= 3) {
                                saveManager.setActiveSave(saveManager.addSave(text, new TapTitansSave()));
                                Snackbar.make(view, "Created blank save \"" + text + "\"", Snackbar.LENGTH_LONG).show();
                            } else {
                                Snackbar.make(view, "Save name too short. Min 3 characters", Snackbar.LENGTH_LONG).show();
                            }
                            updateSaveList();
                            updatePageContents();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create()
                    .show();
        } else if (this.saveIdMap.keySet().contains(item)) {
            saveManager.setActiveSave(this.saveIdMap.get(item));
            for (MenuItem saveItem :
                    this.saveIdMap.keySet()) {
                saveItem.setChecked(false);
            }
            item.setChecked(true);
        } else {
            int id = item.getItemId();
            switch (id) {
                case R.id.nav_world_1:
                    application.currentWorld = World.WORLD_1;
                    selectWorld(World.WORLD_1);
                    break;
                case R.id.nav_world_2:
                    application.currentWorld = World.WORLD_2;
                    selectWorld(World.WORLD_2);
                    break;
            }
        }
        updatePageContents();
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (this.application.defaultSave == -1)
            this.application.defaultSave = saveManager.addSave("Blank save", new TapTitansSave());

        this.preferences = this.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        if (isTapTitansInstalled())
            loadSaveFile();
        updateSaveList();
        changePage(this.application.currentPage, true);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (permissions.length == 0)
            return;

        if (requestCode == this.loadSaveFileRequestKey) {
            if (GenericHelpers.areAllTheSame(grantResults) && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (isTapTitansInstalled()) {
                    loadSaveFile();
                    updateSaveList();
                    updatePageContents();
                }
            }
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev){
        if (blockUi){
            return true;
        } else {
            return super.dispatchTouchEvent(ev);
        }
    }

    //endregion

    private void initPages() {
        this.scrollView = (ScrollView) findViewById(R.id.main_scrollview);
        this.pages.put(Page.Stats, View.inflate(scrollView.getContext(), R.layout.content_statspage, null));
        this.pages.put(Page.Calculator, View.inflate(scrollView.getContext(), R.layout.content_optimiserpage, null));
        this.pages.put(Page.Sequencer, View.inflate(scrollView.getContext(), R.layout.content_sequencerpage, null));
        this.pages.put(Page.FAQHelp, View.inflate(scrollView.getContext(), R.layout.content_faqpage, null));
    }

    private void setEvents(){
        ((ToggleButton)this.pages.get(Page.Sequencer).findViewById(R.id.sequencer_togglebutton_showpriorities)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    pages.get(Page.Sequencer).findViewById(R.id.seqquencer_table_artifactpriorities).setVisibility(View.VISIBLE);
                else
                    pages.get(Page.Sequencer).findViewById(R.id.seqquencer_table_artifactpriorities).setVisibility(View.GONE);
            }
        });
        this.pages.get(Page.Sequencer).findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optimiseSequence();
            }
        });

        this.pages.get(Page.Stats).findViewById(R.id.stats_accountheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout table = (TableLayout)pages.get(Page.Stats).findViewById(R.id.stats_accounttable);
                if (table.getVisibility() == View.VISIBLE){
                    table.setVisibility(View.GONE);
                } else {
                    table.setVisibility(View.VISIBLE);
                }
            }
        });
        this.pages.get(Page.Stats).findViewById(R.id.stats_purchaseheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout table = (TableLayout)pages.get(Page.Stats).findViewById(R.id.stats_purchasetable);
                if (table.getVisibility() == View.VISIBLE){
                    table.setVisibility(View.GONE);
                } else {
                    table.setVisibility(View.VISIBLE);
                }
            }
        });
        this.pages.get(Page.Stats).findViewById(R.id.stats_worldheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout table = (TableLayout)pages.get(Page.Stats).findViewById(R.id.stats_worldtable);
                if (table.getVisibility() == View.VISIBLE){
                    table.setVisibility(View.GONE);
                } else {
                    table.setVisibility(View.VISIBLE);
                }
            }
        });
        this.pages.get(Page.Stats).findViewById(R.id.stats_artifactheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout table = (LinearLayout)pages.get(Page.Stats).findViewById(R.id.stats_artifacttables);
                if (table.getVisibility() == View.VISIBLE){
                    table.setVisibility(View.GONE);
                } else {
                    table.setVisibility(View.VISIBLE);
                }
            }
        });
        this.pages.get(Page.Calculator).findViewById(R.id.optimiser_dmgbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArtifactTable(CalculationType.DMG);
            }
        });
        this.pages.get(Page.Calculator).findViewById(R.id.optimiser_goldbutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArtifactTable(CalculationType.GOLD);
            }
        });
        this.pages.get(Page.Calculator).findViewById(R.id.optimiser_tdmgbuutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArtifactTable(CalculationType.TDMG);
            }
        });
        this.pages.get(Page.Calculator).findViewById(R.id.optimiser_dmgebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                populateArtifactTable(CalculationType.DMGE);
            }
        });
        this.pages.get(Page.Calculator).findViewById(R.id.optimiser_orderheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout table = findTable(R.id.optimiser_artifactsequence);
                if (table.getVisibility() == View.GONE){
                    table.setVisibility(View.VISIBLE);
                }
                else {
                    table.setVisibility(View.GONE);
                }
            }
        });
        this.pages.get(Page.Calculator).findViewById(R.id.optimiser_totalsheader).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TableLayout table = findTable(R.id.optimiser_artifacttotal);
                if (table.getVisibility() == View.GONE){
                    table.setVisibility(View.VISIBLE);
                }
                else {
                    table.setVisibility(View.GONE);
                }
            }
        });
    }

    private void loadSaveFile() {
        String[] permissionsNeeded = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (!hasAllPermissions(permissionsNeeded)) {
            requestPermissionList(permissionsNeeded, this.loadSaveFileRequestKey);
            return;
        }

        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + getString(R.string.tapTitans_name);
        File f = new File(path);
        File[] files = f.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().matches("^files(?!Save).*\\.adat$")) {
                    saveLocation = file;
                    break;
                }
            }
        }
        if (this.preferences.getBoolean(showUnableToLocateSaveKey, true) && saveLocation == null) {
            new AlertDialog.Builder(this)
                    .setTitle("Unable to locate save")
                    .setMessage("Unable to locate the TapTitans save file. Please send a message to /u/Titansmasher_ on reddit about this issue")
                    .setPositiveButton("Send Message", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.reddit.com/message/compose/?to=Titansmasher_")));
                        }
                    })
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .create()
                    .show();
            this.preferences.edit().putBoolean(showUnableToLocateSaveKey, false).commit();
            return;
        }
        this.preferences.edit().putBoolean(showUnableToLocateSaveKey, true).commit();
        try {
            this.saveManager.removeSave(this.application.defaultSave);
            this.application.defaultSave = this.saveManager.addSave("TapTitans Save", new TapTitansSave(saveLocation, false));
            if (this.saveManager.getSaveIds().size() == 1)
                this.saveManager.setActiveSave(this.application.defaultSave);
        } catch (Exception ex) {
            Log.d("SaveCreation", ex.getMessage());
        }
    }

    private boolean isTapTitansInstalled() {
        try {
            this.getPackageManager().getApplicationInfo(getString(R.string.tapTitans_name), 0);
            return true;
        } catch (PackageManager.NameNotFoundException ex) {
            if (this.preferences.getBoolean(installMessageShownKey, false))
                return false;
            new AlertDialog.Builder(this)
                    .setTitle("TapTitans not installed")
                    .setMessage("This app is based around the TapTitans game. It is reccomended that you install the TapTitans app first")
                    .setPositiveButton("Download App", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            try {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + getString(R.string.tapTitans_name))));
                            } catch (ActivityNotFoundException ex) {
                                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + getString(R.string.tapTitans_name))));
                            }
                        }
                    })
                    .setNegativeButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_info)
                    .create()
                    .show();
            this.preferences.edit().putBoolean(installMessageShownKey, true).commit();
            return false;
        }
    }

    private boolean requestPermissionList(String[] permissions, int requestId) {
        List<String> permissionsToRequest = new ArrayList<>();
        boolean missingPermission = false;

        for (String permission :
                permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                missingPermission = true;
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                    permissionsToRequest.add(permission);
                }
            }
        }

        if (permissionsToRequest.size() > 0) {
            ActivityCompat.requestPermissions(this, permissionsToRequest.toArray(new String[permissionsToRequest.size()]), requestId);
        }

        return !missingPermission;
    }

    private boolean hasAllPermissions(String[] permissions) {
        for (String permission :
                permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }

        return true;
    }

    private void wipeMenu(Menu menu) {
        while (menu.size() > 0) {
            menu.removeItem(menu.getItem(0).getItemId());
        }
    }

    private MenuItem findItemById(Menu menu, int id) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).getItemId() == id) {
                return menu.getItem(i);
            }
        }

        return null;
    }

    private TabLayout.Tab findTabByText(TabLayout tabLayout, String text) {
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            if (tabLayout.getTabAt(i).getText().equals(text))
                return tabLayout.getTabAt(i);
        }
        return null;
    }

    private void selectWorld(World world) {
        for (MenuItem worldItem :
                this.worldItems.keySet()) {
            worldItem.setChecked(false);
        }
        Iterator<?> iterator = this.worldItems.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getValue() == world) {
                ((MenuItem) entry.getKey()).setChecked(true);
            }
        }
    }

    private void selectTab(Page page) {
        Iterator<?> iterator = this.pageTabs.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (entry.getValue() == page) {
                ((TabLayout.Tab) entry.getKey()).select();
                return;
            }
        }
    }

    private void updateSaveList() {
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem saveItem = findItemById(navView.getMenu(), R.id.nav_save);
        if (saveItem == null)
            return;

        Menu saveMenu = saveItem.getSubMenu();

        wipeMenu(saveMenu);

        this.saveIdMap = new HashMap<>();

        for (int i :
                saveManager.getSaveIds()) {
            MenuItem item = saveMenu.add(saveManager.getSaveName(i));
            item.setIcon(GenericHelpers.drawableFromAttr(android.R.attr.textCheckMark, getTheme(), getResources()));
            item.setCheckable(true);
            if (saveManager.getActiveSave() == i)
                item.setChecked(true);

            this.saveIdMap.put(item, i);
        }

        this.newSave = saveMenu.add("Add new save");
        newSave.setVisible(false);
        this.newSave.setIcon(android.R.drawable.ic_menu_add);
    }

    private void changePage(Page page) {
        changePage(page, false);
    }

    private void changePage(Page page, boolean force) {
        if (force || page != application.currentPage) {
            scrollView.removeAllViews();
            scrollView.addView(pages.get(page));
            switch (page) {
                case FAQHelp:
                    TextView textView = (TextView) findViewById(R.id.textView_FAQ);
                    textView.setText(Html.fromHtml(getString(R.string.content_faqabouttext)));
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                    break;
                case Stats:
                    populateStats();
                    break;
                case Calculator:
                    populateOptimiser();
                    break;
                case Sequencer:
                    populateSequencer();
                    break;
            }
            application.currentPage = page;
        }
    }

    private void updatePageContents() {
        switch (application.currentPage) {
            case FAQHelp:
                break;
            case Stats:
                populateStats();
                break;
            case Calculator:
                populateOptimiser();
                break;
            case Sequencer:
                populateSequencer();
                break;
        }
    }

    private void populateStats() {
        WorldSave save = application.saveManager.getActiveSave(application.currentWorld);

        //region Account table

        findTextView(R.id.stats_account_playername).setText(save.playerName);
        findTextView(R.id.stats_account_friendcode).setText(save.friendCode);
        findTextView(R.id.stats_account_playerlevel).setText(String.valueOf(save.playerLevel));
        findTextView(R.id.stats_account_lastactive).setText(GenericHelpers.formatDate(save.lastActiveTime, "dd/MM/yyyy HH:mm:ss"));
        findTextView(R.id.stats_account_playtime).setText(GenericHelpers.secondsToTime(save.activeTime));
        findTextView(R.id.stats_account_diamonds).setText(String.valueOf(save.playerDiamonds));
        findTextView(R.id.stats_account_artifactseed).setText(String.valueOf(save.nextArtifactSeed));
        findTextView(R.id.stats_account_weaponseed).setText(String.valueOf(save.heroWeaponSeed));
        findTextView(R.id.stats_account_timesincesync).setText(GenericHelpers.secondsToTime((int) save.playTimeSinceLastSync));
        findTextView(R.id.stats_account_dungeonchain).setText(String.valueOf(save.dungeonsCompleted));
        findTextView(R.id.stats_account_lastcloudsave).setText(GenericHelpers.formatDate(save.lastCloudSaveTime, "dd/MM/yyyy HH:mm:ss"));
        findTextView(R.id.stats_account_ischeater).setText(GenericHelpers.boolToYesNoString(save.cheater));
        if (save.cheater) {
            findTextView(R.id.stats_account_cheatercount).setText(String.valueOf(save.cheatCount));
            findTextView(R.id.stats_account_cheaterreason).setText(save.cheaterReason);
            findRow(R.id.stats_account_cheatercountrow).setVisibility(View.VISIBLE);
            findRow(R.id.stats_account_cheaterreasonrow).setVisibility(View.VISIBLE);
        } else {
            findRow(R.id.stats_account_cheatercountrow).setVisibility(View.GONE);
            findRow(R.id.stats_account_cheaterreasonrow).setVisibility(View.GONE);
        }

        //endregion

        //region Purchases table

        findTextView(R.id.stats_purchases_purchasecount).setText(String.valueOf(save.iapPurchaseCount));
        findTextView(R.id.stats_purchases_spendamount).setText("$" + save.iapSpendingInUSD);
        findTextView(R.id.stats_purchases_unapprovedpurchases).setText(String.valueOf(save.iapPurchaseCount - save.iapApprovedByAppleGoogle));
        findTextView(R.id.stats_purchases_diamonds1).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds1));
        findTextView(R.id.stats_purchases_diamonds2).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds2));
        findTextView(R.id.stats_purchases_diamonds3).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds3));
        findTextView(R.id.stats_purchases_diamonds4).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds4));
        findTextView(R.id.stats_purchases_diamonds5).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds5));
        findTextView(R.id.stats_purchases_diamonds6).setText("x " + String.valueOf(save.allRewardedIAPs.diamonds6));
        //endregion

        //region World table

        int totalRelics = save.playerRelics;
        for (int i:
                save.artifactRelicsSpent.getForWorld(application.currentWorld)){
            totalRelics += i;
        }

        findTextView(R.id.stats_world_maxstage).setText(String.valueOf((int) save.trophyProgress.ReachStage.progress));
        findTextView(R.id.stats_world_currentstage).setText(String.valueOf(save.currentStage));
        findTextView(R.id.stats_world_relics).setText(String.valueOf(save.playerRelics));
        findTextView(R.id.stats_world_totalrelics).setText(String.valueOf(totalRelics));
        findTextView(R.id.stats_world_totalgold).setText(GenericHelpers.beautify(save.playerGold));
        findTextView(R.id.stats_world_goldlost).setText(GenericHelpers.beautify(save.goldLostToPrestige));
        findTextView(R.id.stats_world_dpslost).setText(GenericHelpers.beautify(save.dpsLostToPrestige));

        //endregion

        //region Artifact table

        switch (application.currentWorld) {
            case WORLD_1:
                findTable(R.id.stats_artifacts_world1table).setVisibility(View.VISIBLE);
                findTable(R.id.stats_artifacts_world2table).setVisibility(View.GONE);
                findTextView(R.id.stats_artifacts_artifact1_level).setText(String.valueOf(save.artifactLevels.Artifact1));
                findTextView(R.id.stats_artifacts_artifact1_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact1));
                findTextView(R.id.stats_artifacts_artifact2_level).setText(String.valueOf(save.artifactLevels.Artifact2));
                findTextView(R.id.stats_artifacts_artifact2_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact2));
                findTextView(R.id.stats_artifacts_artifact3_level).setText(String.valueOf(save.artifactLevels.Artifact3));
                findTextView(R.id.stats_artifacts_artifact3_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact3));
                findTextView(R.id.stats_artifacts_artifact4_level).setText(String.valueOf(save.artifactLevels.Artifact4));
                findTextView(R.id.stats_artifacts_artifact4_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact4));
                findTextView(R.id.stats_artifacts_artifact5_level).setText(String.valueOf(save.artifactLevels.Artifact5));
                findTextView(R.id.stats_artifacts_artifact5_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact5));
                findTextView(R.id.stats_artifacts_artifact6_level).setText(String.valueOf(save.artifactLevels.Artifact6));
                findTextView(R.id.stats_artifacts_artifact6_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact6));
                findTextView(R.id.stats_artifacts_artifact7_level).setText(String.valueOf(save.artifactLevels.Artifact7));
                findTextView(R.id.stats_artifacts_artifact7_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact7));
                findTextView(R.id.stats_artifacts_artifact8_level).setText(String.valueOf(save.artifactLevels.Artifact8));
                findTextView(R.id.stats_artifacts_artifact8_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact8));
                findTextView(R.id.stats_artifacts_artifact9_level).setText(String.valueOf(save.artifactLevels.Artifact9));
                findTextView(R.id.stats_artifacts_artifact9_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact9));
                findTextView(R.id.stats_artifacts_artifact10_level).setText(String.valueOf(save.artifactLevels.Artifact10));
                findTextView(R.id.stats_artifacts_artifact10_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact10));
                findTextView(R.id.stats_artifacts_artifact11_level).setText(String.valueOf(save.artifactLevels.Artifact11));
                findTextView(R.id.stats_artifacts_artifact11_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact11));
                findTextView(R.id.stats_artifacts_artifact12_level).setText(String.valueOf(save.artifactLevels.Artifact12));
                findTextView(R.id.stats_artifacts_artifact12_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact12));
                findTextView(R.id.stats_artifacts_artifact13_level).setText(String.valueOf(save.artifactLevels.Artifact13));
                findTextView(R.id.stats_artifacts_artifact13_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact13));
                findTextView(R.id.stats_artifacts_artifact14_level).setText(String.valueOf(save.artifactLevels.Artifact14));
                findTextView(R.id.stats_artifacts_artifact14_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact14));
                findTextView(R.id.stats_artifacts_artifact15_level).setText(String.valueOf(save.artifactLevels.Artifact15));
                findTextView(R.id.stats_artifacts_artifact15_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact15));
                findTextView(R.id.stats_artifacts_artifact16_level).setText(String.valueOf(save.artifactLevels.Artifact16));
                findTextView(R.id.stats_artifacts_artifact16_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact16));
                findTextView(R.id.stats_artifacts_artifact17_level).setText(String.valueOf(save.artifactLevels.Artifact17));
                findTextView(R.id.stats_artifacts_artifact17_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact17));
                findTextView(R.id.stats_artifacts_artifact18_level).setText(String.valueOf(save.artifactLevels.Artifact18));
                findTextView(R.id.stats_artifacts_artifact18_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact18));
                findTextView(R.id.stats_artifacts_artifact19_level).setText(String.valueOf(save.artifactLevels.Artifact19));
                findTextView(R.id.stats_artifacts_artifact19_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact19));
                findTextView(R.id.stats_artifacts_artifact20_level).setText(String.valueOf(save.artifactLevels.Artifact20));
                findTextView(R.id.stats_artifacts_artifact20_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact20));
                findTextView(R.id.stats_artifacts_artifact21_level).setText(String.valueOf(save.artifactLevels.Artifact21));
                findTextView(R.id.stats_artifacts_artifact21_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact21));
                findTextView(R.id.stats_artifacts_artifact22_level).setText(String.valueOf(save.artifactLevels.Artifact22));
                findTextView(R.id.stats_artifacts_artifact22_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact22));
                findTextView(R.id.stats_artifacts_artifact23_level).setText(String.valueOf(save.artifactLevels.Artifact23));
                findTextView(R.id.stats_artifacts_artifact23_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact23));
                findTextView(R.id.stats_artifacts_artifact24_level).setText(String.valueOf(save.artifactLevels.Artifact24));
                findTextView(R.id.stats_artifacts_artifact24_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact24));
                findTextView(R.id.stats_artifacts_artifact25_level).setText(String.valueOf(save.artifactLevels.Artifact25));
                findTextView(R.id.stats_artifacts_artifact25_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact25));
                findTextView(R.id.stats_artifacts_artifact26_level).setText(String.valueOf(save.artifactLevels.Artifact26));
                findTextView(R.id.stats_artifacts_artifact26_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact26));
                findTextView(R.id.stats_artifacts_artifact27_level).setText(String.valueOf(save.artifactLevels.Artifact27));
                findTextView(R.id.stats_artifacts_artifact27_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact27));
                findTextView(R.id.stats_artifacts_artifact28_level).setText(String.valueOf(save.artifactLevels.Artifact28));
                findTextView(R.id.stats_artifacts_artifact28_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact28));
                findTextView(R.id.stats_artifacts_artifact29_level).setText(String.valueOf(save.artifactLevels.Artifact29));
                findTextView(R.id.stats_artifacts_artifact29_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact29));
                findTextView(R.id.stats_artifacts_artifact30_level).setText(String.valueOf(save.artifactLevels.Artifact30));
                findTextView(R.id.stats_artifacts_artifact30_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact30));
                break;
            case WORLD_2:
                findTable(R.id.stats_artifacts_world2table).setVisibility(View.VISIBLE);
                findTable(R.id.stats_artifacts_world1table).setVisibility(View.GONE);
                findTextView(R.id.stats_artifacts_artifact31_level).setText(String.valueOf(save.artifactLevels.Artifact31));
                findTextView(R.id.stats_artifacts_artifact31_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact31));
                findTextView(R.id.stats_artifacts_artifact32_level).setText(String.valueOf(save.artifactLevels.Artifact32));
                findTextView(R.id.stats_artifacts_artifact32_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact32));
                findTextView(R.id.stats_artifacts_artifact33_level).setText(String.valueOf(save.artifactLevels.Artifact33));
                findTextView(R.id.stats_artifacts_artifact33_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact33));
                findTextView(R.id.stats_artifacts_artifact34_level).setText(String.valueOf(save.artifactLevels.Artifact34));
                findTextView(R.id.stats_artifacts_artifact34_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact34));
                findTextView(R.id.stats_artifacts_artifact35_level).setText(String.valueOf(save.artifactLevels.Artifact35));
                findTextView(R.id.stats_artifacts_artifact35_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact35));
                findTextView(R.id.stats_artifacts_artifact36_level).setText(String.valueOf(save.artifactLevels.Artifact36));
                findTextView(R.id.stats_artifacts_artifact36_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact36));
                findTextView(R.id.stats_artifacts_artifact37_level).setText(String.valueOf(save.artifactLevels.Artifact37));
                findTextView(R.id.stats_artifacts_artifact37_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact37));
                findTextView(R.id.stats_artifacts_artifact38_level).setText(String.valueOf(save.artifactLevels.Artifact38));
                findTextView(R.id.stats_artifacts_artifact38_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact38));
                findTextView(R.id.stats_artifacts_artifact39_level).setText(String.valueOf(save.artifactLevels.Artifact39));
                findTextView(R.id.stats_artifacts_artifact39_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact39));
                findTextView(R.id.stats_artifacts_artifact40_level).setText(String.valueOf(save.artifactLevels.Artifact40));
                findTextView(R.id.stats_artifacts_artifact40_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact40));
                findTextView(R.id.stats_artifacts_artifact41_level).setText(String.valueOf(save.artifactLevels.Artifact41));
                findTextView(R.id.stats_artifacts_artifact41_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact41));
                findTextView(R.id.stats_artifacts_artifact42_level).setText(String.valueOf(save.artifactLevels.Artifact42));
                findTextView(R.id.stats_artifacts_artifact42_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact42));
                findTextView(R.id.stats_artifacts_artifact43_level).setText(String.valueOf(save.artifactLevels.Artifact43));
                findTextView(R.id.stats_artifacts_artifact43_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact43));
                findTextView(R.id.stats_artifacts_artifact44_level).setText(String.valueOf(save.artifactLevels.Artifact44));
                findTextView(R.id.stats_artifacts_artifact44_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact44));
                findTextView(R.id.stats_artifacts_artifact45_level).setText(String.valueOf(save.artifactLevels.Artifact45));
                findTextView(R.id.stats_artifacts_artifact45_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact45));
                findTextView(R.id.stats_artifacts_artifact46_level).setText(String.valueOf(save.artifactLevels.Artifact46));
                findTextView(R.id.stats_artifacts_artifact46_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact46));
                findTextView(R.id.stats_artifacts_artifact47_level).setText(String.valueOf(save.artifactLevels.Artifact47));
                findTextView(R.id.stats_artifacts_artifact47_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact47));
                findTextView(R.id.stats_artifacts_artifact48_level).setText(String.valueOf(save.artifactLevels.Artifact48));
                findTextView(R.id.stats_artifacts_artifact48_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact48));
                findTextView(R.id.stats_artifacts_artifact49_level).setText(String.valueOf(save.artifactLevels.Artifact49));
                findTextView(R.id.stats_artifacts_artifact49_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact49));
                findTextView(R.id.stats_artifacts_artifact50_level).setText(String.valueOf(save.artifactLevels.Artifact50));
                findTextView(R.id.stats_artifacts_artifact50_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact50));
                findTextView(R.id.stats_artifacts_artifact51_level).setText(String.valueOf(save.artifactLevels.Artifact51));
                findTextView(R.id.stats_artifacts_artifact51_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact51));
                findTextView(R.id.stats_artifacts_artifact52_level).setText(String.valueOf(save.artifactLevels.Artifact52));
                findTextView(R.id.stats_artifacts_artifact52_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact52));
                findTextView(R.id.stats_artifacts_artifact53_level).setText(String.valueOf(save.artifactLevels.Artifact53));
                findTextView(R.id.stats_artifacts_artifact53_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact53));
                findTextView(R.id.stats_artifacts_artifact54_level).setText(String.valueOf(save.artifactLevels.Artifact54));
                findTextView(R.id.stats_artifacts_artifact54_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact54));
                findTextView(R.id.stats_artifacts_artifact55_level).setText(String.valueOf(save.artifactLevels.Artifact55));
                findTextView(R.id.stats_artifacts_artifact55_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact55));
                findTextView(R.id.stats_artifacts_artifact56_level).setText(String.valueOf(save.artifactLevels.Artifact56));
                findTextView(R.id.stats_artifacts_artifact56_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact56));
                findTextView(R.id.stats_artifacts_artifact57_level).setText(String.valueOf(save.artifactLevels.Artifact57));
                findTextView(R.id.stats_artifacts_artifact57_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact57));
                findTextView(R.id.stats_artifacts_artifact58_level).setText(String.valueOf(save.artifactLevels.Artifact58));
                findTextView(R.id.stats_artifacts_artifact58_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact58));
                findTextView(R.id.stats_artifacts_artifact59_level).setText(String.valueOf(save.artifactLevels.Artifact59));
                findTextView(R.id.stats_artifacts_artifact59_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact59));
                findTextView(R.id.stats_artifacts_artifact60_level).setText(String.valueOf(save.artifactLevels.Artifact60));
                findTextView(R.id.stats_artifacts_artifact60_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact60));
                findTextView(R.id.stats_artifacts_artifact61_level).setText(String.valueOf(save.artifactLevels.Artifact61));
                findTextView(R.id.stats_artifacts_artifact61_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact61));
                findTextView(R.id.stats_artifacts_artifact62_level).setText(String.valueOf(save.artifactLevels.Artifact62));
                findTextView(R.id.stats_artifacts_artifact62_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact62));
                findTextView(R.id.stats_artifacts_artifact63_level).setText(String.valueOf(save.artifactLevels.Artifact63));
                findTextView(R.id.stats_artifacts_artifact63_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact63));
                findTextView(R.id.stats_artifacts_artifact64_level).setText(String.valueOf(save.artifactLevels.Artifact64));
                findTextView(R.id.stats_artifacts_artifact64_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact64));
                findTextView(R.id.stats_artifacts_artifact65_level).setText(String.valueOf(save.artifactLevels.Artifact65));
                findTextView(R.id.stats_artifacts_artifact65_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact65));
                findTextView(R.id.stats_artifacts_artifact66_level).setText(String.valueOf(save.artifactLevels.Artifact66));
                findTextView(R.id.stats_artifacts_artifact66_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact66));
                findTextView(R.id.stats_artifacts_artifact67_level).setText(String.valueOf(save.artifactLevels.Artifact67));
                findTextView(R.id.stats_artifacts_artifact67_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact67));
                findTextView(R.id.stats_artifacts_artifact68_level).setText(String.valueOf(save.artifactLevels.Artifact68));
                findTextView(R.id.stats_artifacts_artifact68_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact68));
                findTextView(R.id.stats_artifacts_artifact69_level).setText(String.valueOf(save.artifactLevels.Artifact69));
                findTextView(R.id.stats_artifacts_artifact69_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact69));
                findTextView(R.id.stats_artifacts_artifact70_level).setText(String.valueOf(save.artifactLevels.Artifact70));
                findTextView(R.id.stats_artifacts_artifact70_relics).setText(String.valueOf(save.artifactRelicsSpent.Artifact70));
                break;
        }

        //endregion

    }

    private void populateOptimiser(){
        WorldSave save = application.saveManager.getActiveSave(application.currentWorld);

        TableLayout sequenceTable = findTable(R.id.optimiser_artifactsequence);
        TableLayout totalTable = findTable(R.id.optimiser_artifacttotal);
        sequenceTable.removeAllViews();
        totalTable.removeAllViews();


        TableRow row = new TableRow(sequenceTable.getContext());
        TextView artifactName = new TextView(sequenceTable.getContext());
        artifactName.setText("Select method above");
        row.addView(artifactName);
        sequenceTable.addView(row);

        row = new TableRow(totalTable.getContext());
        artifactName = new TextView(totalTable.getContext());
        artifactName.setText("Select method above");
        row.addView(artifactName);
        totalTable.addView(row);

        TextView breakpoint = findTextView(R.id.optimiser_breakpointstage);
        TextView prestigeRelics = findTextView(R.id.optimiser_prestigerelics);
        TextView nextRelics = findTextView(R.id.optimiser_nextbreakpointrelics);
        TextView curRelics = findTextView(R.id.optimiser_currentrelics);

        RelicOptimiser optimiser = new RelicOptimiser(application.currentWorld, save);

        breakpoint.setText(optimiser.getNextBreakpoint() + "");
        prestigeRelics.setText(optimiser.relicsAtStage(save.currentStage) + "");
        nextRelics.setText(optimiser.relicsAtStage(optimiser.getNextBreakpoint()) + "");
        curRelics.setText(save.playerRelics + "");
    }

    private void populateArtifactTable(CalculationType method){
        final WorldSave save = application.saveManager.getActiveSave(application.currentWorld);
        final TableLayout sequenceTable = findTable(R.id.optimiser_artifactsequence);
        final TableLayout totalTable = findTable(R.id.optimiser_artifacttotal);
        sequenceTable.removeAllViews();
        totalTable.removeAllViews();
        this.blockUi = true;
        final ProgressBar spinnersequence = (ProgressBar)findViewById(R.id.optimiser_loading_sequence);
        final ProgressBar spinnertotal = (ProgressBar)findViewById(R.id.optimiser_loading_total);
        spinnersequence.setVisibility(View.VISIBLE);
        spinnertotal.setVisibility(View.VISIBLE);


        final RelicOptimiser optimiser = new RelicOptimiser(application.currentWorld, save);
        new AsyncTask<CalculationType, Void, List<PurchaseStep>>(){

            protected List<PurchaseStep> doInBackground(CalculationType... type){
                return optimiser.getBest(type[0], save.playerRelics, 100, false);
            }

            protected void onPostExecute(List<PurchaseStep> steps){
                if (steps.size() == 0) {
                    addArtifactRow(totalTable, "No artifacts in sequence", "", "", false);
                    addArtifactRow(sequenceTable, "No artifacts in sequence", "", "", false);

                    blockUi = false;
                    spinnersequence.setVisibility(View.GONE);
                    spinnertotal.setVisibility(View.GONE);
                    return;
                }

                Map<Artifact, PurchaseStep> totals = new HashMap<Artifact, PurchaseStep>();
                int artifactCostTotal = 0;

                addArtifactRow(sequenceTable, "Artifact", "Level to", "Cost", false);
                addArtifactRow(totalTable, "Artifact", "Level to", "Cost", false);

                boolean altColour = true;
                for (PurchaseStep step
                        : steps){
                    PurchaseStep current;
                    if (totals.containsKey(step.artifact)){
                        current = totals.get(step.artifact);
                    } else {
                        current = new PurchaseStep(step.artifact, 0, 0);
                    }
                    totals.put(current.artifact, new PurchaseStep(current.artifact, step.levelTo, current.cost + step.cost));
                    artifactCostTotal += step.cost;

                    addArtifactRow(sequenceTable, getArtifactName(step.artifact), String.valueOf(step.levelTo), String.valueOf(step.cost), altColour);
                    altColour = !altColour;
                }
                altColour = true;
                for (PurchaseStep step :
                        totals.values()) {
                    addArtifactRow(totalTable, getArtifactName(step.artifact), String.valueOf(step.levelTo), String.valueOf(step.cost), altColour);
                    altColour = !altColour;
                }
                addArtifactRow(sequenceTable, "", "Total:", String.valueOf(artifactCostTotal), altColour);
                addArtifactRow(totalTable, "", "Total:", String.valueOf(artifactCostTotal), altColour);

                blockUi = false;
                spinnersequence.setVisibility(View.GONE);
                spinnertotal.setVisibility(View.GONE);
            }
        }.execute(method);
    }

    private void addArtifactRow(TableLayout table, String artifact, String levelTo, String cost, boolean altColour){
        TextView artifactName = new TextView(table.getContext());
        TextView artifactLevel = new TextView(table.getContext());
        TextView relicCost = new TextView(table.getContext());
        TableRow row = new TableRow(table.getContext());

        artifactName.setText(artifact);
        artifactLevel.setText(levelTo);
        relicCost.setText(cost);

        row.addView(artifactName);
        row.addView(artifactLevel);
        row.addView(relicCost);

        if (altColour){
            row.setBackgroundColor(ContextCompat.getColor(table.getContext(),R.color.row_alternate));
        }

        table.addView(row);
    }

    private void populateSequencer(){
        WorldSave save = application.saveManager.getActiveSave(application.currentWorld);
        SequencePriorityModel priorities = application.saveManager.getSequencerPriorities(application.saveManager.getActiveSave());

        findTextView(R.id.sequencer_currentseed).setText(String.valueOf(save.nextArtifactSeed));

        switch (application.currentWorld){
            case WORLD_1:
                findLayout(R.id.sequencer_artifacts_world1table).setVisibility(View.VISIBLE);
                findLayout(R.id.sequencer_artifacts_world2table).setVisibility(View.GONE);
                setPriorityRowData(R.id.sequencer_artifacts_artifact1_owned, R.id.sequencer_artifacts_artifact1_priority, priorities.Artifact1);
                setPriorityRowData(R.id.sequencer_artifacts_artifact2_owned, R.id.sequencer_artifacts_artifact2_priority, priorities.Artifact2);
                setPriorityRowData(R.id.sequencer_artifacts_artifact3_owned, R.id.sequencer_artifacts_artifact3_priority, priorities.Artifact3);
                setPriorityRowData(R.id.sequencer_artifacts_artifact4_owned, R.id.sequencer_artifacts_artifact4_priority, priorities.Artifact4);
                setPriorityRowData(R.id.sequencer_artifacts_artifact5_owned, R.id.sequencer_artifacts_artifact5_priority, priorities.Artifact5);
                setPriorityRowData(R.id.sequencer_artifacts_artifact6_owned, R.id.sequencer_artifacts_artifact6_priority, priorities.Artifact6);
                setPriorityRowData(R.id.sequencer_artifacts_artifact7_owned, R.id.sequencer_artifacts_artifact7_priority, priorities.Artifact7);
                setPriorityRowData(R.id.sequencer_artifacts_artifact8_owned, R.id.sequencer_artifacts_artifact8_priority, priorities.Artifact8);
                setPriorityRowData(R.id.sequencer_artifacts_artifact9_owned, R.id.sequencer_artifacts_artifact9_priority, priorities.Artifact9);
                setPriorityRowData(R.id.sequencer_artifacts_artifact10_owned, R.id.sequencer_artifacts_artifact10_priority, priorities.Artifact10);
                setPriorityRowData(R.id.sequencer_artifacts_artifact11_owned, R.id.sequencer_artifacts_artifact11_priority, priorities.Artifact11);
                setPriorityRowData(R.id.sequencer_artifacts_artifact12_owned, R.id.sequencer_artifacts_artifact12_priority, priorities.Artifact12);
                setPriorityRowData(R.id.sequencer_artifacts_artifact13_owned, R.id.sequencer_artifacts_artifact13_priority, priorities.Artifact13);
                setPriorityRowData(R.id.sequencer_artifacts_artifact14_owned, R.id.sequencer_artifacts_artifact14_priority, priorities.Artifact14);
                setPriorityRowData(R.id.sequencer_artifacts_artifact15_owned, R.id.sequencer_artifacts_artifact15_priority, priorities.Artifact15);
                setPriorityRowData(R.id.sequencer_artifacts_artifact16_owned, R.id.sequencer_artifacts_artifact16_priority, priorities.Artifact16);
                setPriorityRowData(R.id.sequencer_artifacts_artifact17_owned, R.id.sequencer_artifacts_artifact17_priority, priorities.Artifact17);
                setPriorityRowData(R.id.sequencer_artifacts_artifact18_owned, R.id.sequencer_artifacts_artifact18_priority, priorities.Artifact18);
                setPriorityRowData(R.id.sequencer_artifacts_artifact19_owned, R.id.sequencer_artifacts_artifact19_priority, priorities.Artifact19);
                setPriorityRowData(R.id.sequencer_artifacts_artifact20_owned, R.id.sequencer_artifacts_artifact20_priority, priorities.Artifact20);
                setPriorityRowData(R.id.sequencer_artifacts_artifact21_owned, R.id.sequencer_artifacts_artifact21_priority, priorities.Artifact21);
                setPriorityRowData(R.id.sequencer_artifacts_artifact22_owned, R.id.sequencer_artifacts_artifact22_priority, priorities.Artifact22);
                setPriorityRowData(R.id.sequencer_artifacts_artifact23_owned, R.id.sequencer_artifacts_artifact23_priority, priorities.Artifact23);
                setPriorityRowData(R.id.sequencer_artifacts_artifact24_owned, R.id.sequencer_artifacts_artifact24_priority, priorities.Artifact24);
                setPriorityRowData(R.id.sequencer_artifacts_artifact25_owned, R.id.sequencer_artifacts_artifact25_priority, priorities.Artifact25);
                setPriorityRowData(R.id.sequencer_artifacts_artifact26_owned, R.id.sequencer_artifacts_artifact26_priority, priorities.Artifact26);
                setPriorityRowData(R.id.sequencer_artifacts_artifact27_owned, R.id.sequencer_artifacts_artifact27_priority, priorities.Artifact27);
                setPriorityRowData(R.id.sequencer_artifacts_artifact28_owned, R.id.sequencer_artifacts_artifact28_priority, priorities.Artifact28);
                setPriorityRowData(R.id.sequencer_artifacts_artifact29_owned, R.id.sequencer_artifacts_artifact29_priority, priorities.Artifact29);
                setPriorityRowData(R.id.sequencer_artifacts_artifact30_owned, R.id.sequencer_artifacts_artifact30_priority, priorities.Artifact30);
                break;
            case WORLD_2:
                findLayout(R.id.sequencer_artifacts_world2table).setVisibility(View.VISIBLE);
                findLayout(R.id.sequencer_artifacts_world1table).setVisibility(View.GONE);
                setPriorityRowData(R.id.sequencer_artifacts_artifact31_owned, R.id.sequencer_artifacts_artifact31_priority, priorities.Artifact31);
                setPriorityRowData(R.id.sequencer_artifacts_artifact32_owned, R.id.sequencer_artifacts_artifact32_priority, priorities.Artifact32);
                setPriorityRowData(R.id.sequencer_artifacts_artifact33_owned, R.id.sequencer_artifacts_artifact33_priority, priorities.Artifact33);
                setPriorityRowData(R.id.sequencer_artifacts_artifact34_owned, R.id.sequencer_artifacts_artifact34_priority, priorities.Artifact34);
                setPriorityRowData(R.id.sequencer_artifacts_artifact35_owned, R.id.sequencer_artifacts_artifact35_priority, priorities.Artifact35);
                setPriorityRowData(R.id.sequencer_artifacts_artifact36_owned, R.id.sequencer_artifacts_artifact36_priority, priorities.Artifact36);
                setPriorityRowData(R.id.sequencer_artifacts_artifact37_owned, R.id.sequencer_artifacts_artifact37_priority, priorities.Artifact37);
                setPriorityRowData(R.id.sequencer_artifacts_artifact38_owned, R.id.sequencer_artifacts_artifact38_priority, priorities.Artifact38);
                setPriorityRowData(R.id.sequencer_artifacts_artifact39_owned, R.id.sequencer_artifacts_artifact39_priority, priorities.Artifact39);
                setPriorityRowData(R.id.sequencer_artifacts_artifact40_owned, R.id.sequencer_artifacts_artifact40_priority, priorities.Artifact30);
                setPriorityRowData(R.id.sequencer_artifacts_artifact41_owned, R.id.sequencer_artifacts_artifact41_priority, priorities.Artifact41);
                setPriorityRowData(R.id.sequencer_artifacts_artifact42_owned, R.id.sequencer_artifacts_artifact42_priority, priorities.Artifact42);
                setPriorityRowData(R.id.sequencer_artifacts_artifact43_owned, R.id.sequencer_artifacts_artifact43_priority, priorities.Artifact43);
                setPriorityRowData(R.id.sequencer_artifacts_artifact44_owned, R.id.sequencer_artifacts_artifact44_priority, priorities.Artifact44);
                setPriorityRowData(R.id.sequencer_artifacts_artifact45_owned, R.id.sequencer_artifacts_artifact45_priority, priorities.Artifact45);
                setPriorityRowData(R.id.sequencer_artifacts_artifact46_owned, R.id.sequencer_artifacts_artifact46_priority, priorities.Artifact46);
                setPriorityRowData(R.id.sequencer_artifacts_artifact47_owned, R.id.sequencer_artifacts_artifact47_priority, priorities.Artifact47);
                setPriorityRowData(R.id.sequencer_artifacts_artifact48_owned, R.id.sequencer_artifacts_artifact48_priority, priorities.Artifact48);
                setPriorityRowData(R.id.sequencer_artifacts_artifact49_owned, R.id.sequencer_artifacts_artifact49_priority, priorities.Artifact49);
                setPriorityRowData(R.id.sequencer_artifacts_artifact50_owned, R.id.sequencer_artifacts_artifact50_priority, priorities.Artifact50);
                setPriorityRowData(R.id.sequencer_artifacts_artifact51_owned, R.id.sequencer_artifacts_artifact51_priority, priorities.Artifact51);
                setPriorityRowData(R.id.sequencer_artifacts_artifact52_owned, R.id.sequencer_artifacts_artifact52_priority, priorities.Artifact52);
                setPriorityRowData(R.id.sequencer_artifacts_artifact53_owned, R.id.sequencer_artifacts_artifact53_priority, priorities.Artifact53);
                setPriorityRowData(R.id.sequencer_artifacts_artifact54_owned, R.id.sequencer_artifacts_artifact54_priority, priorities.Artifact54);
                setPriorityRowData(R.id.sequencer_artifacts_artifact55_owned, R.id.sequencer_artifacts_artifact55_priority, priorities.Artifact55);
                setPriorityRowData(R.id.sequencer_artifacts_artifact56_owned, R.id.sequencer_artifacts_artifact56_priority, priorities.Artifact56);
                setPriorityRowData(R.id.sequencer_artifacts_artifact57_owned, R.id.sequencer_artifacts_artifact57_priority, priorities.Artifact57);
                setPriorityRowData(R.id.sequencer_artifacts_artifact58_owned, R.id.sequencer_artifacts_artifact58_priority, priorities.Artifact58);
                setPriorityRowData(R.id.sequencer_artifacts_artifact59_owned, R.id.sequencer_artifacts_artifact59_priority, priorities.Artifact59);
                setPriorityRowData(R.id.sequencer_artifacts_artifact60_owned, R.id.sequencer_artifacts_artifact60_priority, priorities.Artifact60);
                setPriorityRowData(R.id.sequencer_artifacts_artifact61_owned, R.id.sequencer_artifacts_artifact61_priority, priorities.Artifact61);
                setPriorityRowData(R.id.sequencer_artifacts_artifact62_owned, R.id.sequencer_artifacts_artifact62_priority, priorities.Artifact62);
                setPriorityRowData(R.id.sequencer_artifacts_artifact63_owned, R.id.sequencer_artifacts_artifact63_priority, priorities.Artifact63);
                setPriorityRowData(R.id.sequencer_artifacts_artifact64_owned, R.id.sequencer_artifacts_artifact64_priority, priorities.Artifact64);
                setPriorityRowData(R.id.sequencer_artifacts_artifact65_owned, R.id.sequencer_artifacts_artifact65_priority, priorities.Artifact65);
                setPriorityRowData(R.id.sequencer_artifacts_artifact66_owned, R.id.sequencer_artifacts_artifact66_priority, priorities.Artifact66);
                setPriorityRowData(R.id.sequencer_artifacts_artifact67_owned, R.id.sequencer_artifacts_artifact67_priority, priorities.Artifact67);
                setPriorityRowData(R.id.sequencer_artifacts_artifact68_owned, R.id.sequencer_artifacts_artifact68_priority, priorities.Artifact68);
                setPriorityRowData(R.id.sequencer_artifacts_artifact69_owned, R.id.sequencer_artifacts_artifact69_priority, priorities.Artifact69);
                setPriorityRowData(R.id.sequencer_artifacts_artifact70_owned, R.id.sequencer_artifacts_artifact70_priority, priorities.Artifact70);
                break;
        }

        populateSequenceSection();
    }

    private void populateSequenceSection() {
        WorldSave save = application.saveManager.getActiveSave(application.currentWorld);
        SequencePriorityModel priorities = application.saveManager.getSequencerPriorities(application.saveManager.getActiveSave());

        Sequencer sequencer = new Sequencer(save.nextArtifactSeed, priorities);
        List<Boolean> salvages = getCurrentSalvageSteps();
        List<Artifact> result = sequencer.getSequence(application.currentWorld, salvages, application.artifactUnityRandom.get(application.currentWorld));

        TableLayout outputTable = findTable(R.id.sequencer_outputtable);
        outputTable.removeAllViews();

        TableRow headerRow = new TableRow(outputTable.getContext());
        TextView artifactHeader = new TextView(outputTable.getContext());
        TextView salvageHeader = new TextView(outputTable.getContext());

        artifactHeader.setText(R.string.sequencer_order_nameheader);
        salvageHeader.setText(R.string.sequencer_order_salvageheader);

        headerRow.setBackgroundColor(ContextCompat.getColor(application.getApplicationContext(), R.color.row_alternate));
        headerRow.addView(artifactHeader);
        headerRow.addView(salvageHeader);

        outputTable.addView(headerRow);

        boolean altRowColour = false;
        for (int i = 0; i < result.size(); i++) {
            addSequencerRow(outputTable, result.get(i), salvages.size() > i ? salvages.get(i) : false, altRowColour, i + 1 == result.size());
            altRowColour = !altRowColour;
        }
    }

    private void optimiseSequence(){
        WorldSave save = application.saveManager.getActiveSave(application.currentWorld);
        SequencePriorityModel priorities = application.saveManager.getSequencerPriorities(application.saveManager.getActiveSave());

        final Sequencer sequencer = new Sequencer(save.nextArtifactSeed, priorities);
        final LiveUpdate liveUpdate = sequencer.optimiseSalvages(application.currentWorld, application.artifactUnityRandom.get(application.currentWorld), 10000);

        final TableLayout table = findTable(R.id.sequencer_optimisedtable);
        final Handler handler = new Handler();

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                table.removeAllViews();
                final List<Boolean> salvages = (List<Boolean>)liveUpdate.output;

                final List<Artifact> result = sequencer.getSequence(application.currentWorld, salvages, application.artifactUnityRandom.get(application.currentWorld));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        boolean altRowColour = false;
                        for (int i = 0; i < result.size(); i++) {
                            addSequencerRow(table, result.get(i), salvages.size() > i ? salvages.get(i) : false, altRowColour, true);
                            altRowColour = !altRowColour;
                        }
                    }
                });

                if (!liveUpdate.done)
                    handler.postDelayed(this, 500);
            }
        };
        handler.post(runnable);

    }

    private List<Boolean> getCurrentSalvageSteps(){
        TableLayout table = findTable(R.id.sequencer_outputtable);
        List<Boolean> salvages = new ArrayList<>();
        for (int i = 1; i < table.getChildCount(); i++){
            TableRow row = (TableRow)table.getChildAt(i);
            CheckBox checkBox = (CheckBox)row.getChildAt(1);
            salvages.add(checkBox.isChecked());
        }
        return salvages;
    }

    private String getArtifactName(Artifact artifact){
        switch (artifact.artifactId){
            case 1: return getString(R.string.game_artifact1);
            case 2: return getString(R.string.game_artifact2);
            case 3: return getString(R.string.game_artifact3);
            case 4: return getString(R.string.game_artifact4);
            case 5: return getString(R.string.game_artifact5);
            case 6: return getString(R.string.game_artifact6);
            case 7: return getString(R.string.game_artifact7);
            case 8: return getString(R.string.game_artifact8);
            case 9: return getString(R.string.game_artifact9);
            case 10: return getString(R.string.game_artifact10);
            case 11: return getString(R.string.game_artifact11);
            case 12: return getString(R.string.game_artifact12);
            case 13: return getString(R.string.game_artifact13);
            case 14: return getString(R.string.game_artifact14);
            case 15: return getString(R.string.game_artifact15);
            case 16: return getString(R.string.game_artifact16);
            case 17: return getString(R.string.game_artifact17);
            case 18: return getString(R.string.game_artifact18);
            case 19: return getString(R.string.game_artifact19);
            case 20: return getString(R.string.game_artifact20);
            case 21: return getString(R.string.game_artifact21);
            case 22: return getString(R.string.game_artifact22);
            case 23: return getString(R.string.game_artifact23);
            case 24: return getString(R.string.game_artifact24);
            case 25: return getString(R.string.game_artifact25);
            case 26: return getString(R.string.game_artifact26);
            case 27: return getString(R.string.game_artifact27);
            case 28: return getString(R.string.game_artifact28);
            case 29: return getString(R.string.game_artifact29);
            case 30: return getString(R.string.game_artifact30);
            case 31: return getString(R.string.game_artifact31);
            case 32: return getString(R.string.game_artifact32);
            case 33: return getString(R.string.game_artifact33);
            case 34: return getString(R.string.game_artifact34);
            case 35: return getString(R.string.game_artifact35);
            case 36: return getString(R.string.game_artifact36);
            case 37: return getString(R.string.game_artifact37);
            case 38: return getString(R.string.game_artifact38);
            case 39: return getString(R.string.game_artifact39);
            case 40: return getString(R.string.game_artifact40);
            case 41: return getString(R.string.game_artifact41);
            case 42: return getString(R.string.game_artifact42);
            case 43: return getString(R.string.game_artifact43);
            case 44: return getString(R.string.game_artifact44);
            case 45: return getString(R.string.game_artifact45);
            case 46: return getString(R.string.game_artifact46);
            case 47: return getString(R.string.game_artifact47);
            case 48: return getString(R.string.game_artifact48);
            case 49: return getString(R.string.game_artifact49);
            case 50: return getString(R.string.game_artifact50);
            case 51: return getString(R.string.game_artifact51);
            case 52: return getString(R.string.game_artifact52);
            case 53: return getString(R.string.game_artifact53);
            case 54: return getString(R.string.game_artifact54);
            case 55: return getString(R.string.game_artifact55);
            case 56: return getString(R.string.game_artifact56);
            case 57: return getString(R.string.game_artifact57);
            case 58: return getString(R.string.game_artifact58);
            case 59: return getString(R.string.game_artifact59);
            case 60: return getString(R.string.game_artifact60);
            case 61: return getString(R.string.game_artifact61);
            case 62: return getString(R.string.game_artifact62);
            case 63: return getString(R.string.game_artifact63);
            case 64: return getString(R.string.game_artifact64);
            case 65: return getString(R.string.game_artifact65);
            case 66: return getString(R.string.game_artifact66);
            case 67: return getString(R.string.game_artifact67);
            case 68: return getString(R.string.game_artifact68);
            case 69: return getString(R.string.game_artifact69);
            case 70: return getString(R.string.game_artifact70);
            default: return "UNKNOWN_ARTIFACT";
        }
    }

    private void setPriorityRowData(int ownedId, int priorityId, final SequenceArtifact artifact){
        CheckBox checkBox = findCheckBox(ownedId);
        final EditText editText = findEditText(priorityId);

        checkBox.setOnCheckedChangeListener(null);

        editText.setText(String.valueOf(artifact.priority));
        checkBox.setChecked(artifact.isOwned());

        if (artifact.isLocked()){
            checkBox.setClickable(false);
            editText.setEnabled(false);
            editText.setFocusable(false);
            checkBox.setText(Html.fromHtml("&#128274;"));
        } else {
            checkBox.setClickable(true);
            editText.setEnabled(true);
            editText.setFocusable(true);
            checkBox.setText("");
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    artifact.setOwned(isChecked);
                    populateSequenceSection();
                }
            });
        }
    }

    private void addSequencerRow(TableLayout table, Artifact artifact, boolean salvage, boolean altRowColour, boolean locked){
        TableRow row = new TableRow(table.getContext());

        TextView artifactName = new TextView(table.getContext());
        CheckBox salvageBox = new CheckBox(table.getContext());

        artifactName.setText(getArtifactName(artifact));
        salvageBox.setChecked(salvage);
        salvageBox.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                populateSequenceSection();
            }
        });
        if (altRowColour)
            row.setBackgroundColor(ContextCompat.getColor(table.getContext(), R.color.row_alternate));

        row.addView(artifactName);
        row.addView(salvageBox);

        salvageBox.setClickable(!locked);
        if (locked)
            salvageBox.setText(Html.fromHtml("&#128274;"));

        table.addView(row);

    }

    private TableRow findRow(int rowId) {
        return (TableRow) findViewById(rowId);
    }

    private TextView findTextView(int viewId) {
        return (TextView) findViewById(viewId);
    }

    private TableLayout findTable(int tableId) {
        return (TableLayout) findViewById(tableId);
    }

    private LinearLayout findLayout(int layoutId){
        return (LinearLayout) findViewById(layoutId);
    }

    private EditText findEditText(int id){
        return (EditText)findViewById(id);
    }

    private CheckBox findCheckBox(int id){
        return (CheckBox)findViewById(id);
    }
}
