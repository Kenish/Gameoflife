package com.better.than.yours.game.cucumbers.js.not;

class Cell implements Cells{
    private boolean livingStatus;
    Position position ;
    private Integer id;
    private Integer neigbours=0;
    Cell(boolean livingStatus,Position position,Board board){
        this.livingStatus=livingStatus;
        if (position.getX()<0||position.getY()<0){
            throw new WrongPositionException("X and Y coordinates should be positive");
        }
        this.position =position;
        this.id= (position.getX())+(position.getY()*board.width);
    }

    @Override
    public boolean isAlive() {
        return livingStatus;
    }

    @Override
    public int getLivingNeighbours() {
        return neigbours ;
    }

    void addNeigbour(){
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
