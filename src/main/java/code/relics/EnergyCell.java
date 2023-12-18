package code.relics;

import basemod.devcommands.energy.Energy;
import code.RiskOfRelicsReturns;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.core.OverlayMenu;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;
import riskOfRelics.RiskOfRelics;
import riskOfRelics.relics.BaseRelic;

import static code.util.Wiz.*;


public class EnergyCell extends AbstractEasyRelic {



    // ID, images, text.
    public static final String ID = RiskOfRelicsReturns.makeID("EnergyCell");
    private static final String IMAGENAME = "EnergyCell.png";

    public EnergyCell() {
        super(ID, RelicTier.UNCOMMON, LandingSound.FLAT);
    }

    @Override
    public void onBloodied() {
        this.flash();
        adp().energy.energyMaster += 1;

        if (isInCombat()) {
            adp().energy.energy += 1;
        }
        super.onBloodied();
    }

    @Override
    public void onNotBloodied() {
        this.flash();
        adp().energy.energyMaster -= 1;
        if (isInCombat()) {
            adp().energy.energy -= 1;
        }
        super.onNotBloodied();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + 1 + DESCRIPTIONS[1];
    }

}