package com.crowdscout.model.scoutingreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchRecordMerger {

    private static double gapscore = -1;
    //private static double[][] costArray;


    static MatchRecord mergeReports(MatchRecord report1, MatchRecord report2){
        
    
        int row, col;    // for indexing through array
        double northwest, north, west;  // (row, col) entry will be max of these

        int xlen = report1.getEvents().size();
        int ylen = report2.getEvents().size();

        Node[][] scoreArray = new Node[xlen][ylen];
        // Fill the top row and left column:
        scoreArray[0][0] = new Node(0,0,0);
        for (col=1; col <= xlen; col++){
            scoreArray[0][col] = new Node(col, 0, gapscore * col);
            scoreArray[0][col] = scoreArray[0][col - 1];
        }
        for (row=1; row <= ylen; row++){
            scoreArray[row][0] = new Node( 0, row, gapscore * row );
            scoreArray[row][0].setParent( scoreArray[row-1][0]);
        }
        // Now fill in the rest of the array:
        for (row=1; row <= ylen; row++) {
            for (col=1; col <= xlen; col++) {
                
                //TODO get cost for northwest, north, and west.
                north = gapscore;
                west = gapscore;

                Node current = new Node(col, row);

                //current.updateParent(scoreArray[ row - 1 ][ col -1], northwest);
                current.updateParent(scoreArray[ row - 1 ][ col ], north);
                current.updateParent(scoreArray[ row ][ col - 1 ], west);

                scoreArray[row][col] = current;
            }
        }
        // Now set the nodes on the best path.

        List<Node> nodesOnBestPath = new ArrayList<>();
        nodesOnBestPath = new ArrayList<Node>();
        Node currentNode = scoreArray[ylen][xlen];
        while(true){
            if(currentNode.getParent() != null){
                nodesOnBestPath.add(currentNode);
                currentNode = currentNode.getParent();
            }
            else
                break;
        }

        Collections.reverse(nodesOnBestPath);

        
        return null;
    }
}


class Node{

    private int xCoord;
    private int yCoord;

    private double score = Integer.MIN_VALUE;

    private Node parent;

    public Node(int x, int y) {
        this.xCoord = x;
        this.yCoord = y;
    }

    public Node(int x, int y, double d) {
        this(x, y);
        this.score = d;
    }

    public double getScore(){
        return score;
    }



    public void updateParent(Node n, double changeOfScore){
        if(n.score + changeOfScore > score){
            parent = n;
            score = n.getScore() + changeOfScore;
        }
    }

    public Node getParent(){
        return parent;
    }

    public void setParent(Node parent){
        this.parent = parent;
    }

    public int getXDiff(){
        if(parent != null)
            return xCoord - parent.xCoord;
        return 0;
    }

    public int getYDiff(){
        if(parent != null)
            return yCoord - parent.yCoord;
        return 0;
    }
}