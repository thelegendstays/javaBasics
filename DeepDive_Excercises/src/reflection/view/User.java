package reflection.view;

import java.util.ResourceBundle;



public class User {

	public static view get() {
		// TODO Auto-generated method stub
		view temp = null; //NC is an interface
		// TODO Auto-generated method stub
		ResourceBundle r = ResourceBundle.getBundle("freak");
		String cof = r.getString("type");
		
		try {
			Class c = Class.forName(cof);
			Object o = c.newInstance();
			System.out.println("object is getting created");
			temp = (view) o;
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return temp;
	}

}
