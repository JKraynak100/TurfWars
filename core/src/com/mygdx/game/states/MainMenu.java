package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

/**
         Created by skmon on 5/23/2017.
 **/

public class MainMenu extends State {
    private Stage stage;
    private Viewport viewPort;

    private Skin uiSkin;

    private Texture title;
    private Image titleImage;

    private ImageButton startButton;
    private Texture startButtonTexture;

    public MainMenu(GameStateManager gsm) {
        super(gsm);
        // Initialize the Viewport
        viewPort = new StretchViewport(800, 400, cam);

        // Initialize the stage
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        // Initialize all skins and styles
        uiSkin = new Skin();

        // Initialize the table
        Table table = new Table();
        table.setFillParent(true);
        stage.addActor(table);

        // Initialize the title image
        title = new Texture(Gdx.files.internal("appTitle.png"));
        titleImage = new Image();
        titleImage.setDrawable(new TextureRegionDrawable(new TextureRegion(title)));
        titleImage.setSize(title.getWidth()*1.2f, title.getHeight()*1.1f);
        titleImage.setPosition(Gdx.graphics.getWidth()/2 - titleImage.getWidth()/2,
                               Gdx.graphics.getHeight()-(titleImage.getHeight()));

        // Initialize the buttons
        startButtonTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
        TextureRegion startButtonRegion = new TextureRegion(startButtonTexture);
        TextureRegionDrawable startButtonRegionDraw = new TextureRegionDrawable(startButtonRegion);
        startButton = new ImageButton(startButtonRegionDraw);

        startButton.addListener(new ChangeListener() {
            @Override
            public void changed (ChangeEvent event, Actor actor) {
                gsm.set(new PlayState(gsm));
            }
        });

        // Add all actors to table
        table.addActor(titleImage);
        table.row();
        table.addActor(startButton);
    }

    @Override
    public void resize(int width, int height){
        viewPort.update(width, height);
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void dispose(){
        title.dispose();
        startButtonTexture.dispose();
        uiSkin.dispose();
        stage.dispose();
    }
}