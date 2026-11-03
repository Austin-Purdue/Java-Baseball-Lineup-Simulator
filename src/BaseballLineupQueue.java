package Homework_4;

import java.util.Random;

public class BaseballLineupQueue {

    static class Player {
        String name;
        double battingAverage;
        double homeRunPercent;

        Player(String name, double ba, double hr) {
            this.name = name;
            this.battingAverage = ba;
            this.homeRunPercent = hr;
        }
    }

    static class Node {
        Player data;
        Node next;
        Node(Player data) { this.data = data; }
    }

    static class LinkedQueue {
        private Node head;
        private Node tail;

        public void addLast(Player p) {
            Node newNode = new Node(p);
            if(tail == null) {
                tail = newNode;
                head = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
            }
        }

        public Player removeFirst() {
            if(head == null) {
                return null;
            }else{
                Node temp = head;
                head = head.next;
                if(head == null){
                    tail = null;
                }
                return temp.data;
            }
        }

        public Player peekFirst() {
            if(head == null) {
                return null;
            }else{
                return head.data;
            }
        }

        public boolean isEmpty() {
            return head == null;
        }

        public boolean replace(String oldName, Player newPlayer) {
            Node current = head;
            while(current != null) {
                if(current.data.name.equalsIgnoreCase(oldName)){
                    current.data = newPlayer;
                    return true;
                }else{
                    current = current.next;
                }
            }
            return false;
        }

        public void printOrder(String label) {
            System.out.println("--- " + label + " ---");
            Node cur = head;
            int i = 1;
            while (cur != null) {
                System.out.println(i + ". " + cur.data.name);
                cur = cur.next;
                i++;
            }
            System.out.println("----------------------");
        }
    }

    static Random rng = new Random(42);

    static double rand() {
        return rng.nextDouble();
    }

    static int playOneInning(LinkedQueue lineup, int inningNum, String label) {
        System.out.println("----- Inning " + inningNum + " (" + label + ") -----");
        int outs = 0, runs = 0, hits = 0, batterNum = 0;

        while (outs < 3) {
            Player batter = lineup.removeFirst();
            if (batter == null) break;
            batterNum++;

            double r = rand();
            boolean hr  = r < batter.homeRunPercent;
            boolean hit = !hr && r < batter.battingAverage;

            if (hr) {
                runs += 2; hits++;
                System.out.printf("Batter %d – %s | Random: %.3f | HOME RUN (+2)%n",
                        batterNum, batter.name, r);
            } else if (hit) {
                runs += 1; hits++;
                System.out.printf("Batter %d – %s | Random: %.3f | HIT (+1)%n",
                        batterNum, batter.name, r);
            } else {
                outs++;
                System.out.printf("Batter %d – %s | Random: %.3f | OUT (%d)%n",
                        batterNum, batter.name, r, outs);
            }

            lineup.addLast(batter);
        }

        System.out.println("Inning Over — Runs: " + runs + "  Hits: " + hits + "\n");
        return runs;
    }


    public static void main(String[] args) {
        LinkedQueue lineup = new LinkedQueue();

        lineup.addLast(new Player("Ted Williams",   0.344, 0.0687));
        lineup.addLast(new Player("Rogers Hornsby", 0.359, 0.0375));
        lineup.addLast(new Player("Mark McGwire",   0.265, 0.0950));
        lineup.addLast(new Player("Babe Ruth",      0.340, 0.0850));

        lineup.printOrder("Initial Lineup");

        int totalRuns = 0;

        for (int inning = 1; inning <= 4; inning++) {
            totalRuns += playOneInning(lineup, inning, "regular play");
        }

        System.out.println("----- Player Substitution -----");
        boolean replaced = lineup.replace("Mark McGwire",
                new Player("Jackie Robinson", 0.313, 0.029));
        if (replaced) {
            System.out.println("Mark McGwire replaced with Jackie Robinson.");
        } else {
            System.out.println("Player not found — no change made.");
        }

        lineup.printOrder("Updated Lineup After Substitution");

        totalRuns += playOneInning(lineup, 5, "after substitution");

        System.out.println("---------------- Game Over ----------------");
        System.out.println("Final Score: " + totalRuns + " runs");
    }
}
