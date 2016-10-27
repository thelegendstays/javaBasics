package so.ds.maps;

public class Item {
	private int itemno, qty,price;
	private String itemname;
	public int getItemno() {
		return itemno;
	}
	public void setItemno(int itemno) {
		this.itemno = itemno;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	/**
	 * @param itemno
	 * @param qty
	 * @param price
	 * @param itemname
	 */
	public Item(int itemno, int qty, int price, String itemname) {
		this.itemno = itemno;
		this.qty = qty;
		this.price = price;
		this.itemname = itemname;
	}
	@Override
	public String toString() {
		return "Item [itemno=" + itemno + ", qty=" + qty + ", price=" + price
				+ ", itemname=" + itemname + "]";
	}
	
}
