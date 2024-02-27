package com.mygdx.throwup;

import com.badlogic.gdx.utils.TimeUtils;

public class MyObject {
    int type;
    float x, y;
    float vx, vy;
    float width, height;
    float rotation, speedRotation;
    int phase, nPhases;
    long timeLastPhase, timePhaseInterval;


    void move() {
        x += vx;
        y += vy;
        rotation +=speedRotation;
    }

    void changePhase(){
        if(TimeUtils.millis() > timeLastPhase+timePhaseInterval) {
            if (++phase == nPhases) phase = 0;
            timeLastPhase = TimeUtils.millis();
        }
    }

    float getX(){
        return x-width/2;
    }

    float getY(){
        return y-height/2;
    }

    boolean overlap(MyObject o){
        return Math.abs(x-o.x) < width/3 + o.width/2 & Math.abs(y-o.y) < height/3 + o.height/3;
    }
}
