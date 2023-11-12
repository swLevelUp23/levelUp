package entity;

import engine.Cooldown;
import engine.DrawManager;
import engine.GameState;

import java.util.Set;

public class EnemyBoss extends EnemyShip {
    private int fullHP;
    /** HP의 배율 */
    private final double HPPOWER = .1;
    /** 총알의 속도 배율 */
    private final double BULLETSPEEDPOWER = 2;
    /** 슈팅 쿨다운 배율 */
    private final double BULLETCOOLDOWN = 0.3;
    /** 제거시 올라가는 점수 */
    private final int POINT = 500;

    public EnemyBoss(final int positionX, final int positionY,
                     final DrawManager.SpriteType spriteType, final GameState gameState) {
        super(positionX, positionY, spriteType, gameState);
        super.HP = (int)(super.HP * HPPOWER);
        fullHP = super.HP;
        super.spriteType = spriteType.Boss;
        super.pointValue = POINT;
    }

    public final void update() {
        if (this.animationCooldown.checkFinished()) {
            this.animationCooldown.reset();
            spriteType = DrawManager.SpriteType.Boss;
        }
    }

    public final void shoot(final Set<Bullet> bullets, Cooldown shootingCooldown, int boss) {
        //속도가 다른 3개의 총알 발사
        bullets.add(BulletPool.getBullet(positionX
                + width / 2, positionY, (int)(super.BULLET_SPEED),0));
        bullets.add(BulletPool.getBullet(positionX
                + width / 2, positionY, (int)(super.BULLET_SPEED * 2),0));
        bullets.add(BulletPool.getBullet(positionX
                + width / 2, positionY, (int)(super.BULLET_SPEED * 3),0));
        shootingCooldown.timedown(BULLETCOOLDOWN);
    }

    public int getFullHP() { return fullHP; }
}
