package com.games.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.ChainShape;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import java.awt.Button;

import box2dLight.RayHandler;

/**
 * Created by D Sai Vamshi on 01-04-2018.
 */

public class level2 implements Screen {

    private OrthographicCamera camera;

    private Box2DDebugRenderer debug;
    private World world;
    private Body player, platform , Obstruc ,Obstruc1,Obstrcu2,Obstruc3 ,Obstruct4,fltplat ,fltplat2, key, fltplat3,fltplat4;
    private RayHandler rayH;
    // private PointLight pointLi;
    private static final float PPM = 32;
    private Button button1, button2;
    private BodyDef bodyDef = new BodyDef();
    private FixtureDef fixtureDef = new FixtureDef();
    private float horizontalForce = 0;
    private float speed = 0.3f;
    private boolean check = false , check2 = false , checkk=false , checkk2 = false;
    public float r=0,g=0,b=0,a=1 ,radius = 2.1f , mass = 10.0f;
    public Fixture fix ,fix1 , nonfix , fixture1;
    private Body body;
    //private Music music;
    private Screen scr;
    private SpriteBatch batch,batch1;    // not using for now see above comment
    private Texture tex , tex1 , tex2;   // not using for now see above comment
    private ShapeRenderer shaperender;
    private boolean changelevel = false , isCheck = false;
    private ContactListener lisener;   // not using for now
   // private CreateBox obj;
    private CreateBox Create;
    private Player Create2;



    @Override
    public void show() {


        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();


        camera = new OrthographicCamera();
        camera.setToOrtho(false, w / 2, h / 3);


        world = new World(new Vector2(0, -9.8f), false);
        world.setContactListener(new ContactListener() {

                                     @Override
                                     public void beginContact(Contact contact) {


                                         fix  = contact.getFixtureA();
                                         fix1 = contact.getFixtureB();



                                         if(contact.getFixtureA().getBody() ==player && contact.getFixtureB().getBody() == Obstruc
                                                 ||contact.getFixtureA().getBody() ==Obstruc && contact.getFixtureB().getBody() == player){

                                             System.out.print("Collision happend");
                                            // player.destroyFixture(fixture1);
                                             ((Game)Gdx.app.getApplicationListener()).setScreen(new level2());// this is used for screen change


                                         }
                                         if(contact.getFixtureA().getBody() ==key && contact.getFixtureB().getBody() == fltplat2
                                                 ||contact.getFixtureA().getBody() ==fltplat2 && contact.getFixtureB().getBody() == key){
                                             ((Game)Gdx.app.getApplicationListener()).setScreen(new level3());

                                         }

                                         if(contact.getFixtureA().getBody() ==player && contact.getFixtureB().getBody() == Obstruc1
                                                 ||contact.getFixtureA().getBody() ==Obstruc1 && contact.getFixtureB().getBody() == player){

                                             System.out.print("Collision happend");
                                             // player.destroyFixture(fixture1);
                                             ((Game)Gdx.app.getApplicationListener()).setScreen(new level2());// this is used for screen change


                                         }

                                         if(contact.getFixtureA().getBody() ==player && contact.getFixtureB().getBody() == Obstrcu2
                                                 ||contact.getFixtureA().getBody() ==Obstrcu2 && contact.getFixtureB().getBody() == player){

                                             System.out.print("Collision happend");
                                             // player.destroyFixture(fixture1);
                                             ((Game)Gdx.app.getApplicationListener()).setScreen(new level2());// this is used for screen change


                                         }



                                         if(fix1.getUserData()==null&&fix.getUserData()==null){



                                             //System.out.print("Collision happend");



                                         }

//
                                         return;


                                     }

                                     @Override
                                     public void endContact(Contact contact) {

//
//
                                     }

                                     @Override
                                     public void preSolve(Contact contact, Manifold oldManifold) {

                                     }

                                     @Override
                                     public void postSolve(Contact contact, ContactImpulse impulse) {

                                     }




                                 }



        );



        debug = new Box2DDebugRenderer();
        rayH = new RayHandler(world);

        rayH.setBlur(true);

        rayH.setBlurNum(3);
        rayH.setShadows(true);

//-------------player----------------------------------------------//
        player = createplayer(60,40,10.0f, 20.0f, false);
//---------------------------------------------------------------//


        //-----------------------tring out things-------------------------//

        //Create2 = new Player(10)





        //----------------------------------------------------------------//
        destoryobj(80,-40 ,110.0f,80.0f, true);
        destoryobj(180,-20,90.0f,120.0f,true);
        destoryobj(360,110,200.0f,100.0f,true );
        Obstruc =destoryobj(765,-76,1080.0f,5.0f,true);   // traps
        Obstruc1 =destoryobj(360,57,200.0f,5.0f,true);   // traps2
        //obj.ucreatebox(10,10,50,50,false,world);
        Obstrcu2 = destoryobj(360,-30,80.0f,5.0f,true);   //floating platfrom
        fltplat = destoryobj( 524, -5,30,30,true);

        fltplat4 = destoryobj( 719,-5,40,30,true);
        fltplat2 = destoryobj(740,33,5,5,true);





        Obstruc3=destoryobj(270,-10,20.0f,120.0f,true); // obstrucal1
        Obstruct4=destoryobj(450,-10,20.0f,120.0f,true); // obstrucal2




        createplayer(750,40,20.0f,240.0f,true); // end of the level 1
        createplayer(-10,40,5.0f,241.0f,true); //start of the level 1


        //destoryobj(90,125,20.0f,70.0f,true,true);
        //ground
        platform = createEdge(0,-80,50,0,true);
        //Roof
        createEdge(0,160,50,0,true);
        key =createplayer(180,50,30,30,false);//create box
       // createplayer(740, 10, 15, 15, true,fix); //contact box






        //Texbody =  createplayer(0,-265,600,50,true);  // for texture
        //--------------not using for now-------------//
        batch = new SpriteBatch();


        tex = new Texture("bricks.png");
        tex1 = new Texture("create box.png");

        //tex1 = new Texture("blue.png");
        //tex2 = new Texture("yellow.png");
        //----------------------------------------------//




        shaperender = new ShapeRenderer();




    }







    @Override
    public void render(float delta) {

        // Sprite batch in declared here where render updates every frame
        // in box2d world , we cannot use Sprite batch out side this

        update(Gdx.graphics.getDeltaTime());

        Gdx.gl.glClearColor(0.0f, 0.0f, 0.0f, 0.1f);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //setScreen(new Splash());

        Colorchange(r,g,b,a);
        debug.render(world, camera.combined.cpy().scl(PPM)); // ray handler should be below this to shadows and lights
        rayH.render();
        //rayH.setCombinedMatrix(camera);
        //rayH.updateAndRender();
        //world.step(1/60f , 6 ,2);
        rayH.updateAndRender();



        if(check == false) {

            shaperender.begin(ShapeRenderer.ShapeType.Filled);

            //Obstruc =  destoryobj(70 , 70 ,20.0f,180.0f, true, shaperender);

            shaperender.setColor(Color.RED);                                     // this works that way  it should work like overlapping things
            shaperender.rect(260, 55.0f, 200.0f, 5);
            shaperender.rect(225, -78.0f, 1090.0f, 5);
            shaperender.rect(320, -32, 80.0f, 5.0f);
            shaperender.end();

        } else if (check == true) {


            shaperender.begin(ShapeRenderer.ShapeType.Line);

            shaperender.setColor(Color.RED);             // this works that way  it should work like overlapping things

            shaperender.rect(260, 55.0f, 200.0f, 5);
            shaperender.rect(225, -78.0f, 1090.0f, 5);
            shaperender.rect(320, -32, 80.0f, 5.0f);

            shaperender.end();


        }

        if(check2 == false){



            shaperender.begin(ShapeRenderer.ShapeType.Filled);
            shaperender.setColor(Color.YELLOW);
            shaperender.rect(260, -70, 20, 120);
            shaperender.end();





        }else if(check2 == true){



            shaperender.begin(ShapeRenderer.ShapeType.Line);
            shaperender.setColor(Color.YELLOW);
            shaperender.rect(260, -70, 20, 120);

            shaperender.end();



        }




        if(checkk == false){



            shaperender.begin(ShapeRenderer.ShapeType.Filled);
            shaperender.setColor(Color.CYAN);
            shaperender.rect(440, -70, 20, 120);

            shaperender.end();





        } else if(checkk == true){



            shaperender.begin(ShapeRenderer.ShapeType.Line);
            shaperender.setColor(Color.CYAN);
            shaperender.rect(440, -70, 20, 120);

            shaperender.end();



        }
        if(checkk2 == true){


            shaperender.begin(ShapeRenderer.ShapeType.Filled);
            shaperender.setColor(Color.PINK);
            shaperender.rect( 542,-20,120,30);


            shaperender.end();



        }

        shaperender.begin(ShapeRenderer.ShapeType.Filled);
        shaperender.setColor(Color.PINK);
        shaperender.rect( 509,-20,30,30);
        shaperender.end();


        shaperender.begin(ShapeRenderer.ShapeType.Filled);
        shaperender.setColor(Color.BROWN);
        shaperender.rect(25,-80 ,110.0f,80.0f);
        shaperender.rect( 135,-80,90.0f,120.0f);
        shaperender.rect(  260,60,200.0f,100.0f);
        shaperender.rect(699,-20,40,30);
        shaperender.end();

        shaperender.begin(ShapeRenderer.ShapeType.Line);

        shaperender.setColor(Color.WHITE);
        shaperender.rect(710, 10, 30, 30);  // final objective in the level 1

        shaperender.end();





        batch.begin();
        //batch.draw(tex,Texbody.getPosition().x*PPM/2-(tex.getWidth()/2),Texbody.getPosition().y*PPM-(tex.getHeight()/2)); test case

        //titles of the bottom platform
        batch.draw(tex,1000,-280,200,200);
        batch.draw(tex,800,-280,200,200);
        batch.draw(tex,600,-280,200,200);
        batch.draw(tex,0,-280,200,200);
        batch.draw(tex,400,-280,200,200);
        batch.draw(tex,600,-280,200,200);
        batch.draw(tex,200,-280,200,200);
        batch.draw(tex,-200,-280,200,200);
        batch.draw(tex,-400,-280,200,200);
        batch.draw(tex,-600,-280,200,200);
        batch.draw(tex,-800,-280,200,200);
        batch.draw(tex,-1000,-280,200,200);

        //titles of the top platform
        batch.draw(tex,1000,160,200,200);
        batch.draw(tex,800,160,200,200);
        batch.draw(tex,0,  160,200,200);
        batch.draw(tex,400,160,200,200);
        batch.draw(tex,600,160,200,200);
        batch.draw(tex,200,160,200,200);
        batch.draw(tex,-200,160,200,200);
        batch.draw(tex,-400,160,200,200);
        batch.draw(tex,-600,160,200,200);
        batch.draw(tex,-800,160,200,200);
        batch.draw(tex,-1000,160,200,200);
        //batch.draw(tex,30,-60,50,60);
       // batch.draw(tex1,key.getPosition().x*PPM/1.1f,key.getPosition().y*PPM/1.4f,32,30);  // do it later ...................


        batch.end();







    }

    @Override
    public void resize(int width, int height) {

        camera.setToOrtho(false, width / 2, height / 2);

    }



    //-------------------------------------------never used till now ----------------------------//
    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }
    //--------------------------------------------------------------------------------------------//







    @Override
    public void dispose() {


        rayH.dispose();
        world.dispose();
        debug.dispose();

        batch.dispose();  //not using this for now
    }
    //----------------------------------------made up methods(defined methods)---------------------------//




    public void inputUpdate(final float delta){


        Gdx.input.setInputProcessor(new InputProcessor() {


                                        @Override
                                        public boolean keyDown(int keycode) {


                                            switch (keycode) {
                                                case Input.Keys.W:

                                                    float jump = 3.0f;

                                                    player.setLinearVelocity(player.getLinearVelocity().x , jump);
                                                    // world.destroyBody(body);






                                                    //Colorchange(0.3f, 0.4f, 0.5f, 1.0f);
                                                    //movement.y = speed;



                                                    break;

                                                case Input.Keys.A:



                                                    horizontalForce -= speed;
                                                    player.setLinearVelocity(horizontalForce, player.getLinearVelocity().y);






                                                    //Colorchange(0.5f, 0.2f, 0.7f, 1.0f);
                                                    //movement.x = -speed;

                                                    break;

                                                case Input.Keys.S:




                                                    //Colorchange(0.3f, 0.4f, 0.2f, 1.0f);  Don't unComment this
                                                    //movement.y = -speed;

                                                    break;

                                                case Input.Keys.D:


                                                    horizontalForce += speed;
                                                    player.setLinearVelocity(horizontalForce , player.getLinearVelocity().y);



                                                    //Colorchange(0.4f, 0.7f, 0.8f, 1.0f);
                                                    //movement.x = speed;

                                                    break;

                                                case Input.Keys.UP:

                                                    check = true;
                                                    // Red values
                                                    r=1.0f;
                                                    g=0.0f;
                                                    b=0.0f;
                                                    //body.destroyFixture(fixture);
                                                    //Obstruc.destroyFixture(fix);
                                                    Obstruc.setActive(false);
                                                    Obstruc1.setActive(false);
                                                    Obstrcu2.setActive(false);


                                                    System.out.println("is in 2");


                                                    break;


                                                case Input.Keys.LEFT:
                                                    // Yellow Values
                                                    r=1.0f;
                                                    g=1.0f;
                                                    b=0.0f;

                                                    Obstruc3.setActive(false);
                                                    check2 = true;




                                                    break;


                                                case Input.Keys.RIGHT:


                                                    //White values
                                                    r=0.0f;
                                                    g=1.0f;
                                                    b=1.0f;
                                                    createplayer(679,-73,30,30,false);
                                                    Obstruct4.setActive(false);

                                                    checkk = true;


                                                    break;




                                                case Input.Keys.DOWN:


                                                    //Violet values
                                                    r=1.7f;
                                                    g=0.0f;
                                                    b=1.7f;

                                                    fltplat3 = destoryobj( 602,-5,120,30,true);
                                                    checkk2 = true;


                                                    break;




                                                default:



                                                    r=0.0f;
                                                    g=0.0f;
                                                    b=0.0f;
                                                    //Colorchange(0, 0, 0, 1);

                                                    break;
                                            }







                                            return true;
                                        }

                                        @Override
                                        public boolean keyUp(int keycode) {

                                            switch (keycode) {
                                                case Input.Keys.UP:

                                                    r=1.0f;
                                                    g=0.0f;
                                                    b=0.0f;

                                                    Obstruc.setActive(true);
                                                    Obstruc1.setActive(true);
                                                    Obstrcu2.setActive(true);
                                                    check = false;

                                                    break;

                                                case Input.Keys.LEFT:


                                                    r=1.0f;
                                                    g=1.0f;
                                                    b=0.0f;

                                                    Obstruc3.setActive(true);
                                                    check2 = false;

                                                    break;

                                                case Input.Keys.RIGHT:

                                                    r=0.0f;
                                                    g=1.0f;
                                                    b=1.0f;

                                                    checkk = false;
                                                    Obstruct4.setActive(true);


                                                    break;

                                                case Input.Keys.DOWN:


                                                    //Violet values
                                                    r=1.7f;
                                                    g=0.0f;
                                                    b=1.7f;



                                                    break;




                                                default:



                                                    r=0.0f;
                                                    g=0.0f;
                                                    b=0.0f;
                                                    //Colorchange(0, 0, 0, 1);

                                                    break;
                                            }






                                            return true;
                                        }

                                        @Override
                                        public boolean keyTyped(char character) {
                                            return false;
                                        }

                                        @Override
                                        public boolean touchDown(int screenX, int screenY, int pointer, int button) {

				/*
				if(button1.getX()*PPM==screenX){

					//horizontalForce -= speed;
					Gdx.app.log("Button","touchDown");


				} else if(button1.getY()*PPM==screenY){

					//horizontalForce +=speed;
					Gdx.app.log("Button","touchDown");


				}

				*/
                                            return false;
                                        }

                                        @Override
                                        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				/*
				if(button1.getX()==screenX){

					//horizontalForce = 0;
					Gdx.app.log("Button","touchup");


				} else if(button1.getY()==screenY){

					//horizontalForce +=0;
					Gdx.app.log("Button","touchup");

				}

				*/
                                            return false;
                                        }

                                        @Override
                                        public boolean touchDragged(int screenX, int screenY, int pointer) {
                                            return false;
                                        }

                                        @Override
                                        public boolean mouseMoved(int screenX, int screenY) {

                                            return false;
                                        }

                                        @Override
                                        public boolean scrolled(int amount) {
                                            return false;
                                        }




                                    }


        );

       /*
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){

			horizontalForce -= speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){

			horizontalForce +=speed;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)){

			player.setLinearVelocity(player.getLinearVelocity().x , speed);
		}
		*/




        player.setLinearVelocity(player.getLinearVelocity().x , player.getLinearVelocity().y);


    }




    public void update(float delta) {

        world.step(1 / 60f, 6, 2);

        cameraupdate(delta);
        inputUpdate(delta);
        batch.setProjectionMatrix(camera.combined);                          //not using this for now
        shaperender.setProjectionMatrix(camera.combined);

    }






    public Body createplayer(int x , int y , float width, float height, boolean isStatic) {



        //body definition

        Body body;
        Fixture fix;

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

        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef).getUserData();
        shape.dispose();






        //-----------platfrom-------------//
/*



		return body;

	}

*/
        return body;

    }


    public Body createEdge(int x ,int y ,float x1,float y1, boolean isStatic ){

        Body body1;

        if (isStatic)
            bodyDef.type = BodyDef.BodyType.StaticBody;
        else
            bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(x/PPM,y/PPM);

        ChainShape shape1 = new ChainShape();
        shape1.createChain(new Vector2[] {new Vector2(-x1*PPM,y1*PPM) ,new Vector2(x1*PPM,y1*PPM)});
        fixtureDef.shape = shape1;
        fixtureDef.density = .7f;
        fixtureDef.friction = 1.0f;
        body1 = world.createBody(bodyDef);
        body1.createFixture(fixtureDef);
        shape1.dispose();

        return body1;



    }




    public Body destoryobj(int x , int y ,float width, float height, boolean isStatic) {


        //body definition

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


        body = world.createBody(bodyDef);
        body.createFixture(fixtureDef);


        shape.dispose();


        return body;

    }


    public void drawtex(Texture in , Body by , Batch ba){     // not using for now


        ba.begin();
        ba.draw(in , by.getPosition().x*PPM-(in.getWidth()/2),by.getPosition().y*PPM-(in.getHeight()/2));
        ba.end();

    }






    public void Colorchange(float r , float g , float b , float a) {

        // r = 0; g = 0.0f ; b = 0.0f; a = 1.0f;

        rayH.setAmbientLight(r, g, b, a);


    }


    public void cameraupdate(float delta) {                       // getting bodies position

        Vector3 position = camera.position;
        position.set(380,30,0);

        camera.position.set(position);
        camera.update();


    }

}
