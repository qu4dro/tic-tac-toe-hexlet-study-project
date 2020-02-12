import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.Game;
import ru.orlovvv.xo.model.Player;
import ru.orlovvv.xo.view.ConsoleView;
import ru.orlovvv.xo.view.ICoordinateGetter;

public class Main {

    public static void main(String[] args) {

        final String name1 = "Peter";
        final String name2 = "Ivan";
        final Player[] players = new Player[2];

        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);
        Field<Figure> field = new Field<>(3);
        final Game<Figure> game = new Game<>(players, field, "TicTacToe");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game)) {
            consoleView.show(game);

        }

    }
}
