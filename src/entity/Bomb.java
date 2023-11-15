package entity;

import engine.DrawManager.SpriteType;

import java.awt.*;

public class Bomb extends Entity{


    /**
     * Constructor, establishes the entity's generic properties.
     *
     * @param positionX Initial position of the entity in the X axis.
     * @param positionY Initial position of the entity in the Y axis.
     * @param width     Width of the entity.
     * @param height    Height of the entity.
     * @param color     Color of the entity.
     */
    /** 폭탄 공격 속도 */
    private double speed;
    /** 폭탄 공격의 주체자 */
    private int shooter;

    public Bomb(int positionX, int positionY, double bombSpeed, int shooter) {
        super(positionX, positionY, 3*2, 5*2, Color.MAGENTA);
        this.speed = bombSpeed;
        this.shooter = shooter;
        this.spriteType = SpriteType.BombShape_large;
        setSprite();
    }

    /** 폭탄 공격의 spriteType 지정 */
    public final void setSprite(){
        if(speed >= 0)
            this.spriteType = SpriteType.BombShape_large;
    }

    /** 폭탄 위치를 현재 x위치 += 폭탄의 이동 속도로 변경 */
    public final void update(){this.positionY += this.speed; }

    /** 폭탄 공격 속도 setter */
    public final void setSpeed(final int speed) {this.speed = speed; }

    /** 폭탄 공격 속도 getter */
    public double getSpeed() {
        return speed;
    }
    /** 폭탄 공격 주체자 getter */
    public int getShooter() {
        return shooter;
    }
}
