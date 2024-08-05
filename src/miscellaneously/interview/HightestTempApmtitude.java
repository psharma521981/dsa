package src.miscellaneously.interview;

import java.util.HashMap;
import java.util.Map;

//Codelity Guidewire
public class HightestTempApmtitude {
    Map<Integer, String> maxAmplitude = new HashMap<>();
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String solution(int[] T) {
        if (T == null)
            return null;

        int lenOfTemp = (T.length / 4);
        if (lenOfTemp == 0)
            return null;

        storeAmplitude("WINTER", T, 0, (lenOfTemp * 1) - 1);
        storeAmplitude("SPRING", T, (lenOfTemp * 1), (lenOfTemp * 2) - 1);
        storeAmplitude("SUMMER", T, (lenOfTemp * 2), (lenOfTemp * 3) - 1);
        storeAmplitude("AUTUMN", T, (lenOfTemp * 3), (lenOfTemp * 4) - 1);

        int maxDiff = Integer.MIN_VALUE;

        for (Integer season : maxAmplitude.keySet()) {
            maxDiff = Math.max(maxDiff, season);
        }

        return maxAmplitude.get(maxDiff);

    }

    private void storeAmplitude(String season, int[] T, int low, int high) {
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = Integer.MIN_VALUE;

        while (low <= high) {
            if (T[low] >= maxTemp) {
                maxTemp = T[low];
            }
            if (T[low] < minTemp) {
                minTemp = T[low];
            }

            low++;

        }

        if (minTemp <= 0 && maxTemp >= 0) {
            maxAmplitude.put((maxTemp + Math.abs(minTemp)), season);
        } else if (minTemp > 0 && maxTemp > 0) {
            maxAmplitude.put((maxTemp - minTemp), season);
        } else if (minTemp < 0 && maxTemp < 0) {
            maxAmplitude.put((Math.abs(maxTemp) - Math.abs(minTemp)), season);
        }
    }

}
