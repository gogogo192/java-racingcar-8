package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();

    public void start(){
        String[] carNames = inputView.carNamesInput();

        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        int attempts = inputView.playInput();

        for (int i = 0; i < attempts; i++) {
            for (int j = 0; j < cars.length; j++) {
                cars[j].move();
            }
            outputView.roundResultPrint(cars);
        }

        int maxPosition = 0;
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() > maxPosition) {
                maxPosition = cars[i].getPosition();
            }
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < cars.length; i++) {
            if (cars[i].getPosition() == maxPosition) {
                winners.add(cars[i].getName());
            }
        }
        outputView.winnerPrint(winners);
    }
}
