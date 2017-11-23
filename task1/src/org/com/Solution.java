package org.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	SessionFactory sf = new Configuration().configure().buildSessionFactory();
	Session session = sf.openSession();

	public void create() throws NumberFormatException, IOException {
		session.beginTransaction();
		System.out.println("Enter the id : ");
		int id = Integer.valueOf(bf.readLine());
		System.out.println("Enter the name : ");
		String name = bf.readLine();
		System.out.println("Enter the quantity : ");
		int quantity = Integer.valueOf(bf.readLine());
		Item obj = new Item(id, name, quantity);
		session.getTransaction().commit();
		session.save(obj);
	}

	public void update() throws NumberFormatException, IOException {
		int flag = 1, flag2 = 1;
		System.out.println("1.For update ");
		flag = Integer.valueOf(bf.readLine());
		while (flag == 1) {
			System.out.println("Enter the id which want to be update : ");
			int id = Integer.valueOf(bf.readLine());
			Item obj = session.get(Item.class, id);
			session.beginTransaction();
			while (flag2 == 1) {
				System.out.println("one want to update  1. for name 2. for quantity 3. for price \n");
				int choice = Integer.valueOf(bf.readLine());
				switch (choice) {
				case 1: {
					System.out.println("Enter the name : ");
					String name = bf.readLine();
					obj.setName(name);
					break;
				}
				case 2: {
					System.out.println("Enter the quantity : ");
					int quantity = Integer.valueOf(bf.readLine());
					obj.setQty(quantity);
					break;
				}
				case 3: {
					System.out.println("Enter the price");
					double price = Double.valueOf(bf.readLine());
					obj.setPrice(price);
					break;
				default:
					break;
				}
				System.out.println("1.to update another column \n 2.Not continue");
				flag2 = Integer.valueOf(bf.readLine());
			}
			session.update(obj);
			session.getTransaction().commit();
			session.save(obj);
			/*System.out.println("1.For update ");
			flag = Integer.valueOf(bf.readLine());*/

		}
	}

	public void delete() throws NumberFormatException, IOException {
		int flag = 1, flag2 = 1;
		System.out.println("1.For delete");
		flag = Integer.valueOf(bf.readLine());
		switch (flag) {
		case 1: {
			System.out.println("Enter the id which want to be update : ");
			int id = Integer.valueOf(bf.readLine());
			Item obj = session.get(Item.class, id);
			session.beginTransaction();
			session.delete(obj);
			session.getTransaction().commit();
			session.save(obj);
			System.out.println("1.For delete \n 2.Not delete");
			flag = Integer.valueOf(bf.readLine());
			break;
		}
		default:
			System.out.println("Wrong choice");
			break;
		}
	}

	public void search() throws NumberFormatException, IOException {
		int flag = 1, flag2 = 1;
		System.out.println("1.For search ");
		flag = Integer.valueOf(bf.readLine());
		switch (flag) {
		case 1: {
			System.out.println("Enter the id which want to be search : ");
			int id = Integer.valueOf(bf.readLine());
			Item obj = session.get(Item.class, id);
			if (obj != null) {
				session.beginTransaction();
				System.out.println("The Id : " + obj.getId());
				System.out.println("The name : " + obj.getName());
				System.out.println("The quantity : " + obj.getQty());
				System.out.println("The price : " + obj.getPrice());
				session.getTransaction().commit();
			}
			System.out.println("1.To search \n 2.Not continue");
			flag = Integer.valueOf(bf.readLine());
		}
			break;
		default:
			System.out.println("Worng choice");
			break;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int choice = 1;
		Solution ob = new Solution();
		while (choice >= 1 && choice <= 4) {
			System.out.println("1. For create \n 2. For update \n 3. For delete \n 4. For search \n 5.exit");
			choice = Integer.valueOf(bf.readLine());
			switch (choice) {
			case 1: {
				ob.create();
				break;
			}
			case 2: {
				ob.update();
				break;
			}
			case 3: {
				ob.delete();
				break;
			}
			case 4: {
				ob.search();
				break;
			}
			default:
				break;
			}
		}
		// session.close();
	}

}
