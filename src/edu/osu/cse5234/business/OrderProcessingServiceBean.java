package edu.osu.cse5234.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.osu.cse5234.business.view.Inventory;
import edu.osu.cse5234.business.view.InventoryService;
import edu.osu.cse5234.business.view.Item;
import edu.osu.cse5234.model.LineItem;
import edu.osu.cse5234.model.Order;
import edu.osu.cse5234.util.ServiceLocator;

/**
 * Session Bean implementation class OrderProcessingServiceBean
 */
@Stateless
@LocalBean
public class OrderProcessingServiceBean {

	private InventoryService inventoryService;
	@PersistenceContext
	private EntityManager entityManager;
	
	private InventoryService getInventoryService(){
		if(inventoryService==null){
	    	inventoryService = ServiceLocator.getInventoryService();
		}
		return inventoryService;
	}
    /**
     * Default constructor. 
     */
    public OrderProcessingServiceBean() {
        // TODO Auto-generated constructor stub
    }

    public String processOrder(Order order){
    	List<Item> list = new ArrayList<Item>();
    	for(LineItem item : order.getItems()){
    		Item i = new Item();
    		i.setName(item.getName());
    		i.setQuantity(item.getQuantity()+"");
    		list.add(i);
    	}
    	// update regarding item count
    	getInventoryService().updateInventory(list);
    	// store order into DB
    	entityManager.persist(order);
    	entityManager.flush();
    	// generate random letter of length 3
    	Random random = new Random();
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i<3;i++){
    		sb.append((char)('A'+random.nextInt(26)));
    	}
		return sb.toString();
    }
    public boolean validateItemAvailability(Order order){
    	List<Item> items = new ArrayList<Item>();
    	for(LineItem item : order.getItems()){
    		Item i = new Item();
    		i.setName(item.getName());
    		i.setQuantity(String.valueOf(item.getQuantity()));
    		items.add(i);
    	}
    	return getInventoryService().validateQuantity(items);
    }
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
    
}
