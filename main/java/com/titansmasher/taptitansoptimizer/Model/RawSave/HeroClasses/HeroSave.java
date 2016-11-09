package com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses;

import com.titansmasher.taptitansoptimizer.Helpers.GenericHelpers;

import org.json.JSONObject;

/**
 * Created by Danny on 19/10/2016.
 */

public class HeroSave {
    public HeroLevels heroLevels;
    public HeroRespawnTimers respawnTimers;
    public HeroWeapons heroWeaponUpgrades;
    public HeroLevels heroLevelsGirl;
    public HeroRespawnTimers respawnTimersGirl;
    public HeroWeapons heroWeaponUpgradesGirl;
    public int unclaimedWeaponUpgrades;
    public int unclaimedWeaponUpgradesGirl;
    public int heroWeaponSeed;
    public int heroWeaponSeedGirl;
    public int superWeapon;
    public int superWeaponGirl;

    public String HEROLEVELS_KEY = "heroLevels";
    public String HEROLEVELSGIRL_KEY = "heroLevelsGirl";
    public String RESPAWNTIMERS_KEY = "respawnTimers";
    public String RESPAWNTIMERSGIRL_KEY = "respawnTimersGirl";
    public String HEROWEAPONUPGRADES_KEY = "heroWeaponUpgrades";
    public String HEROWEAPONUPGRADESGIRL_KEY = "heroWeaponUpgradesGirl";
    public String UNCLAIMEDWEAPONUPGRADES_KEY = "unclaimedWeaponUpgrades";
    public String UNCLAIMEDWEAPONUPGRADESGIRL_KEY = "unclaimedWeaponUpgradesGirl";
    public String SUPERWEAPON_KEY = "superWeapon";
    public String SUPERWEAPONGIRL_KEY = "superWeaponGirl";
    public String HEROWEAPONSEED_KEY = "heroWeaponSeed";
    public String HEROWEAPONSEEDGIRL_KEY = "heroWeaponSeedGirl";

    public HeroSave(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.heroLevels = new HeroLevels(GenericHelpers.getJSONObjectSafe(obj, HEROLEVELS_KEY));
        this.heroLevelsGirl = new HeroLevels(GenericHelpers.getJSONObjectSafe(obj, HEROLEVELSGIRL_KEY));
        this.respawnTimers = new HeroRespawnTimers(GenericHelpers.getJSONObjectSafe(obj, RESPAWNTIMERS_KEY));
        this.respawnTimersGirl = new HeroRespawnTimers(GenericHelpers.getJSONObjectSafe(obj, RESPAWNTIMERSGIRL_KEY));
        this.heroWeaponUpgrades = new HeroWeapons(GenericHelpers.getJSONObjectSafe(obj, HEROWEAPONUPGRADES_KEY));
        this.heroWeaponUpgradesGirl = new HeroWeapons(GenericHelpers.getJSONObjectSafe(obj, HEROWEAPONUPGRADESGIRL_KEY));

        this.unclaimedWeaponUpgrades = Integer.parseInt(GenericHelpers.getStringSafe(obj, UNCLAIMEDWEAPONUPGRADES_KEY));
        this.unclaimedWeaponUpgradesGirl = Integer.parseInt(GenericHelpers.getStringSafe(obj, UNCLAIMEDWEAPONUPGRADESGIRL_KEY));
        this.superWeapon = Integer.parseInt(GenericHelpers.getStringSafe(obj, SUPERWEAPON_KEY));
        this.superWeaponGirl = Integer.parseInt(GenericHelpers.getStringSafe(obj, SUPERWEAPONGIRL_KEY));
        this.heroWeaponSeed = Integer.parseInt(GenericHelpers.getStringSafe(obj, HEROWEAPONSEED_KEY));
        this.heroWeaponSeedGirl = Integer.parseInt(GenericHelpers.getStringSafe(obj, HEROWEAPONSEEDGIRL_KEY));
    }

    private void populateFromNull() {
        this.heroLevels = new HeroLevels(null);
        this.heroLevelsGirl = new HeroLevels(null);
        this.respawnTimers = new HeroRespawnTimers(null);
        this.respawnTimersGirl = new HeroRespawnTimers(null);
        this.heroWeaponUpgrades = new HeroWeapons(null);
        this.heroWeaponUpgradesGirl = new HeroWeapons(null);

        this.unclaimedWeaponUpgrades = 0;
        this.unclaimedWeaponUpgradesGirl = 0;
        this.superWeapon = 0;
        this.superWeaponGirl = 0;
        this.heroWeaponSeed = 0;
        this.heroWeaponSeedGirl = 0;
    }

    public JSONObject generateJson(){
        JSONObject obj = new JSONObject();

        GenericHelpers.putJSONObjectSafe(obj, HEROLEVELS_KEY, heroLevels.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, HEROLEVELSGIRL_KEY, heroLevelsGirl.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, RESPAWNTIMERS_KEY, respawnTimers.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, RESPAWNTIMERSGIRL_KEY, respawnTimersGirl.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, HEROWEAPONUPGRADES_KEY, heroWeaponUpgrades.generateJson());
        GenericHelpers.putJSONObjectSafe(obj, HEROWEAPONUPGRADESGIRL_KEY, heroWeaponUpgradesGirl.generateJson());
        GenericHelpers.putIntSafe(obj, UNCLAIMEDWEAPONUPGRADES_KEY, unclaimedWeaponUpgrades);
        GenericHelpers.putIntSafe(obj, UNCLAIMEDWEAPONUPGRADESGIRL_KEY, unclaimedWeaponUpgradesGirl);
        GenericHelpers.putIntSafe(obj, SUPERWEAPON_KEY, superWeapon);
        GenericHelpers.putIntSafe(obj, SUPERWEAPONGIRL_KEY, superWeaponGirl);
        GenericHelpers.putIntSafe(obj, HEROWEAPONSEED_KEY, heroWeaponSeed);
        GenericHelpers.putIntSafe(obj, HEROWEAPONSEEDGIRL_KEY, heroWeaponSeedGirl);


        return obj;
    }
}
