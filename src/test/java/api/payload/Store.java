package api.payload;

public class Store {
	
	int petID;
	int quantity;
	int shipDate;
	String status="placed";
	boolean complete=true;

	public int getPetID() {
		return petID;
	}
	public void setPetID(int petID) {
		this.petID = petID;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getShipDate() {
		return shipDate;
	}
	public void setShipDate(int shipDate) {
		this.shipDate = shipDate;
	}
	


}
