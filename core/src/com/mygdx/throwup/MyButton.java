package com.mygdx.throwup;

import static com.mygdx.throwup.ThrowUp.*;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;

public class MyButton {
    BitmapFont font;
    String text;
    float x, y;
    private float width, height;
    private boolean isCentered;

    public MyButton(String text, float x, float y, BitmapFont font) {
        this.font = font;
        this.text = text;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
        height = layout.height;
        this.x = x;
        this.y = y;
    }

    public MyButton(String text, float y, BitmapFont font) {
        this.font = font;
        this.text = text;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
        height = layout.height;
        this.x = SCR_WIDTH/2-width/2;
        this.y = y;
        isCentered = true;
    }

    void setText(String text) {
        this.text = text;
        GlyphLayout layout = new GlyphLayout(font, text);
        width = layout.width;
        if(isCentered){
            this.x = SCR_WIDTH/2-width/2;
        }
    }

    boolean hit(float tx, float ty) {
        return x<tx & tx<x+width & y>ty & ty>y-height;
    }
}
