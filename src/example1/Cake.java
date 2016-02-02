package example1;

import javax.swing.JOptionPane;

/**
 * This class is an an abstraction of a real cake object. It demonstrates poor
 * encapsulation.
 * 
 * @author jlombardo
 */
public class Cake {
    private String cakeName;
    //// Both of these properties violate encapsulation rules. All should be
    // declared private scope and should have getter and/or setter methods.
    ///////
    private int quantity;
    private int size;

    //// Some of the methods below violate encapsulation rules. Many should
    //   be private, those that have arguments (setters) need validation rules.
    ////////

    // Encapsulating the setCakeName field
    public void cakeName(String name) {
        this.cakeName = name;
    }
    public String getCakeName(){
        return this.cakeName;
    }
    
    // Encapsulating the quantity field
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public int getQuantity() {
        return quantity;
    }
    //Encapsulating the size field
    public void setSize(int size){
        this.size = size;
    }
    public int getSize() {
        return this.size;
    }
    
    /* 
        These methods represent steps that should be performed
        in a certain order, but there is no guarantee this will happen.
        Furthermore, making all of these methods public exposes complexity
        that is not necessary. 
    */

    // VERY BAD! quantity should be validated for legal range
    private void gatherIngredients(int quantity) {
        if(quantity > 0 && quantity  < 20) {
            this.quantity = quantity;
            System.out.println("Ingredients gathered");
        }
        else{
        JOptionPane.showMessageDialog(null, "Error: quantity is out of range.");
            System.exit(0);
        }
    }

    private void mixIngredients() {
        System.out.println("Ingredients mixed");
    }

    public void bake()throws InterruptedException {
        gatherIngredients(quantity);
        mixIngredients();
        System.out.println("Baking...");
        Thread.sleep(5000);
        System.out.println("Beep Beep Beep");
        //takeFromOvenAndLetCool();
    }

    public void takeFromOvenAndLetCool() {
        System.out.println("All done baking, removed from oven, cooling...");
    }
}
