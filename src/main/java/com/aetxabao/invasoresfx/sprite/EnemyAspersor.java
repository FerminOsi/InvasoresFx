package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.sprite.weaponry.AShot;
import com.aetxabao.invasoresfx.sprite.weaponry.AWeapon;
import com.aetxabao.invasoresfx.sprite.weaponry.AspersorGun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class EnemyAspersor extends EnemyShipDiagonal  {
    public EnemyAspersor(Rect gameRect, Image img, int N) {
        super(gameRect, img, N);
    }



    public ArrayList<AShot> shoot() {
        ArrayList<AShot> list = new ArrayList<>();
        if (weapon!=null) {
            list = weapon.shoot(this);
        }
        return list;

    }
}
