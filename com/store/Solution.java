package com.store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.store.details.GunDetails;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		session.beginTransaction();
		System.out.println("User_id:");
		int id = Integer.valueOf(bf.readLine());
		System.out.println("Gun_name:");
		String gunName = String.valueOf(bf.readLine());
		System.out.println("Holder_name:");
		String holderName = String.valueOf(bf.readLine());
		System.out.println("Gun_model");
		int gunModel = Integer.valueOf(bf.readLine());
		System.out.println("Gun_serial_number:");
		long serialNumber = Long.valueOf(bf.readLine());
		System.out.println("Gun_type:");
		String type = String.valueOf(bf.readLine());
		System.out.println("Firing_range:");
		float range = Float.valueOf(bf.readLine());
		System.out.println("Gun_weight:");
		float weight = Float.valueOf(bf.readLine());

		GunDetails obj = new GunDetails(id, gunName, holderName, gunModel, serialNumber, type, range, weight);
		System.out.println("User_id:"+obj.getId());
		System.out.println("Gun_name:"+obj.getGunName());
		System.out.println("Holder_name:"+obj.getHolderName());
		System.out.println("Gun_model"+obj.getGunModel());
		System.out.println("Gun_serial_number:"+obj.getSerialNumber());
		System.out.println("Gun_type:"+obj.getType());
		System.out.println("Firing_range:"+obj.getRange());
		System.out.println("Gun_weight:"+obj.getWeight());
		session.save(obj);
		session.getTransaction().commit();
		session.close();
	}

}
