//package Adapter;
//
//import Adapter.learn.*;
//
//public class Main {
//    public static void main(String[] args) {
//        RoundHole hole = new RoundHole(5);
//        RoundPeg roundPeg = new RoundPeg(5);
//        System.out.println("Round peg fits: " + hole.fits(roundPeg));
//
//        SquarePeg smallSqPeg = new SquarePeg(5);
//        SquarePeg largeSqPeg = new SquarePeg(10);
//
//        SquarePegAdapter smallAdapter = new SquarePegAdapter(smallSqPeg);
//        SquarePegAdapter largeAdapter = new SquarePegAdapter(largeSqPeg);
//
//        System.out.println("Small square peg fits: " + hole.fits(smallAdapter));
//        System.out.println("Large square peg fits: " + hole.fits(largeAdapter));
//
//    }
//}