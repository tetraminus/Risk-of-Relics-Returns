package code.relics;

import basemod.helpers.RelicType;
import code.RiskOfRelicsReturns;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.PoisonPower;
import riskOfRelics.RiskOfRelics;
import riskOfRelics.relics.BaseRelic;

import static code.util.Wiz.*;


public class DeadMansFoot extends AbstractEasyRelic {


    public static final int AMOUNT = 6;
    public static final int THRESHOLD = 3;
    // ID, images, text.
    public static final String ID = RiskOfRelicsReturns.makeID("DeadMansFoot");
    private static final String IMAGENAME = "DeadMansFoot.png";

    public DeadMansFoot() {
        super(ID, RelicTier.COMMON, LandingSound.MAGICAL, RelicType.GREEN);
    }

    @Override
    public void atBattleStart() {
        counter = 0;
        super.atBattleStart();
    }

    @Override
    public int onAttacked(DamageInfo info, int damageAmount) {
        if (info.owner != null && info.owner != adp()) {
            flash();
            counter++;
            if (counter >= THRESHOLD) {
                counter = 0;
                applyToEnemy((AbstractMonster) info.owner, new PoisonPower(info.owner, adp(), AMOUNT));
            }
        }
        return super.onAttacked(info, damageAmount);
    }

    @Override
    public void onVictory() {
        counter = -1;
        super.onVictory();
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + THRESHOLD + DESCRIPTIONS[1] + AMOUNT + DESCRIPTIONS[2];
    }
}