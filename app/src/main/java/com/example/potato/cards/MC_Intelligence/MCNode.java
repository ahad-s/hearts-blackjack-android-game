package com.example.potato.cards.MC_Intelligence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * Created by Potato on 10/20/2015.
 */
public class MCNode {

    static final double constant = Math.sqrt(2);

    ArrayList<MCNode> childMCNodes = new ArrayList<>();

    SimpleCard nodeCard;
    ArrayList<SimpleCard> restOfCards;

    MCNode parentNode;

    boolean rootNode = false;

    public ArrayList<SimpleCard> getRestOfCards() {
        return restOfCards;
    }

    public boolean isRootNode() {
        return rootNode;
    }

    private int timesVisited; // N(v)

    public ArrayList<MCNode> getChildMCNodes() {
        return childMCNodes;
    }

    // TODO: wtf is this name, Q(v) -- totalRewardsOfPlayoutsThroughoutThisNode
    private double totalRewards; // i.e. calculate using the payoffs of children

    public SimpleCard getNodeCard() {
        return nodeCard;
    }

    public MCNode(SimpleCard thisCard, ArrayList<SimpleCard> restOfCards){
        this.nodeCard = thisCard;
        this.restOfCards = new ArrayList<>((ArrayList<SimpleCard>) restOfCards.clone());
    }


    public boolean isTerminalNode(){
        return (restOfCards.size() > 0);
    }

    public MCNode getParentNode() {
        return parentNode;
    }

    public void addChildNode(MCNode n){
        childMCNodes.add(n);
    }



    public int getTimesVisited() {
        return timesVisited;
    }

    public double getTotalRewards() {
        return totalRewards;
    }

    public void incrementTimesVisited(){
        this.timesVisited++;
    }


    // recalculate reward using UCB
    public void addTotalRewards(double newRewards){
        this.totalRewards += newRewards;
    }





    // backpropagation + adding up rewards along tree
    private void backThat658383Up(MCNode n, double newReward){ // newReward should just be the new score of game, i.e. (1/26 * score)
        while (!n.isRootNode()){
            n.incrementTimesVisited();
            n.addTotalRewards(newReward); // TODO
            n = n.getParentNode();
        }
    }
}
