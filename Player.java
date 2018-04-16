package com.games.screens;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by D Sai Vamshi on 12-04-2018.
 */

public class Player {

    private BodyDef bodyDef = new BodyDef();
    private FixtureDef fixtureDef = new FixtureDef();
    private static final float PPM = 32;
    private Body body;
    private String id;

    public Player(float x , float y , float width, float height, boolean isStatic , World world ,String id){


          this.id = id;
          this.body = createbody(x,y,width,height,isStatic,world);






    }

    private Body createbody(float x , float y , float width, float height, boolean isStatic , World world ){






        //------------player------//

        if (isStatic)
            bodyDef.type = BodyDef.BodyType.StaticBody;
        else
            bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x / PPM, y / PPM);
        //.fixedRotation = true;


        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 2 / PPM, height / 2 / PPM);          // taking bodies position
        fixtureDef.shape = shape;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.0f;
        fixtureDef.density = 0.0f;


        this.body = world.createBody(bodyDef);
        this.body.createFixture(fixtureDef).setUserData(this);

        shape.dispose();

       return body;



    }

}
