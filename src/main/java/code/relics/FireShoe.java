package code.relics;

import code.RiskOfRelicsReturns;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import riskOfRelics.RiskOfRelics;
import riskOfRelics.powers.BurningPower;
import riskOfRelics.relics.BaseRelic;

import static code.util.Wiz.*;


public class FireShoe extends AbstractEasyRelic {


    public static final int AMOUNT = 4;
    // ID, images, text.
    public static final String ID = RiskOfRelicsReturns.makeID("FireShoe");
    private static final String IMAGENAME = "FireShoe.png";

    public FireShoe() {
        super(ID, RelicTier.RARE, LandingSound.MAGICAL);
    }

    @Override
    public void atTurnStart() {
        AbstractMonster m = gcr().monsters.getRandomMonster();
        applyToEnemy(m, new BurningPower(m, adp(), AMOUNT));
        super.atTurnStart();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + AMOUNT + DESCRIPTIONS[1];
    }

}