package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.image.Image;

import java.util.List;

public class EnemyBoss extends EnemyShip implements ICanSpawn{

    public EnemyBoss(Rect gameRect, Image img, int N) {
        super(gameRect, img, N);
    }

    @Override
    public List<AEnemy> spawn() {
        return null;
    }
}
