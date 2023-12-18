package code.relics;

import code.RiskOfRelicsReturns;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import riskOfRelics.RiskOfRelics;
import riskOfRelics.relics.BaseRelic;

import static code.util.Wiz.*;


public class RustyJetpack extends AbstractEasyRelic {


    public static final int AMOUNT = 3;
    public static int DRAW = 1;
    // ID, images, text.
    public static final String ID = RiskOfRelicsReturns.makeID("RustyJetpack");
    private static final String IMAGENAME = "RustyJetpack.png";

    public RustyJetpack() {
        super(ID, RelicTier.UNCOMMON, LandingSound.MAGICAL);

    }

    @Override
    public void onVictory() {
        counter = -1;
        super.onVictory();
    }

    @Override
    public void atBattleStart() {
        counter = 0;
        super.atBattleStart();
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        if (c.type == AbstractCard.CardType.ATTACK) {
            this.flash();
            counter++;
            if (counter >= AMOUNT) {
                counter = 0;
                this.addToBot(new GainEnergyAction(DRAW));
                atb(new DrawCardAction(DRAW)) ;

            }
        }else{
            counter = 0;
        }


        super.onPlayCard(c, m);
    }

    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + AMOUNT + DESCRIPTIONS[1] + DRAW + DESCRIPTIONS[2] + DRAW + DESCRIPTIONS[3];
    }

}