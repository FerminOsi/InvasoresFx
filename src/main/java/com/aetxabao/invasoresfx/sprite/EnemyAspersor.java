package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.sprite.weaponry.AShot;
import com.aetxabao.invasoresfx.sprite.weaponry.AWeapon;
import com.aetxabao.invasoresfx.sprite.weaponry.AspersorGun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

import static com.aetxabao.invasoresfx.game.AppConsts.*;
import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYSHIP_ALFA;


public class EnemyAspersor extends AEnemy implements IHaveShield {
    int impactCount;

    @Override
    public boolean impact() {
        this.addImpact();
        return impactCount > 2;
    }

    public void addImpact() {
        this.impactCount++;
    }

    int N;//ticks para cambio de frame
    int n;
    Rect gameRect;

    public EnemyAspersor(Rect gameRect, Image img, int N) {
        super(img, ENEMYSHIP_ROWS, ENEMYSHIP_COLS);
        this.gameRect = gameRect;
        xSpeed = ENEMYSHIP_MAX_SPEED;
        x = gameRect.left+width/2;
        this.N = N;
        this.n = 0;
    }

    public void updateFrame(){
        if (++n==N) {
            n = 0;
            currentFrame = ++currentFrame % cols;
        }
    }

    @Override
    public Rect getRect(){
        return new Rect(x, y, (int)(x + ENEMYSHIP_ALFA * width),(int)(y + ENEMYSHIP_ALFA * height));
    }

    public void update() {
        if (x > gameRect.right - width - xSpeed || x + xSpeed < gameRect.left) {
            xSpeed = -xSpeed;
        }
        x = x + xSpeed;
        y = y + ySpeed;
        updateFrame();
    }

    @Override
    public void draw(GraphicsContext gc) {
        int srcX = currentFrame * width;
        int srcY = 0;
        Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
        Rect dst = new Rect(x, y, (int)(x + ENEMYSHIP_ALFA * width), (int)(y + ENEMYSHIP_ALFA * height));
        gc.drawImage(img, src.left, src.top, src.width(), src.height(),
                dst.left, dst.top, dst.width(), dst.height());
    }

}
