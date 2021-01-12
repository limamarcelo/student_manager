package control.main;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import model.dao.teacher.TeacherDAO;
import model.dao.teacher.TeacherDAOImpl;
import model.entity.teacher.Teacher;

public class Main {

	public static void main(String[] args) {
		

		TeacherDAO dao = new TeacherDAOImpl();

		//teste
		
		
		String name = "Bruna";
		String cpf = "992500";
		String email = "teste.bruna@slaa.oi";
		String subject = "Direito Constitucional";
		
		Teacher teacher = new Teacher(name, cpf, email, subject);

		dao.insertTeaher(teacher);

		Session sessao = null;
		
		sessao = conectarBanco().openSession();

		CriteriaBuilder construtor = sessao.getCriteriaBuilder();

        CriteriaQuery<Teacher> consulta = construtor.createQuery(Teacher.class);
        Root<Teacher> raizContato = consulta.from(Teacher.class);

        consulta.select(raizContato);
        
        sessao.save(teacher);

        List<Teacher> teachers = sessao.createQuery(consulta).getResultList();

       
        for(int i = 0;  i < teachers.size(); i++) {
        	System.out.println("nome: " + teachers.get(i).getName());
        }
       }
	private static SessionFactory conectarBanco() {

		Configuration configuracao = new Configuration();

		configuracao.addAnnotatedClass(model.entity.teacher.Teacher.class);
		configuracao.configure("hibernate-cfg.xml");

		ServiceRegistry servico = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();

		SessionFactory fabricaSessao = configuracao.buildSessionFactory(servico);

		return fabricaSessao;

	}
}
