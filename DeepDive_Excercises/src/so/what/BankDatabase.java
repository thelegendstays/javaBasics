package so.what;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



// BankDatabase.java
// Represents the bank account information database 

public class BankDatabase
{
   // array of Accounts
   private boolean stop;
   // no-argument BankDatabase constructor initializes accounts
   
   
   // retrieve Account object containing specified account number
   private Account getAccount( int scrap )
   {
	   Connection con = null;
		Account a =new Account(scrap,0,0,0);
		try {
			
			String freakjunk = 
					"select ACCOUNTNUMBER, PIN, AVAILABLEBALANCE,TOTALBALANCE  from account  where ACCOUNTNUMBER =  ? ";
			con = DbType.get();
			PreparedStatement stmt = con.prepareStatement(freakjunk);
						stmt.setInt(1, scrap);
						
					ResultSet rs = stmt.executeQuery();
					if(rs.next())
					{
						a.setPin(rs.getInt("PIN"));
						a.setAvailableBalance(rs.getInt("AVAILABLEBALANCE"));
						a.setTotalBalance(rs.getInt("TOTALBALANCE"));
						
						
					}
					else
							return null;
			
			
			
			stmt.close();
		
			System.out.println("program workingfine");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("id already taken, choose another id");
		}
		finally
		{
			try {
				if( con != null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return a;		
      
   } // end method getAccount

   // determine whether user-specified account number and PIN match
   // those of an account in the database
   public boolean authenticateUser( int userAccountNumber, int userPIN )
   {
      // attempt to retrieve the account with the account number
      Account userAccount = getAccount( userAccountNumber );

      // if account exists, return result of Account method validatePIN
      if ( userAccount != null )
         {
    	  if(userAccount.validatePIN(userPIN))userAccount.resetWrongTry();
         
    	  else
        	 {userAccount.incWrongTry();if(userAccount.isBlocked())stop=true;}
    	  return userAccount.validatePIN( userPIN );
         }
      else 
    	  return false;
     
   } // end method authenticateUser

   // return available balance of Account with specified account number
   public double getAvailableBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getAvailableBalance();
   } // end method getAvailableBalance

   // return total balance of Account with specified account number
   public double getTotalBalance( int userAccountNumber )
   {
      return getAccount( userAccountNumber ).getTotalBalance();
   } // end method getTotalBalance

   // credit an amount to Account with specified account number
   public void credit( int userAccountNumber, double amount )
   {
	   Connection con = null;
		try {
			Account a =getAccount( userAccountNumber );
			a.credit( amount );
			String freakjunk = 
					"update account set TOTALBALANCE =?  where ACCOUNTNUMBER =  ? ";
			con = DbType.get();
			PreparedStatement stmt = con.prepareStatement(freakjunk);
			stmt.setInt(1, (int) a.getTotalBalance());
			stmt.setInt(2, a.getAccountNumber());
			
			
			int ra  = stmt.executeUpdate();
			//ra does not matter in this case.
			if( ra > 0)
					System.out.println("update successful");
			else
					System.out.println("update where conditin failed");
			
			stmt.close();
		
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("id already taken, choose another id");
		}
		finally
		{
			try {
				if( con != null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
      
   } // end method credit

   // debit an amount from Account with specified account number
   public void debit( int userAccountNumber, double amount )
   {
	   Connection con = null;
		try {
			Account a =getAccount( userAccountNumber );
			a.debit( amount );
			String tot = 
					"update account set TOTALBALANCE =? where ACCOUNTNUMBER =  ? ";
			String avl = 
					"update account set AVAILABLEBALANCE =? where ACCOUNTNUMBER =  ? ";
			con = DbType.get();
			PreparedStatement stmt1 = con.prepareStatement(tot);
			PreparedStatement stmt2 = con.prepareStatement(avl);
			stmt1.setInt(1, (int) a.getTotalBalance());
			stmt1.setInt(2, a.getAccountNumber());
			
			stmt2.setInt(1, (int) a.getAvailableBalance());
			stmt2.setInt(2, a.getAccountNumber());
			int ra1  = stmt1.executeUpdate();
			int ra2  = stmt2.executeUpdate();
			//ra does not matter in this case.
			if( ra1 > 0)
					System.out.println("update tot successful");
			else
					System.out.println("update tot where conditin failed");
			if( ra2 > 0)
				System.out.println("update avl successful");
		else
				System.out.println("update avl where conditin failed");
			
			stmt1.close();
			stmt2.close();
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println("id already taken, choose another id");
		}
		finally
		{
			try {
				if( con != null)
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
   } // end method debit
   
   public boolean isStop()
   {return stop;}
} // end class BankDatabase



/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/