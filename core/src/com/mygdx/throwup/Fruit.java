package com.mygdx.throwup;

import static com.mygdx.throwup.ThrowUp.*;

import com.badlogic.gdx.math.MathUtils;

public class Fruit extends MyObject {
    float angle, initialVelocity; // угол, скорость
    float g = 9.81f; // Ускорение свободного падения
    float paddingX;
    boolean directionFlip;

    // Расчет компонент скорости по осям X и Y
    float velocityX;
    float velocityY;

    // Время полета
    float timeOfFlight;
    float deltaTime; // приращение времени
    float time; // текущее время

    float scale; // масштаб

    public Fruit() {
        type = MathUtils.random(0, 5);
        width = height = 100;
        this.x = x;
        start();
    }

    @Override
    void move() {
        super.move();
        x = velocityX * time; // x = Vx * t
        y = velocityY * time - 0.5f* g * time * time; // y = Vy * t - 0.5 * g * t^2
        x *= scale;
        y *= scale;
        x += paddingX;
        if(directionFlip) x = SCR_WIDTH-x;
        time += deltaTime;
        if(time>timeOfFlight) start();
    }

    boolean outOfScreen(){
        return y > SCR_HEIGHT+height/2;
    }

    void start() {
        directionFlip = MathUtils.randomBoolean();
        speedRotation = MathUtils.random(0f, 5f)*(directionFlip?1:-1);
        angle = MathUtils.random(70, 87);
        initialVelocity = MathUtils.random(10f, 14f);
        deltaTime = MathUtils.random(0.01f, 0.03f);
        paddingX = MathUtils.random(width, width+SCR_WIDTH/4);

        // Расчет компонент скорости по осям X и Y
        velocityX = (float) (initialVelocity * Math.cos(Math.toRadians(angle)));
        velocityY = (float) (initialVelocity * Math.sin(Math.toRadians(angle)));

        // Время полета
        timeOfFlight = (2 * velocityY) / g;
        time = 0;
        scale = 100;
    }
}
