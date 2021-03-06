/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 *
 * @author Gabriel
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // PROJETO- criando projetos e repositório Git- Aula 234
        
        Scanner sc= new Scanner(System.in);
        
        SellerDao sellerDao= DaoFactory.createSellerDao();
        
        System.out.println("=== TESTE 1: seller findById ====");
        Seller seller= sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println("\n=== TESTE 2: seller findByDepartment ====");
        Department department= new Department(2, null);
        List<Seller> list= sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("\n=== TESTE 3: seller findByAll ====");
        list= sellerDao.findAll();
        for (Seller obj : list) {
            System.out.println(obj);
        }
        
        System.out.println("\n=== TESTE 4: seller insert ====");
        Seller newSeller= new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        
        System.out.println("\n=== TESTE 5: seller update ====");
        seller= sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Updated completed");
        
        System.out.println("\n=== TESTE 6: seller delete ====");
        System.out.println("Enter id for delete test: ");
        int id= sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        
        sc.close();
    }
    
}
