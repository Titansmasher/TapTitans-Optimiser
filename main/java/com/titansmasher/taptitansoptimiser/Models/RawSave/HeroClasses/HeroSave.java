package com.titansmasher.taptitansoptimiser.Models.RawSave.HeroClasses;

import com.titansmasher.taptitansoptimiser.Helpers.GenericHelpers;

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

    public HeroSave(JSONObject obj) {
        if (obj == null) {
            populateFromNull();
            return;
        }
        this.heroLevels = new HeroLevels(GenericHelpers.getJSONObjectSafe(obj, "heroLevels"));
        this.heroLevelsGirl = new HeroLevels(GenericHelpers.getJSONObjectSafe(obj, "heroLevelsGirl"));
        this.respawnTimers = new HeroRespawnTimers(GenericHelpers.getJSONObjectSafe(obj, "respawnTimers"));
        this.respawnTimersGirl = new HeroRespawnTimers(GenericHelpers.getJSONObjectSafe(obj, "respawnTimersGirl"));
        this.heroWeaponUpgrades = new HeroWeapons(GenericHelpers.getJSONObjectSafe(obj, "heroWeaponUpgrades"));
        this.heroWeaponUpgradesGirl = new HeroWeapons(GenericHelpers.getJSONObjectSafe(obj, "heroWeaponUpgradesGirl"));

        this.unclaimedWeaponUpgrades = Integer.parseInt(GenericHelpers.getStringSafe(obj, "unclaimedWeaponUpgrades"));
        this.unclaimedWeaponUpgradesGirl = Integer.parseInt(GenericHelpers.getStringSafe(obj, "unclaimedWeaponUpgradesGirl"));
        this.superWeapon = Integer.parseInt(GenericHelpers.getStringSafe(obj, "superWeapon"));
        this.superWeaponGirl = Integer.parseInt(GenericHelpers.getStringSafe(obj, "superWeaponGirl"));
        this.heroWeaponSeed = Integer.parseInt(GenericHelpers.getStringSafe(obj, "heroWeaponSeed"));
        this.heroWeaponSeedGirl = Integer.parseInt(GenericHelpers.getStringSafe(obj, "heroWeaponSeedGirl"));
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
}
