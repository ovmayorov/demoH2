package org.example;
import org.example.model.Bookings;
import org.example.model.TicketFlights;
import org.example.model.Tickets;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
                Configuration cfg = new Configuration()
                .addAnnotatedClass(Bookings.class)
                .addAnnotatedClass(TicketFlights.class)
                .addAnnotatedClass(Tickets.class);

        SessionFactory sessionFactory = cfg.buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try{
            session.beginTransaction();

            Bookings booking1 = session.get(Bookings.class,00000F );

            System.out.println("Booking # " + booking1.getBookRef());
            System.out.println("Date: " + booking1.getBookDate());
            System.out.println("Total Amount: " + booking1.getTotalAmount());

            session.getTransaction().commit();
        }catch(Exception ex){
            session.getTransaction().rollback();
        }finally {
            sessionFactory.close();
        }


//        try{
//            Class.forName("org.postgresql.Driver");
//        }catch(ClassNotFoundException e){
//            System.out.println("Cannot load driver PostgreSQL");
//        }
//
//        String url = "jdbc:postgresql://localhost:5432/demo";
//        String user = "postgres";
//        String password = "12345677";
//        try{
//            Connection connection = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to database successfully");
//        }catch(SQLException ex){
//            System.err.println("Cannot connect to database " + ex.getMessage());
//        }

    }
}
