package entity;

import engine.DrawManager;
import engine.Frame;
import engine.GameSettings;
import engine.GameState;
import org.junit.jupiter.api.Test;
import screen.GameScreen;

import static org.junit.jupiter.api.Assertions.*;

class EnemyShipFormationTest {
    @Test
    void testFormation() {
        assertAll(
                "multi",
                () -> {
                    // Test case 1
                    GameSettings gameSettings = new GameSettings(5, 4, 60, 2000, 5.5);
                    GameState gameState = new GameState(1, 0, 1, 0, 0);
                    EnemyShipFormation BossenemyShipFormation = new EnemyShipFormation(gameSettings, gameState);

                    DrawManager.SpriteType checkSpritetype;

                    checkSpritetype = BossenemyShipFormation.init_formation.get(0).get(0).spriteType;
                    assertTrue((DrawManager.SpriteType.EnemyShipC1 == checkSpritetype)
                                || (DrawManager.SpriteType.EnemyShipD1 == checkSpritetype)
                                || (DrawManager.SpriteType.EnemyShipE == checkSpritetype));

                    checkSpritetype = BossenemyShipFormation.init_formation.get(1).get(1).spriteType;
                    assertTrue((DrawManager.SpriteType.EnemyShipB1 == checkSpritetype)
                            || (DrawManager.SpriteType.EnemyShipD1 == checkSpritetype)
                            || (DrawManager.SpriteType.EnemyShipE == checkSpritetype));

                    checkSpritetype = BossenemyShipFormation.init_formation.get(3).get(3).spriteType;
                    assertTrue((DrawManager.SpriteType.EnemyShipA1 == checkSpritetype)
                            || (DrawManager.SpriteType.EnemyShipD1 == checkSpritetype)
                            || (DrawManager.SpriteType.EnemyShipE == checkSpritetype));
                },
                () -> {
                    // Test case 2
                    GameSettings gameSettings = new GameSettings(8, 7, 3, 500,4.8,true);
                    GameState gameState = new GameState(8, 0, 1, 0, 0);
                    EnemyShipFormation BossenemyShipFormation = new EnemyShipFormation(gameSettings, gameState);

                    DrawManager.SpriteType checkSpritetype;

                    checkSpritetype = BossenemyShipFormation.init_formation.get(0).get(0).spriteType;
                    assertEquals(DrawManager.SpriteType.EnemyShipC1, checkSpritetype);

                    int formationLength = BossenemyShipFormation.init_formation.get(2).size();
                    assertEquals(4, formationLength);

                    checkSpritetype = BossenemyShipFormation.init_formation.get(8).get(0).spriteType;
                    assertEquals(DrawManager.SpriteType.Boss, checkSpritetype);
                }
        );
    }
}