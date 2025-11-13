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
class ClydeTest {

    private final PacManSprites pacmans = new PacManSprites();

    private final BoardFactory bf  = new BoardFactory(pacmans);
    private final GhostFactory gf = new GhostFactory(pacmans);
    private final LevelFactory lf  = new LevelFactory(pacmans, gf);
    private final PlayerFactory pf = new PlayerFactory(pacmans);

    private final MapParser mapParser = new GhostMapParser(lf,bf,gf);

    //private final Unit nearest = Navigation.findNearest(Player.class, hyde.getSquare());
    //private final Square target = nearest.getSquare();
    //private final List<Direction> path = Navigation.shortestPath(hyde.getSquare(), target, hyde);

    /**
     * Verifies the board has the correct width.
     */
    @Test
    void verifynextAiMoveFarPathFree() {
        //Map
        char[][] map = {
            "############".toCharArray(),
            "#P        C#".toCharArray(),
            "############".toCharArray()
        };
        // Setup
        Level level = mapParser.parseMap(map);
        Board board = level.getBoard();

        Ghost hyde = (Clyde) Navigation.findUnitInBoard(Ghost.class,board);

        Player player = pf.createPacMan();
        player.setDirection(Direction.EAST);
        level.registerPlayer(player);

        Optional<Direction>[] directionPossibilities = new Optional[]{
            Optional.of(Direction.NORTH),
            Optional.of(Direction.SOUTH),
            Optional.of(Direction.WEST)
        };
        System.out.println(hyde.nextAiMove());
        //Test
        assertThat(hyde.nextAiMove()).isIn(directionPossibilities);
    }

    @Test
    void verifynextAiMoveNearPathFree() {
        //Map
        char[][] map = {
            "##############".toCharArray(),
            "#P          C#".toCharArray(),
            "##############".toCharArray()
        };
        // Setup
        Level level = mapParser.parseMap(map);
        Board board = level.getBoard();

        Ghost hyde = (Clyde) Navigation.findUnitInBoard(Ghost.class,board);

        Player player = pf.createPacMan();
        player.setDirection(Direction.WEST);
        level.registerPlayer(player);

        System.out.println(hyde.nextAiMove());

        System.out.println(board);
        //Test
        assertThat(hyde.nextAiMove()).isEqualTo(Optional.of(Direction.NORTH));
    }

    @Test
    void verifynextAiMovePathBlock() {
        //Map
        char[][] map = {
            "############".toCharArray(),
            "#P       #C#".toCharArray(),
            "############".toCharArray()
        };
        // Setup
        Level level = mapParser.parseMap(map);
        Board board = level.getBoard();

        Ghost hyde = (Clyde) Navigation.findUnitInBoard(Ghost.class,board);

        Player player = pf.createPacMan();
        player.setDirection(Direction.EAST);
        level.registerPlayer(player);

        //Test
        assertThat(hyde.nextAiMove()).isEqualTo(Optional.empty());
    }

    /**
     * Verifies the board has the correct height.
     */
}
