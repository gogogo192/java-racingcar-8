package racingcar;

import java.util.List;

public class OutputView {

    public void roundResultPrint(Car[] cars){
        for(int a=0; a< cars.length; a++){
            System.out.println(cars[a].getName()+ ":" +"-".repeat(cars[a].getPosition()));
        }
        System.out.println();
    }

    public void winnerPrint(List<String> winners) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (i != winners.size() - 1) { // 마지막 요소 뒤에는 쉼표 안 붙이기
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}
