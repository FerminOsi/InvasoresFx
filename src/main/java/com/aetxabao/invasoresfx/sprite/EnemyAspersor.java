package com.aetxabao.invasoresfx.sprite;


import com.aetxabao.invasoresfx.sprite.weaponry.AShot;
import com.aetxabao.invasoresfx.sprite.weaponry.AWeapon;
import com.aetxabao.invasoresfx.sprite.weaponry.AspersorGun;
import com.aetxabao.invasoresfx.sprite.weaponry.Gun;
import com.aetxabao.invasoresfx.util.Rect;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import static com.aetxabao.invasoresfx.game.AppConsts.*;
import static com.aetxabao.invasoresfx.game.AppConsts.ENEMYSHIP_ALFA;



public class EnemyAspersor extends AEnemy implements ICanSpawn {

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


    @Override
    public List<AEnemy> spawn() {
        int count = 0;
        ArrayList<AEnemy> enemigos = new ArrayList<>();
        Random r = new Random();

        int randomNum = r.nextInt((100) + 1);
        if (randomNum > 98){
            enemigos.add(new EnemyShip(gameRect, img, n));
            enemigos.get(count).setWeapon(new AspersorGun());
            count +=1;
        }
        return enemigos;
    }
}
