package com.titansmasher.taptitansoptimizer.Model;

import com.titansmasher.taptitansoptimizer.Model.Enums.World;
import com.titansmasher.taptitansoptimizer.Model.RawSave.AbilityClasses.AbilityCooldowns;
import com.titansmasher.taptitansoptimizer.Model.RawSave.AbilityClasses.AbilityLevels;
import com.titansmasher.taptitansoptimizer.Model.RawSave.AbilityClasses.AbilitySave;
import com.titansmasher.taptitansoptimizer.Model.RawSave.ArtifactClasses.ArtifactLevels;
import com.titansmasher.taptitansoptimizer.Model.RawSave.ArtifactClasses.ArtifactRelics;
import com.titansmasher.taptitansoptimizer.Model.RawSave.Friends;
import com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses.HeroLevels;
import com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses.HeroRespawnTimers;
import com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses.HeroSave;
import com.titansmasher.taptitansoptimizer.Model.RawSave.HeroClasses.HeroWeapons;
import com.titansmasher.taptitansoptimizer.Model.RawSave.Inbox;
import com.titansmasher.taptitansoptimizer.Model.RawSave.PlayerCustomizations;
import com.titansmasher.taptitansoptimizer.Model.RawSave.PlayerInfoSave;
import com.titansmasher.taptitansoptimizer.Model.RawSave.PowerUpInventory;
import com.titansmasher.taptitansoptimizer.Model.RawSave.RewardedIAPs;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TapTitansSave;
import com.titansmasher.taptitansoptimizer.Model.RawSave.Tournament;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TrophyClasses.TrophyProgressSave;
import com.titansmasher.taptitansoptimizer.Model.RawSave.TutorialProgress;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Danny on 21/10/2016.
 */

public class WorldSave {
    public String playerName;
    public ArtifactLevels artifactLevels;
    public HeroLevels heroLevels;
    public HeroRespawnTimers respawnTimers;
    public HeroWeapons heroWeaponUpgrades;
    public int unclaimedWeaponUpgrades;
    public int nextArtifactSeed;
    public int heroWeaponSeed;
    public int superWeapon;
    public int playerLevel;
    public Date lastActiveTime;
    public double playerGold;
    public int playerRelics;
    public int currentStage;
    public int unlockedStage;
    public int killsInWave;
    public boolean beenToLatestStage;
    public AbilityLevels levels;
    public AbilityCooldowns cooldown;
    public double playTimeSinceLastSync;
    public double goldLostToPrestige;
    public double dpsLostToPrestige;
    public Date lastPrestige;
    public double uncollectedGold;
    public boolean optionsAutoAdvanceGender;
    public TrophyProgressSave trophyProgress;
    public UUID playerId;
    public String friendCode;
    public int cleanMasterDiamonds;
    public int playerDiamonds;
    public boolean hasOfflineGold;
    public boolean skipOfflineGold;
    public boolean signedIntoSocial;
    public boolean shouldAskToSignInSocial;
    public String socialId;
    public ArtifactRelics artifactRelicsSpent;
    public boolean artifactRelicsSpentFixed;
    public PowerUpInventory powerUpInventory;
    public boolean cheater;
    public String cheaterReason;
    public int syncCount;
    public double originalTimeOffset;
    public int cheatCount;
    public int world;
    public int iapPurchaseCount;
    public double iapSpendingInUSD;
    public int iapApprovedByAppleGoogle;
    public RewardedIAPs allRewardedIAPs;
    public int rewardedCustomerServiceDiamond;
    public int rewardedCustomerServiceRelics;
    public TutorialProgress tutorialProgress;
    public int dungeonsCompleted;
    public int dungeonStage;
    public Date lastDungeonTime;
    public Date lastCompletedDungeonTime;
    public Tournament tournament;
    public Date doubleFairyTime;
    public Inbox readInboxMessages;
    public int tt_language;
    public boolean hideTournamentPanel;
    public int gameRating;
    public boolean isLinkedToFacebook;
    public PlayerCustomizations unlockedPlayerCustomizations;
    public PlayerCustomizations currentPlayerCustomizations;
    public Friends friendsModel;
    public String facebookId;
    public int dailyClickMinValue;
    public int music;
    public int sound;
    public boolean pushNotifications;
    public boolean calculatorMode;
    public boolean optionsAutoAdvance;
    public boolean hasRatedGame;
    public boolean seenOfflineGoldPanel;
    public boolean likedFacebook;
    public boolean followedTwitter;
    public boolean optionsFairyVideo;
    public boolean optionsMultiplayerEnabled;
    public int optionsPerformance;
    public boolean hasOpenedFriendsPanel;
    public String backupIAPProductIdentifier;
    public String backupIAPBase64EncodedTransactionReceipt;
    public String lastSavedVersion;
    public boolean firstPurchaseMsgShown;
    public Date lastCloudSaveTime;
    public Date lastClickPeriod;
    public boolean hasCloudSaveEverSynced;
    public boolean canDoSeason2;
    public boolean drunkenHammerRewardeReceived;
    public boolean isDeveloper;
    public String firstVersionInstalled;
    public String oniixTransferKey;
    public String superPrestige;
    public int activeTime;
    private TapTitansSave save;

    public WorldSave(TapTitansSave save, World world) {
        this.save = save;
        loadConstantValues();
        switch (world) {
            case WORLD_1:
                loadFromWorld1(save);
                break;
            case WORLD_2:
                loadFromWorld2(save);
                break;
            default:
                return;
        }
    }

    public boolean isEditable() {
        return this.save.isEditable();
    }

    private void loadFromWorld1(TapTitansSave save) {
        PlayerInfoSave info = save.playerInfoSave;
        HeroSave heroInfo = info.heroSave;
        AbilitySave abilityInfo = info.abilitySave;

        playerName = info.playerName;
        nextArtifactSeed = info.nextArtifactSeed;
        heroLevels = info.heroSave.heroLevels;
        respawnTimers = info.heroSave.respawnTimers;
        heroWeaponUpgrades = info.heroSave.heroWeaponUpgrades;
        unclaimedWeaponUpgrades = heroInfo.unclaimedWeaponUpgrades;
        heroWeaponSeed = heroInfo.heroWeaponSeed;
        superWeapon = heroInfo.superWeapon;
        playerLevel = info.playerLevel;
        lastActiveTime = info.lastActiveTime;
        playerGold = info.playerGold;
        playerRelics = info.playerRelics;
        currentStage = info.currentStage;
        unlockedStage = info.unlockedStage;
        killsInWave = info.killsInWave;
        beenToLatestStage = info.beenToLatestStage;
        levels = info.abilitySave.levels;
        cooldown = info.abilitySave.cooldown;
        playTimeSinceLastSync = info.playTimeSinceLastSync;
        goldLostToPrestige = info.goldLostToPrestige;
        dpsLostToPrestige = info.dpsLostToPrestige;
        lastPrestige = info.lastPrestige;
        uncollectedGold = info.uncollectedGold;
        optionsAutoAdvanceGender = info.optionsAutoAdvanceBoy;
        trophyProgress = info.trophyProgress;
    }

    private void loadFromWorld2(TapTitansSave save) {
        PlayerInfoSave info = save.playerInfoSave;
        HeroSave heroInfo = info.heroSave;
        AbilitySave abilityInfo = info.abilitySave;

        playerName = info.playerNameGirl;
        nextArtifactSeed = info.nextArtifactSeedGirl;
        heroLevels = info.heroSave.heroLevelsGirl;
        respawnTimers = info.heroSave.respawnTimersGirl;
        heroWeaponUpgrades = info.heroSave.heroWeaponUpgradesGirl;
        unclaimedWeaponUpgrades = heroInfo.unclaimedWeaponUpgradesGirl;
        heroWeaponSeed = heroInfo.heroWeaponSeedGirl;
        superWeapon = heroInfo.superWeaponGirl;
        playerLevel = info.playerLevelGirl;
        lastActiveTime = info.lastActiveTimeGirl;
        playerGold = info.playerGoldGirl;
        playerRelics = info.playerRelicsGirl;
        currentStage = info.currentStageGirl;
        unlockedStage = info.unlockedStageGirl;
        killsInWave = info.killsInWaveGirl;
        beenToLatestStage = info.beenToLatestStageGirl;
        levels = info.abilitySave.levelsGirl;
        cooldown = info.abilitySave.cooldownGirl;
        playTimeSinceLastSync = info.playTimeSinceLastSyncGirl;
        goldLostToPrestige = info.goldLostToPrestigeGirl;
        dpsLostToPrestige = info.dpsLostToPrestigeGirl;
        lastPrestige = info.lastPrestigeGirl;
        uncollectedGold = info.uncollectedGoldGirl;
        optionsAutoAdvanceGender = info.optionsAutoAdvanceGirl;
        trophyProgress = info.trophyProgressGirl;
    }

    private void loadConstantValues() {
        PlayerInfoSave info = this.save.playerInfoSave;

        this.playerId = info.playerId;
        this.friendCode = info.friendCode;
        this.cleanMasterDiamonds = info.cleanMasterDiamonds;
        this.playerDiamonds = info.playerDiamonds;
        this.hasOfflineGold = info.hasOfflineGold;
        this.skipOfflineGold = info.skipOfflineGold;
        this.signedIntoSocial = info.signedIntoSocial;
        this.shouldAskToSignInSocial = info.shouldAskToSignInSocial;
        this.socialId = info.socialId;
        this.artifactLevels = info.artifactLevels;
        this.artifactRelicsSpentFixed = info.artifactRelicsSpentFixed;
        this.cheater = info.cheater;
        this.cheaterReason = info.cheaterReason;
        this.syncCount = info.syncCount;
        this.originalTimeOffset = info.originalTimeOffset;
        this.cheatCount = info.cheatCount;
        this.world = info.world;
        this.iapPurchaseCount = info.iapPurchaseCount;
        this.iapSpendingInUSD = info.iapSpendingInUSD;
        this.iapApprovedByAppleGoogle = info.iapApprovedByAppleGoogle;
        this.rewardedCustomerServiceDiamond = info.rewardedCustomerServiceDiamond;
        this.rewardedCustomerServiceRelics = info.rewardedCustomerServiceRelics;
        this.dungeonsCompleted = info.dungeonsCompleted;
        this.dungeonStage = info.dungeonStage;
        this.lastDungeonTime = info.lastDungeonTime;
        this.lastCompletedDungeonTime = info.lastCompletedDungeonTime;
        this.tournament = info.tournament;
        this.doubleFairyTime = info.doubleFairyTime;
        this.readInboxMessages = info.readInboxMessages;
        this.tt_language = info.tt_language;
        this.hideTournamentPanel = info.hideTournamentPanel;
        this.gameRating = info.gameRating;
        this.isLinkedToFacebook = info.isLinkedToFacebook;
        this.unlockedPlayerCustomizations = info.unlockedPlayerCustomizations;
        this.currentPlayerCustomizations = info.currentPlayerCustomizations;
        this.friendsModel = info.friendsModel;
        this.facebookId = info.facebookId;
        this.dailyClickMinValue = info.dailyClickMinValue;
        this.music = info.music;
        this.sound = info.sound;
        this.pushNotifications = info.pushNotifications;
        this.calculatorMode = info.calculatorMode;
        this.optionsAutoAdvance = info.optionsAutoAdvance;
        this.hasRatedGame = info.hasRatedGame;
        this.seenOfflineGoldPanel = info.seenOfflineGoldPanel;
        this.likedFacebook = info.likedFacebook;
        this.followedTwitter = info.followedTwitter;
        this.optionsFairyVideo = info.optionsFairyVideo;
        this.optionsMultiplayerEnabled = info.optionsMultiplayerEnabled;
        this.optionsPerformance = info.optionsPerformance;
        this.hasOpenedFriendsPanel = info.hasOpenedFriendsPanel;
        this.backupIAPProductIdentifier = info.backupIAPProductIdentifier;
        this.backupIAPBase64EncodedTransactionReceipt = info.backupIAPBase64EncodedTransactionReceipt;
        this.lastSavedVersion = info.lastSavedVersion;
        this.firstPurchaseMsgShown = info.firstPurchaseMsgShown;
        this.lastCloudSaveTime = info.lastCloudSaveTime;
        this.lastClickPeriod = info.lastClickPeriod;
        this.hasCloudSaveEverSynced = info.hasCloudSaveEverSynced;
        this.canDoSeason2 = info.canDoSeason2;
        this.drunkenHammerRewardeReceived = info.drunkenHammerRewardeReceived;
        this.isDeveloper = info.isDeveloper;
        this.firstVersionInstalled = info.firstVersionInstalled;
        this.oniixTransferKey = info.oniixTransferKey;
        this.superPrestige = info.superPrestige;
        this.activeTime = info.activeTime;

        this.artifactRelicsSpent = info.artifactRelicsSpent;
        this.powerUpInventory = info.powerUpInventory;
        this.allRewardedIAPs = info.allRewardedIAPs;
        this.tutorialProgress = info.tutorialProgress;
    }
}
