import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class A5 {
    static Double ActionRate = 1.0D;

    static class Camp {
        int id;
        double plannedBudget;
        double spentBudget;
        double maxBid;

        public Camp(int id, double budget, double maxBid) {
            this.id = id;
            this.plannedBudget = budget;
            this.maxBid = maxBid;
        }

        @Override
        public String toString() {
            return "Camp{" +
                    "id=" + id +
                    ", plannedBudget=" + plannedBudget +
                    ", spentBudget=" + spentBudget +
                    '}';
        }

        double getBid(Camp c, int minute) {
            double baseBidCurrentHour = c.maxBid * 0.75/ 2;
            double timePassedHour = (double) (minute + 1) / 60;
            double remainingBudget = c.plannedBudget - c.spentBudget;
            double remainingPlannedBudget = c.plannedBudget * (1 - timePassedHour);
            double adjustmentFactor = remainingPlannedBudget <= 0 ? remainingBudget : remainingBudget / remainingPlannedBudget;
            double bid = Math.min(c.maxBid * 0.75, baseBidCurrentHour * adjustmentFactor) * ActionRate;
            return bid;
        }
    }

    static class Bid {
        Camp c;
        double bid;

        public Bid(Camp c, double bid) {
            this.c = c;
            this.bid = bid;
        }
    }

    static void runAuction(List<Camp> list, int m) {
        PriorityQueue<Bid> pq = new PriorityQueue<Bid>((a, b) -> Double.compare(b.bid, a.bid));
        for (Camp c : list) {
            pq.add(new Bid(c, c.getBid(c, m)));
        }
        Bid winner = pq.poll();
        winner.c.spentBudget += winner.bid;
        System.out.println("winner is " + winner.c+", bid = " + winner.bid);
    }

    public static void main(String[] args) {
        List<Camp> list = new ArrayList<>();
        int n = 100;
        list.add(new Camp(0, 100, 5));
        for (int i = 1; i < n; i++) {
            list.add(new Camp(i, 100, 1));
        }
        for (int m = 1; m < 60; m++) {
            runAuction(list, m);

        }
    }
}
