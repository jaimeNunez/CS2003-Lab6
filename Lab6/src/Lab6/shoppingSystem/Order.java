/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package Lab6.shoppingSystem;

// line 22 "../../umpleShoppingSystem.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private String orderDate;
  private int orderCost;
  private int shippingCost;
  private int itemCost;

  //Order Associations
  private Account account;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(String aOrderDate, int aOrderCost, int aShippingCost, int aItemCost, Account aAccount)
  {
    orderDate = aOrderDate;
    orderCost = aOrderCost;
    shippingCost = aShippingCost;
    itemCost = aItemCost;
    boolean didAddAccount = setAccount(aAccount);
    if (!didAddAccount)
    {
      throw new RuntimeException("Unable to create order due to account");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setOrderDate(String aOrderDate)
  {
    boolean wasSet = false;
    orderDate = aOrderDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderCost(int aOrderCost)
  {
    boolean wasSet = false;
    orderCost = aOrderCost;
    wasSet = true;
    return wasSet;
  }

  public boolean setShippingCost(int aShippingCost)
  {
    boolean wasSet = false;
    shippingCost = aShippingCost;
    wasSet = true;
    return wasSet;
  }

  public boolean setItemCost(int aItemCost)
  {
    boolean wasSet = false;
    itemCost = aItemCost;
    wasSet = true;
    return wasSet;
  }

  public String getOrderDate()
  {
    return orderDate;
  }

  public int getOrderCost()
  {
    return orderCost;
  }

  public int getShippingCost()
  {
    return shippingCost;
  }

  public int getItemCost()
  {
    return itemCost;
  }

  public Account getAccount()
  {
    return account;
  }

  public boolean setAccount(Account aAccount)
  {
    boolean wasSet = false;
    if (aAccount == null)
    {
      return wasSet;
    }

    Account existingAccount = account;
    account = aAccount;
    if (existingAccount != null && !existingAccount.equals(aAccount))
    {
      existingAccount.removeOrder(this);
    }
    account.addOrder(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Account placeholderAccount = account;
    this.account = null;
    placeholderAccount.removeOrder(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "orderDate" + ":" + getOrderDate()+ "," +
            "orderCost" + ":" + getOrderCost()+ "," +
            "shippingCost" + ":" + getShippingCost()+ "," +
            "itemCost" + ":" + getItemCost()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "account = "+(getAccount()!=null?Integer.toHexString(System.identityHashCode(getAccount())):"null");
  }
}