package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EnemyBoss extends EnemyShip implements  IHaveShield{

    public EnemyBoss(Rect gameRect, Image img, int N) {
        super(gameRect, img, N);
    }
    int impactCount;

    @Override
    public boolean impact() {
        this.addImpact();
        return impactCount > 20;
    }

    public void addImpact() {
        this.impactCount++;
    }


}
