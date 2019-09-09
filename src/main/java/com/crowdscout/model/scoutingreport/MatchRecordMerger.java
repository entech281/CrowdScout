package com.crowdscout.model.scoutingreport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchRecordMerger {

    private static final int acceptableTimeDifference = 6;
    private static final int acceptableTimeDifferenceSquared = acceptableTimeDifference * acceptableTimeDifference;
    private static final double gapscore = -1;

    

    public static MatchRecord mergeReports(MatchRecord report1, MatchRecord report2){
        
        List<Node> nodes = getNodesOnBestPath(report1.getEvents(), report2.getEvents());
        AlignEventLists(report1.getEvents(), report2.getEvents(), nodes);
        return new MatchRecord(report1.getEvents());
    }

    private static List<Node> getNodesOnBestPath(List<ReportedEvent> events1, List<ReportedEvent> events2){
        int row, col;    // for indexing through array

        int xlen = events1.size();
        int ylen = events2.size();

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
                double northwest, north, west;
                northwest = GetAcceptBothScore(events1.get(col), events2.get(row));
                north = gapscore;
                west = gapscore;

                Node current = new Node(col, row);

                current.updateParent(scoreArray[ row - 1 ][ col -1], northwest);
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

        nodesOnBestPath.remove(0);

        return nodesOnBestPath;
    }

    private static double GetAcceptBothScore(ReportedEvent e1, ReportedEvent e2){
        return - Math.pow( ( e1.getStartedTime() - e2.getStartedTime()),1)
                     - Math.pow( e1.getDuration() - e1.getDuration(), 2)
                     + 2 * acceptableTimeDifferenceSquared;
    }

    private static void AlignEventLists(List<ReportedEvent> list1, List<ReportedEvent> List2, List<Node> nodes){
        
        int xCounter = 0;
        int yCounter = 0;

        for (Node node : nodes) {
            if(node.getXDiff()==0){
                list1.add(xCounter, getMissedEvent());
            } else{
                xCounter ++;
            }
            if(node.getYDiff()==0){
                list1.add(yCounter, getMissedEvent());
            } else{
                yCounter ++;
            }

        }
    }

    private static ReportedEvent getMissedEvent(){
        return new ReportedEvent("missed", 0, 0);
    }

    private static List<ReportedEvent> MergeEventLists(List<ReportedEvent> list1, List<ReportedEvent> list2){
        List<ReportedEvent> finalReport = new ArrayList<>();
        for (int i = 0; i < list1.size(); i ++) {
            ReportedEvent event1 = list1.get(i);
            ReportedEvent event2 = list2.get(i);
            if(event1.getName().equals(event2.getName())){
                finalReport.add(
                    new ReportedEvent(event1.getName(), 
                    ( event1.getStartedTime() + event2.getStartedTime() ) / 2, 
                    (event1.getDuration() + event2.getDuration() ) / 2
                ));
            }
            
        }
        
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
