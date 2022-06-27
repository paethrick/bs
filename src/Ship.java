import java.util.List;

public class Ship {

    private List<Square> NewShip;
    private ShipType shipType;

    public Ship(List<Square> newShip, ShipType shipType) {
        NewShip = newShip;
        this.shipType = shipType;
    }

    public List<Square> getFields() {
        return NewShip;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void add(Square square){
        NewShip.add(square);
    }

    public boolean isPlacementOk(Ship ship1, List<Ship> ships, Board board){
        int count = 0;
        for(int i=0; i<ship1.getFields().size(); i++){
            if(ship1.getFields().get(i).getY() > board.getSizeY() ||
                    ship1.getFields().get(i).getX() > board.getSizeX()){
                count++;
            }
            for(int k=0; k<ships.size(); k++){
                for(int j=0; j<ships.get(k).getFields().size(); j++){
                    if((ship1.getFields().get(i).getX() == ships.get(k).getFields().get(j).getX() &&
                            ship1.getFields().get(i).getY() == ships.get(k).getFields().get(j).getY())){
                        count++;
                    }
                }
            }
        }
        if(count == 0){
            return true;
        } else {
            return false;
        }
    }
}
