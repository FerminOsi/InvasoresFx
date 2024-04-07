package com.aetxabao.invasoresfx.sprite.weaponry;

import com.aetxabao.invasoresfx.sprite.ASprite;

import java.util.ArrayList;

import static com.aetxabao.invasoresfx.game.AppConsts.BALL_SPRITE_IMAGE;
import static com.aetxabao.invasoresfx.game.AppConsts.BALL_SPRITE_IMAGE_FULLPEN;

public class AspersorGun extends Gun{

    public ArrayList<AShot> shoot(ASprite sprite) {
        ArrayList<AShot> list = new ArrayList<>();
        AShot shot = new FullPenGun(BALL_SPRITE_IMAGE_FULLPEN);
        AShot shot1 = new Laserbeam(BALL_SPRITE_IMAGE);
        shot.setPos(sprite.getRect().centerX(), sprite.getRect().bottom);
        shot1.setPos(sprite.getRect().centerX(), sprite.getRect().bottom);
        list.add(shot);
        list.add(shot1);
        return list;
    }
}
