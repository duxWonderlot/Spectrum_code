package com.games.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by D Sai Vamshi on 15-04-2018.
 */

public class Controller {


    Viewport viewport;
    Stage stage;
    boolean downpressed , leftpressd , uppressed , rightpressed;
    OrthographicCamera cam;

    public Controller() {

        cam = new OrthographicCamera();
        viewport = new FillViewport(800,480, cam);
        stage = new Stage(viewport , Tutlevel.batch1);

        Gdx.input.setInputProcessor(stage);


        Table table = new Table();
        table.left().bottom();

        Image leftImg = new Image(new Texture("leftcontrols.png"));
        leftImg.setSize(50,50);

        leftImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event , float x ,float y , int pointer , int button){

                uppressed = true;
                return true;

            }

            @Override
            public void touchUp(InputEvent event , float x , float y , int pointer , int button){


                 downpressed = false;


            }

        });

        Image RightImg = new Image(new Texture("rightcontrols.png"));
        RightImg.setSize(50,50);

        RightImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {


                rightpressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightpressed = false;

            }
        });


        Image UpImg = new Image(new Texture("upcontrols.png"));
        UpImg.setSize(50,50);

        UpImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                uppressed = true;
                return true;

            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {

                uppressed = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });



        Image DownImg = new Image(new Texture("downcontrols.png"));
        DownImg.setSize(50,50);

        DownImg.addListener(new InputListener(){


            @Override
            public boolean touchDown(InputEvent event , float x ,float y , int pointer , int button){

                downpressed = true;
                return true;

            }

            @Override
            public void touchUp(InputEvent event , float x , float y , int pointer , int button){


                downpressed = false;


            }





        });

        table.add();
        table.add(UpImg).size(UpImg.getWidth() , UpImg.getHeight());
        table.add();
        table.row().pad(5,5,5,5);
        table.add(leftImg).size(leftImg.getWidth(),leftImg.getHeight());
        table.add();
        table.add(RightImg).size(RightImg.getWidth(),RightImg.getHeight());
        table.row().padBottom(5);
        table.add();
        table.add(DownImg).size(DownImg.getWidth(),DownImg.getHeight());
        table.add();



        stage.addActor(table);



    }

    public void draw(){

        stage.draw();


    }


    public boolean isDownpressed() {
        return downpressed;
    }

    public boolean isLeftpressd() {
        return leftpressd;
    }

    public boolean isUppressed() {
        return uppressed;
    }

    public boolean isRightpressed() {
        return rightpressed;
    }


    public void resize(int width , int height){

      viewport.update(width,height);

    }

}
