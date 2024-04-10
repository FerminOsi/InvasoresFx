package com.aetxabao.invasoresfx.sprite;

import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static com.aetxabao.invasoresfx.game.AppConsts.*;
import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYSHIP_ALFA;

public class EnemyBoss extends AEnemy implements  IHaveShield{
    int N;//ticks para cambio de frame
    int n;
    Rect gameRect;
    public EnemyBoss(Rect gameRect, Image img, int N) {
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

