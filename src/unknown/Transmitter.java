package unknown;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by junhyeok on 2016-10-26.
 */
public class Transmitter {
    private static Building[] buildings;
    private static List<Building> transmitters;
    private static double sum;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("input6.txt"));
        //Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        buildings = new Building[n];
        int idx = 0;

        transmitters = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            buildings[i] = new Building(sc.nextInt() == 0 ? false : true, sc.nextInt(), sc.nextInt(), i);
            if (buildings[i].hasTransmitter) {
                transmitters.add(buildings[i]);
            }
        }
        for (Building transmitter :
                transmitters) {
            for (int i = transmitter.idx - 1; i >= 0; i--) {
                if(buildings[i].distance==transmitter.distance)
                    break;
                if(buildings[i].hasTransmitter){
                    sum+=transmitter.distance-buildings[i].distance;
                    break;
                }
                if(transmitter.idx==1)
                    sum+=transmitter.distance;
                if(i==transmitter.idx-1){
                    sum+=transmitter.distance-buildings[i].distance;
                }
                if(buildings[i].height>transmitter.height)
                    break;
                double dist = calReachedPoint(buildings[i], transmitter,true);
                if (transmitter.idx == 1) {
                    if (dist > 0)
                        sum += dist;
                } else {
                    if (dist > buildings[i ].distance && !buildings[i-1].hasTransmitter) {
                        sum += dist - buildings[i - 1].distance;
                    }
                }
            }
            for (int i = transmitter.idx + 1; i < n; i++) {
                if(buildings[i].hasTransmitter || buildings[i].distance==transmitter.distance){
                    break;
                }
                if(transmitter.idx==n-1)
                    sum+=d-transmitter.distance;
                if(i==transmitter.idx+1){
                    sum+=buildings[i].distance-transmitter.distance;
                }
                if(buildings[i].height>transmitter.height)
                    break;
                double dist = calReachedPoint(transmitter, buildings[i],false);
                if (i == n - 1) {
                    if (dist < d)
                        sum += d - dist;
                } else {
                    if (dist < buildings[i].distance && !buildings[i+1].hasTransmitter) {
                        sum += buildings[i].distance - dist;
                    }
                }
            }
        }
        System.out.println(String.format("%.5f",sum));


    }


    static double calReachedPoint(Building a, Building b, boolean isLeft) {

        double dis=b.distance - b.height * ((isLeft)?1:-1)*(Math.abs(b.distance - a.distance) / ((double) Math.abs(b.height - a.height)));
        return dis;
    }

    private static class Building {
        int height;
        int distance;
        boolean hasTransmitter;
        int idx;

        public Building() {
            //
        }

        public Building(boolean hasTransmitter, int distance, int height, int idx) {
            this.hasTransmitter = hasTransmitter;
            this.distance = distance;
            this.height = height;
            this.idx = idx;
        }
    }
}
