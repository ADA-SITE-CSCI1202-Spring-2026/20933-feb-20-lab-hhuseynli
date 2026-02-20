import java.util.Scanner;
public class Invoice {
    private String partNumber;
    private String partDescription;
    private int itemQuantity;
    private double pricePerItem;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter part number:");
        String partNumber = sc.nextLine();
        System.out.println("Enter part description:");
        String partDescription = sc.nextLine();
        System.out.println("Enter item quantity:");
        int itemQuantity = sc.nextInt();
        System.out.println("Enter price per item:");
        double pricePerItem = sc.nextDouble();
        Invoice invoice = new Invoice(partNumber, partDescription, itemQuantity, pricePerItem);
        System.out.println("Invoice amount: " + invoice.getInvoiceAmount());

    }
    public Invoice (String partNumber, String partDescription, int itemQuantity, double pricePerItem){
        this.partNumber = partNumber;
        this.partDescription = partDescription;
        setItemQuantity(itemQuantity);
        setPricePerItem(pricePerItem);
    }

    public void setPartNumber(String partNumber){
        this.partNumber = partNumber;
    }

    public void setPartDescription(String partDescription){
        this.partDescription = partDescription;
    }

    public void setItemQuantity(int itemQuantity){
        if (itemQuantity > 0){
            this.itemQuantity = itemQuantity;
        } else {
            this.itemQuantity = 0;
        }
    }
    
    public void setPricePerItem(double pricePerItem){
        if (pricePerItem > 0){
            this.pricePerItem = pricePerItem;
        } else {
            this.pricePerItem = 0.0;
        }
    }

    public String getPartNumber(){
        return partNumber;
    }

    public String getPartDescription(){
        return partDescription;
    }

    public int getItemQuantity(){
        return itemQuantity;
    }

    public double getPricePerItem(){
        return pricePerItem;
    }
    
    public double getInvoiceAmount(){
        return itemQuantity * pricePerItem;
    }
}