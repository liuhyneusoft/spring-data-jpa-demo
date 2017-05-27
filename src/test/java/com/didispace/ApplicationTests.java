package com.didispace;

import com.didispace.domain.p.one2many.Author;
import com.didispace.domain.p.one2many.AutoRepository;
import com.didispace.domain.p.one2many.Book;
import com.didispace.domain.p.one2many1.Author1;
import com.didispace.domain.p.one2many1.AutoRepository1;
import com.didispace.domain.p.one2many1.Book1;
import com.didispace.domain.p.one2one.AddressEO;
import com.didispace.domain.p.one2one.CustomerEO;
import com.didispace.domain.p.one2one.One2OneRepository;
import com.didispace.domain.p.one2one1.AddressEO1;
import com.didispace.domain.p.one2one1.CustomerEO1;
import com.didispace.domain.p.one2one1.One2OneRepository1;
import com.didispace.domain.p.person.Person;
import com.didispace.domain.p.person.PersonRepository;
import com.didispace.domain.p.user.User;
import com.didispace.domain.p.user.UserRepository;
import com.didispace.domain.p.paginator.SourceCodeService;
import com.didispace.domain.s.Message;
import com.didispace.domain.s.MessageRepository;
import com.didispace.service.PersonService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationTests {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MessageRepository messageRepository;


	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private PersonService personService;

	@Before
	public void setUp() {
	}

	@Test
	public void test() throws Exception {

		userRepository.save(new User("aaa", 10));
		userRepository.save(new User("bbb", 20));
		userRepository.save(new User("ccc", 30));
		userRepository.save(new User("ddd", 40));
		//userRepository.save(new User("eee5", 50));

		System.out.println(userRepository.findAll().size());

		messageRepository.save(new Message("o1", "aaaaaaaaaa"));
		messageRepository.save(new Message("o2", "bbbbbbbbbb"));
		messageRepository.save(new Message("o3", "cccccccccc"));

		System.out.println(messageRepository.findAll().size());

	}

	@Test
	public void testPerson() throws Exception {
//		personRepository.save(new Person("zhangsan"));
//		personRepository.save(new Person("lisi"));
		personService.testPerson();
	}

	@Test
	public void testPersonUpdate() throws Exception {
		Person p = personRepository.findOne(1l);
		p.setName("zhangsan111111");
		personRepository.save(p);
	}

	@Test
	public void testQueryUserAgeLessen22() throws Exception {
		List<User> list = userRepository.findByAgeLessThan(22);
		for(User u : list){
			System.out.println(u.getName()+u.getAge());
		}
	}

	@Test
	public void testQueryUserAgeMorethan33() throws Exception {
		List<User> list = userRepository.findByBigAge(33);
		for(User u : list){
			System.out.println(u.getName()+u.getAge());
		}
	}

	@Test
	public void testQueryUserName() throws Exception {
		List<User> list = userRepository.findByName("b");
		for(User u : list){
			System.err.println(u.getName()+u.getAge());
		}
	}


	@Test
	public void testNameQuery() throws Exception {
		List<User> list = userRepository.nqFindByAge(22);
		for(User u : list){
			System.out.println(u.getName()+u.getAge());
		}
	}

	@Test
	public void testFindUserByParam() throws Exception {
		List<User> list = userRepository.findByNameParam("c");
		for(User u : list){
			System.out.println(u.getName()+u.getAge());
		}
	}

	@Test
	@Transactional
	public void testupdateUserByName() throws Exception {
		personService.testupdateUserByName();
	}

	@Autowired
	private AutoRepository autoRepository;

	@Test
	public void testSaveAuthor() throws Exception {
		Author author = new Author();
		author.setName("au1");
		Book b1 = new Book();
		b1.setName("b1");
		Book b2 = new Book();
		b2.setName("b2");
		Set<Book> sb = new HashSet<>();
		sb.add(b1);
		sb.add(b2);
		author.setBooks(sb);
		autoRepository.save(author);

	}
	@Test
	public void testQueryAuthor() throws Exception {
		Author author = autoRepository.findOne(1l);
		Set<Book> sb = author.getBooks();
		for(Book b :sb){
			System.out.println(b.getName());
		}
	}

	@Test
	public void testQueryAuthor1() throws Exception {
		Author1 author = autoRepository1.findOne(1l);
		Set<Book1> sb = author.getBooks();
		for(Book1 b :sb){
			System.out.println(b.getName());
		}
	}

	@Autowired
	private AutoRepository1 autoRepository1;

	@Test
	public void testSaveAuthor1() throws Exception {
		Author1 author = new Author1();
		author.setName("au111111");
		Book1 b1 = new Book1();
		b1.setName("b11111");
		Book1 b2 = new Book1();
		b2.setName("b222222");
		Set<Book1> sb = new HashSet<>();
		sb.add(b1);
		sb.add(b2);
		author.setBooks(sb);
		autoRepository1.save(author);
	}

	@Autowired
	private One2OneRepository one2OneRepository;
	@Test
	public void testSaveCustomer() throws Exception {
		CustomerEO customerEO = new CustomerEO();
		customerEO.setName("ai shui shui ");
		AddressEO addressEO = new AddressEO();
		addressEO.setAddres("liao ning da lian");
		customerEO.setAddress(addressEO);
		one2OneRepository.save(customerEO);
	}

	@Test
	public void testFindCustomer() throws Exception {
		CustomerEO customerEO =  one2OneRepository.findOne(1l);
		System.out.println(customerEO.getName());
		System.out.println(customerEO.getAddress().getAddres());
	}



	@Autowired
	private One2OneRepository1 one2OneRepository1;
	@Test
	public void testSaveCustomer1() throws Exception {
		CustomerEO1 customerEO = new CustomerEO1();
		customerEO.setName("shenme qingkuang ");
		AddressEO1 addressEO = new AddressEO1();
		addressEO.setAddres("jilin baishan");
		customerEO.setAddress(addressEO);
		one2OneRepository1.save(customerEO);
	}

	@Test
	public void testFindCustomer1() throws Exception {
		CustomerEO1 customerEO =  one2OneRepository1.findOne(1l);
		System.out.println(customerEO.getName());
		System.out.println(customerEO.getAddress().getAddres());
	}


	@Autowired
	private SourceCodeService sourceCodeService;

	@Test
	public void testPage() throws Exception {
		Page<User> sourceCodes1 = this.sourceCodeService.getSourceCode(1, 2);
		Page<User> sourceCodes2 = this.sourceCodeService.getSourceCode(2, 2);
		Page<User> sourceCodes3 = this.sourceCodeService.getSourceCode(3, 2);
		List<User> users1 = sourceCodes1.getContent();
		List<User> users2 = sourceCodes2.getContent();
		List<User> users3 = sourceCodes3.getContent();
		for(User user:users1){
			System.out.println(user.getName());
		}
		for(User user:users2){
			System.out.println(user.getName());
		}
		for(User user:users3){
			System.out.println(user.getName());
		}
	}
}
