/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.26.0-b05b57321 modeling language!*/

package Lab6.shoppingSystem;
import java.util.*;

// line 5 "../../umpleShoppingSystem.ump"
public class Customer
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Attributes
  private String customerName;
  private int customerAge;
  private String customerGender;
  private double customerSize;

  //Customer Associations
  private List<Account> accounts;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aCustomerName, int aCustomerAge, String aCustomerGender, double aCustomerSize)
  {
    customerName = aCustomerName;
    customerAge = aCustomerAge;
    customerGender = aCustomerGender;
    customerSize = aCustomerSize;
    accounts = new ArrayList<Account>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCustomerName(String aCustomerName)
  {
    boolean wasSet = false;
    customerName = aCustomerName;
    wasSet = true;
    return wasSet;
  }

  public boolean setCustomerAge(int aCustomerAge)
  {
    boolean wasSet = false;
    customerAge = aCustomerAge;
    wasSet = true;
    return wasSet;
  }

  public boolean setCustomerGender(String aCustomerGender)
  {
    boolean wasSet = false;
    customerGender = aCustomerGender;
    wasSet = true;
    return wasSet;
  }

  public boolean setCustomerSize(double aCustomerSize)
  {
    boolean wasSet = false;
    customerSize = aCustomerSize;
    wasSet = true;
    return wasSet;
  }

  public String getCustomerName()
  {
    return customerName;
  }

  public int getCustomerAge()
  {
    return customerAge;
  }

  public String getCustomerGender()
  {
    return customerGender;
  }

  public double getCustomerSize()
  {
    return customerSize;
  }

  public Account getAccount(int index)
  {
    Account aAccount = accounts.get(index);
    return aAccount;
  }

  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }

  public int numberOfAccounts()
  {
    int number = accounts.size();
    return number;
  }

  public boolean hasAccounts()
  {
    boolean has = accounts.size() > 0;
    return has;
  }

  public int indexOfAccount(Account aAccount)
  {
    int index = accounts.indexOf(aAccount);
    return index;
  }

  public static int minimumNumberOfAccounts()
  {
    return 0;
  }

  public Account addAccount(String aAccountID, String aAccountName, String aPassword, String aCreatedDate)
  {
    return new Account(aAccountID, aAccountName, aPassword, aCreatedDate, this);
  }

  public boolean addAccount(Account aAccount)
  {
    boolean wasAdded = false;
    if (accounts.contains(aAccount)) { return false; }
    Customer existingCustomer = aAccount.getCustomer();
    boolean isNewCustomer = existingCustomer != null && !this.equals(existingCustomer);
    if (isNewCustomer)
    {
      aAccount.setCustomer(this);
    }
    else
    {
      accounts.add(aAccount);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAccount(Account aAccount)
  {
    boolean wasRemoved = false;
    //Unable to remove aAccount, as it must always have a customer
    if (!this.equals(aAccount.getCustomer()))
    {
      accounts.remove(aAccount);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addAccountAt(Account aAccount, int index)
  {  
    boolean wasAdded = false;
    if(addAccount(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAccountAt(Account aAccount, int index)
  {
    boolean wasAdded = false;
    if(accounts.contains(aAccount))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAccounts()) { index = numberOfAccounts() - 1; }
      accounts.remove(aAccount);
      accounts.add(index, aAccount);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAccountAt(aAccount, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=accounts.size(); i > 0; i--)
    {
      Account aAccount = accounts.get(i - 1);
      aAccount.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "customerName" + ":" + getCustomerName()+ "," +
            "customerAge" + ":" + getCustomerAge()+ "," +
            "customerGender" + ":" + getCustomerGender()+ "," +
            "customerSize" + ":" + getCustomerSize()+ "]";
  }
}