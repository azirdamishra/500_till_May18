//package com.company;

//import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdOut;

public class PercolationStats {
    // perform independent trials on an n-by-n grid
    //private int gridSide ;
    //private int openSites;
    private int T = 0;
    private final double[] fractions;
    public PercolationStats(int n, int trials){
        if (n <= 0 || T <= 0) {
            throw new java.lang.IllegalArgumentException();
        }
        //this.gridSide = n;
        this.T = trials;
        fractions = new double[T];
        double fraction;

        for(int e = 0; e < T; e++){
            Percolation percolation = new Percolation(n);
            int openSites = percolation.numberOfOpenSites();
            fraction = (double) openSites / (n*n);
            fractions[e] = fraction;
        }
    }

    // sample mean of percolation threshold
    public double mean(){
        return StdStats.mean(fractions);
    }

    // sample standard deviation of percolation threshold
    public double stddev(){
        return StdStats.stddev(fractions);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo(){
        return mean() - ((1.96 * stddev()) / Math.sqrt(T));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi(){
        return mean() + ((1.96 * stddev()) / Math.sqrt(T));
    }

    // test client (see below)
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int T = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, T);

        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                    = " + ps.mean());
        StdOut.println("stddev                  = " + ps.stddev());
        StdOut.println("95% confidence interval = " + confidence);
    }

}
