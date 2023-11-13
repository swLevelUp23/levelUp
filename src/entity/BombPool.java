package entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class BombPool {
    /** HashMap<shooter, Set<Bomb>>() 이고 0번은 적, 1번은 1번 ship, 2번은 2번 ship */
    private static Map<Integer, Set<Bomb>> pool = new HashMap<Integer, Set<Bomb>>();
    /**
     * Returns a bullet from the pool if one is available, a new one if there
     * isn't.
     *
     * @param positionX
     *            Requested position of the bullet in the X axis.
     * @param positionY
     *            Requested position of the bullet in the Y axis.
     * @param speed
     *            Requested speed of the bullet, positive or negative depending
     *            on direction - positive is down.
     * @param shooter
     *            Player who shot the bullet.
     *            0 for enemy, 1 for first player, 2 for second player.
     * @return Requested bullet.
     */
    public static Bomb getBomb(final int positionX,
                                   final int positionY, final int speed, final int shooter) {
        Bomb bomb;
        /** shooter의 bomb이 비어있지 않으면 */
        if (pool.containsKey(shooter) && !pool.get(shooter).isEmpty()) {
            /** bomb에 shooter의 다음 이터레이터를 저장 */
            bomb = pool.get(shooter).iterator().next();
            /** 사용한 것은 지우고 */
            pool.get(shooter).remove(bomb);
            /** 위치 설정 */
            bomb.setPositionX(positionX - bomb.getWidth() / 2);
            bomb.setPositionY(positionY);
            bomb.setSpeed(speed);
            bomb.setSprite();
        }
        /** Bomb을 다 썼다면 새로 생성 */
        else {
            bomb = new Bomb(positionX, positionY, speed, shooter);
            bomb.setPositionX(positionX - bomb.getWidth() / 2);
        }
        return bomb;
    }

    /**
     * Adds one or more bullets to the list of available ones.
     *
     * @param bombs
     *            Bullets to recycle.
     */
    public static void recycle(final Set<Bomb> bombs) {
        for (Bomb bomb : bombs) {
            int shooter = bomb.getShooter();
            if (!pool.containsKey(shooter)) {
                pool.put(shooter, new HashSet<Bomb>());
            }
            pool.get(shooter).add(bomb);
        }
    }
}
