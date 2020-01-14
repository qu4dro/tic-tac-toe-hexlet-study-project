import ru.orlovvv.xo.model.Field;
import ru.orlovvv.xo.model.Figure;
import ru.orlovvv.xo.model.Game;
import ru.orlovvv.xo.model.Player;
import ru.orlovvv.xo.view.ConsoleView;

public class Main {

    public static void main(String[] args) {

        final String name1 = "Peter";
        final String name2 = "Ivan";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(3), "TicTacToe");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while(consoleView.move(game)) {
            consoleView.show(game);
        }

    }
}
