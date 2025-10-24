package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String[] carNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        for(int i=0; i< carNames.length; i++){
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }
    public int playInput(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        int attempts = Integer.parseInt(input);

        return attempts;
    }
}
