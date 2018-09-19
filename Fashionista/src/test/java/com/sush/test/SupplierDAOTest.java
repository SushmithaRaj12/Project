package com.sush.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sush.dao.CategoryDAO;
import com.sush.dao.SupplierDAO;
import com.sush.model.Category;
import com.sush.model.Supplier;

public class SupplierDAOTest {
	 static SupplierDAO supplierDAO;
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.sush");
			context.refresh();
		    supplierDAO=(SupplierDAO)context.getBean("SupplierDAO");
		}
	
		//@Ignore
	    @Test
	    public void addSupplierTest()
	    {
	    	Supplier supplier=new Supplier();
	    	supplier.setSupplierName("Lakme");
	        supplier.setAddress("Newyork");
	        supplier.setSupplierName("Revlon");
	        supplier.setAddress("Los Angles");
	        assertTrue("Problem in Adding Supplier:",supplierDAO.addSupplier(supplier));
	    }
		@Ignore
	    @Test
	    public void updateSupplierTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(3);
	    	supplier.setSupplierName("ColorBar");
	        supplier.setAddress("Manhattan");
	        assertTrue("Problem in updating the Supplier:",supplierDAO.updateSupplier(supplier));
	    }
	    @Ignore
	    @Test
	    public void deleteSupplierTest()
	    {
	    	Supplier supplier=supplierDAO.getSupplier(2);
	        supplier.setAddress("Calfornia");
	        assertTrue("Problem in deleting the Supplier:",supplierDAO.deleteSupplier(supplier));
	    }
	    
	    @Ignore
	    @Test
	    public void listSuppliersTest()
	    {
	    	List<Supplier>listSuppliers=supplierDAO.listSuppliers();
	    	assertNotNull("Problem in listing supppliers",listSuppliers);
	    	for(Supplier supplier:listSuppliers)
	    	{
	    		System.out.print(supplier.getSupplierId()+":::");
	    		System.out.print(supplier.getSupplierName()+":::");
	    		System.out.print(supplier.getAddress());
	    	}
	    		
	    	
	    }
}
