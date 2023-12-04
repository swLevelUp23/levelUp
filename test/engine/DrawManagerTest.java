package engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawManagerTest {

    private int frameWidth = 434;
    private DrawManager drawManager = new DrawManager();

    @Test
    void drawBossLife() {
        assertEquals((int)(414*1.0), drawManager.life(10));  //Boss Life: 9/10
        assertEquals((int)(414*0.9), drawManager.life(9));  //Boss Life: 9/10
        assertEquals((int)(414*0.8), drawManager.life(8));  //Boss Life: 8/10
        assertEquals((int)(414*0.7), drawManager.life(7));  //Boss Life: 7/10
        assertEquals((int)(414*0.6), drawManager.life(6));  //Boss Life: 6/10
        assertEquals((int)(414*0.5), drawManager.life(5));  //Boss Life: 5/10
        assertEquals((int)(414*0.4), drawManager.life(4));  //Boss Life: 4/10
        assertEquals((int)(414*0.3), drawManager.life(3));  //Boss Life: 3/10
        assertEquals((int)(414*0.2), drawManager.life(2));  //Boss Life: 2/10
        assertEquals((int)(414*0.1), drawManager.life(1));  //Boss Life: 1/10
    }
}