package com.games.screens;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Created by D Sai Vamshi on 12-04-2018.
 */

public class testcont implements ContactListener {




    @Override
    public void beginContact(Contact contact) {


            Fixture fix  = contact.getFixtureA();
            Fixture fix1 = contact.getFixtureB();



            if(fix1==null || fix==null) return;
            if(fix1.getUserData()==null||fix.getUserData()==null) return;

            if(isTutContact(fix ,fix1)) {

               CreateBox cba =(CreateBox)fix.getUserData();
               CreateBox cbb = (CreateBox)fix1.getUserData();

               cba.test();


            }



    }

    @Override
    public void endContact(Contact contact) {


        Fixture fix  = contact.getFixtureA();
        Fixture fix1 = contact.getFixtureB();



        if(fix1==null || fix==null) return;
        if(fix1.getUserData()==null||fix.getUserData()==null) return;

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }

    private boolean isTutContact(Fixture a , Fixture b){

        if(a.getUserData() instanceof CreateBox && b.getUserData() instanceof  CreateBox) {
            if (a.getUserData() instanceof Player && b.getUserData() instanceof Player) {
                return true;
            }
        }
        return false;
       //return (a.getUserData() instanceof CreateBox && b.getUserData() instanceof CreateBox);

    }
}
