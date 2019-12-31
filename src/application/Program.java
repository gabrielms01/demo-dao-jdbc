/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.List;
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
    }
    
}
