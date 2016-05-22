package com.better.than.yours.game.cucumbers.js.not;

class Cell implements Cells{
    private boolean livingStatus; // living status of cell
    Position position ; // instance of position
    private Integer id; // unique id
    private Integer neigbours=0; // number of neighbours
    Cell(boolean livingStatus,Position position){  //constructor making some cells
        this.livingStatus=livingStatus;
        if (position.getX()<0||position.getY()<0){
            throw new WrongPositionException("X and Y coordinates should be positive");
        }
        this.position =position;
        this.id=(position.getX())+(position.getY()*Board.width);
    }

    @Override
    public boolean isAlive() {
        return livingStatus;
    }

    @Override
    public int getLivingNeighbours() {
        return neigbours ;
    }

    void addNeigbour(){ // adding neigbours
        neigbours+=1;
    }

    public Integer getId(){
        return this.id;
    }

    void revive(){
        this.livingStatus=true;
    }

    void kill(){
        this.livingStatus=false;
    }

    void zeroNeighbours() {
        this.neigbours=0;
    }
}
