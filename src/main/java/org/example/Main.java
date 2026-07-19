package org.example;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.example.entities.*;
import org.example.persistence.customePersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String puNam = "pu-name";
        String providerClassName = "org.hibernate.jpa.HibernatePersistenceProvider";
        String jdbcUrl = "jdbc:mysql://localhost/uni_system";
        String userName = "root";
        String pass = "123456";
        List<String> mangedClassName =List.of("org.example.entities.Student","org.example.entities.Instructor",
                "org.example.entities.Department","org.example.entities.Course","org.example.entities.Student_Card");

        HashMap<String, String> props = new HashMap<>();
        props.put("hibernate.show_sql","true");


        EntityManagerFactory emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new customePersistenceUnitInfo(puNam, providerClassName, jdbcUrl, userName, pass, mangedClassName), props);

        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();


//            String jpql1 =" SELECT s FROM Student s";
//            TypedQuery<Student> q = em.createQuery(jpql1,Student.class);
//            q.getResultList().forEach(System.out::println);

//            String jpql2 ="SELECT d FROM Department d";
//            TypedQuery<Department> q2 = em.createQuery(jpql2,Department.class);
//            q2.getResultList().forEach(System.out::println);

//            String jpql3 ="SELECT c FROM Course c";
//            TypedQuery<Course> q3 = em.createQuery(jpql3,Course.class);
//            q3.getResultList().forEach(System.out::println);
//
//            String jpql4 ="SELECT i FROM Instructor i";
//            TypedQuery<Instructor> q4 = em.createQuery(jpql4,Instructor.class);
//            q4.getResultList().forEach(System.out::println);

//            String jpql5 =" SELECT s FROM Student s WHERE s.id =4";
//            TypedQuery<Student> q5 = em.createQuery(jpql5,Student.class);
//            q5.getResultList().forEach(System.out::println);

//            String jpql6="SELECT d FROM Department d where d.dep_name LIKE :name";
//            TypedQuery<Department> q6 = em.createQuery(jpql6,Department.class);
//            q6.setParameter("name","C%");
//            q6.getResultList().forEach(System.out::println);

//            String jpql7="SELECT c FROM Course c where c.crs_title LIKE :name";
//            TypedQuery<Course> q7 = em.createQuery(jpql7,Course.class);
//            q7.setParameter("name","Java");
//            q7.getResultList().forEach(System.out::println);

//             String jpql8 = " SELECT s FROM Student s WHERE s.age >:age";
//             TypedQuery<Student> q8=em.createQuery(jpql8,Student.class);
//             q8.setParameter("age",22);
//             q8.getResultList().forEach(System.out::println);

//            String jpql9= " SELECT s FROM Student s WHERE s.age >:minage AND s.age <:maxage";
//            //String jpql9= " SELECT s FROM Student s WHERE s.age BETWEEN :minage AND :maxage";
//            TypedQuery<Student> q9=em.createQuery(jpql9,Student.class);
//            q9.setParameter("minage",20);
//            q9.setParameter("maxage",23);
//            q9.getResultList().forEach(System.out::println);

//            String jpql10 = " SELECT s FROM Student s WHERE s.name LIKE :name";
//             TypedQuery<Student> q10=em.createQuery(jpql10,Student.class);
//             q10.setParameter("name","m%");
//             q10.getResultList().forEach(System.out::println);

//            String jpql11 = " SELECT s FROM Student s WHERE s.name LIKE :name";
//            TypedQuery<Student> q11=em.createQuery(jpql11,Student.class);
//            q11.setParameter("name","%Ali");
//            q11.getResultList().forEach(System.out::println);

//            String jpql12 = " SELECT s FROM Student s WHERE s.name LIKE :name";
//            TypedQuery<Student> q12=em.createQuery(jpql12,Student.class);
//            q12.setParameter("name","%med%");
//            q12.getResultList().forEach(System.out::println);

//            String jpql13 = " SELECT c FROM Course c WHERE c.crs_hours > :hours";
//            TypedQuery<Course> q13=em.createQuery(jpql13,Course.class);
//            q13.setParameter("hours",3);
//            q13.getResultList().forEach(System.out::println);

//            String jpql14 = " SELECT s FROM Student s ORDER BY s.name ASC";
//            TypedQuery<Student> q14=em.createQuery(jpql14,Student.class);
//            q14.getResultList().forEach(System.out::println);

//            String jpql15 = " SELECT i FROM Instructor i ORDER BY i.ins_salary DESC";
//            TypedQuery<Instructor> q15=em.createQuery(jpql15,Instructor.class);
//            q15.getResultList().forEach(System.out::println);

//            String jpql16 = " SELECT d FROM Department d ORDER BY d.dep_name ASC";
//            TypedQuery<Department> q16=em.createQuery(jpql16,Department.class);
//            q16.getResultList().forEach(System.out::println);

//            String jpql17 = "SELECT s,d FROM Student s , Department d WHERE d.dep_id = s.department.dep_id";
//            TypedQuery<Object[]> q17=em.createQuery(jpql17,Object[].class);
//            q17.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));

//            String jpql18 = "SELECT s,d.dep_name FROM Student s , Department d WHERE d.dep_id = s.department.dep_id AND d.dep_name LIKE :depName";
//            TypedQuery<Object[]> q18=em.createQuery(jpql18,Object[].class);
//            q18.setParameter("depName","Computer%");
//            q18.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));
//
//            String jpql17 = "SELECT s,d FROM Student s , Department d WHERE d.dep_id = s.department.dep_id";
//            TypedQuery<Object[]> q17=em.createQuery(jpql17,Object[].class);
//            q17.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));

//            String jpql19 = "SELECT i.ins_name , d.dep_name FROM Instructor i , Department d WHERE d.dep_id = s.department.dep_id AND d.dep_name LIKE :depName";
//            TypedQuery<Object[]> q19=em.createQuery(jpql19,Object[].class);
//            q19.setParameter("depName","Computer%");
//            q19.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));

//            String jpql20 = "SELECT s.name ,st.cardNumber FROM Student s , Student_Card st WHERE st.id = s.Student_Card.id";
//            TypedQuery<Object[]> q20=em.createQuery(jpql20,Object[].class);
//            q20.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));

//            String jpql21 = "SELECT s.name ,st.cardNumber FROM Student s , Student_Card st WHERE st.id = s.Student_Card.id AND s.name LIKE :name";
//            TypedQuery<Object[]> q21=em.createQuery(jpql21,Object[].class);
//            q21.setParameter("name","Youssef%");
//            q21.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));
//
//        String jpql22 =" SELECT i.ins_name ,d.dep_name FROM Instructor i , Department d WHERE d.dep_id = i.department.dep_id AND d.dep_name LIKE :depName";
//        TypedQuery<Object[]> q22 = em.createQuery(jpql22,Object[].class);
//        q22.setParameter("depName","Cy%");
//        q22.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));

//        String jpql23 =" SELECT s.name, crs.crs_title FROM Student s JOIN s.course crs WHERE crs_title LIKE :name";
//        TypedQuery<Object[]> q23 = em.createQuery(jpql23,Object[].class);
//        q23.setParameter("name","C%");
//        q23.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));
//
//            String jpql24 =" SELECT s.name,COUNT(crs) FROM Course crs JOIN crs.student s  GROUP BY s.name HAVING  COUNT(crs)>1";
//            TypedQuery<Object[]> q24 = em.createQuery(jpql24,Object[].class);
//            q24.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));


//            String jpql25 =" SELECT s.name , count(s) FROM Student s GROUP BY s.name HAVING s.name LIKE :name ";
//            TypedQuery<Object[]> q25 = em.createQuery(jpql25 ,Object[].class);
//            q25.setParameter("name","R%");
//            q25.getResultList().forEach(o-> System.out.println(o[0] +" "+ o[1]));

//            TypedQuery<Student> q26 =em.createNamedQuery("StudentsWithCourses",Student.class);
//            q26.getResultList().forEach(System.out::println);

//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery <Student>cq = builder.createQuery(Student.class);
//        Root<Student> stRoot = cq.from(Student.class);
//        cq.select(stRoot);
//        TypedQuery<Student> query =em.createQuery(cq);
//        query.getResultList().forEach(System.out::println);

//            CriteriaBuilder builder1 = em.getCriteriaBuilder();
//            CriteriaQuery <Object[]>cq1 = builder1.createQuery(Object[].class);
//            Root<Student> stRoot1 = cq1.from(Student.class);
//            cq1.multiselect(stRoot1.get("name"),stRoot1.get("age"));
//            TypedQuery<Object[]> query1 =em.createQuery(cq1);
//            query1.getResultList().forEach(o->System.out.println(o[0]+ " "+o[1]));

//            CriteriaBuilder builder2 = em.getCriteriaBuilder();
//            CriteriaQuery <Object[]>cq2 = builder2.createQuery(Object[].class);
//            Root<Student> stRoot2 = cq2.from(Student.class);
//            cq2.multiselect(stRoot2.get("name"),stRoot2.get("age"))
//                    .where(builder2.ge(stRoot2.get("age"),22))
//                    .orderBy(builder2.asc(stRoot2.get("name")));
//            TypedQuery<Object[]> query2 =em.createQuery(cq2);
//            query2.getResultList().forEach(o->System.out.println(o[0]+ " "+o[1]));

//            CriteriaBuilder builder3 = em.getCriteriaBuilder();
//            CriteriaQuery <Object[]>cq3 = builder3.createQuery(Object[].class);
//            Root<Student> stRoot3 = cq3.from(Student.class);
//            Join<Student,Department> department =stRoot3.join("department");
//            cq3.multiselect(stRoot3.get("name"),department.get("dep_name"))
//                    .orderBy(builder3.asc(stRoot3.get("name")));
//            TypedQuery<Object[]> query3 =em.createQuery(cq3);
//            query3.getResultList().forEach(o->System.out.println(o[0]+ " "+o[1]));
//
//            CriteriaBuilder builder4 = em.getCriteriaBuilder();
//            CriteriaQuery<Object[]> cq4 =builder4.createQuery(Object[].class);
//            Root<Student>stRoot4 =cq4.from(Student.class);
//            Join<Student,Student_Card> studentStudent_cardJoin = stRoot4.join("Student_Card");
//            cq4.multiselect(stRoot4.get("name"),studentStudent_cardJoin.get("cardNumber"));
//            TypedQuery<Object[]> query4 =em.createQuery(cq4);
//            query4.getResultList().forEach(o->System.out.println(o[0]+ " "+o[1]));

//            CriteriaBuilder builder5 =em.getCriteriaBuilder();
//            CriteriaQuery<Tuple> cq5 = builder5.createTupleQuery();
//            Root<Student> stRoot5 = cq5.from(Student.class);
//            Join<Student ,Course> studentCourseJoin = stRoot5.join("course");
//            cq5.multiselect(stRoot5.get("name") , studentCourseJoin.get("crs_title"));
//            TypedQuery<Tuple> q5 =em.createQuery(cq5);
//            q5.getResultList().forEach(t-> System.out.println(t.get(0)+ " "+ t.get(1)));

//            CriteriaBuilder builder6 =em.getCriteriaBuilder();
//            CriteriaQuery<Tuple> cq6 = builder6.createTupleQuery();
//            Root<Student> stRoot6 = cq6.from(Student.class);
//            Join<Student,Department> studentDepartmentJoin = stRoot6.join("department");
//            Join<Student ,Course> studentCourseJoin = stRoot6.join("course",JoinType.LEFT);
//            cq6.multiselect(stRoot6.get("name") , studentCourseJoin.get("crs_title"),
//                    studentDepartmentJoin.get("dep_name"))
//                    .where(builder6.ge(stRoot6.get("age"),22));
//            TypedQuery<Tuple> q6 =em.createQuery(cq6);
//            q6.getResultList().forEach(t-> System.out.println(t.get(0)+ " "+ t.get(1)+" "+t.get(2)));


//            CriteriaBuilder builder7 = em.getCriteriaBuilder();
//            CriteriaQuery <Student> mainQuery = builder7.createQuery(Student.class);
//            Root<Student> studentRoot = mainQuery.from(Student.class);
//            Subquery<Long> subquery = mainQuery.subquery(Long.class);
//            Root<Student> subStudentRoot = subquery.correlate(studentRoot);
//            Join<Student,Course> studentCourseJoin = subStudentRoot.join("course");
//            subquery.select(builder7.count(studentCourseJoin));
//            mainQuery.select(studentRoot).where(builder7.greaterThan(subquery,2L));
//            TypedQuery<Student> q7=em.createQuery(mainQuery);
//            q7.getResultList().forEach(System.out::println);



//            EntityGraph<?> graph = em.createEntityGraph(Student.class);
//            graph.addAttributeNodes("Student_Card" );
//           em.createQuery("SELECT s FROM Student s ",Student.class)
//                   .setHint("jakarta.persistence.loadgraph",graph)
//                   .getResultList().forEach(a-> System.out.println(a.getStudent_Card()));

//             EntityGraph<?> mainGraph =em.createEntityGraph(Student.class);
//             Subgraph<Department> subgraph =mainGraph.addSubgraph("department");
//             subgraph.addAttributeNodes("instructor");
//             em.createQuery("SELECT s FROM Student s" ,Student.class)
//                    .setHint("jakarta.persistence.loadgraph",mainGraph)
//                            .getResultList().forEach(s->
//                                    System.out.println(s.getDepartment().getInstructor()));

             EntityGraph<?> graph =em.getEntityGraph("instructor.course");

             em.createQuery("SELECT i FROM Instructor i",Instructor.class)
                     .setHint("jakarta.persistence.fetchgraph",graph)
                             .getResultList().forEach(i-> System.out.println(i.getCourse()));



            em.getTransaction().commit();
        } finally {
            em.close();
        }


    }
}