package morerelics.relics;

import basemod.BaseMod;
import basemod.interfaces.PostCampfireSubscriber;
import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.relics.AbstractRelic;

public class MagicKindling extends CustomRelic implements PostCampfireSubscriber {
    public static final String ID = "MagicKindling";
    private static final String IMG = "img/relics/MagicKindling.png";
    
    private boolean used = false;
    
    public MagicKindling() {
        super(ID, new Texture(Gdx.files.internal(IMG)), RelicTier.BOSS, LandingSound.MAGICAL);
        
        BaseMod.subscribeToPostCampfire(this);
    }
    
    public boolean receivePostCampfire() {
        if (!used) {
            used = true;
            flash();
            return false;
        }
        
        return true;
    }
    
    @Override
    public void onEnterRestRoom() {
        used = false;
    }
    
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0];
    }
    
    @Override
    public AbstractRelic makeCopy() {
        return new MagicKindling();
    }
}