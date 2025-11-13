package nl.tudelft.jpacman.npc.ghost;


import java.util.*;

import nl.tudelft.jpacman.board.*;
import nl.tudelft.jpacman.level.*;
import nl.tudelft.jpacman.npc.Ghost;
import nl.tudelft.jpacman.sprite.PacManSprites;
import nl.tudelft.jpacman.sprite.Sprite;
import nl.tudelft.jpacman.npc.ghost.Clyde;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * Test various aspects of clyde.
 *
 * @author Blessing Tutka
 */
class InkyTest {

    private final PacManSprites pacmans = new PacManSprites();

    private final BoardFactory bf  = new BoardFactory(pacmans);
    private final GhostFactory gf = new GhostFactory(pacmans);
    private final LevelFactory lf  = new LevelFactory(pacmans, gf);
    private final PlayerFactory pf = new PlayerFactory(pacmans);
    private final MapParser mapParser = new GhostMapParser(lf,bf,gf);


    /**
     * Verifies the board has the correct width.
     */
    @Test
    void verifynextAiMoveNearPathFree() {
        // Map setup
        char[][] map = {
            "############".toCharArray(),
            "#P        C#".toCharArray(),
            "############".toCharArray()
        };

        //Setup
//        Level level = mapParser.parseMap(map);
//        Board board = level.getBoard();
//
//        Ghost inky = (Inky) Navigation.findUnitInBoard(Inky.class,board);
//        Ghost blinky = (Blinky) Navigation.findUnitInBoard(Blinky.class,board);
//
//        Player player = pf.createPacMan();
//        player.setDirection(Direction.EAST);
//        level.registerPlayer(player);
//
//        Optional<Direction>[] directionPossibilities = new Optional[]{
//            Optional.of(Direction.NORTH),
//            Optional.of(Direction.SOUTH),
//            Optional.of(Direction.WEST)
//        };
//        //Test
//        assertThat(inky.nextAiMove()).isIn(directionPossibilities);
    }

    /**
     * Verifies the board has the correct height.
     */
}
