package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.sprite.weaponry.AShot;
import com.aetxabao.invasoresfx.sprite.weaponry.AWeapon;
import com.aetxabao.invasoresfx.sprite.weaponry.AspersorGun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class EnemyAspersor extends EnemyShipDiagonal implements IHaveShield {
    int impactCount;
    public EnemyAspersor(Rect gameRect, Image img, int N) {
        super(gameRect, img, N);
    }

    @Override
    public boolean impact() {
        this.addImpact();
        return impactCount > 3;
    }

    public void addImpact() {
        this.impactCount++;
    }
}
