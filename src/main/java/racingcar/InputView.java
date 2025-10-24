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
        while (true) {
            System.out.println("시도할 횟수는 몇 회인가요?");
            String input = Console.readLine();
            if (!isNumeric(input)) { // depth 1
                System.out.println("숫자를 입력해야 합니다. 다시 입력해주세요.");
                continue;
            }
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                System.out.println("시도 횟수는 1 이상이어야 합니다. 다시 입력해주세요.");
                continue;
            }
            return attempts;
        }
    }
    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true; // depth 1
    }
}
