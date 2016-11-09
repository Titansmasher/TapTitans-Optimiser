package com.titansmasher.taptitansoptimizer.UI.Abstracts;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;
import com.titansmasher.taptitansoptimizer.Model.Enums.Artifact;
import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimizer.Model.SaveData;
import com.titansmasher.taptitansoptimizer.Model.WorldSave;
import com.titansmasher.taptitansoptimizer.OptimiserApp;
import com.titansmasher.taptitansoptimizer.R;
import com.titansmasher.taptitansoptimizer.UI.DonateActivity;
import com.titansmasher.taptitansoptimizer.UI.FloatingWidgetService;
import com.titansmasher.taptitansoptimizer.UI.SettingsActivity;
import com.titansmasher.taptitansoptimizer.UI.StatsActivity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public abstract class ActivityBase extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected LinearLayout baseContent;
    protected OptimiserApp application;
    protected Map<World, MenuItem> navDrawer = new HashMap<>();
    protected Map<World, MenuItem> appBar = new HashMap<>();
    protected Map<MenuItem, Integer> saveSelectors = new HashMap<>();
    protected MenuItem newSave;
    protected MenuItem requestPerms;
    protected MenuItem backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        application = (OptimiserApp)getApplication();

        setContentView(R.layout.activity_main);
        baseContent = (LinearLayout)findViewById(R.id.activity_base_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        findTextView(navigationView.getHeaderView(0), R.id.nav_header_description).setText(Html.fromHtml(getString(R.string.nav_header_description)));
        findTextView(navigationView.getHeaderView(0), R.id.nav_header_description).setMovementMethod(LinkMovementMethod.getInstance());

        navDrawer.put(World.WORLD_1, navigationView.getMenu().findItem(R.id.nav_world1));
        navDrawer.put(World.WORLD_2, navigationView.getMenu().findItem(R.id.nav_world2));

        requestPerms = navigationView.getMenu().findItem(R.id.nav_grantperms);
        backButton = navigationView.getMenu().findItem(R.id.nav_back);
        backButton.setVisible(shouldShowBackButton());

        navDrawer.get(application.currentWorld).setChecked(true);

        if (application.shouldShowInstallMessage()){
            showInstallMessage();
        }

        if (!application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this)){
            if (application.neverAskAgain){
                return;
            }
            application.requestPermissionList(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0, this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        application.saveGameSaves();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this)){
            if (application.neverAskAgain){
                return;
            }
            application.requestPermissionList(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0, this);
        }
        application.loadGameSaves(this);
        requestPerms.setVisible(!application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this));

        updateSaveList();

        checkCorrectSave(application.activeSaveId);
        checkCorrectWorld(application.currentWorld);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (permissions.length == 0)
            return;

        for (String permission :
                permissions) {
            if (grantResults[permission.indexOf(permission)] == PackageManager.PERMISSION_DENIED && !ActivityCompat.shouldShowRequestPermissionRationale(this, permission)){
                application.neverAskAgain = true;
                return;
            }
        }

        if (requestCode == 0) {
            application.loadGameSaves(this);
            updateSaveList();
            requestPerms.setVisible(!application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this));
        }
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
        appBar.put(World.WORLD_1, menu.findItem(R.id.appbar_world1));
        appBar.put(World.WORLD_2, menu.findItem(R.id.appbar_world2));
        checkCorrectWorld(application.currentWorld);
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
            if (shouldShowBackButton())
                finish();
            startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
        } else if (id == R.id.action_support){
            if (shouldShowBackButton())
                finish();
            startActivity(new Intent(getApplicationContext(), DonateActivity.class));
        } else if (id == R.id.appbar_world2){
            application.currentWorld = World.WORLD_1;
            checkCorrectWorld(World.WORLD_1);
            worldChanged(World.WORLD_1);
        } else if (id == R.id.appbar_world1){
            application.currentWorld = World.WORLD_2;
            checkCorrectWorld(World.WORLD_2);
            worldChanged(World.WORLD_2);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id){
            case R.id.nav_world1:
                application.currentWorld = World.WORLD_1;
                checkCorrectWorld(World.WORLD_1);
                worldChanged(World.WORLD_1);
                break;
            case R.id.nav_world2:
                application.currentWorld = World.WORLD_2;
                checkCorrectWorld(World.WORLD_2);
                worldChanged(World.WORLD_2);
                break;
            case R.id.nav_grantperms:
                if (application.neverAskAgain){
                    new AlertDialog.Builder(this)
                            .setTitle("Unable to request permissions")
                            .setMessage("You have selected \"Never ask again\" on a previous permission request, preventing this app requesting permissions ever again. Please go into the settings and grant the \"Read external storage\" permission manually.")
                            .setPositiveButton("Ok", null)
                            .show();
                    break;
                }
                if (!application.hasPermission(Manifest.permission.READ_EXTERNAL_STORAGE, this)){
                    application.requestPermissionList(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0, this, true);
                }
                break;
            case R.id.nav_back:
                finish();
                return false;
            default:
                if (item == this.newSave){
                    showNewSaveDialog();
                } else {
                    application.activeSaveId = saveSelectors.get(item);
                    checkCorrectSave(saveSelectors.get(item));
                    saveChanged();
                }
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }

    private void checkCorrectWorld(World world){
        navDrawer.get(World.WORLD_1).setChecked(false);
        navDrawer.get(World.WORLD_2).setChecked(false);
        navDrawer.get(world).setChecked(true);

        if (appBar.size() > 0){
            appBar.get(World.WORLD_1).setVisible(false);
            appBar.get(World.WORLD_2).setVisible(false);
            appBar.get(world).setVisible(true);
        }
    }

    private void checkCorrectSave(int saveId){
        for (MenuItem menuItem :
                saveSelectors.keySet()) {
            menuItem.setChecked(application.activeSaveId == saveSelectors.get(menuItem));
        }
    }

    protected boolean canDrawOverApps(){
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || Settings.canDrawOverlays(this);
    }

    protected void requestDrawOverApps(){
        if (application.neverAskAgain){
            new AlertDialog.Builder(this)
                    .setTitle("Unable to request permissions")
                    .setMessage("You have selected \"Never ask again\" on a previous permission request, preventing this app requesting permissions ever again. Please go into the settings and grant the \"Draw over other apps\" permission manually.")
                    .setPositiveButton("Ok", null)
                    .show();
            return;
        }
        startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())));
    }

    public void startFloatingWidget(View view){
        FloatingWidgetService.setContent(view);
        if (canDrawOverApps())
            startService(new Intent(getApplication(), FloatingWidgetService.class));
        else
            requestDrawOverApps();
    }

    public void stopFloatingWidget(){
        stopService(new Intent(getApplication(), FloatingWidgetService.class));
    }

    public abstract void worldChanged(World world);
    public abstract void saveChanged();
    public abstract boolean shouldShowBackButton();

    protected void updateSaveList(){
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        MenuItem saveSection = navView.getMenu().findItem(R.id.nav_saveselector);
        Menu saveMenu = saveSection.getSubMenu();

        while (saveMenu.size() > 0) {
            saveMenu.removeItem(saveMenu.getItem(0).getItemId());
        }

        saveSelectors = new HashMap<>();
        for (int i:
                application.saveManager.getSaveIds()){
            TapTitansSave save = application.saveManager.getSave(i);
            MenuItem saveItem;
            if (save.isEditable())
                saveItem = saveMenu.add(application.saveManager.getSaveName(i));
            else
                saveItem = saveMenu.add(application.saveManager.getSaveName(i) + Html.fromHtml(" &#128274;"));
            saveItem.setIcon(GenericHelpers.drawableFromAttr(android.R.attr.textCheckMark, getTheme(), getResources()));
            saveItem.setCheckable(true);
            if (application.saveManager.getSave(application.activeSaveId) == application.saveManager.getSave(i)) {
                saveItem.setChecked(true);
            }

            this.saveSelectors.put(saveItem, i);
        }

        this.newSave = saveMenu.add("Add new save");
        this.newSave.setIcon(android.R.drawable.ic_menu_add);

        saveChanged();
    }

    private void showInstallMessage(){
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
    }

    protected void showNewSaveDialog() {
        final EditText input = new EditText(this);
        final View view = this.baseContent;

        new AlertDialog.Builder(this)
                .setTitle("Enter save name")
                .setView(input)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String text = input.getText().toString();
                        if (text.length() >= 3) {
                            SaveData data = new SaveData();
                            data.saveName = text;
                            application.activeSaveId = application.saveManager.addSave(data);
                            Snackbar.make(view, "Created blank save \"" + text + "\"", Snackbar.LENGTH_LONG).show();
                            application.saveGameSaves();
                            updateSaveList();
                        } else {
                            Snackbar.make(view, "Save name too short. Min 3 characters", Snackbar.LENGTH_LONG).show();
                        }
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
    }

    protected TableRow findRow(View view, int rowId) {
        return (TableRow) view.findViewById(rowId);
    }

    protected TextView findTextView(View view, int viewId) {
        return (TextView) view.findViewById(viewId);
    }

    protected TableLayout findTable(View view, int tableId) {
        return (TableLayout) view.findViewById(tableId);
    }

    protected LinearLayout findLayout(View view, int layoutId){
        return (LinearLayout) view.findViewById(layoutId);
    }

    protected EditText findEditText(View view, int id){
        return (EditText) view.findViewById(id);
    }

    protected CheckBox findCheckBox(View view, int id){
        return (CheckBox) view.findViewById(id);
    }

    protected Button findButton(View view, int id){
        return (Button) view.findViewById(id);
    }

    protected String getArtifactName(Artifact artifact){
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

    protected WorldSave getWorldSave(){
        TapTitansSave save = application.saveManager.getSave(application.activeSaveId);
        if (save != null)
            return save.getWorldSave(application.currentWorld);
        return null;
    }

    protected TextWatcher generatePositiveIntValidator() {
        return generatePositiveIntValidator(Integer.MAX_VALUE);
    }

    protected TextWatcher generatePositiveIntValidator(final int limit) {
        return generatePositiveIntValidator(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return limit;
            }
        });
    }


    protected TextWatcher generatePositiveIntValidator(final Callable<Integer> getInt) {
        return new TextWatcher() {
            boolean parsing = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (parsing)
                    return;

                parsing = true;
                String replaceText;
                try {
                    if (s.toString().length() == 0) {
                        replaceText = "0";
                    } else if (GenericHelpers.parseIntDefault(s.toString(), -1) > getInt.call() || GenericHelpers.parseIntDefault(s.toString(), -1) == -1) {
                        replaceText = String.valueOf(getInt.call());
                    } else {
                        replaceText = String.valueOf(GenericHelpers.parseIntDefault(s.toString(), 0));
                    }
                } catch (Exception ex){
                    replaceText = "0";
                }

                s.replace(0, s.length(), replaceText, 0, replaceText.length());

                parsing = false;
            }
        };
    }
}
