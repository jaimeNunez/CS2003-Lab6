/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package Lab6.shoppingSystem;
import java.util.*;

// line 13 "../../umpleShoppingSystem.ump"
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String accountID;
  private String accountName;
  private String password;
  private String createdDate;

  //Account Associations
  private List<Order> orders;
  private Customer customer;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aAccountID, String aAccountName, String aPassword, String aCreatedDate, Customer aCustomer)
  {
    accountID = aAccountID;
    accountName = aAccountName;
    password = aPassword;
    createdDate = aCreatedDate;
    orders = new ArrayList<Order>();
    boolean didAddCustomer = setCustomer(aCustomer);
    if (!didAddCustomer)
    {
      throw new RuntimeException("Unable to create account due to customer");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAccountID(String aAccountID)
  {
    boolean wasSet = false;
    accountID = aAccountID;
    wasSet = true;
    return wasSet;
  }

  public boolean setAccountName(String aAccountName)
  {
    boolean wasSet = false;
    accountName = aAccountName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }

  public boolean setCreatedDate(String aCreatedDate)
  {
    boolean wasSet = false;
    createdDate = aCreatedDate;
    wasSet = true;
    return wasSet;
  }

  public String getAccountID()
  {
    return accountID;
  }

  public String getAccountName()
  {
    return accountName;
  }

  public String getPassword()
  {
    return password;
  }

  public String getCreatedDate()
  {
    return createdDate;
  }

  public Order getOrder(int index)
  {
    Order aOrder = orders.get(index);
    return aOrder;
  }

  public List<Order> getOrders()
  {
    List<Order> newOrders = Collections.unmodifiableList(orders);
    return newOrders;
  }

  public int numberOfOrders()
  {
    int number = orders.size();
    return number;
  }

  public boolean hasOrders()
  {
    boolean has = orders.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = orders.indexOf(aOrder);
    return index;
  }

  public Customer getCustomer()
  {
    return customer;
  }

  public static int minimumNumberOfOrders()
  {
    return 0;
  }

  public Order addOrder(String aOrderDate, int aOrderCost, int aShippingCost, int aItemCost)
  {
    return new Order(aOrderDate, aOrderCost, aShippingCost, aItemCost, this);
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (orders.contains(aOrder)) { return false; }
    Account existingAccount = aOrder.getAccount();
    boolean isNewAccount = existingAccount != null && !this.equals(existingAccount);
    if (isNewAccount)
    {
      aOrder.setAccount(this);
    }
    else
    {
      orders.add(aOrder);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    //Unable to remove aOrder, as it must always have a account
    if (!this.equals(aOrder.getAccount()))
    {
      orders.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(orders.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrders()) { index = numberOfOrders() - 1; }
      orders.remove(aOrder);
      orders.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public boolean setCustomer(Customer aCustomer)
  {
    boolean wasSet = false;
    if (aCustomer == null)
    {
      return wasSet;
    }

    Customer existingCustomer = customer;
    customer = aCustomer;
    if (existingCustomer != null && !existingCustomer.equals(aCustomer))
    {
      existingCustomer.removeAccount(this);
    }
    customer.addAccount(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    for(int i=orders.size(); i > 0; i--)
    {
      Order aOrder = orders.get(i - 1);
      aOrder.delete();
    }
    Customer placeholderCustomer = customer;
    this.customer = null;
    placeholderCustomer.removeAccount(this);
  }


  public String toString()
  {
    return super.toString() + "["+
            "accountID" + ":" + getAccountID()+ "," +
            "accountName" + ":" + getAccountName()+ "," +
            "password" + ":" + getPassword()+ "," +
            "createdDate" + ":" + getCreatedDate()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "customer = "+(getCustomer()!=null?Integer.toHexString(System.identityHashCode(getCustomer())):"null");
  }
}